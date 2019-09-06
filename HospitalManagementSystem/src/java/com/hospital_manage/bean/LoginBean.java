
package com.hospital_manage.bean;

import com.hospital_manage.util.NewHibernateUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
@SessionScoped
public class LoginBean {
    
    private String user;
    private String psd;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }
    
    
    
    
    
    
    
    
    
    
    
    public String checkUser1(LoginBean loginBean){
        
     String result;
       Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;
        try {
          ts=  session.beginTransaction();
            Query q= session.createQuery("FROM LoginBean where email=:email");
            List<LoginBean> list= q.list();
            
            for(LoginBean a: list){
            if(user.equals(a.getUser())&&psd.equals(a.psd)){
                user = a.getUser();
                psd = a.getPsd();
            result= "doctorPanel.xhtml?faces-redirect=true";
            }
            }
           
        } catch (Exception e) {
        }
          
      return null;  
    }
    
    
    
    
    
    
    
    
    
}
