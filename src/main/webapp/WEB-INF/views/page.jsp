<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01/06/2023
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
  <style>
    table, th, td {
      border: 1px solid #000;
      border-collapse: collapse;
    }
    th, td {
      padding: 10px;
    }
  </style>
</head>
<body>
  <h3>PAGINATION</h3>
    <table>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Price</th>
          <th>Date</th>
        </tr>
        <c:forEach var="sach" items="${page.content}">
            <tr>
              <td>${sach.masach}</td>
              <td>
                  <a href="${pageContext.request.contextPath}/sach/detail/${sach.masach}">${sach.tensach}</a>
              </td>
              <td>${sach.gia}</td>
              <td>${sach.nxb}</td>
            </tr>
        </c:forEach>
    </table>

    <a href="${pageContext.request.contextPath}/sach/page?p=0">First</a>
    <a href="${pageContext.request.contextPath}/sach/page?p=${page.number-1 < 0 ? 0 : page.number-1}">Previous</a>
    <a href="${pageContext.request.contextPath}/sach/page?p=${page.number+1 > page.totalPages-1 ? page.totalPages-1 : page.number+1}">Next</a>
    <a href="${pageContext.request.contextPath}/sach/page?p=${page.totalPages-1}">Last</a>

  <ul>
        <li>Số thực thể hiện tại: ${page.numberOfElements}</li>
        <li>Trang số: ${page.number}</li>
        <li>Kích thước trang: ${page.size}</li>
        <li>Tổng số thực thể: ${page.totalElements}</li>
        <li>Tổng số trang: ${page.totalPages}</li>
    </ul>
</body>
</html>
