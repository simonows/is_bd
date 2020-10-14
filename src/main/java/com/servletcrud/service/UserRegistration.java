package com.servletcrud.service;

import com.servletcrud.util.DBConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserRegistration extends HttpServlet{
    DBConnect con;

    @Override
    public void init() {
        con = new DBConnect();
        con.init();
    }

    @Override
    public void destroy() {
        con.close();
    }

    @Override
    public void doPost(
         HttpServletRequest request
        ,HttpServletResponse response
    ) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name=request.getParameter("name");
        String pass=request.getParameter("password");

        try {
            int i = dao.addUser(new User(
                name
              , pass
            ));
            if (i > 0) {
                request.setAttribute(
                     "successlog"
                    ,"Вы успешно зарегистрированы"
                );
                RequestDispatcher rs = request.getRequestDispatcher("regauth");
                rs.include(request, response);
            }
        } catch(Exception e2) {
            request.setAttribute("errorlog", e2.getMessage());
            RequestDispatcher rs = request.getRequestDispatcher("regauth");
            rs.include(request, response);
            e2.printStackTrace();
        }
    }
    
    @Override
    public void doGet(
         HttpServletRequest request
        ,HttpServletResponse response
    ) throws ServletException, IOException {
        doPost(request, response);
    }
}
