package com.servletcrud.service;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;


public class Regauth extends HttpServlet {
    int captcha_x;
    int captcha_y;

    public void StartCaptcha() throws IOException {
        FileWriter writer = new FileWriter(
             "/opt/tomcat9/webapps/aviakassa-1.0/captcha.txt"
            ,false
        );
        writer.write(String.valueOf(captcha_x + captcha_y));
        writer.flush();
        writer.close();
    }

    @Override
    protected void doGet(
         HttpServletRequest request
        ,HttpServletResponse response
    ) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(
         HttpServletRequest request
        ,HttpServletResponse response
    ) throws ServletException, IOException {
        captcha_x = (int)Math.abs(Math.random() * 100);
        captcha_y = (int)Math.abs(Math.random() * 100);
        StartCaptcha();
        response.setContentType("text/html; charset=UTF-8");

        request.setAttribute(
             "captcha"
            ,String.valueOf(captcha_x)
            + " + " + String.valueOf(captcha_y) + " = ?"
        );
        RequestDispatcher rs = request.getRequestDispatcher("form_regauth.jsp");
        rs.include(request, response);
    }
}
