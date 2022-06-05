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
    <title>修改和删除学院</title>
</head>
<body>
    <table class="table table-hover" align="center" width="500"height="249" border="1"
           cellspacing="0" style="text-align: center">
        <caption>学院信息</caption>
        <thead>
        <tr>
            <th>学院编号</th>
            <th>学院名称</th>
            <th>修改</th>
            <th>删除</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${colleges}" var="vars" varStatus="i">
        <tr>
            <td>${vars.number}</td>
            <td>${vars.name}</td>
            <td><a href="updatecollege.jsp?old=${vars.name}">修改</a></td>
            <td><a href="collegeaction?num=${vars.number}&name=${vars.name}&methods=delete">删除</a></td>
        </tr>
        </c:forEach>
        <c:if test="${colleges=='[]'}"><td colspan="4"><h3 style="text-align: center">当前无学院信息，请先添加学院！</h3></td></c:if>
        </tbody>
    </table>
<c:if test="${colleges==null}"><h3 style="text-align: center">当前无学院信息，请先添加学院！</h3></c:if>
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