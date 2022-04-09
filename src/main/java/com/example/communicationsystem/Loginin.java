package com.example.communicationsystem;

import Dao.Accout.AccountDAO;
import Dao.Accout.AccountDaoImpl;
import Dao.DaoException;
import javabean.Account;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Loginin",  urlPatterns = "/loginin")
public class Loginin extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        AccountDAO dao = new AccountDaoImpl();
        boolean success = false;
        try {
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            String position = request.getParameter("position");
            Account account = new Account();
            account = dao.findByUsername(username,password,position);
            if(account==null){
                System.out.println("无用户名或用户名密码错误");
                response.sendRedirect("loginin.jsp?error=yes");
            }else {
                if (request.getParameter("check") != null && request.getParameter("check").equals("check")) {
                    Cookie nameCookie = new Cookie("username", username);
                    Cookie pswCookie = new Cookie("password", password);
                    Cookie namCookie = new Cookie("name",account.getName());
                    Cookie posCookie = new Cookie("position",account.getPosition());
                    nameCookie.setMaxAge(60 * 60);
                    pswCookie.setMaxAge(60 * 60);
                    namCookie.setMaxAge(60 * 60);
                    posCookie.setMaxAge(60 * 60);
                    response.addCookie(nameCookie);
                    response.addCookie(pswCookie);
                    response.addCookie(namCookie);
                    response.addCookie(posCookie);
                }
                HttpSession session = request.getSession(true);
                session.setAttribute("position",position);
                session.setAttribute("name",account.getName());
                session.setAttribute("username",account.getUsername());
                if (position.equals("admin")){
                    response.sendRedirect("admincontrol.jsp");
                }else if (position.equals("student")){
                    response.sendRedirect("answeraction?sno="+account.getUsername()+"&methods=quarynewanswer");
                }else if (position.equals("teacher")){
                    response.sendRedirect("questionaction?tno="+account.getUsername()+"&methods=quarynewquestion");
                }
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String username = null;
        String password=null;
        String name = null;
        String position=null;
        Cookie cookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (int i=0;i<cookies.length;i++){
                cookie=cookies[i];
                if (cookie.getName().equals("username")){
                    username=cookie.getValue();
                }
                if (cookie.getName().equals("password")){
                    password=cookie.getValue();
                }
                if (cookie.getName().equals("name")){
                    name=cookie.getValue();
                }
                if (cookie.getName().equals("position")){
                    position=cookie.getValue();
                }
            }
            if (username!=null){
                HttpSession session= request.getSession(true);
                session.setAttribute("position",position);
                session.setAttribute("username",username);
                session.setAttribute("name",name);
                if (position.equals("admin")){
                    response.sendRedirect("answeraction?sno="+username+"&methods=quarynewanswer");
                }else if (position.equals("teacher")){
                    response.sendRedirect("questionaction?tno="+username+"&methods=quarynewquestion");
                }
            }else{
                System.out.println("无cookie");
                response.sendRedirect("loginin.jsp");
            }
        }else{
            System.out.println("无cookie");
            response.sendRedirect("loginin.jsp");
        }
    }

    public void destroy() {
    }
}