package com.hospital_manage.bean;


import com.hospital_manage.util.NewHibernateUtil;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
@SessionScoped
@Entity
@Table(name = "doctors")
public class DoctorBean {
    @Column(name = "name")
    private String name;
    @Id
    @Column(name = "email")
    private String email;
    
    @Column(name = "phone")
    private int phone;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "msg")
    private String msg;
    
    @Column(name = "Specialist")
    private String specialist;  

    
     
     
    
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
    
    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String Specialist) {
        this.specialist = Specialist;
    }
    
    
    public String saveDoctor(DoctorBean doctor){
    Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            session.save(doctor);
            ts.commit();
        } catch (Exception e) {
             ts.rollback();
        }finally{
         session.flush();
        }
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "Insert Succesfull"));
    
       return null;
    }
    
    
    public List<DoctorBean> showDoctor(){
    Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("FROM DoctorBean");
           List<DoctorBean> list= query.list();
           ts.commit();
           return list;
        } catch (Exception e) {
            ts.rollback();
        }finally{
        session.flush();
        }  
        
    return null;
    }
    
    
   
    
    
    
   
    
    
    
    
    
    public String editDoctor(DoctorBean doctor){
        this.setEmail(doctor.getEmail());
        this.setGender(doctor.getGender());
        this.setMsg(doctor.getMsg());
        this.setName(doctor.getName());
        this.setPhone(doctor.getPhone());
        this.setSpecialist(doctor.getSpecialist());        
    return "editDoctor";
    }
    
    
    
    
    
    public String  findDoctor(){
       
    Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("FROM DoctorBean");
           
           ts.commit();
          return"userViewDoctor";
        } catch (Exception e) {
            ts.rollback();
        }finally{
            
        session.flush();
        }         
    return null;
    }
    
    
    
    
    public String updateDoctor(DoctorBean doctor){
    Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            session.update(doctor);
            ts.commit();
        } catch (Exception e) {
             ts.rollback();
        }finally{
         session.flush();
        }
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "Update Succesfull"));
    
       return null;  
    }
    
    
    
    public String deletDoctor(DoctorBean doctor){
    Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            session.delete(doctor);
            ts.commit();
        } catch (Exception e) {
             ts.rollback();
        }finally{
         session.flush();
        }  
        
       
    
       return null;  
    }

    
  
    

}








