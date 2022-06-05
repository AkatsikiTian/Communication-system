<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加课程</title>
</head>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="./bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="./bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
<body>
<div style="width:100%;text-align:center;margin-top: 50px">
    <h3 style="margin: 20px;padding: 10px">添加课程</h3>
    <form action="courseaction" method="post">
        课程名称:&nbsp;<input type="text" name="name" placeholder="请输入课程名称"><br/><br/>
        授课老师:&nbsp;<input type="text" name="tno" placeholder="请输入授课教师的工号"><br/><br/>
        开课学院：<select name="college" style="width: 18%">
        <c:forEach items="${colleges}" var="vars" varStatus="i">
            <option value="${vars.number}">${vars.name}</option>
        </c:forEach>
    </select><br/><br/>
        简&nbsp;&nbsp;&nbsp;&nbsp;介:&nbsp;<textarea name="content" placeholder="请输入课程的简介" rows="3" cols="20"></textarea>
        <input type="hidden" name="methods" value="add">
        <p style="margin-top: 30px;padding-right: 10px"><button type="submit" class="btn btn-success">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="reset" class="btn btn-warning" style="padding-right: 10px">重置</button>
        </p>
    </form>
</div>
<script type="text/javascript">
    function getUrlVars() {
        var vars = [],
            hash;
        var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
        for (var i = 0; i < hashes.length; i++) {
            hash = hashes[i].split('=');
            vars.push(hash[0]);
            vars[hash[0]] = hash[1];
        }
        return vars;
    }
    var success = getUrlVars()["error1"];
    console.log(success);
    if (success=="no"){
        alert("添加失败,可能是教师编号错误");
    }else if (success =="yes"){
        alert("添加成功");
    }
</script>
</body>
</html>
