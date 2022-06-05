<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 54456
  Date: 2021/12/16
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改和删除老师</title>
</head>
<body>
    <table class="table table-hover" align="center" width="500"height="249" border="1"
           cellspacing="0" style="text-align: center">
        <caption>老师信息</caption>
        <thead>
        <tr>
            <th>教师编号</th>
            <th>教师姓名</th>
            <th>教师职称</th>
            <th>所授课程</th>
            <th>教师简介</th>
            <th>修改</th>
            <th>删除</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${teachers}" var="vars" varStatus="i">
            <tr>
                <td>${vars.tno}</td>
                <td>${vars.tname}</td>
                <td>${vars.prof}</td>
                <td><a href="teacheraction?Tno=${vars.tno}&methods=quarycourse">课程</a></td>
                <td>${vars.introduction}</td>
                <td><a href="updateTeacher.jsp?tno=${vars.tno}&tname=${vars.tname}
                &prof=${vars.prof}&introduction=${vars.introduction}">修改</a></td>
                <td><a href="teacheraction?Tno=${vars.tno}&methods=delete">删除</a></td>
            </tr>
        </c:forEach>
        <c:if test="${teachers=='[]'}"><td colspan="7"><h3 style="text-align: center">当前无教师信息，请先添加教师！</h3></td></c:if>
        </tbody>
    </table>
</body>
</html>
<script>
    //取出传回来的参数error并与yes比较
    var errori ='<%=request.getParameter("error1")%>';
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
</script>