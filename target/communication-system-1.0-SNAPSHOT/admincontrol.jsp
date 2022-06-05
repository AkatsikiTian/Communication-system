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
    <title>后台管理系统</title>
</head>
<link href="./bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="./bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" aria-label="Tenth navbar example">

        <div class="navbar-collapse justify-content-md-end collapse" id="navbarsExample08">
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <div class="nav-link dropdown-toggle" id="dropdown08" data-bs-toggle="dropdown" aria-expanded="false">登陆成功，欢迎你${name}</div>
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
                <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                    <span>对课程可操作的功能：</span>
                </h6>
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#" onclick="addCoursePage()">
                            <span data-feather="course"></span>
                            增加课程信息
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" onclick="changeCoursePage()">
                            <span data-feather="file"></span>
                            删改课程信息
                        </a>
                    </li>
                    <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                        <span>对教师可操作的功能：</span>
                    </h6>
                    <li class="nav-item">
                        <a class="nav-link" href="#" onclick="addTeacherPage()">
                            <span data-feather="users" ></span>
                            增加教师信息
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" onclick="updateTeacherPage()">
                            <span data-feather="users"></span>
                            删除或修改教师信息
                        </a>
                    </li>
                    <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                        <span>对学院可操作的功能：</span>
                    </h6>
                    <li class="nav-item">
                        <a class="nav-link" href="#" onclick="addCollegePage()">
                            <span data-feather="bar-chart-2"></span>
                            增加学院信息
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" onclick="MainCollegePage()">
                            <span data-feather="layers"></span>
                            删改学院信息
                        </a>
                    </li>
                </ul>

                <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                    <span>其余功能：</span>
                </h6>
                <ul class="nav flex-column mb-2">
                    <li class="nav-item">
                        <a class="nav-link" href="javascript:void(0)" onclick="changequestion()">
                            <span data-feather="file-text"></span>
                            删除或修改所有课程交流和留言信息。
                        </a>
                    </li>
                </ul>
                <ul class="nav flex-column mb-2">
                    <li class="nav-item">
                        <a class="nav-link" href="javascript:void(0)" onclick="changeanswer()">
                            <span data-feather="file-text"></span>
                            删除或修改所有回答信息。
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <iframe scrolling="auto" name="iframe1" id="iframe1" frameborder="0"  scrolling="no" width="100%" height="550"></iframe>
            </div>
        </main>
    </div>
</div>

<script language="JavaScript">
    function addCoursePage(){
        var iframe1=document.getElementById("iframe1");
        iframe1.src="courseaction?methods=q";
        return true;
    }
    function changeCoursePage(){
        var iframe1=document.getElementById("iframe1");
        iframe1.src="courseaction?methods=quary";
        return true;
    }
    function addCollegePage(){
        var iframe1=document.getElementById("iframe1");
        iframe1.src="addcollege.html";
        return true;
    }
    function MainCollegePage(){
        var iframe1=document.getElementById("iframe1");
        iframe1.src="collegeaction?methods=quary";
        return true;
    }
    function addTeacherPage(){
        var iframe1=document.getElementById("iframe1");
        iframe1.src="addteachers.html";
        return true;
    }
    function updateTeacherPage(){
        var iframe1=document.getElementById("iframe1");
        iframe1.src="teacheraction?methods=quary";
        return true;
    }
    function changequestion(){
        var iframe1=document.getElementById("iframe1");
        iframe1.src="questionaction?methods=findallquestion";
        return true;
    }
    function changeanswer(){
        var iframe1=document.getElementById("iframe1");
        iframe1.src="answeraction?methods=findallanswer";
        return true;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
</body>
</html>
