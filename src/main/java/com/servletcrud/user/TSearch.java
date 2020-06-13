package com.servletcrud.user;

import java.io.*;
import com.servletcrud.service.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.servletcrud.util.DBConnect;
import java.util.*;

public class TSearch extends HttpServlet {
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
        List<Ticket> tTable = new ArrayList<Ticket>();
        request.setCharacterEncoding("UTF-8");

        ResultSet rs;
        String from_p = request.getParameter("from");
        String to_p = request.getParameter("to");
        String buy_p = request.getParameter("buy");
        HttpSession session = request.getSession(false);

        if (from_p == null) {
            from_p = "";
        }
        if (to_p == null) {
            to_p = "";
        }

        if (buy_p != null) {
            try {
                rs = con.exec(
                    "SELECT id FROM users WHERE name = ?"
                  , (String)session.getAttribute("name")
                );

                rs.next();
                int id = rs.getInt("id");

                id = con.update(
                    "INSERT INTO ticket_user VALUES(?, ?, ?)"
                  , id
                  , Integer.parseInt(buy_p)
                  , 1
                );
                if (id != 1) {
                    request.setAttribute(
                         "errorlog"
                        ,"Не получилось завершить операцию, попробуйте позже"
                    );
                    getServletContext().getRequestDispatcher(
                        "/ticket_search.jsp"
                    ).forward(request, response);
                    return;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            response.sendRedirect("tickets");
            return;
        }

        try {
            if (from_p.length() != 0 && to_p.length() != 0) {
                rs = con.exec(
                    "SELECT tickets.* FROM tickets "
                  + "LEFT JOIN ticket_user ON ticket_user.ticket_id=tickets.id "
                  + "LEFT JOIN users ON users.id=ticket_user.user AND users.name = ? "
                  + "WHERE users.name IS NULL AND from_t = ? AND to_t = ? "
                  , (String)session.getAttribute("name")
                  , from_p
                  , to_p
                );
            }
            else if (from_p.length() == 0 && to_p.length() != 0) {
                rs = con.exec(
                    "SELECT tickets.* FROM tickets "
                  + "LEFT JOIN ticket_user ON ticket_user.ticket_id=tickets.id "
                  + "LEFT JOIN users ON users.id=ticket_user.user AND users.name = ? "
                  + "WHERE users.name IS NULL AND to_t = ? "
                  , (String)session.getAttribute("name")
                  , to_p
                );
            }
            else if (from_p.length() != 0 && to_p.length() == 0) {
                rs = con.exec(
                    "SELECT tickets.* FROM tickets "
                  + "LEFT JOIN ticket_user ON ticket_user.ticket_id=tickets.id "
                  + "LEFT JOIN users ON users.id=ticket_user.user AND users.name = ? "
                  + "WHERE users.name IS NULL AND from_t = ? "
                  , (String)session.getAttribute("name")
                  , from_p
                );
            }
            else {
                rs = con.exec(
                    "SELECT tickets.* FROM tickets "
                  + "LEFT JOIN ticket_user ON ticket_user.ticket_id=tickets.id "
                  + "LEFT JOIN users ON users.id=ticket_user.user AND users.name = ? "
                  + "WHERE users.name IS NULL "
                  , (String)session.getAttribute("name")
                );
            }

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

            request.setAttribute("data", tTable);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher(
            "/ticket_search.jsp"
        ).forward(request, response);
    }

    @Override
    protected void doPost(
        HttpServletRequest request
      , HttpServletResponse response
    ) throws ServletException, IOException {
        doGet(request, response);
    }
}
