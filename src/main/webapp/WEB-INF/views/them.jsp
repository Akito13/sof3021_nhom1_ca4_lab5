<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 6/2/2023
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Bài làm thêm</title>
    <style>
      table, th, td {
        border: 1px solid #000;
        border-collapse: collapse;
      }

      table {
        width: 70%;
      }

      th, td {
        padding: 10px;
        text-align: center;
      }

    </style>
</head>
<body>
  <c:choose>
    <c:when test="${not empty sach}">
      <ul>
        <li>Tên sách: <strong>${sach.tensach}</strong></li>
        <li>Loại sách: <strong>${sach.maloai != null ? sach.maloai.tenloai : "Không có loại phù hợp"}</strong></li>
        <li>Giá: <strong>${sach.gia}</strong></li>
        <li>NXB: <strong>${sach.nxb}</strong></li>
      </ul>
      <c:if test="${not empty list}">
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Tên</th>
              <th>Giá</th>
              <th>NXB</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${list}" var="item">
              <tr>
                <td>${item.value.masach}</td>
                <td><a href="${pageContext.request.contextPath}/sach/detail/${item.value.masach}">${item.value.tensach}</a></td>
                <td>${item.value.gia}</td>
                <td>${item.value.nxb}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </c:if>
    </c:when>
    <c:otherwise>
      <h3>${error}</h3>
    </c:otherwise>
  </c:choose>
</body>
</html>
