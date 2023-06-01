<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01/06/2023
  Time: 11:32 AM
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
    <h1>Phân Loại Sản Phẩm</h1>
    <form:form method="post" modelAttribute="loai">
        <form:input path="maloai" />
        <form:input path="tenloai" /><br>
        <form:button formaction="/loai/create">Create</form:button>
        <form:button formaction="/loai/update">Update</form:button>
        <br>
        <a href="${pageContext.request.contextPath}/loai/delete/${loai.maloai}">Delete</a>
        <a href="${pageContext.request.contextPath}/loai/index">Reset</a>
    </form:form>
    <br>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="loai">
                <tr>
                    <td>${loai.maloai}</td>
                    <td>${loai.tenloai}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/loai/edit/${loai.maloai}">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
