package com.example.communicationsystem;

import Dao.Accout.AccountDAO;
import Dao.Accout.AccountDaoImpl;
import Dao.Student.StudentDao;
import Dao.Student.StudentDaoImpl;
import Dao.DaoException;
import javabean.Account;
import javabean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Register",  urlPatterns = "/register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        AccountDAO dao = new AccountDaoImpl();
        StudentDao dao1 = new StudentDaoImpl();
        boolean success = false;
        boolean success1 = false;
        try {
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            String position = "student";
            String Name = request.getParameter("name").trim();
            Account account=new Account(username,password,position,Name);
            Student student=new Student(username,Name);
            success = dao.addaccount(account);
            if(success){
                success1=dao1.addstudent(student);
                if (success1){
                    System.out.println("注册成功");
                    response.sendRedirect("loginin.jsp?success=yes");
                }else {
                    System.out.println("注册失败");
                    dao.deleteaccount(account);
                    response.sendRedirect("register.html?success=no");
                }
            }else {
                System.out.println("注册失败");
                response.sendRedirect("register.html?success=no");
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

}
