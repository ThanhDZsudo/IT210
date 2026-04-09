package com.edupath.model.entity;

// Lớp Entity đại diện cho một Khóa học
public class Course {
    private String code;        // Mã khóa học (Khóa chính)
    private String name;        // Tên khóa học
    private String level;       // Trình độ (Beginner, Intermediate, Advanced)
    private double price;       // Học phí
    private String description; // Lộ trình học/Mô tả
    private String teacher;     // Tên giảng viên
    private String duration;    // Thời lượng (VD: 20 buổi)
    private String startDate;   // Ngày khai giảng
    private int studentCount;   // Số học viên đang học (Dùng để bắt lỗi Xóa)
    private int maxStudents;    // Sĩ số tối đa

    // Constructor khởi tạo đầy đủ tham số
    public Course(String code, String name, String level, double price, String description,
                  String teacher, String duration, String startDate, int studentCount, int maxStudents) {
        this.code = code; this.name = name; this.level = level; this.price = price;
        this.description = description; this.teacher = teacher; this.duration = duration;
        this.startDate = startDate; this.studentCount = studentCount; this.maxStudents = maxStudents;
    }

    // Logic xử lý: Kiểm tra xem khóa học đã kín chỗ chưa (Chức năng 3)
    public boolean isFull() {
        return this.studentCount >= this.maxStudents;
    }

    // ---------- GETTERS & SETTERS ----------
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getTeacher() { return teacher; }
    public void setTeacher(String teacher) { this.teacher = teacher; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
    public int getStudentCount() { return studentCount; }
    public void setStudentCount(int studentCount) { this.studentCount = studentCount; }
    public int getMaxStudents() { return maxStudents; }
    public void setMaxStudents(int maxStudents) { this.maxStudents = maxStudents; }
}