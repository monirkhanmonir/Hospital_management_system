
package com.hospital_manage.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
    
    
    public String checkUser(){
     String result = null;
        if(user.equals("admin")){
            if(user.equals("admin")&&psd.equals("admin")){
           result= "adminPanel.xhtml?faces-redirect=true";
        }else{
       
         result= "login.xhtml?faces-redirect=true";
        }
        
        }else if(user.equals("doctor")){
        
            if(user.equals("doctor")&&psd.equals("doctor")){
           result= "doctorPanel.xhtml?faces-redirect=true";
        }else{
       
         result= "login.xhtml?faces-redirect=true";
        }
            
            
        }
          
      return result;  
    }
    
    
}
