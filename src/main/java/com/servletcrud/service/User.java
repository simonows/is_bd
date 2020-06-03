package com.servletcrud.service;


import com.servletcrud.util.DBConnection;
import java.util.Date;
 
public class User {
   String uname, password, email;
   Date registeredon;
   
   public String getUname()
   {
       return uname;
   }
   public String getPassword()
   {
       return password;
   }
   public Date getRegisteredon()
   {
       return registeredon;
   }
   public String getEmail()
   {
       return email;
   }
   
   public void setUname(String uname1)
   {
       uname = uname1;
   }
   public void setPassword(String password2)
   {
       password = password2;
   }
   public void setRegisteredon(Date reg)
   {
       registeredon = reg;
   }
   public void setEmail(String email1)
   {
       email = email1;
   }

}