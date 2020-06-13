package com.servletcrud.service;

import com.servletcrud.util.DBConnect;
import java.sql.*;
import java.util.*;


public class UserDao {
    DBConnect con;

    public UserDao() {
        con = new DBConnect();
        con.init();
    }

    @Override
    protected void finalize() {
        con.close();
    }

    public void checkUser(User user) {
        try {
            ResultSet rs = con.exec(
                "select name from users where name = ?"
              , user.getUname()
            );
            if (rs.next()) {
                updateUser(user);
            } else {
                addUser(user);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }
    }

    public void addUser(User user) {
        con.update(
            "insert into users(name, password) values (?, ?)"
          , user.getUname()
          , user.getPassword()
        );
    }

    public void deleteUser(String userId) {
        con.update(
            "delete from users where name=?"
          , userId
        );
    }

    public void updateUser(User user) {
        con.update(
            "update users set password=? where name=?"
          , user.getPassword()
          , user.getUname()
        );
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            ResultSet rs = con.exec("select * from users");
            while (rs.next()) {
                User user = new User();
                user.setUname(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getUserById(String userId) {
        User user = new User();
        try {
            ResultSet rs = con.exec("select * from users where name=?", userId);

            if (rs.next()) {
                user.setUname(rs.getString("name"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
