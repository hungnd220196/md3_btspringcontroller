<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 5/8/2024
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1 class="alert alert-primary">Danh sách nhan viên</h1>
<a href="/add" class="btn btn-info">Thêm mới</a>
<table class="table">
    <thead>
    <tr>
        <th>MNV</th>
        <th>FullName</th>
        <th>Gender</th>
        <th>birthday</th>
        <th>address</th>
        <th>department</th>
        <th>position</th>
        <th>salary</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="em">
        <tr>
            <td scope="row">${em.employeeId}</td>
            <td>${em.employeeName}</td>
            <td>${em.gender?"Nam":"Nữ"}</td>
            <td><fmt:formatDate value="${em.birthDay}" pattern="dd/MM/yyyy"/></td>
            <td>${em.address}</td>
            <td>${em.department}</td>
            <td>${em.position}</td>
            <td>${em.salary}</td>
            <td><a href="/edit?id=${em.employeeId}" class="btn btn-warning"><i class="bi bi-pencil-square"></i></a></td>
            <td><a href="/delete?id=${em.employeeId}" class="btn btn-danger"><i class="bi bi-trash"></i></a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>
