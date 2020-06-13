package com.servletcrud.service;

import java.util.Date;

public class User {
   String uname, password, email;
   String namet, sernamet, patrt;
   String birth, rege;
   Date registeredon;

   public void setname_t(String name_t)
   {
       namet = name_t;
   }
   public void setsername_t(String sername_t)
   {
       sernamet = sername_t;
   }
   public void setpatr_t(String patr_t)
   {
       patrt = patr_t;
   }
   public void setbirth(String birth)
   {
       birth = birth;
   }
   public void setrege(String rege)
   {
       rege = rege;
   }

   public void setUname(String uname1)
   {
       uname = uname1;
   }
   public String getUname()
   {
       return uname;
   }
   public void setPassword(String password2)
   {
       password = password2;
   }
   public String getPassword()
   {
       return password;
   }
   public void setRegisteredon(Date reg)
   {
       registeredon = reg;
   }
   public Date getRegisteredon()
   {
       return registeredon;
   }
   public void setEmail(String email1)
   {
       email = email1;
   }
   public String getEmail()
   {
       return email;
   }
}

