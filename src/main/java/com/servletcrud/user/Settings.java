package com.servletcrud.user;

import java.io.*;
import com.servletcrud.service.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.servletcrud.util.DBConnect;
import java.util.*;

public class Settings extends HttpServlet {
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
    ) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        String del = request.getParameter("del");

        if (del != null) {
            if (!del.equals("yes")) {
                response.sendRedirect("settings.jsp");
                return;
            }
        }
        if (del == null) {
            response.sendRedirect("settings.jsp");
            return;
        }

        ResultSet rs = con.exec(
            "SELECT id FROM users WHERE users.name = ?"
          , (String)session.getAttribute("name")
        );

        int userId = 0;
        try {
            rs.next();
            userId = rs.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        con.update(
            "DELETE FROM users WHERE users.name = ?"
          , (String)session.getAttribute("name")
        );

        con.update(
            "DELETE FROM user_data WHERE user_data.id = ?"
          , userId
        );

        con.update(
            "DELETE FROM ticket_user WHERE ticket_user.user = ?"
          , userId
        );

        response.sendRedirect("logout");
    }

    @Override
    protected void doPost(
        HttpServletRequest request
      , HttpServletResponse response
    ) throws ServletException, IOException {
        doGet(request, response);
    }
}
