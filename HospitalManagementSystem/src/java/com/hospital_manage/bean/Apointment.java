package com.hospital_manage.bean;

import com.hospital_manage.util.NewHibernateUtil;
import java.sql.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
@SessionScoped
@Entity
@Table(name = "apointment")
public class Apointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "drName")
    private String drName;

    @Column(name = "drPhone")
    private int drPhone;

    @Column(name = "dID")
    private int dID;

    @Column(name = "fName")
    private String firstName;

    @Column(name = "lName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private int phone;

    @Column(name = "gender")
    private String gender;

    

    @Column(name = "address")
    private String address;

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrName() {
        return drName;
    }

    public void setDrName(String drName) {
        this.drName = drName;
    }

    public int getDrPhone() {
        return drPhone;
    }

    public void setDrPhone(int drPhone) {
        this.drPhone = drPhone;
    }

    public int getdID() {
        return dID;
    }

    public void setdID(int dID) {
        this.dID = dID;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    
    
    
    
    
    

    public String getApointment(String drName, int drPhone) {

        this.drName = drName;
        this.drPhone = drPhone;

        return "apointment.xhtml?faces-redirect=true";
    }

    public String saveApointment(Apointment apointment) {

        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;

        try {

            ts = session.beginTransaction();
            session.save(apointment);
            ts.commit();

        } catch (Exception e) {
            ts.rollback();
        } finally {
            session.flush();
        }
        
        
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Apointment request Successful",  "Patient Name: " + firstName+" "+lastName
                +"<br> Patient Status: null. <br> Apointment Id: "+id) );
        return null;
    }

    

    

}
