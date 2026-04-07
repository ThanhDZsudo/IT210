package com.example.btth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.btth.entity.Student;
import com.example.btth.service.StudentService;

import java.util.List;

@Controller // Đánh dấu đây là một Controller xử lý các yêu cầu Web (HTTP Requests)
public class StudentController {

    @Autowired // Tự động kết nối và tiêm (inject) tầng Service vào để sử dụng
    private StudentService service;

    /**
     * UC-01 & 03: Hiển thị danh sách sinh viên, hỗ trợ tìm kiếm và sắp xếp.
     * @RequestParam: Lấy các tham số từ URL như ?search=...&sortBy=...
     */
    @GetMapping({"/", "/students"}) // Tiếp nhận yêu cầu tại đường dẫn gốc hoặc /students
    public String listStudents(
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "faculty", required = false) String faculty,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            Model model) {

        // Gọi Service để xử lý lọc và sắp xếp danh sách
        List<Student> students = service.getFilteredAndSortedStudents(search, faculty, sortBy);

        // Đưa dữ liệu vào Model để gửi sang trang JSP hiển thị
        model.addAttribute("students", students);
        model.addAttribute("searchKeyword", search); // Giữ lại từ khóa để in lên ô tìm kiếm

        return "list"; // Trả về trang /WEB-INF/views/list.jsp
    }

    /**
     * UC-02: Xem chi tiết thông tin một sinh viên qua ID.
     */
    @GetMapping("/students/detail")
    public String studentDetail(@RequestParam("id") int id, Model model) {
        // Gửi dữ liệu sinh viên tìm được qua Model
        model.addAttribute("student", service.getStudentById(id));
        return "detail"; // Trả về trang detail.jsp
    }

    /**
     * UC-04: Hiển thị trang báo cáo thống kê (Dashboard).
     */
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Lấy bản đồ các chỉ số thống kê từ Service và gửi sang View
        model.addAttribute("stats", service.getDashboardStats());
        return "dashboard"; // Trả về trang dashboard.jsp
    }
}