package com.hospital_manage.bean;

import com.hospital_manage.util.NewHibernateUtil;
import java.util.ArrayList;
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
   
    public String saveData(Patient patient) {

        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            this.setId(apointment.getId());
            this.setName(apointment.getFirstName());
            this.setDrName(doctor.getName());
            session.save(patient);
            ts.commit();
        } catch (Exception e) {
            ts.rollback();
        } finally {
            session.flush();
        }

        return null;
    }

    public String myPatient(int id) {
        patientList = new ArrayList<>();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            Query q = session.createQuery("from Patient where id=:id");
            q.setInteger("id", id);
            patientList = q.list();
            return "myPatient";

        } catch (Exception e) {
        } finally {
            session.flush();
        }

        return null;
    }

   

   

}
