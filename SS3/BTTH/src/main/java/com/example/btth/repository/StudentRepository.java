package com.example.btth.repository;

import org.springframework.stereotype.Repository;
import com.example.btth.entity.Student;
import java.util.ArrayList;
import java.util.List;

@Repository // Đánh dấu lớp này thuộc tầng dữ liệu, Spring sẽ tự động tạo và quản lý đối tượng này
public class StudentRepository {
    // Khai báo một danh sách để lưu trữ dữ liệu sinh viên trong bộ nhớ (RAM)
    private List<Student> students;

    /**
     * Hàm khởi tạo (Constructor).
     * Dùng để khởi tạo "dữ liệu cứng" (Mock Data) ngay khi ứng dụng chạy,
     * thay thế cho việc truy vấn từ cơ sở dữ liệu thật.
     */
    public StudentRepository() {
        students = new ArrayList<>();
        // Khởi tạo danh sách 15 sinh viên với đầy đủ các thuộc tính để kiểm thử các chức năng
        students.add(new Student(1, "Nguyen Tien Thanh", "B21DCCN001", "CNTT", 2021, 3.8, "Đang học"));
        students.add(new Student(2, "Le Thi Hoa", "B20DCCN002", "CNTT", 2020, 3.2, "Đang học"));
        students.add(new Student(3, "Tran Van Binh", "B19ATKM003", "ATTT", 2019, 2.5, "Bảo lưu"));
        students.add(new Student(4, "Pham Tuan Anh", "B18DCCN004", "CNTT", 2018, 3.9, "Tốt nghiệp"));
        students.add(new Student(5, "Vu Thi Mai", "B21PTIT005", "PTIT", 2021, 3.5, "Đang học"));
        students.add(new Student(6, "Hoang Quang Hai", "B21DCCN006", "CNTT", 2021, 3.1, "Đang học"));
        students.add(new Student(7, "Ngo Thi Lan", "B19MRKT007", "Qtkd", 2019, 2.8, "Tốt nghiệp"));
        students.add(new Student(8, "Dang Viet Hoang", "B22DPT008", "DPT", 2022, 3.6, "Đang học"));
        students.add(new Student(9, "Doan Tuan Kiet", "B20ATKM009", "ATTT", 2020, 1.9, "Bảo lưu"));
        students.add(new Student(10, "Bui Thi Thu", "B21DCCN010", "CNTT", 2021, 3.95, "Đang học"));
        students.add(new Student(11, "Phan Nhat Minh", "B18PTIT011", "PTIT", 2018, 3.4, "Tốt nghiệp"));
        students.add(new Student(12, "Ly Gia Han", "B22Qtkd012", "Qtkd", 2022, 3.7, "Đang học"));
        students.add(new Student(13, "Truong Quoc Bao", "B21DCCN013", "CNTT", 2021, 2.1, "Bảo lưu"));
        students.add(new Student(14, "Vo Thi Xuan", "B20DPT014", "DPT", 2020, 3.0, "Đang học"));
        students.add(new Student(15, "Dinh Van Truong", "B21ATKM015", "ATTT", 2021, 2.9, "Đang học"));
    }

    /**
     * Trình xuất toàn bộ danh sách sinh viên hiện có.
     * Tầng Service sẽ gọi hàm này để lấy dữ liệu thô trước khi lọc hoặc sắp xếp.
     */
    public List<Student> getAll() {
        return students;
    }

    /**
     * Tìm kiếm một sinh viên cụ thể dựa trên ID.
     * Sử dụng Stream API để duyệt danh sách và tìm phần tử khớp với ID truyền vào.
     */
    public Student getById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id) // Lọc sinh viên có ID trùng khớp
                .findFirst()                  // Lấy kết quả đầu tiên tìm thấy
                .orElse(null);                // Nếu không thấy thì trả về null
    }
}