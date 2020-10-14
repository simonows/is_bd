package com.servletcrud.user;

import java.io.*;
import com.servletcrud.service.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.servletcrud.util.DBConnect;
import com.servletcrud.service.*;
import java.util.*;

public class Cabinet extends HttpServlet {
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
    protected void doGet(
        HttpServletRequest request
      , HttpServletResponse response
    )throws ServletException, IOException {
        UserDao dao = new UserDao();
        HttpSession session = request.getSession(false);

        ResultSet rs = con.exec(
            "SELECT user_data.* from user_data "
          + "INNER JOIN users ON users.id=user_data.id "
          + "WHERE name = ? "
          , (String)session.getAttribute("name")
        );

        try {
            rs.next();
            request.setAttribute("namet", dao.getUserByName((String)session.getAttribute("name")).data.getName());
            request.setAttribute("sernamet", dao.getUserByName((String)session.getAttribute("name")).data.getSername());
            request.setAttribute("patrt", dao.getUserByName((String)session.getAttribute("name")).data.getPatronymic());
            request.setAttribute("birtht", dao.getUserByName((String)session.getAttribute("name")).data.getBirth());
            request.setAttribute("reget", dao.getUserByName((String)session.getAttribute("name")).data.getRege());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        getServletContext().getRequestDispatcher(
            "/cabinet.jsp"
        ).forward(request, response);
    }

    @Override
    protected void doPost(
        HttpServletRequest request
      , HttpServletResponse response
    )
    throws ServletException, IOException {
        doGet(request, response);
    }
}
