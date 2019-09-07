package com.hospital_manage.bean;

import com.hospital_manage.util.NewHibernateUtil;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.Query;
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
    @Column(name = "drEmail")
    private String drEmail;

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

    @Column(name = "date")
    private Date date;
    
    @Transient
    private DoctorBean doctor = new DoctorBean();
   

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDrEmail() {
        return drEmail;
    }

    public void setDrEmail(String drEmail) {
        this.drEmail = drEmail;
    }
    
    public DoctorBean getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorBean doctor) {
        this.doctor = doctor;
    }
    
    
   

    public String getApointment(String drName, int drPhone, String drEmail) {

        this.drName = drName;
        this.drPhone = drPhone;
        this.drEmail = drEmail;

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

        context.addMessage(null, new FacesMessage("Apointment request Successful", "Patient Name: " + firstName + " " + lastName
                + "<br> Patient Status: null. <br> Apointment Id: " + id));

        clearApointment();
        return "index";
    }

    public void clearApointment() {
        this.setAddress("");
        this.setDrName("");
        this.setDrPhone(0);
        this.setEmail("");
        this.setFirstName("");
        this.setGender("");
        this.setId(0);
        this.setLastName("");
        this.setPhone(0);
        this.setDrEmail("");

    }

    public List<Apointment> showApointentPatient() {
        drEmail = doctor.getEmail();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            Query q = session.createQuery("FROM Apointment where drEmail=:drEmail");
            q.setString("drEmail",drEmail );
            List<Apointment> list = q.list();
            ts.commit();
            return list;
        } catch (Exception e) {
            ts.rollback();
        } finally {
            session.flush();
        }

        return null;
    }

    public String provideServices(Apointment apointment) {

        this.setFirstName(apointment.getFirstName());
        this.setEmail(apointment.getEmail());
        this.setPhone(apointment.getPhone());
        this.setGender(apointment.getGender());
        this.setDate(apointment.getDate());
        this.setId(apointment.getId());
        return "apointedPatient";
    }

    public List<Apointment> showApointment() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("FROM Apointment");
            List<Apointment> list = query.list();
            ts.commit();
            return list;
        } catch (Exception e) {
            ts.rollback();
        } finally {
            session.flush();
        }

        return null;
    }

    public String deleteApo(Apointment apointment) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;

        try {

            ts = session.beginTransaction();
            session.delete(apointment);
            ts.commit();
            return "adminShowApointment.xhtml";
        } catch (Exception e) {
            ts.rollback();
        } finally {
            session.flush();
        }
        return null;
    }

   

    

    

}
