<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 54456
  Date: 2021/12/29
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    body{
        text-align: center;
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
<body>
        <div style="color: rgba(218,129,127,0.8)">课程名称：</div>
        <div style="color: rgba(204,121,119,0.55)">${courses[param.i].cname}</div>
        <div style="color: rgba(218,129,127,0.8)">主讲老师：</div>
        <div style="color: rgba(204,121,119,0.55)">${courses[param.i].tname}</div>
        <div style="color: rgba(218,129,127,0.8)">开课学院：</div>
        <div style="color: rgba(204,121,119,0.55)">${courses[param.i].name}</div>
        <div style="color: rgba(218,129,127,0.8)">课程介绍：</div>
        <div style="color: rgba(204,121,119,0.55)">${courses[param.i].content}</div>
        <hr/>
        <div>课程留言：</div>
        <c:forEach items="${coursequestion}" var="questions" begin="${param.index*5-5}" end="${param.index*5-1}" step="1" varStatus="i">
           <div> ${i.index+1}.标题:${questions.title}       时间：${questions.time}</div>
            <div>${questions.content}</div>
            <div>老师解答：</div>
            <c:if test="${questions.state==0}">未解答
                <c:if test="${position=='teacher'}">
                    <form action="questionaction" target="_parent" method="post">
                        我的回答：<input name="content" type="text" placeholder="请输入解答">
                        <input name="questionid" type="hidden" value="${questions.id}">
                        <input name="cno" type="hidden" value="${questions.cno}">
                        <input name="tno" type="hidden" value="${username}">
                        <input name="questionid" type="hidden" value="${vars.id}">
                        <input name="methods" type="hidden" value="addanswer">
                        <button type="submit" class="btn btn-primary">提交</button>
                    </form>
                </c:if>
            </c:if>
            <c:if test="${questions.state==1}">
                <c:forEach items="${courseanswer}" var="vars">
                    <c:if test="${questions.id==vars.questionid}">
                            时间：<div>${vars.time}</div>
                            解答内容：<div>${vars.content}</div>
                    </c:if>
                </c:forEach>
            </c:if>
            <br/>
        </c:forEach>
        <c:if test="${coursequestion=='[]'}"><td colspan="7"><h3 style="text-align: center">当前课程尚未有留言信息！</h3></td></c:if><br/>
        <div class="page">
            <c:if test="${param.index>1}"><a href="addstudentcourse.jsp?index=${param.index-1}&n=${param.n}&cno=${param.cno}">上一页</a></c:if>
            <a href="Javascript: void(0)">第${param.index}页  共${param.n}页</a>
            <c:if test="${param.index<param.n}"><a href="addstudentcourse.jsp?index=${param.index+1}&n=${param.n}&cno=${param.cno}">下一页</a></c:if>
        </div>

</body>
</html>
