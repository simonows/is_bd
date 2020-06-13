package com.servletcrud.user;

import java.io.*;
import com.servletcrud.service.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.servletcrud.util.DBConnect;
import java.util.*;

public class Tickets extends HttpServlet {
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
       ,HttpServletResponse response
    )throws ServletException, IOException {
        List<Ticket> tTable;
        HttpSession session = request.getSession(false);
        tTable = new ArrayList<Ticket>();

        request.setCharacterEncoding("UTF-8");

        ResultSet rs = con.exec(
            "SELECT tickets.* FROM tickets "
          + "INNER JOIN ticket_user ON ticket_user.ticket_id=tickets.id "
          + "INNER JOIN users ON ticket_user.user=users.id "
          + "WHERE users.name = ? "
          , (String)session.getAttribute("name")
        );

        try {
            while (rs.next()) {
                Ticket tRow = new Ticket();

                tRow.setId(rs.getInt("id"));
                tRow.setTickNum(rs.getInt("ticket"));
                tRow.setFrom(rs.getString("from_t"));
                tRow.setTo(rs.getString("to_t"));
                tRow.setFromTime(rs.getString("from_time"));
                tRow.setToTime(rs.getString("to_time"));
                tRow.setStatus(rs.getInt("status"));

                tTable.add(tRow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("data", tTable);

        getServletContext().getRequestDispatcher(
            "/tickets.jsp"
        ).forward(request, response);
    }

    @Override
    protected void doPost(
        HttpServletRequest request
      , HttpServletResponse response
    )throws ServletException, IOException {
        doGet(request, response);
    }
}
