<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard - Báo cáo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow border-0">
        <div class="card-header bg-dark text-white d-flex justify-content-between align-items-center">
            <h3 class="mb-0">📊 Báo cáo Tổng quan (Dashboard)</h3>
            <!-- FIX LỖI LINK QUAY LẠI Ở ĐÂY -->
            <a href="${pageContext.request.contextPath}/students" class="btn btn-light btn-sm fw-bold">⬅ Quay lại danh sách</a>
        </div>

        <div class="card-body">
            <div class="row mb-4">
                <div class="col-md-6">
                    <div class="card bg-primary text-white text-center p-3 shadow-sm">
                        <h5>Tổng số Sinh viên</h5>
                        <h1 class="display-4 fw-bold">${stats.total}</h1>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card bg-success text-white text-center p-3 shadow-sm">
                        <h5>GPA Trung bình Toàn Khoa</h5>
                        <h1 class="display-4 fw-bold">${stats.avgGpa}</h1>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <div class="card shadow-sm h-100">
                        <div class="card-header bg-light fw-bold">📈 Tỷ lệ Trạng thái</div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                Đang học <span class="badge bg-success rounded-pill">${stats.percentStudying}%</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                Bảo lưu <span class="badge bg-warning text-dark rounded-pill">${stats.percentSuspended}%</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                Tốt nghiệp <span class="badge bg-primary rounded-pill">${stats.percentGraduated}%</span>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="card border-warning shadow-sm h-100">
                        <div class="card-header bg-warning text-dark fw-bold">🏆 Vinh danh Thủ khoa</div>
                        <div class="card-body text-center mt-3">
                            <h4 class="text-primary fw-bold">${stats.topStudent.fullName}</h4>
                            <p class="mb-1 text-muted">Khoa: ${stats.topStudent.faculty}</p>
                            <h2 class="text-danger fw-bold">${stats.topStudent.gpa}</h2>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>