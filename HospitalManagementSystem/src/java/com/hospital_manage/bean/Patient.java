package com.hospital_manage.bean;

import com.hospital_manage.util.NewHibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
@Table(name = "patient")
public class Patient {

    @Id
    @Column(name = "id")
    int id;
    @Column(name = "name")
    private String name;
    
    
    @Column(name = "drName")
    private String drName;
    @Column(name = "mdcn1")
    private String mdcn1;
    @Column(name = "rule1")
    private String rule1;
    
    @Column(name = "drEmail")
    private String drEmail;
    
    @Column(name = "drPhone")
    private int drPhone;
    
    @Column(name = "drGender")
    private String drGender;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "phone")
    private int phone;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "date")
    private Date date;
    
    
    
    
    

    @Transient
    private Apointment apointment = new Apointment();
    @Transient
    private DoctorBean doctor = new DoctorBean();
    @Transient
    private List<Patient> patientList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDrName() {
        return drName;
    }

    public void setDrName(String drName) {
        this.drName = drName;
    }

    public Apointment getApointment() {
        return apointment;
    }

    public void setApointment(Apointment apointment) {
        this.apointment = apointment;
    }

    public DoctorBean getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorBean doctor) {
        this.doctor = doctor;
    }

    public String getMdcn1() {
        return mdcn1;
    }

    public void setMdcn1(String mdcn1) {
        this.mdcn1 = mdcn1;
    }

    public String getRule1() {
        return rule1;
    }

    public void setRule1(String rule1) {
        this.rule1 = rule1;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }
    
    
    public String getDrEmail() {
        return drEmail;
    }

    public void setDrEmail(String drEmail) {
        this.drEmail = drEmail;
    }

    public int getDrPhone() {
        return drPhone;
    }

    public void setDrPhone(int drPhone) {
        this.drPhone = drPhone;
    }

    public String getDrGender() {
        return drGender;
    }

    public void setDrGender(String drGender) {
        this.drGender = drGender;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    

    public String saveData(Patient patient, DoctorBean doctor, Apointment apointment) {

        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;
        try {
            
            this.setDrName(doctor.getName());
            this.setDrEmail(doctor.getEmail());
            this.setDrPhone(doctor.getPhone());
            this.setDrGender(doctor.getGender());
            this.setId(apointment.getId());
            this.setName(apointment.getFirstName());
            this.setEmail(apointment.getEmail());
            this.setPhone(apointment.getPhone());
            this.setGender(apointment.getGender());
            this.setDate(apointment.getDate());
            
            ts = session.beginTransaction();
            session.saveOrUpdate(patient);
            ts.commit();
            session.flush();
            
        } catch (Exception e) {
            ts.rollback();
        }

        return null;
    }

    public String myPatient(Patient patient) {
        patientList = new ArrayList<>();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            Query q = session.createQuery("from Patient where id=:id");
            q.setInteger("id", patient.getId());
            patientList = q.list();
            return "myPatient";

        } catch (Exception e) {
        } finally {
            session.flush();
        }

        return null;
    }

    

}
