package com.example.communicationsystem;

import Dao.Colleges.CollegeDao;
import Dao.Colleges.CollegeDaoImpl;
import Dao.Course.CourseDao;
import Dao.Course.CourseDaoImpl;
import Dao.DaoException;
import Dao.Teacher.TeacherDao;
import Dao.Teacher.TeacherDaoImpl;
import javabean.College;
import javabean.Course;
import javabean.TC;
import javabean.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CourseAction",  urlPatterns = "/courseaction")
public class CourseAction extends HttpServlet {
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
                case "delete":delete(request,response);break;
                case "quary":quary(request,response);break;
                default:quaryCollege(request,response);
            }
        }
        protected void add(HttpServletRequest request,
                HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            CourseDao dao = new CourseDaoImpl();
            boolean success = false;
            try {
                String name = request.getParameter("name").trim();
                String tno = request.getParameter("tno");
                int college = Integer.parseInt(request.getParameter("college"));
                String content = request.getParameter("content");
                Course course = new Course(name,college,content,tno);
                success=dao.addCourse(course);
                if(!success){
                    System.out.println("添加失败");
                    response.sendRedirect("addcourse.jsp?error1=no");
                }else {
                    System.out.println("添加成功");
                    response.sendRedirect("addcourse.jsp?error1=yes");
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
            CourseDao dao = new CourseDaoImpl();
            boolean success = false;
            try {
                int Cno= Integer.parseInt(request.getParameter("cno"));
                String Cname=request.getParameter("cname");
                int college= Integer.parseInt(request.getParameter("college"));
                String content = request.getParameter("content");
                String tno = request.getParameter("tno");
                Course course = new Course(Cname,college,content,tno);
                course.setCno(Cno);
                success=dao.updatecourse(course);
                if(!success){
                    System.out.println("修改失败");
                    response.sendRedirect("maincourse.jsp?error1=no");
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
            CourseDao dao = new CourseDaoImpl();
            boolean success = false;
            try {
                int Cno = Integer.parseInt(request.getParameter("Cno").trim());
                Course course = new Course();
                course.setCno(Cno);
                success=dao.deletecourse(course);
                if(!success){
                    System.out.println("删除失败");
                    response.sendRedirect("maincourse.jsp?error2=no");
                }else {
                    System.out.println("删除成功");
                    quary(request,response);
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
        protected void quaryCollege(HttpServletRequest request,
                HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            CollegeDao dao = new CollegeDaoImpl();
            List<College> colleges;
            try {
                colleges=dao.findAllcollege();
                if(colleges==null){
                    System.out.println("查询失败");
                }else {
                    System.out.println("查询成功");
                    HttpSession session= request.getSession();
                    session.setAttribute("colleges",colleges);
                    response.sendRedirect("addcourse.jsp");
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
        CourseDao dao = new CourseDaoImpl();
        List<TC> courses;
        CollegeDao dao1 = new CollegeDaoImpl();
        List<College> colleges;
        try {
            courses=dao.findAllCourse();
            colleges=dao1.findAllcollege();
            if(courses==null){
                System.out.println("查询失败");
            }else {
                System.out.println("查询成功");
                HttpSession session= request.getSession();
                session.setAttribute("courses",courses);
                session.setAttribute("colleges",colleges);
                response.sendRedirect("maincourse.jsp");
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
    }
