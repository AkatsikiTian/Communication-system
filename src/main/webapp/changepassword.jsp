<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: 54456
  Date: 2021/12/16
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
</head>
<link href="./bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="./bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
<body>
<div style="width:100%;text-align:center;margin-top: 50px">
    <h3 style="margin: 20px;padding: 10px">修改密码</h3>
    <form action="changepsw" name="myForm" onsubmit="return validataForm()" method="post">
        原密码&nbsp;<input type="password" name="oldpassword" placeholder="请输入原密码"><br/>
        新密码&nbsp;<input type="password" style="margin-top: 5px" name="newpassword" placeholder="请输入新密码"><br/>
        确定密码&nbsp;<input type="password" style="margin-top: 5px" name="newpassword1" placeholder="请再输入一次新密码">
        <input type="hidden" name="username" value="${username}">
        <input type="hidden" name="position" value="${position}">
        <p style="margin-top: 30px;padding-right: 10px"><button type="submit" class="btn btn-success">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="reset" class="btn btn-warning" style="padding-right: 10px">重置</button>
        </p>
    </form>
</div>
<script language="JavaScript">
    function validataForm(){
        var  password= document.forms["myForm"]["newpassword"].value;
        var  password1= document.forms["myForm"]["newpassword1"].value;
        if(password.length<6){
            alert("密码小于六位");
            return false;
        }else if (password!=password1){
            alert("两次输入的密码不同");
            return false;
        }
        return true;
    }
    var csuccess ='<%=request.getParameter("csuccess")%>';
    if(csuccess=="no"){undefined
        alert("密码修改失败!");
    }
</script>
</body>
</html>
