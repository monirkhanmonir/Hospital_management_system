package com.hospital_manage.bean;

import com.hospital_manage.util.NewHibernateUtil;
import java.util.ArrayList;


import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
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

    @Column(name = "psd")
    private String psd;
    
    @Transient
     private List<DoctorBean> list;
    
    

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

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }
    
       public List<DoctorBean> getList() {
        return list;
    }

    public void setList(List<DoctorBean> list) {
        this.list = list;
    }

    public String saveDoctor(DoctorBean doctor) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            session.save(doctor);
            ts.commit();
        } catch (Exception e) {
            ts.rollback();
        } finally {
            session.flush();
        }
        clear();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "Insert Succesfull"));

        return null;
    }

    public List<DoctorBean> showDoctor() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("FROM DoctorBean");
            List<DoctorBean> list = query.list();
            ts.commit();
            return list;
        } catch (Exception e) {
            ts.rollback();
        } finally {
            session.flush();
        }

        return null;
    }

    public String editDoctor(DoctorBean doctor) {
        this.setEmail(doctor.getEmail());
        this.setGender(doctor.getGender());
        this.setMsg(doctor.getMsg());
        this.setName(doctor.getName());
        this.setPhone(doctor.getPhone());
        this.setSpecialist(doctor.getSpecialist());
        this.setPsd(doctor.getPsd());
        return "editDoctor";
    }

    

    public String updateDoctor(DoctorBean doctor) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            session.update(doctor);
            ts.commit();
        } catch (Exception e) {
            ts.rollback();
        } finally {
            session.flush();
        }
        clear();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "Update Succesfull"));

        return "adminShowDoctor";
    }

    public String deletDoctor(DoctorBean doctor) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            session.delete(doctor);
            ts.commit();
            return "adminShowDoctor";
        } catch (Exception e) {
            ts.rollback();
        } finally {
            session.flush();
        }

        return null;
    }

    public void clear() {
        this.setEmail("");
        this.setGender("");
        this.setMsg("");
        this.setName("");
        this.setPhone(0);
        this.setSpecialist("");
        this.setPsd("");
    }

    public String checkUser1(String email, String psd) {
        String result = null;

        if (email.equals("admin") && psd.equals("admin")) {
            result = "adminProfile.xhtml?faces-redirect=true";
            this.setEmail("");
            this.setPsd("");
            
        } else {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            Transaction ts = null;
            try {
                ts = session.beginTransaction();
                Query q = session.createQuery("FROM DoctorBean where email=:email");
                q.setString("email", email);
                List<DoctorBean> list = q.list();
                for (DoctorBean a : list) {
                    if (email.equals(a.getEmail()) && psd.equals(a.getPsd())) {
                        this.setName(a.getName());
                        this.setEmail(a.getEmail());
                        this.setPhone(a.getPhone());
                        this.setGender(a.getGender());
                        
                        result = "doctorPanel.xhtml?faces-redirect=true";
                    } else {
                        result = "gallary.xhtml?faces-redirect=true";
                    }
                }

            } catch (Exception e) {
            }
        }

        return result;
    }
    

    
    
    
    
    
    
    
    public String findDoctor(String specialist) {
        list = new ArrayList<>();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("FROM DoctorBean where Specialist=:specialist");
           query.setString("specialist", specialist);
            list = query.list();
            ts.commit();
            return "userViewDoctor";
        } catch (Exception e) {
            ts.rollback();
        } finally {

            session.flush();
        }
        return null;
    }
    
    
    
    
    

    
}
