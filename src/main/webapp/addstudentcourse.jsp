<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 54456
  Date: 2021/12/16
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="./bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="./bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
<html>
<head>
    <title>课程主页</title>
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
<div style="margin: 20px;text-align: center">学生的课程信息</div>
<div style="float: right">
    <form action="teacheraction" method="post" name="myForm">
        <input type="text" name="sno" placeholder="输入学生学号进行添加">
        <input type="hidden" name="methods" value="addstudent">
        <input type="hidden" name="cno" value="${param.cno}">
        <button type="submit" class="btn btn-primary">增加学生</button>
    </form>
</div>
<table class="table table-hover" align="center" width="500"height="249" border="1"
       cellspacing="0" style="text-align: center">
    <thead>
    <tr>
        <th>课程名称</th>
        <th>学生姓名</th>
        <th>删除学员</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="vars" begin="${param.index*5-5}" end="${param.index*5-1}" step="1" varStatus="i">
        <tr>
            <td>${vars.sno}</td>
            <td>${vars.name}</td>
            <td><button type="button" class="btn btn-danger" onclick="javascrtpt:window.location.href='teacheraction?sno=${vars.sno}&cno=${param.cno}&methods=deletestudent'">删除</button></td>
        </tr>
    </c:forEach>
    <c:if test="${students=='[]'}"><td colspan="7"><h3 style="text-align: center">老师尚未有学生，请添加学生！</h3></td></c:if>
    </tbody>
</table>
<div class="page">
    <c:if test="${param.index>1}"><a href="addstudentcourse.jsp?index=${param.index-1}&n=${param.n}&cno=${param.cno}">上一页</a></c:if>
    <a href="Javascript: void(0)">第${param.index}页  共${param.n}页</a>
    <c:if test="${param.index<param.n}"><a href="addstudentcourse.jsp?index=${param.index+1}&n=${param.n}&cno=${param.cno}">下一页</a></c:if>
</div>
</body>
</html>
<script>
    //取出传回来的参数error并与yes比较
    var errori ='<%=request.getParameter("error1")%>';
    var index = <%=request.getParameter("index")%>;
    var n = <%=request.getParameter("n")%>
        console.log(errori);
    if(errori=="no") {
        undefined
        alert("添加失败!");
    }
    var error ='<%=request.getParameter("error2")%>';
    if(error=="no") {
        undefined
        alert("删除失败!");
    }
    function detailpage(){
        var tno='<%=request.getParameter("tno")%>';
    }
</script>