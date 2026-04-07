<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Danh sách Sinh viên - StudentHub</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
            <h3 class="mb-0">🎓 Danh sách Sinh viên Khoa CNTT</h3>
            <a href="${pageContext.request.contextPath}/dashboard" class="btn btn-warning fw-bold">📊 Xem Dashboard</a>
        </div>

        <div class="card-body">
            <div class="row mb-3">
                <div class="col-md-5">
                    <a href="?sortBy=name" class="btn btn-outline-primary btn-sm">⬇ Sắp xếp Tên (A-Z)</a>
                    <a href="?sortBy=gpa" class="btn btn-outline-success btn-sm">⬇ Sắp xếp GPA (Cao-Thấp)</a>
                </div>
                <div class="col-md-7 text-end">
                    <!-- FIX LỖI TÌM KIẾM Ở ĐÂY -->
                    <form action="${pageContext.request.contextPath}/students" method="GET" class="d-flex justify-content-end">
                        <input type="text" name="search" class="form-control form-control-sm w-50 me-2" placeholder="Nhập Tên hoặc Mã SV..." value="${searchKeyword}">
                        <input type="text" name="faculty" class="form-control form-control-sm w-25 me-2" placeholder="Nhập Khoa (VD: CNTT)">
                        <button type="submit" class="btn btn-secondary btn-sm">🔍 Tìm kiếm</button>
                    </form>
                </div>
            </div>

            <c:if test="${not empty searchKeyword}">
                <div class="alert alert-info py-2">Đã tìm thấy <b>${students.size()}</b> kết quả phù hợp.</div>
            </c:if>

            <table class="table table-hover table-bordered text-center align-middle">
                <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Mã SV</th>
                    <th>Họ và Tên</th>
                    <th>Khoa</th>
                    <th>GPA</th>
                    <th>Trạng thái</th>
                    <th>Hành động</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="s" items="${students}">
                    <tr>
                        <td>${s.id}</td>
                        <td class="fw-bold">${s.studentCode}</td>
                        <td class="text-start">${s.fullName}</td>
                        <td>${s.faculty}</td>
                        <td class="fw-bold text-danger">${s.gpa}</td>
                        <td>
                            <c:choose>
                                <c:when test="${s.status == 'Đang học'}"><span class="badge bg-success">${s.status}</span></c:when>
                                <c:when test="${s.status == 'Bảo lưu'}"><span class="badge bg-warning text-dark">${s.status}</span></c:when>
                                <c:otherwise><span class="badge bg-primary">${s.status}</span></c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <!-- FIX LỖI LINK CHI TIẾT Ở ĐÂY -->
                            <a href="${pageContext.request.contextPath}/students/detail?id=${s.id}" class="btn btn-info btn-sm text-white">Xem chi tiết</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>