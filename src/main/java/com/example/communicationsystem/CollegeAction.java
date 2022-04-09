package com.example.communicationsystem;


import Dao.Colleges.CollegeDao;
import Dao.Colleges.CollegeDaoImpl;
import Dao.DaoException;
import javabean.College;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CollegeAction",  urlPatterns = "/collegeaction")
public class CollegeAction extends HttpServlet {
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
        if (methods.equals("delete")){
            delete(request,response);
        }else{
            quary(request,response);
        }

    }
    protected void add(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        CollegeDao dao = new CollegeDaoImpl();
        boolean success = false;
        try {
            String name = request.getParameter("name").trim();
            String num = request.getParameter("num");
            College college = new College();
            college.setName(name);
            success=dao.addcollege(college);
            if(!success){
                System.out.println("添加失败");
                response.sendRedirect("addcollege.html?error1=no");
            }else {
                System.out.println("添加成功");
                response.sendRedirect("addcollege.html?error1=yes");
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
        CollegeDao dao = new CollegeDaoImpl();
        boolean success = false;
        try {
            String name = request.getParameter("name").trim();
            College college = new College();
            college.setName(name);
            String oldname = request.getParameter("oldname");
            success=dao.updatecollege(college,oldname);
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
        CollegeDao dao = new CollegeDaoImpl();
        boolean success = false;
        try {
            String name = request.getParameter("name").trim();
            College college = new College();
            college.setName(name);
            success=dao.deletecollege(college);
            if(!success){
                System.out.println("删除失败");
                response.sendRedirect("MainCollege.jsp?error2=no");
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
        CollegeDao dao = new CollegeDaoImpl();
        List<College> colleges;
        try {
            colleges=dao.findAllcollege();
            if(colleges==null){
                System.out.println("查询失败");
                response.sendRedirect("MainCollege.jsp");
            }else {
                System.out.println("查询成功");
                HttpSession session= request.getSession();
                session.setAttribute("colleges",colleges);
                response.sendRedirect("MainCollege.jsp");
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
