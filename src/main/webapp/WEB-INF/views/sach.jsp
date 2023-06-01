<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01/06/2023
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <h1>Sort by price</h1>
    <table>
        <thead>
            <tr>
                <th><a href="${pageContext.request.contextPath}/sach/sort?by=masach">ID</a></th>
                <th><a href="${pageContext.request.contextPath}/sach/sort?by=tensach">Name</a></th>
                <th><a href="${pageContext.request.contextPath}/sach/sort?by=gia">Price</a></th>
                <th><a href="${pageContext.request.contextPath}/sach/sort?by=nxb">Date</a></th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="sach">
            <tr>
                <td>${sach.masach}</td>
                <td>${sach.tensach}</td>
                <td>${sach.gia}</td>
                <td>${sach.nxb}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</body>
</html>
