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
<div style="margin: 20px;text-align: center">自己的提问信息</div>
<table class="table table-hover" align="center" width="500"height="249" border="1"
       cellspacing="0" style="text-align: center">
    <thead>
    <tr>
        <th>标题</th>
        <th>日期</th>
        <th>所属课程</th>
        <th>提问内容</th>
        <th>查看老师回答</th>
        <th>修改操作</th>
        <th>删除操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${questions}" var="vars" begin="${param.index*5-5}" end="${param.index*5-1}" step="1" varStatus="i">
        <tr>
            <td>${vars.title}</td>
            <td>${vars.time}</td>
            <td>${vars.cname}</td>
            <td>${vars.content}</td>
            <td><button type="button" onclick="javascrtpt:parent.location.href='studentaction?methods=findanswer&i=${i.index}&sno=${username}&id=${vars.id}'" class="btn btn-primary" >查看回答</button></td>
            <td><button type="button" onclick="javascrtpt:window.location.href='updatequestion.jsp?i=${i.index}'" class="btn btn-info" >修改</button></td>
            <td><button type="button" onclick="javascrtpt:window.location.href='studentaction?methods=delete&id=${vars.id}&sno=${username}'" class="btn btn-danger">删除</button></td>
        </tr>
    </c:forEach>
    <c:if test="${questions=='[]'}"><td colspan="6"><h3 style="text-align: center">当前尚未有提问，快去提问吧！</h3></td></c:if>
    </tbody>
</table>
<div class="page">
    <c:if test="${param.index>1}"><a href="questionmain.jsp?index=${param.index-1}&n=${param.n}">上一页</a></c:if>
    <a href="Javascript: void(0)">第${param.index}页  共${param.n}页</a>
    <c:if test="${param.index<param.n}"><a href="questionmain.jsp?index=${param.index+1}&n=${param.n}">下一页</a></c:if>

</div>
</body>
</html>
