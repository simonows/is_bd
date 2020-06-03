package com.servletcrud.util;
import java.sql.*;


public class DBConnection {
    public Connection checkUser() {
        try {
            Connection con;
            // loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            // creating connection with the database
            con=DriverManager.getConnection(
                 "jdbc:mysql://localhost:3306/user"
                ,"tomcat9"
                ,"password"
            );
            
            return con;
        } catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
