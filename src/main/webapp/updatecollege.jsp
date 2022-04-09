<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: 54456
  Date: 2021/12/16
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学院</title>
</head>
<link href="./bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="./bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
<body>
<div style="width:100%;text-align:center;margin-top: 50px">
    <h3 style="margin: 20px;padding: 10px">修改学院</h3>
    <form action="collegeaction" method="post">
        学院名称&nbsp;<input type="text" name="name" placeholder="请输入学院名称" value="${param.old}">
        <input type="hidden" name="methods" value="update">
        <input type="hidden" name="oldname" value="${param.old}">
        <p style="margin-top: 30px;padding-right: 10px"><button type="submit" class="btn btn-success">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="reset" class="btn btn-warning" style="padding-right: 10px">重置</button>
        </p>
    </form>
</div>

</body>
</html>
