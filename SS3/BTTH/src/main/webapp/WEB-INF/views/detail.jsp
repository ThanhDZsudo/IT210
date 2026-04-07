<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết Sinh viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<%-- Sử dụng các class Flexbox của Bootstrap (d-flex, align-items-center...) để căn giữa toàn bộ nội dung ra giữa màn hình --%>
<body class="bg-light d-flex align-items-center justify-content-center" style="height: 100vh;">

<%-- Card shadow: Tạo một khối hộp có hiệu ứng đổ bóng --%>
<div class="card shadow" style="width: 25rem;">
    <%-- Header của Card: Hiển thị tiêu đề trên nền màu xanh (bg-info) --%>
    <div class="card-header bg-info text-white text-center">
        <h4 class="mb-0">Hồ sơ Sinh viên</h4>
    </div>

    <div class="card-body">
        <%-- Hiển thị tên sinh viên nổi bật ở giữa bằng thẻ h5 và class text-primary --%>
        <h5 class="card-title text-primary text-center fw-bold mb-4">${student.fullName}</h5>

        <%-- Sử dụng List Group của Bootstrap để trình bày các thông tin theo từng dòng kẻ --%>
        <ul class="list-group list-group-flush mb-4">
            <%-- Dùng EL ${student.xxx} để truy xuất vào các thuộc tính đã định nghĩa trong lớp Entity Student --%>
            <li class="list-group-item"><b>🔖 Mã SV:</b> ${student.studentCode}</li>
            <li class="list-group-item"><b>🏢 Khoa:</b> ${student.faculty}</li>
            <li class="list-group-item"><b>📅 Năm nhập học:</b> ${student.enrollmentYear}</li>
            <%-- GPA được tô đỏ (text-danger) để gây chú ý --%>
            <li class="list-group-item"><b>⭐ Điểm GPA:</b> <span class="text-danger fw-bold">${student.gpa}</span></li>
            <li class="list-group-item"><b>📌 Trạng thái:</b> ${student.status}</li>
        </ul>

        <div class="text-center">
            <%-- Nút quay lại: Sử dụng contextPath để đảm bảo đường dẫn về trang danh sách luôn chính xác --%>
            <a href="${pageContext.request.contextPath}/students" class="btn btn-secondary">⬅ Quay lại danh sách</a>
        </div>
    </div>
</div>

</body>
</html>