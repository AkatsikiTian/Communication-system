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
import javabean.TC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "QuestionAction",  urlPatterns = "/questionaction")
public class QuestionAction extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String methods = request.getParameter("methods");
        switch (methods){
            case "update":update(request,response);break;
            case "addanswer":addanswer(request,response);break;
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
            case "findallquestion":findallquestion(request,response);break;
            case "quarynewquestion":quarynewquestion(request,response);break;
            default:break;
        }
    }
    protected void findallquestion(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        QuestionDao dao = new QuestionDaoImpl();
        ArrayList<Question> questions;
        try {
            questions=dao.findallquestion();
            if(questions==null){
                System.out.println("查询失败");
            }else{
                System.out.println("查询成功");
                HttpSession session= request.getSession();
                session.setAttribute("allquestion",questions);
                int n=(questions.size()-1)/5+1;
                response.sendRedirect("adminquestion.jsp?n="+n+"&index=1");
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
                if (request.getParameter("new").equals("yes")){
                    quarynewquestion(request,response);
                }else{
                    findallquestion(request,response);
                }

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
                findallquestion(request,response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    private void quarynewquestion(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        QuestionDao dao = new QuestionDaoImpl();
        String tno=request.getParameter("tno");
        ArrayList<Question>questions;
        try {
            questions=dao.findquestiontoanswer(tno);
            if(questions==null){
                System.out.println("查询失败");
                response.sendRedirect("tearchermain.jsp");
            }else{
                System.out.println("查询成功");
                HttpSession session= request.getSession();
                session.setAttribute("newquestions",questions);
                int len=questions.size();
                int n=(len-1)/5+1;
                response.sendRedirect("teachermain.jsp?n="+n+"&len="+len);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    protected void addanswer(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        AnswerDao dao = new AnswerDaoImpl();
        Date date=new Date();   //这里的时util包下的
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //这是24时
        String Date=temp.format(date);
        String content = request.getParameter("content");
        String tno = request.getParameter("tno");
        int questionid = Integer.parseInt(request.getParameter("questionid"));
        int cno = Integer.parseInt(request.getParameter("cno"));
        Answer answer = new Answer();
        answer.setCno(cno);
        answer.setTno(tno);
        answer.setContent(content);
        answer.setTime(Date);
        answer.setQuestionid(questionid);
        try {
            boolean success=dao.addanswer(answer);
            if(!success){
                System.out.println("添加失败");
                quarynewquestion(request,response);
            }else{
                System.out.println("添加成功");
                quarynewquestion(request,response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
