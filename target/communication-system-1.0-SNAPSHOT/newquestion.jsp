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
    <title>回答新问题</title>
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
<nav class="navbar navbar-expand-lg" aria-label="Tenth navbar example" style="background-color: rgb(200,200,169);padding: 0px">
    <div class="navbar-brand col-md-3 col-lg-2 me-0 px-3" style="text-align: center;padding: 8px;background-color: gray;color: whitesmoke">教师端</div>
    <div class="navbar-collapse justify-content-md-end collapse" id="navbarsExample08" >
        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <div class="nav-link dropdown-toggle" id="dropdown08" data-bs-toggle="dropdown" aria-expanded="false" style="color: black">登陆成功，欢迎您${name}老师!</div>
                <ul class="dropdown-menu" aria-labelledby="dropdown08">
                    <li><a class="dropdown-item" href="changepassword.jsp">修改密码</a></li>
                    <li><a class="dropdown-item" href="loginin.jsp">登出</a></li>
                </ul>
            </li>
        </ul>
    </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
            <div class="position-sticky pt-3">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="questionaction?tno=${username}&methods=quarynewquestion">
                            <span data-feather="course"></span>
                            返回主页
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <h2 style="margin: 20px;text-align: center">新的提问信息</h2>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                <thead>
                <tr>
                    <th>标题</th>
                    <th>日期</th>
                    <th>所属课程</th>
                    <th>提问内容</th>
                    <th>修改操作</th>
                    <th>删除操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${newquestions}" var="vars" begin="${param.index*5-5}" end="${param.index*5-1}" step="1" varStatus="i">
                    <tr>
                        <td>${vars.title}</td>
                        <td>${vars.time}</td>
                        <td>${vars.cname}</td>
                        <td>${vars.content}</td>
                        <td><button type="button" onclick="javascrtpt:window.location.href='answerquestion.jsp?i=${i.index}'" class="btn btn-info" >回答</button></td>
                        <td><button type="button" onclick="javascrtpt:window.location.href='questionaction?methods=delete&id=${vars.id}&new=yes'" class="btn btn-danger">删除</button></td>
                    </tr>
                </c:forEach>
                <c:if test="${newquestions=='[]'}"><td colspan="6"><h3 style="text-align: center">当前尚未有新的提问</h3></td></c:if>
                </tbody>
            </table>
            </div>
            <div class="page">
                <c:if test="${param.index>1}"><a href="newquestion.jsp?index=${param.index-1}&n=${param.n}">上一页</a></c:if>
                <a href="Javascript: void(0)">第${param.index}页  共${param.n}页</a>
                <c:if test="${param.index<param.n}"><a href="newquestion.jsp?index=${param.index+1}&n=${param.n}">下一页</a></c:if>
            </div>
        </main>
    </div>
</div>
<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
</body>
</html>
