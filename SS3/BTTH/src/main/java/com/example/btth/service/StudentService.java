package com.example.btth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.btth.entity.Student;
import com.example.btth.repository.StudentRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service // Đánh dấu đây là tầng Service, nơi chứa logic nghiệp vụ của ứng dụng
public class StudentService {
    @Autowired // Tự động kết nối với Repository để lấy dữ liệu thô
    private StudentRepository repository;

    public Student getStudentById(int id) {
        return repository.getById(id);
    }

    /**
     * Thuật toán tách "Tên" từ chuỗi "Họ và Tên".
     * Giúp sắp xếp chuẩn theo tên người Việt (A-Z chữ cái cuối).
     */
    private String getFirstName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) return "";
        String[] parts = fullName.trim().split("\\s+"); // Tách chuỗi theo dấu cách
        return parts[parts.length - 1]; // Lấy phần tử cuối cùng (Tên)
    }

    /**
     * Logic chính: Lọc sinh viên theo từ khóa (Tên/Mã SV), theo Khoa và Sắp xếp.
     */
    public List<Student> getFilteredAndSortedStudents(String search, String faculty, String sortBy) {
        List<Student> list = repository.getAll(); // Lấy dữ liệu thô từ Repository

        // 1. Lọc theo Tìm kiếm (Tên hoặc Mã SV) - Dùng Java Stream API
        if (search != null && !search.trim().isEmpty()) {
            String keyword = search.trim().toLowerCase();
            list = list.stream()
                    .filter(s -> s.getFullName().toLowerCase().contains(keyword) ||
                            s.getStudentCode().toLowerCase().contains(keyword))
                    .sorted(Comparator.comparing((Student s) -> getFirstName(s.getFullName()))
                    .thenComparing(Student::getFullName))
                    .collect(Collectors.toList());
        }

        // 2. Lọc theo Khoa
        if (faculty != null && !faculty.trim().isEmpty()) {
            list = list.stream()
                    .filter(s -> s.getFaculty().equalsIgnoreCase(faculty.trim()))
                    .collect(Collectors.toList());
        }

        // 3. Sắp xếp chuẩn theo Tên (A-Z) hoặc GPA (Cao -> Thấp)
        if ("name".equalsIgnoreCase(sortBy)) {
            list = list.stream()
                    .sorted(Comparator.comparing((Student s) -> getFirstName(s.getFullName()))
                            .thenComparing(Student::getFullName)) // Nếu trùng tên thì xếp theo Họ
                    .collect(Collectors.toList());
        } else if ("gpa".equalsIgnoreCase(sortBy)) {
            list = list.stream()
                    .sorted(Comparator.comparing(Student::getGpa).reversed())
                    .collect(Collectors.toList());
        }

        return list;
    }

    /**
     * Logic tính toán Dashboard: Tổng số, Tỷ lệ %, GPA Trung bình, Thủ khoa.
     */
    public Map<String, Object> getDashboardStats() {
        List<Student> list = repository.getAll();
        Map<String, Object> stats = new HashMap<>();
        int total = list.size();
        stats.put("total", total);

        if (total > 0) {
            // Thống kê số lượng theo trạng thái
            long studying = list.stream().filter(s -> s.getStatus().equals("Đang học")).count();
            // ... tính toán tỷ lệ % ...
            stats.put("percentStudying", Math.round((studying * 100.0) / total));

            // Tính GPA trung bình toàn bộ danh sách
            double avgGpa = list.stream().mapToDouble(Student::getGpa).average().orElse(0.0);
            stats.put("avgGpa", Math.round(avgGpa * 100.0) / 100.0);

            // Tìm sinh viên có GPA cao nhất (Thủ khoa)
            Student topStudent = list.stream().max(Comparator.comparing(Student::getGpa)).orElse(null);
            stats.put("topStudent", topStudent);
        }
        return stats;
    }
}