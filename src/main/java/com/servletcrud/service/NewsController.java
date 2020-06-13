package com.servletcrud.service;

import com.servletcrud.util.DBConnect;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servletcrud.service.UserDao;
import com.servletcrud.service.User;
import com.servletcrud.service.News;



public class NewsController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/user.jsp";
    private static String NEWS_USER = "/news.jsp";
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

    protected void doGet(
        HttpServletRequest request
      , HttpServletResponse response
    ) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        request.setAttribute("news", getAllNews());
        forward = NEWS_USER;
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    public List<News> getAllNews() {
        List<News> nw = new ArrayList<News>();

        ResultSet rs = con.exec("select * from news");
        try {
            while (rs.next()) {
                News nw2 = new News();
                nw2.setUname(rs.getString("name"));
                nw2.setImgLink(rs.getString("imglink"));
                nw2.setNewsLink(rs.getString("newslink"));
                nw2.setDesc(rs.getString("desct"));

                nw.add(nw2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nw;
    }

    protected void doPost(
        HttpServletRequest request
      , HttpServletResponse response
    ) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        request.setAttribute("news", getAllNews());
        forward = NEWS_USER;
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
}
