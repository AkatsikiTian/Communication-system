<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 54456
  Date: 2022/1/1
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="./bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="./bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
<html>
<head>
    <title>回答</title>
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
    <div class="navbar-brand col-md-3 col-lg-2 me-0 px-3" style="text-align: center;padding: 8px;background-color: gray;color: whitesmoke">学生端</div>
    <div class="navbar-collapse justify-content-md-end collapse" id="navbarsExample08" >
        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <div class="nav-link dropdown-toggle" id="dropdown08" data-bs-toggle="dropdown" aria-expanded="false" style="color: black">登陆成功，欢迎${name}同学!</div>
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
                        <a class="nav-link active" aria-current="page" href="answeraction?sno=${username}&methods=quarynewanswer">
                            <span data-feather="course"></span>
                            返回主页
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="javascript:window.history.go(-1);">
                            <span data-feather="course"></span>
                            返回上一页
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <h2 style="margin: 20px;text-align: center">回答信息</h2>
            <div class="table-responsive">
                <div>问题标题：${questions[param.index].title}</div>
                <div>问题提问时间：${questions[param.index].time}</div>
                <div>问题所属课程：${questions[param.index].cname}</div>
                <div>问题内容：${questions[param.index].content}</div>
                <hr/>
                <h3><strong>老师回答</strong></h3>
                <c:if test="${newanswer!='false'}">
                    <div>回答内容：${newanswer.content}</div>
                    <div>回答时间：${newanswer.time}</div>
                </c:if>
                <c:if test="${newanswer=='false'}">
                    <h4><strong>未解答！</strong></h4>
                </c:if>
            </div>

        </main>
    </div>
</div>
<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
</body>
</html>
