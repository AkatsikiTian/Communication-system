<%--
  Created by IntelliJ IDEA.
  User: 54456
  Date: 2021/12/13
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生主页</title>
</head>
<form id="form" action="answeraction" method="get">
    <input type="hidden" value="${username}" name="sno">
    <input type="hidden" name="methods" value="quarynewanswer">
</form>
<script>
    window.onunload=function(){
        document.getElementById("form").submit();
    }
</script>
<link href="./bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="./bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
<body>
<nav class="navbar navbar-expand-lg" aria-label="Tenth navbar example" style="background-color: rgb(200,200,169);padding: 0px">
    <div class="navbar-brand col-md-3 col-lg-2 me-0 px-3" style="text-align: center;padding: 8px;background-color: gray;color: whitesmoke">学生端</div>
    <div class="navbar-collapse justify-content-md-end collapse" id="navbarsExample08" >
        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <div class="nav-link dropdown-toggle" id="dropdown08" data-bs-toggle="dropdown" aria-expanded="false" style="color: black">登陆成功，欢迎${name}同学</div>
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
                        <a class="nav-link active" aria-current="page" href="#" onclick="mainPage()">
                            <span data-feather="course"></span>
                            主页
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#" onclick="myquestionPage()">
                            <span data-feather="course"></span>
                            我的提问
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="newanswer.jsp?n=${param.n}&index=1">
                            <span data-feather="course"></span>
                            新的回答(当前有${param.len}个新回答)
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <iframe scrolling="auto" name="iframe1" id="iframe1" frameborder="0"  scrolling="no" width="100%" height="550"
                        src="studentaction?methods=quarycourse&Sno=${username}"></iframe>
            </div>
        </main>
    </div>
</div>

<script language="JavaScript">
    function mainPage(){
        var iframe1=document.getElementById("iframe1");
        iframe1.src="studentaction?methods=quarycourse&Sno=${username}";
        return true;
    }
    function myquestionPage(){
        var iframe1=document.getElementById("iframe1");
        iframe1.src="studentaction?methods=findmyquestion&sno=${username}";
        return true;
    }
    function MainCollegePage(){
        var iframe1=document.getElementById("iframe1");
        iframe1.src="collegeaction?methods=quary";
        return true;
    }
</script>
<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
</body>
</html>
