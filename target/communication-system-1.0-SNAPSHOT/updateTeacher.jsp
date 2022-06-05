<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 54456
  Date: 2021/12/15
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改教师信息</title>
</head>
<link href="./bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="./bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
<div style="width:100%;text-align:center;margin-top: 50px">
    <h3 style="margin: 20px;padding: 10px">修改教师信息</h3>
    <form action="teacheraction" method="post">
        工号：&nbsp;<input type="text" name="num" placeholder="请输入老师的工号" value="${param.tno}"><br/><br/>
        名字：&nbsp;<input type="text" name="name" placeholder="请输入老师的名字" value="${param.tname}"><br/><br/>
        职称：&nbsp;<select name="Prof" style="width: 18%" value="${param.prof}">
        <option value="教授" <c:if test="${param.prof=='教授'}">selected="selected"</c:if>> 教授</option>
        <option value="副教授" <c:if test="${param.prof=='副教授'}">selected="selected"</c:if>>副教授</option>
        <option value="讲师" <c:if test="${param.prof=='讲师'}">selected="selected"</c:if>>讲师</option>
        <option value="助教" <c:if test="${param.prof=='助教'}">selected="selected"</c:if>>助教</option>
    </select><br/><br/>
        简介:<textarea name="introduction" placeholder="请输入老师的简介" rows="3" cols="20">${param.introduction}</textarea>
        <input type="hidden" name="methods" value="update">
        <input type="hidden" name="oldtno" value="${param.tno}">
        <p style="margin-top: 30px;padding-right: 10px"><button type="submit" class="btn btn-success">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="reset" class="btn btn-warning" style="padding-right: 10px">重置</button>
        </p>
    </form>
</div>
</body>
</html>
