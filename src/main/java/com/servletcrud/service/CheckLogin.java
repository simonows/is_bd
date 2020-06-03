package com.servletcrud.service;

import com.servletcrud.util.DBConnection;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;


@WebServlet(name = "CheckLogin", urlPatterns = {"/CheckLogin"})
public class CheckLogin extends HttpServlet {
    DBConnection dBConnection;
    Connection con;

    @Override
    public void init() {

    }

    public void processRequest(
         HttpServletRequest request
        ,HttpServletResponse response
    ) throws ServletException, IOException, JSONException, SQLException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        
        try (PrintWriter out = response.getWriter()) {
            JSONObject jsonEnt = new JSONObject();
            dBConnection = new DBConnection();
            con = dBConnection.checkUser();

            PreparedStatement ps = con.prepareStatement(
                "select password from users where name = ?"
            );

            ps.setString(1, request.getParameter("login"));

            ResultSet resultSet = ps.executeQuery();
            resultSet.last();
            if (resultSet.getRow() == 0){
                //jsonEnt.put("backgroundColor","#99CC66");
                jsonEnt.put("serverInfo", "Логин свободен");
            } else {
                //jsonEnt.put("backgroundColor","#CC6666");
                jsonEnt.put("serverInfo", "Логин занят");
            }
            out.print(jsonEnt.toString());
            con.close();
        }
    }

    @Override
    public void doGet(
         HttpServletRequest request
        ,HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            //Logger.getLogger(AuthenticationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex2) {
            //Logger.getLogger(AuthenticationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void doPost(
         HttpServletRequest request
        ,HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            //Logger.getLogger(AuthenticationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex2) {
            //Logger.getLogger(AuthenticationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
