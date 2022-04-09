package com.example.communicationsystem;

import Dao.Answer.AnswerDao;
import Dao.Answer.AnswerDaoImpl;
import Dao.DaoException;
import Dao.Question.QuestionDao;
import Dao.Question.QuestionDaoImpl;
import Dao.Student.StudentDao;
import Dao.Student.StudentDaoImpl;
import javabean.Answer;
import javabean.Question;

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

@WebServlet(name = "AnswerAction",  urlPatterns = "/answeraction")
public class AnswerAction extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String methods = request.getParameter("methods");
        switch (methods){
            case "update":update(request,response);break;
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
            case "findallanswer":quary(request,response);break;
            case "quarynewanswer":quarynewanswer(request,response);break;
            case "detailanswer":detailanswer(request,response);break;
            default:break;
        }
    }
    private void delete(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        AnswerDao dao = new AnswerDaoImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            boolean success=dao.deleteanswer(id);
            if(!success){
                System.out.println("删除失败");
            }else{
                System.out.println("删除成功");
                quary(request,response);
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
        AnswerDao dao = new AnswerDaoImpl();
        Date date=new Date();   //这里的时util包下的
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //这是24时
        String Date=temp.format(date);
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            boolean success=dao.updateanswer(id,content,Date);
            if(!success){
                System.out.println("更改失败");
                response.sendRedirect("adminupdateanswer.jsp?success=no");
            }else{
                System.out.println("更改成功");
                quary(request,response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
    private void quary(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        AnswerDao dao = new AnswerDaoImpl();
        List<Answer>answers;
        try {
            answers=dao.findallanswer();
            if(answers==null){
                System.out.println("查询失败");
            }else{
                System.out.println("查询成功");
                HttpSession session= request.getSession();
                session.setAttribute("allanswer",answers);
                int n=(answers.size()-1)/5+1;
                response.sendRedirect("adminanswer.jsp?n="+n+"&index=1");
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    private void quarynewanswer(HttpServletRequest request,
                                  HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        QuestionDao dao = new QuestionDaoImpl();
        String sno=request.getParameter("sno");
        ArrayList<Question> questions;
        try {
            questions=dao.findquestiontoanswer2(sno);
            if(questions==null){
                System.out.println("查询失败");
                response.sendRedirect("studentmain.jsp");
            }else{
                System.out.println("查询成功");
                HttpSession session= request.getSession();
                session.setAttribute("newanswers",questions);
                int len=questions.size();
                int n=(len-1)/5+1;
                response.sendRedirect("studentmain.jsp?n="+n+"&len="+len);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
    private void detailanswer(HttpServletRequest request,
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
            }else{
                System.out.println("查询成功");
                HttpSession session= request.getSession();
                session.setAttribute("newanswer",answer);
                response.sendRedirect("detailnewanswer.jsp?index="+request.getParameter("i"));
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
