package com.servletcrud.util;
import java.sql.*;


public class DBConnect {
    private final static int WAIT_TIMEOUT = 1;
    private static String user = "tomcat9";
    private static String pass = "password";

    private static Connection con;

    public boolean init() {
        try {
            if (con != null && con.isValid(WAIT_TIMEOUT)) {
                return true;
            }
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/user?characterEncoding=utf8"
              , user
              , pass
            );

            return true;
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void close() {
        try {
            con.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet exec(String query, Object ... v) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            if (!con.isValid(WAIT_TIMEOUT)) {
                if (!init()) {
                    return rs;
                }
            }
            ps = con.prepareStatement(query);
            for (int i = 0; i < v.length; i++) {
                if (v[i].getClass() == String.class) {
                    ps.setString(i + 1, (String)v[i]);
                } else if (v[i].getClass() == String.class) {
                    ps.setInt(i + 1, (int)v[i]);
                } else if (v[i].getClass() == Integer.class) {
                    ps.setInt(i + 1, (Integer)v[i]);
                }
            }
            rs = ps.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    public int update(String query, Object ... v) {
        PreparedStatement ps = null;
        int ret = -1;

        try {
            if (!con.isValid(WAIT_TIMEOUT)) {
                if (!init()) {
                    return ret;
                }
            }
            ps = con.prepareStatement(query);
            for (int i = 0; i < v.length; i++) {
                if (v[i].getClass() == String.class) {
                    ps.setString(i + 1, (String)v[i]);
                } else if (v[i].getClass() == String.class) {
                    ps.setInt(i + 1, (int)v[i]);
                } else if (v[i].getClass() == Integer.class) {
                    ps.setInt(i + 1, (Integer)v[i]);
                }
            }
            ret = ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }
}
