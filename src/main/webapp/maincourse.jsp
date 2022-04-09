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
  <title>修改和删除课程</title>
</head>
<body>
  <table class="table table-hover" align="center" width="500"height="249" border="1"
         cellspacing="0" style="text-align: center">
    <caption>课程信息</caption>
    <thead>
    <tr>
      <th>课程编号</th>
      <th>课程名称</th>
      <th>所属学院</th>
      <th>授课教师</th>
      <th>课程简介</th>
      <th>修改</th>
      <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${courses}" var="vars" varStatus="i">
      <tr>
        <td>${vars.cno}</td>
        <td>${vars.cname}</td>
        <td>${vars.name}</td>
        <td>${vars.tname}</td>
        <td>${vars.content}</td>
        <td><a href="updatecourse.jsp?cno=${vars.cno}&cname=${vars.cname}
&name=${vars.name}&tname=${vars.tname}&content=${vars.content}&
tno=${vars.tno}&college=${vars.college}">修改</a></td>
        <td><a href="courseaction?Cno=${vars.cno}&methods=delete">删除</a></td>
      </tr>
    </c:forEach>
    <c:if test="${courses=='[]'}"><td colspan="7"><h3 style="text-align: center">当前无课程信息，请先添加课程！</h3></td></c:if>
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