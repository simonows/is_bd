package com.servletcrud.service;


import com.servletcrud.util.DBConnection;
import java.util.Date;
 
 
public class News {
   String uname, imglink, newslink, desc;
   Date registeredon;
   
   public String getUname()
   {
       return uname;
   }
   public String getImgLink()
   {
       return imglink;
   }
   public String setNewsLink()
   {
       return newslink;
   }
   public String setDesc()
   {
       return desc;
   }

   
   public void setUname(String uname1)
   {
       uname = uname1;
   }
   public void setImgLink(String imglink2)
   {
       imglink = imglink2;
   }
   public void setNewsLink(String newslink2)
   {
       newslink = newslink2;
   }
   public void setDesc(String desc2)
   {
       desc = desc2;
   }

}