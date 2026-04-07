package com.example.btth.entity;

/**
 * Lớp Entity đại diện cho đối tượng Sinh viên.
 * Dùng để lưu trữ và vận chuyển thông tin giữa các tầng (DAO, Service, Controller, JSP).
 */
public class Student {
    // Khai báo các thuộc tính (Properties) cá nhân của sinh viên
    private int id;                // ID tự tăng hoặc định danh duy nhất
    private String fullName;       // Họ và tên đầy đủ
    private String studentCode;    // Mã số sinh viên (VD: B21DCCN001)
    private String faculty;        // Khoa (VD: CNTT, ATTT)
    private int enrollmentYear;    // Năm nhập học
    private double gpa;            // Điểm trung bình tích lũy
    private String status;         // Trạng thái (Đang học, Bảo lưu, Tốt nghiệp)

    /**
     * Hàm khởi tạo (Constructor) có tham số.
     * Giúp tạo nhanh một đối tượng Sinh viên với đầy đủ thông tin.
     */
    public Student(int id, String fullName, String studentCode, String faculty, int enrollmentYear, double gpa, String status) {
        this.id = id;
        this.fullName = fullName;
        this.studentCode = studentCode;
        this.faculty = faculty;
        this.enrollmentYear = enrollmentYear;
        this.gpa = gpa;
        this.status = status;
    }

    /**
     * Các hàm Getter.
     * Vì các thuộc tính để là 'private' (đảm bảo tính đóng gói - Encapsulation),
     * nên cần các hàm này để các lớp khác (như JSP hoặc Service) có thể đọc dữ liệu.
     */
    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getStudentCode() { return studentCode; }
    public String getFaculty() { return faculty; }
    public int getEnrollmentYear() { return enrollmentYear; }
    public double getGpa() { return gpa; }
    public String getStatus() { return status; }
}