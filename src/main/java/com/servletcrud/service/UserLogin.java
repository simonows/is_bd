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
public class UserLogin extends HttpServlet{
    DBConnection dBConnection;
    Connection con;

    @Override
    public void init() {
        dBConnection = new DBConnection();
        con = dBConnection.checkUser(); 
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("name");
        String pass = request.getParameter("password");
        String captcha = request.getParameter("captcha_text");
        
        try {
            if (!checkCaptcha(captcha))
            {
                request.setAttribute("errorlog", "Captcha incorrect " + captcha);
                RequestDispatcher rs = request.getRequestDispatcher("form_regauth.jsp");
                rs.include(request, response);
                return;
            }
            if (checkUser(con, email, pass))
            {
                RequestDispatcher rs = request.getRequestDispatcher("Welcome");
                rs.forward(request, response);
            }
            else
            {
                request.setAttribute("errorlog", "Username or Password incorrect");
                RequestDispatcher rs = request.getRequestDispatcher("form_regauth.jsp");
                rs.include(request, response);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }  
   
    public boolean checkCaptcha(String name) throws IOException {
        FileReader reader = new FileReader("/opt/tomcat9/webapps/aviakassa-1.0/captcha.txt");
        char [] a = new char[200];
        reader.read(a);
        String captcha = new String(a);

        if (captcha.equals(name)){
            return true;
        }
        else{
            return false;
        }
    }
   
    public boolean checkUser(Connection con, String name, String pass) throws SQLException{
            PreparedStatement ps = con.prepareStatement
            ("select * from users where name=? and password=?");
        ps.setString(1, name);
        ps.setString(2, pass);
        ResultSet rs =ps.executeQuery();
        return rs.next();
   }
}
