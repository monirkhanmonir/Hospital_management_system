package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DoctorBean {

    private String name;
    private String email;
    private int phone;
    private String gender;
    private String msg;
    
    private String Specialist;  

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
    public String saveDoctor(){
    int i = 0;
        Connection con = DBConnection.getConnection();
        
        String sql = "insert into doctors(name,email,phone,gender,Specialist,msg)values(?,?,?,?,?,?)";
        try {
            PreparedStatement pst =  con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setInt(3, phone);
            pst.setString(4,gender);
            pst.setString(5,Specialist);
            pst.setString(6,msg);
          i =  pst.executeUpdate();
           
           
           
        } catch (SQLException ex) {
            Logger.getLogger(DoctorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
       return null;
    }

    public String getSpecialist() {
        return Specialist;
    }

    public void setSpecialist(String Specialist) {
        this.Specialist = Specialist;
    }
    

}
