package com.servletcrud.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.servletcrud.util.DBConnect;
import com.servletcrud.util.HibernateSessionFactoryUtil;
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
              , user.getName()
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
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void deleteUser(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public void updateUser(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public List<User> getAllUsers() {
        List<User> users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Users").list();
        return users;
    }

    public User getUserById(int userId) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, userId);
    }
    public User getUserByName(String userName) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, userName);
    }
}
