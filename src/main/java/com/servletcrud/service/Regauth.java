/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servletcrud.service;


import com.servletcrud.util.DBConnection;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sourav
 */
public class Regauth extends HttpServlet {
    DBConnection dBConnection;
    Connection con;
    int captcha_x;
    int captcha_y;

    @Override
    public void init() {
        
    }
    
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
        captcha_x = (int)Math.abs(Math.random() * 100);
        captcha_y = (int)Math.abs(Math.random() * 100);
        StartCaptcha();
        response.setContentType("text/html; charset=UTF-8");
        
        request.setAttribute("captcha", String.valueOf(captcha_x) + " + " + String.valueOf(captcha_y) + " = ?");
        RequestDispatcher rs = request.getRequestDispatcher("form_regauth.jsp");
        rs.include(request, response);
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
        
        request.setAttribute("captcha", String.valueOf(captcha_x) + " + " + String.valueOf(captcha_y) + " = ?");
        RequestDispatcher rs = request.getRequestDispatcher("form_regauth.jsp");
        rs.include(request, response);
    }  
}
