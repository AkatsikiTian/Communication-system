package com.example.communicationsystem;

import Dao.Accout.AccountDAO;
import Dao.Accout.AccountDaoImpl;
import Dao.DaoException;
import javabean.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Changepassword",  urlPatterns = "/changepsw")
public class changepassword extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        Account account = new Account(request.getParameter("username"),
                request.getParameter("newpassword"),request.getParameter("position"),request.getParameter("name"));
        AccountDAO dao = new AccountDaoImpl();
        try {
            if (dao.findByUsername(request.getParameter("username"),request.getParameter("oldpassword"),request.getParameter("position"))!=null){
                boolean success = dao.updateaccount(account);
                if (success){
                    response.sendRedirect("loginin.jsp?csuccess=yes");
                }else{
                    response.sendRedirect("changepassword.jsp?csuccess=no");
                }
            }else{
                response.sendRedirect("changepassword.jsp?csuccess=no");
            }

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {


    }
}

