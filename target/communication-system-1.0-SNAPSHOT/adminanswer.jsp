<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 54456
  Date: 2021/12/29
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="./bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="./bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
<html>
<head>
    <title>自己的问题汇总</title>
    <style type="text/css">
        .page{
            text-align: center;
            margin-top: 50px;
        }
        .page a,.page span{
            text-decoration: none;
            border:1px solid #f9d52b;
            padding: 5px 7px;
            color: #767675;
            cursor: pointer;
        }.page a:hover,.page span:hover{
             color: red;
         }

    </style>
</head>
<body>
<div style="margin: 20px;text-align: center">所有的回答信息</div>
<table class="table table-hover" align="center" width="500"height="249" border="1"
       cellspacing="0" style="text-align: center">
    <thead>
    <tr>
        <th>id</th>
        <th>日期</th>
        <th>所属课程</th>
        <th>回答内容</th>
        <th>回答的教师号</th>
        <th>修改操作</th>
        <th>删除操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allanswer}" var="vars" begin="${param.index*5-5}" end="${param.index*5-1}" step="1" varStatus="i">
        <tr>
            <td>${vars.id}</td>
            <td>${vars.time}</td>
            <td>${vars.cname}</td>
            <td>${vars.content}</td>
            <td>${vars.tno}</td>
            <td><button type="button" onclick="javascrtpt:window.location.href='adminupdateanswer.jsp?i=${i.index}'" class="btn btn-info" >修改</button></td>
            <td><button type="button" onclick="javascrtpt:window.location.href='answeraction?methods=delete&id=${vars.id}'" class="btn btn-danger">删除</button></td>
        </tr>
    </c:forEach>
    <c:if test="${allanswer=='[]'}"><td colspan="6"><h3 style="text-align: center">当前尚未有回答！</h3></td></c:if>
    </tbody>
</table>
<div class="page">
    <c:if test="${param.index>1}"><a href="adminanswer.jsp?index=${param.index-1}&n=${param.n}">上一页</a></c:if>
    <a href="Javascript: void(0)">第${param.index}页  共${param.n}页</a>
    <c:if test="${param.index<param.n}"><a href="adminanswer.jsp?index=${param.index+1}&n=${param.n}">下一页</a></c:if>

</div>
</body>
</html>
