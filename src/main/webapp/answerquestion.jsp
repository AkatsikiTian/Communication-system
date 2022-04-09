<%--
  Created by IntelliJ IDEA.
  User: 54456
  Date: 2021/12/31
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="./bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="./bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
<html>
<head>
    <title>回答问题</title>
</head>
<style>
</style>
<body style="text-align: center">
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
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4" style="margin: 20px">

            <div>标题:${newquestions[param.i].title}</div><br/><br/>
            <div>内容:${newquestions[param.i].content}</div><br/><br/>
            <div>课程:${newquestions[param.i].cname}</div><br/><br/>
            <hr/>
            <form action="questionaction" method="post">
                回答：<br/><textarea name="content" placeholder="请输入您的解答"></textarea>
                <input name="tno" value="${username}" type="hidden">
                <input type="hidden" name="cno" value="${newquestions[param.i].cno}">
                <input type="hidden" name="questionid" value="${newquestions[param.i].id}">
                <input type="hidden" name="methods" value="addanswer">
                <button type="submit" class="btn btn-success" >提交</button>
            </form>
        </main>
    </div>
</div>
<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
</body>
</html>
