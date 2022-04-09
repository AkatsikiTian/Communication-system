<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>登录</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sign-in/">



    <!-- Bootstrap core CSS -->
    <link href="bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>


    <!-- Custom styles for this template -->
    <link href="login.css" rel="stylesheet">
</head>
<body class="text-center" style="background-image: url(album/login.jpg); width:100%;height: 100%;
  background-size: cover;background-attachment: fixed;background-repeat: no-repeat;">
<main class="form-signin">
    <form action="loginin" method="post">
        <img class="mb-4" src="./album/a.jpg" width="72" height="57">
        <h1 class="h3 mb-3 fw-normal">欢迎登陆教学在线留言答疑系统</h1>
        <div class="form-floating">
            <input type="text" class="form-control" id="floatingInput" placeholder="学号/工号/账号" name="username">
            <label for="floatingInput">Username</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" placeholder="密码" name="password">
            <label for="floatingPassword">Password</label>
        </div>
        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="check" name="check"> 记住我
            </label>
        </div>
        <div class="checkbox mb-3">
            <label>
                <input type="radio" value="student" name="position" checked>学生
            </label>
            <label>
                <input type="radio" value="teacher" name="position">老师
            </label>
            <label>
                <input type="radio" value="admin" name="position">管理员
            </label>
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit">点我登陆</button>
        <p><a href="register.html">没有账号，点我注册！</a> </p>
        <p class="mt-5 mb-3 text-muted">cover by wjt</p>
    </form>
</main>
</body>
</html>
<script>
    //取出传回来的参数error并与yes比较
    var errori ='<%=request.getParameter("error")%>';
    var success ='<%=request.getParameter("success")%>';
    var csuccess ='<%=request.getParameter("csuccess")%>';
    if(errori=="yes"){undefined
        alert("用户名或密码错误!");
    }
    if (success=="yes"){
        alert("注册成功");
    }
    if (csuccess=='yes'){
        alert("密码修改成功");
    }
</script>