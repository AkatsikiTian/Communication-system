<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 54456
  Date: 2021/12/29
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
<div style="margin: 20px;text-align: center">老师的课程信息</div>
<table class="table table-hover" align="center" width="500"height="249" border="1"
       cellspacing="0" style="text-align: center">
    <thead>
    <tr>
        <%--        <th>课程编号</th>--%>
        <th>课程名称</th>
        <th>所属学院</th>
        <th>授课教师</th>
        <%--        <th>课程简介</th>--%>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${courses}" var="vars" begin="${param.index*5-5}" end="${param.index*5-1}" step="1" varStatus="i">
        <tr>
            <td>${vars.cname}</td>
            <td>${vars.name}</td>
            <td>${vars.tname}</td>
            <td><button type="button" class="btn btn-primary" onclick="javascrtpt:window.location.href='teacheraction?' +
             'methods=quarystudent&cno=${vars.cno}'">添加/删除同学</button></td>
            <td><button type="button" class="btn btn-info" onclick="javascrtpt:window.location.href='studentaction?' +
                    'cno=${vars.cno}&i=${i.index}&methods=findquestion'">查看</button></td>
        </tr>
    </c:forEach>
    <c:if test="${courses=='[]'}"><td colspan="7"><h3 style="text-align: center">当前无课程信息，请先添加课程！</h3></td></c:if>
    </tbody>
</table>
<div class="page">
    <c:if test="${param.index>1}"><a href="studentcourse.jsp?index=${param.index-1}&n=${param.n}">上一页</a></c:if>
    <a href="Javascript: void(0)">第${param.index}页  共${param.n}页</a>
    <c:if test="${param.index<param.n}"><a href="studentcourse.jsp?index=${param.index+1}&n=${param.n}">下一页</a></c:if>

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
        alert("修改失败!");
    }
    var error ='<%=request.getParameter("error2")%>';
    if(error=="no") {
        undefined
        alert("删除失败!");
    }
    function validataForm(){
        var  tno= document.forms["myForm"]["tno"].value;
        var  name= document.forms["myForm"]["name"].value;
        if(tno&&name||(!tno&&!name)){
            alert("同时输入两个参数或没输入，无效！请输入一个即可查询");
            return false;
        }else{
            return true;
        }
    }
    function detailpage(){
        var tno='<%=request.getParameter("tno")%>';
    }
</script>