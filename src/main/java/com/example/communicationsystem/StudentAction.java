package com.example.communicationsystem;

import Dao.Answer.AnswerDao;
import Dao.Answer.AnswerDaoImpl;
import Dao.Course.CourseDao;
import Dao.Course.CourseDaoImpl;
import Dao.DaoException;
import Dao.Question.QuestionDao;
import Dao.Question.QuestionDaoImpl;
import Dao.Student.StudentDao;
import Dao.Student.StudentDaoImpl;
import javabean.Answer;
import javabean.Question;
import javabean.Student;
import javabean.TC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "StudentAction",  urlPatterns = "/studentaction")
public class StudentAction extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String methods = request.getParameter("methods");
        switch (methods){
            case "add":add(request,response);break;
            case "addquestion":addquestion(request,response);break;
            case "quary1":quary1(request,response);break;
            case "updatequestion":update(request,response);break;
            default:break;
        }
    }


    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String methods = request.getParameter("methods");
        switch (methods){
            case "delete":delete(request,response);break;
            case "findmyquestion":findmyquestion(request,response);break;
            case "findquestion":findquestion(request,response);break;
            case "findanswer":findanswer(request,response);break;
            default:quarycourse(request,response);
        }
    }
    protected void quarycourse(HttpServletRequest request,
                               HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        CourseDao dao = new CourseDaoImpl();
        List<TC> courses;
        try {
            courses=dao.findStudentCourse(request.getParameter("Sno"));
            if(courses==null){
                System.out.println("查询失败");
            }else {
                System.out.println("查询成功");
                HttpSession session= request.getSession();
                session.setAttribute("courses",courses);
                int n=(courses.size()-1)/5+1;
                response.sendRedirect("studentcourse.jsp?n="+n+"&index=1&sno="+request.getParameter("Sno"));
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
    protected void quary1(HttpServletRequest request,
                               HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        CourseDao dao = new CourseDaoImpl();
        String sno = request.getParameter("sno");
        String name = request.getParameter("name");
        String tno = request.getParameter("tno");
        System.out.println("name:"+name);
        System.out.println("tno:"+tno);
        List<TC> courses = null;
        try {
            if (!name.equals("")){
                courses=dao.findStudentCourse2(sno,name);
            }else if(!tno.equals("")){
                courses=dao.findStudentCourse1(sno,tno);
            }
            if(courses==null){
                System.out.println("查询失败");
            }else {
                System.out.println("查询成功");
                HttpSession session= request.getSession();
                session.setAttribute("courses",courses);
                int n=(courses.size()-1)/5+1;
                response.sendRedirect("studentcourse.jsp?n="+n+"&index=1&sno="+sno);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
    protected void add(HttpServletRequest request,
                               HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        StudentDao dao = new StudentDaoImpl();
        String sno = request.getParameter("sno");
        int cno = Integer.parseInt(request.getParameter("cno"));
        try {
            boolean success=dao.addstudentcourse(sno,cno);
            if(!success){
                System.out.println("添加失败");
                response.sendRedirect("addstudentcourse.jsp?error1=no");
            }else{
                System.out.println("添加成功");
                response.sendRedirect("addstudentcourse.jsp?error1=yes");
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
    protected void addquestion(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        QuestionDao dao = new QuestionDaoImpl();
        String sno = request.getParameter("sno");
        String content = request.getParameter("content");
        int cno = Integer.parseInt(request.getParameter("cno"));
        String title = request.getParameter("title");
        Date date=new Date();   //这里的时util包下的
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //这是24时
        String Date=temp.format(date);
        Question question = new Question(Date,content,sno,cno,title);
        try {
            boolean success=dao.addquestion(question);
            if(!success){
                System.out.println("添加失败");
                response.sendRedirect("askquestion.jsp?success=no");
            }else{
                System.out.println("添加成功");
                findmyquestion(request,response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    protected void findmyquestion(HttpServletRequest request,
                               HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        StudentDao dao = new StudentDaoImpl();
        ArrayList<Question> questions;
        try {
            questions=dao.findmyquestion(request.getParameter("sno"));
            if(questions==null){
                System.out.println("查询失败");
            }else{
                System.out.println("查询成功");
                HttpSession session= request.getSession();
                session.setAttribute("questions",questions);
                int n=(questions.size()-1)/5+1;
                response.sendRedirect("questionmain.jsp?n="+n+"&index=1&sno="+request.getParameter("sno"));
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
    private void update(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        StudentDao dao = new StudentDaoImpl();
        Date date=new Date();   //这里的时util包下的
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //这是24时
        String Date=temp.format(date);
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            boolean success=dao.updatequestion(title,content,Date,id);
            if(!success){
                System.out.println("更改失败");
                response.sendRedirect("updatequestion.jsp?success=no");
            }else{
                System.out.println("更改成功");
                findmyquestion(request,response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        StudentDao dao = new StudentDaoImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            boolean success=dao.deletequestion(id);
            if(!success){
                System.out.println("删除失败");
            }else{
                System.out.println("删除成功");
                findmyquestion(request,response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    protected void findquestion(HttpServletRequest request,
                                  HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        QuestionDao dao = new QuestionDaoImpl();
        AnswerDao dao1 = new AnswerDaoImpl();
        ArrayList<Question> questions;
        ArrayList<Answer> answers;
        try {
            questions=dao.findquestion(Integer.parseInt(request.getParameter("cno")));
            answers=dao1.findanswer(Integer.parseInt(request.getParameter("cno")));
            if(questions==null||answers==null){
                System.out.println("查询失败");
            }else{
                System.out.println("查询成功");
                HttpSession session= request.getSession();
                session.setAttribute("coursequestion",questions);
                session.setAttribute("courseanswer",answers);
                int n=(questions.size()-1)/5+1;
                response.sendRedirect("detailcourse.jsp?n="+n+"&index=1&i="+request.getParameter("i"));
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
    private void findanswer(HttpServletRequest request,
                              HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        AnswerDao dao = new AnswerDaoImpl();
        int id= Integer.parseInt(request.getParameter("id"));
        Answer answer;
        try {
            answer=dao.quaryanswer(id);
            if(answer==null){
                System.out.println("查询失败");
                HttpSession session= request.getSession();
                session.setAttribute("newanswer",false);
                response.sendRedirect("detailanswer.jsp?index="+request.getParameter("i"));
            }else{
                System.out.println("查询成功");
                HttpSession session= request.getSession();
                session.setAttribute("newanswer",answer);
                response.sendRedirect("detailanswer.jsp?index="+request.getParameter("i"));
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
