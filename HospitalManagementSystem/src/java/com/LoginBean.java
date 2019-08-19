
package com;

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
        if(user.equals("admin")&&psd.equals("admin")){
           return "adminPanel.xhtml?faces-redirect=true";
        }else{
       
         return "gallary.xhtml?faces-redirect=true";
        }
    }
    
    
}
