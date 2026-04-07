<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>Danh sách nhân viên</title>
  <style>
    body { font-family: Arial, sans-serif; padding: 20px; }
    table { width: 100%; border-collapse: collapse; margin-top: 20px; }
    th, td { border: 1px solid #ddd; padding: 10px; text-align: center; }
  </style>
</head>
<body>

<h2 style="text-align: center; color: #333;">DANH SÁCH NHÂN VIÊN</h2>

<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Họ Tên</th>
    <th>Phòng Ban</th>
    <th>Mức Lương ($)</th>
    <th>Đánh Giá</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="emp" items="${employeeList}">
    <tr>
      <td>${emp.id}</td>
      <td>${emp.fullName}</td>
      <td>${emp.department}</td>
      <td>${emp.salary}</td>
      <td>
        <c:choose>
          <c:when test="${emp.salary >= 10000}">
            <span class="high-salary">Mức lương cao</span>
          </c:when>
          <c:otherwise>
            <span class="base-salary">Mức lương cơ bản</span>
          </c:otherwise>
        </c:choose>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

</body>
</html>