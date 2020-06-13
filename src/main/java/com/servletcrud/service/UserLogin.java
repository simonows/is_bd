package com.servletcrud.service;

import com.servletcrud.util.DBConnect;
import java.io.*;
import java.sql.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;


public class UserLogin extends HttpServlet{
    DBConnect con;
    String captcha;

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
    protected void doPost(
         HttpServletRequest request
        ,HttpServletResponse response
    ) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("name");
        String pass = request.getParameter("password");
        String captcha_text = request.getParameter("captcha_text");

        try {
            if (!checkCaptcha(captcha_text))
            {
                request.setAttribute("errorlog", "Капча введена неверно");
                RequestDispatcher rs = request.getRequestDispatcher("regauth");
                rs.include(request, response);
                return;
            }
            if (checkUser(con, email, pass))
            {
                HttpSession session = request.getSession(true);
                session.setAttribute("name", email);

                response.sendRedirect("cabinet");
            }
            else
            {
                request.setAttribute(
                     "errorlog"
                   , "Неправильный логин или пароль"
                );
                RequestDispatcher rs = request.getRequestDispatcher("regauth");
                rs.include(request, response);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean checkCaptcha(String name) throws IOException {
        FileReader reader = new FileReader(
            "/opt/tomcat9/webapps/aviakassa-1.0/captcha.txt"
        );
        char []buf = new char[200];
        int len = reader.read(buf);

        buf = Arrays.copyOf(buf, len);
        captcha = new String(buf);

        if (captcha.equals(name)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkUser(
         DBConnect con
        ,String name
        ,String pass
    ) throws SQLException {
        ResultSet rs = con.exec(
            "select * from users where name=? and password=?"
          , name
          , pass
        );

        return rs.next();
    }
}
