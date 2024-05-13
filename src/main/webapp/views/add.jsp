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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<h1 class="text-center">Thêm mơi</h1>
<form class="row g-3" action="/add" method="post">
    <div class="col-md-6">
        <label for="inputEmail4" class="form-label">Name</label>
        <input type="text" class="form-control" name="employeeName" id="inputEmail4">
    </div>
    <div class="col-md-6">
        <label for="inputPassword4" class="form-label">department</label>
        <input type="text" class="form-control" name="department" id="inputPassword4">
    </div>
    <div class="col-12">
        <label for="inputAddress" class="form-label">Địa chỉ</label>
        <input type="text" class="form-control" name="address" id="inputAddress" >
    </div><div class="col-12">
        <label for="inputAddress1" class="form-label">Vị trí</label>
        <input type="text" class="form-control" name="position" id="inputAddress1" >
    </div><div class="col-12">
        <label for="inputAddress2" class="form-label">Salary</label>
        <input type="text" class="form-control" name="salary" id="inputAddress2" >
    </div>
    <div class="col-md-6">
        <label for="inputCity" class="form-label">Birth Day</label>
        <input type="date" class="form-control" name="birthDay" id="inputCity">
    </div>
    <div class="col-md-4">
        <label for="inputState" class="form-label">Sex</label>
        <select id="inputState" name="gender" class="form-select">
            <option selected value="true">Nam</option>
            <option value="false">Nữ</option>
        </select>
    </div>
    <div class="col-12">
        <input type="submit" class="btn btn-primary" value="add" name="action"/>
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
