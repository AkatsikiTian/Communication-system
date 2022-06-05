<%--
  Created by IntelliJ IDEA.
  User: 54456
  Date: 2021/12/31
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>回答</title>

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
        input{
            width: 300px;
            height: 30px;
            border-radius: 8px;
        }
    </style>


    <!-- Custom styles for this template -->
    <link href="login.css" rel="stylesheet">
</head>
<body>
<div style="width:100%;text-align:center;margin-top: 50px">
    <h3 class="h3 mb-3 fw-normal">修改回答</h3>
    <form action="answeraction" method="post">
        <input type="hidden" name="tno" value="${allanswer[param.i].tno}">
        课程名：<input type="text"  name="cname" value="${allanswer[param.i].cname}" readonly><br/><br/>
        <input type="hidden" name="id" value="${allanswer[param.i].id}">
        <input type="hidden" name="methods" value="update">
        <textarea name="content" cols="34" rows="5" placeholder="请输入内容">${allanswer[param.i].content}</textarea><br/>
        <button type="submit" class="btn btn-success">提交</button>&nbsp;
        <button type="reset" class="btn btn-warning" style="margin-left: 10px">重置</button>
    </form>
</div>
</body>
</html>
<script>
    //取出传回来的参数error并与yes比较
    var success ='<%=request.getParameter("success")%>';
    if(success=="yes"){undefined
        alert("回答更新成功!");
    }else if (success=="no"){undefined
        alert("回答更改失败，请稍后提交再试！");
    }
</script>