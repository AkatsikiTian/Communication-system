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
import Dao.Teacher.TeacherDao;

import Dao.Teacher.TeacherDaoImpl;
import javabean.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "TeacherAction",  urlPatterns = "/teacheraction")
public class TeacherAction extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String methods = request.getParameter("methods");
        switch (methods){
            case "add":add(request,response);break;
            case "update":update(request,response);break;
            case "delete":delete(request,response);break;
            case "quary":quary(request,response);break;
            case "addstudent":addstudent(request,response);break;
            case "updateanswer":updateanswer(request,response);break;
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
            case "add":add(request,response);break;
            case "update":update(request,response);break;
            case "delete":delete(request,response);break;
            case "quary":quary(request,response);break;
            case "quarystudent":quarystudent(request,response);break;
            case "deletestudent":deletestudent(request,response);break;
            case "findmyanswer":findmyanswer(request,response);break;
            case "deleteanswer":deleteanswer(request,response);break;
            default:quarycourse(request,response);
        }
    }
    protected void add(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        TeacherDao dao = new TeacherDaoImpl();
        boolean success = false;
        try {
            String num = request.getParameter("num");
            String name = request.getParameter("name").trim();
            String prof = request.getParameter("Prof");
            String introduction = request.getParameter("introduction");
            Teacher teacher = new Teacher();
            teacher.setTno(num);
            teacher.setTname(name);
            teacher.setProf(prof);
            teacher.setIntroduction(introduction);
            success=dao.addteacher(teacher);
            if(!success){
                System.out.println("添加失败");
                response.sendRedirect("addteachers.html?error1=no");
            }else {
                System.out.println("添加成功");
                response.sendRedirect("addteachers.html?error1=yes");
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
    protected void update(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        TeacherDao dao = new TeacherDaoImpl();
        boolean success = false;
        try {
            String Tno=request.getParameter("num").trim();
            String Tname=request.getParameter("name");
            String Prof=request.getParameter("Prof");
            String introduction=request.getParameter("introduction");
            String oldtno = request.getParameter("oldtno");
            Teacher teacher = new Teacher(Tno,Tname,Prof,introduction);
            success=dao.updateteacher(teacher,oldtno);
            if(!success){
                System.out.println("修改失败");
                response.sendRedirect("MainCollege.jsp?error1=no");
            }else {
                System.out.println("修改成功");
                quary(request,response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
    protected void delete(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        TeacherDao dao = new TeacherDaoImpl();
        boolean success = false;
        try {
            String Tno = request.getParameter("Tno").trim();
            Teacher teacher = new Teacher();
            teacher.setTno(Tno);
            success=dao.deleteteacher(teacher);
            if(!success){
                System.out.println("删除失败");
                response.sendRedirect("mainteacher.jsp?error2=no");
            }else {
                System.out.println("删除成功");
                quary(request,response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
    protected void quary(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        TeacherDao dao = new TeacherDaoImpl();
        List<Teacher> teachers;
        try {
            teachers=dao.findAllteacher();
            if(teachers==null){
                System.out.println("查询失败");
                response.sendRedirect("mainteacher.jsp");
            }else {
                System.out.println("查询成功");
                HttpSession session= request.getSession();
                session.setAttribute("teachers",teachers);
                response.sendRedirect("mainteacher.jsp");
            }
        } catch (DaoException e) {
            e.printStackTrace();
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
            courses=dao.findCourse(request.getParameter("Tno"));
            if(courses==null){
                System.out.println("查询失败");
            }else {
                System.out.println("查询成功");
                HttpSession session= request.getSession();
                session.setAttribute("courses",courses);
                System.out.println(request.getParameter("isteacher"));
                if (request.getParameter("isteacher")!=null){
                    System.out.println("此处有在运行");
                    int n=(courses.size()-1)/5+1;
                    response.sendRedirect("teachercourse.jsp?n="+n+"&index=1&tno="+request.getParameter("Tno"));
                }else{
                    response.sendRedirect("maincourse.jsp");
                }

            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
    protected void quarystudent(HttpServletRequest request,
                               HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        TeacherDao dao = new TeacherDaoImpl();
        List<Student> students=null;
        try {
            students=dao.quarystudent(Integer.parseInt(request.getParameter("cno")));
            if(students==null){
                System.out.println("查询失败");
            }else {
                System.out.println("查询成功");
                HttpSession session= request.getSession();
                session.setAttribute("students",students);
                    int n=(students.size()-1)/5+1;
                System.out.println(students.size());
                    response.sendRedirect("addstudentcourse.jsp?n="+n+"&index=1&cno="+request.getParameter("cno"));

            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
    protected void addstudent(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        TeacherDao dao = new TeacherDaoImpl();
        boolean success = false;
        try {
            String sno = request.getParameter("sno");
            int cno = Integer.parseInt(request.getParameter("cno"));
            success=dao.addstudent(sno,cno);
            if(!success){
                System.out.println("添加失败");
                HttpSession session= request.getSession();
                List<Student> students= (List<Student>) session.getAttribute("students");
                int n=(students.size()-1)/5+1;
                response.sendRedirect("addstudentcourse.jsp?error1=no&n="+n+"&index=1&cno="+request.getParameter("cno"));
            }else {
                System.out.println("添加成功");
                quarystudent(request,response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    protected void deletestudent(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        TeacherDao dao = new TeacherDaoImpl();
        boolean success = false;
        try {
            String sno = request.getParameter("sno");
            int cno = Integer.parseInt(request.getParameter("cno"));
            success=dao.deletestudent(sno,cno);
            if(!success){
                System.out.println("删除失败");
                HttpSession session= request.getSession();
                List<Student> students= (List<Student>) session.getAttribute("students");
                int n=(students.size()-1)/5+1;
                response.sendRedirect("addstudentcourse.jsp?error1=no&n="+n+"&index=1&cno="+request.getParameter("cno"));
            }else {
                System.out.println("删除成功");
                quarystudent(request,response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    protected void findmyanswer(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        AnswerDao dao = new AnswerDaoImpl();
        QuestionDao dao1 = new QuestionDaoImpl();
        List<Answer> answers=null;
        List<Question> questions=null;
        try {
            answers = dao.findmyanswer(request.getParameter("tno"));
            questions = dao1.findquestiontoanswer1(request.getParameter("tno"));
            if(answers==null||questions==null){
                System.out.println("查询失败");
            }else {
                System.out.println("查询成功");
                HttpSession session= request.getSession();
                session.setAttribute("answers",answers);
                session.setAttribute("questions",questions);
                int n=(answers.size()-1)/5+1;
                System.out.println(answers.size());
                response.sendRedirect("myanswer.jsp?n="+n+"&index=1&cno="+request.getParameter("cno"));

            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    private void deleteanswer(HttpServletRequest request,
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
                findmyanswer(request,response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    private void updateanswer(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        AnswerDao dao = new AnswerDaoImpl();
        Date date=new Date();   //这里的时util包下的
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //这是24时
        String Date=temp.format(date);
        String content=request.getParameter("content");
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            boolean success=dao.updateanswer(id,content,Date);
            if(!success){
                System.out.println("更改失败");
                response.sendRedirect("updatequestion.jsp?success=no");
            }else{
                System.out.println("更改成功");
                findmyanswer(request,response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
