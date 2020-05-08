package com.servletcrud.service;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.servletcrud.util.DBConnection;

public class Welcome extends HttpServlet {
    DBConnection dBConnection;
    Connection con;

    @Override
    public void init() {
      //dBConnection = new DBConnection();
      //con = dBConnection.checkUser(); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("Welcome user");*/
        PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><head><title>Личный кабинет</title><link href=\"css/base.css\" rel=\"stylesheet\" type=\"text/css\"/></head><body><header><div id=\"logo\" class=\"noselect\"><span class=\"second-ch\">S</span>8</div><div class=\"signup\"><a href=\"regauth\">Выйти</a></div></header><br/><br/><h2 align=\"center\">Пользователи сервиса</h2><div style=\"margin-top:20px;\">");  
        try 
        {  
            dBConnection = new DBConnection();
            con = dBConnection.checkUser(); 
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from users");  
            out.println("<table border=1>");  
            out.println("<tr><th>Id</th><th>Name</th><th>Passphrase</th><tr>");  
            while (rs.next()) 
            {
                int s = rs.getInt("id");
                String n = rs.getString("name");  
                String nm = rs.getString("password");     
                out.println("<tr><td>" + s + "</td><td>" + n + "</td><td>" + nm + "</td></tr>");   
            }  
            out.println("</table>");  
            out.println("</div></body></html>");  
            con.close();  
        }  
        catch (Exception e) 
        {  
            out.println(e.getMessage());  
        }  
    }  
}