package com.servletcrud.service;

import java.io.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;


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
