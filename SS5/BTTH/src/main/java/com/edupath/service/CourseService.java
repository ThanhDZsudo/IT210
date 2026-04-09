package com.edupath.service;

import com.edupath.model.entity.Course;
import com.edupath.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

// Đánh dấu đây là tầng xử lý Logic Nghiệp vụ (Business Logic)
@Service
public class CourseService {

    @Autowired // Kêu Spring tự động tiêm (Inject) cái Repository vào đây
    private CourseRepository repo;

    // Logic Chức năng 2: Lọc khóa học theo 2 điều kiện (Level và Giá tiền)
    public List<Course> filterCourses(String level, double maxPrice) {
        return repo.findAll().stream()
                // Nếu người dùng chọn "All" thì lấy hết, ngược lại thì lọc theo level
                .filter(c -> level.equals("All") || c.getLevel().equals(level))
                // Chỉ lấy các khóa có học phí bé hơn mức nhập vào
                .filter(c -> c.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    // Lấy 1 khóa học theo mã
    public Course getByCode(String code) {
        return repo.findByCode(code);
    }

    // Logic Chức năng 4: Lưu thông tin sau khi Cập nhật
    public void updateCourse(Course updatedCourse) {
        Course existing = repo.findByCode(updatedCourse.getCode());
        if (existing != null) { // Nếu tìm thấy trong DB ảo thì tiến hành đè thông tin mới
            existing.setPrice(updatedCourse.getPrice());
            existing.setStartDate(updatedCourse.getStartDate());
        }
    }

    // Logic Chức năng 5: Kiểm tra Bẫy nghiệp vụ trước khi cho phép Xóa
    public String deleteCourse(String code) {
        Course course = repo.findByCode(code);
        if (course != null) {
            // Nghiệp vụ (SRS): Nếu khóa học đang có người học (>= 1) thì CẤM XÓA
            if (course.getStudentCount() > 0) {
                return "Không thể hủy khóa học đã có học viên đăng ký!"; // Trả về thông báo lỗi
            }
            repo.remove(code); // Thỏa mãn điều kiện thì gọi Repository để xóa
            return "SUCCESS"; // Xóa thành công
        }
        return "Không tìm thấy khóa học!";
    }
}