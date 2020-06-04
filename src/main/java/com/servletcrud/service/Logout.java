package com.servletcrud.service;

import com.servletcrud.util.DBConnection;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Logout extends HttpServlet{

    @Override
    public void init() {
    }

    @Override
    protected void doGet(
         HttpServletRequest request
        ,HttpServletResponse response
    ) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("name");
        RequestDispatcher rs = request.getRequestDispatcher("regauth");
        rs.forward(request, response);
    }
    
    @Override
    protected void doPost(
         HttpServletRequest request
        ,HttpServletResponse response
    ) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("name");
        RequestDispatcher rs = request.getRequestDispatcher("regauth");
        rs.forward(request, response);
    }
}
