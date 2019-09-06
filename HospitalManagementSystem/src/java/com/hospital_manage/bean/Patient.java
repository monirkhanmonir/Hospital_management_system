
package com.hospital_manage.bean;

import com.hospital_manage.util.NewHibernateUtil;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
@SessionScoped
@Entity
public class Patient {
    private String drName;
    private String drEmail;
    private int drPhone;
    private String drGender;
    @Id
    private int id;
    private String name;
    private String email;
    private String gender;
    private int phone;
    private Date date;
    private String md1;
    private String rule1;
    private String md2;
    private String rule2;
    private String md3;
    private String rule3;
    private String md4;
    private String rule4;
    private String md5;
    private String rule5;
    private String md6;
    private String rule6;
    private String md7;
    private String rule7;
    private String md8;
    private String rule8;
    private String md9;
    private String rule9;
    private String md10;
    private String rule10;
    private DoctorBean doctor = new DoctorBean();
    private Apointment apointment = new Apointment();
    
    
  
    public String getDrName() {
        return drName;
    }

    public void setDrName(String drName) {
        this.drName = drName;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMd1() {
        return md1;
    }

    public void setMd1(String md1) {
        this.md1 = md1;
    }

    public String getRule1() {
        return rule1;
    }

    public void setRule1(String rule1) {
        this.rule1 = rule1;
    }

    public String getMd2() {
        return md2;
    }

    public void setMd2(String md2) {
        this.md2 = md2;
    }

    public String getRule2() {
        return rule2;
    }

    public void setRule2(String rule2) {
        this.rule2 = rule2;
    }

    public String getMd3() {
        return md3;
    }

    public void setMd3(String md3) {
        this.md3 = md3;
    }

    public String getRule3() {
        return rule3;
    }

    public void setRule3(String rule3) {
        this.rule3 = rule3;
    }

    public String getMd4() {
        return md4;
    }

    public void setMd4(String md4) {
        this.md4 = md4;
    }

    public String getRule4() {
        return rule4;
    }

    public void setRule4(String rule4) {
        this.rule4 = rule4;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getRule5() {
        return rule5;
    }

    public void setRule5(String rule5) {
        this.rule5 = rule5;
    }

    public String getMd6() {
        return md6;
    }

    public void setMd6(String md6) {
        this.md6 = md6;
    }

    public String getRule6() {
        return rule6;
    }

    public void setRule6(String rule6) {
        this.rule6 = rule6;
    }

    public String getMd7() {
        return md7;
    }

    public void setMd7(String md7) {
        this.md7 = md7;
    }

    public String getRule7() {
        return rule7;
    }

    public void setRule7(String rule7) {
        this.rule7 = rule7;
    }

    public String getMd8() {
        return md8;
    }

    public void setMd8(String md8) {
        this.md8 = md8;
    }

    public String getRule8() {
        return rule8;
    }

    public void setRule8(String rule8) {
        this.rule8 = rule8;
    }

    public String getMd9() {
        return md9;
    }

    public void setMd9(String md9) {
        this.md9 = md9;
    }

    public String getRule9() {
        return rule9;
    }

    public void setRule9(String rule9) {
        this.rule9 = rule9;
    }

    public String getMd10() {
        return md10;
    }

    public void setMd10(String md10) {
        this.md10 = md10;
    }

    public String getRule10() {
        return rule10;
    }

    public void setRule10(String rule10) {
        this.rule10 = rule10;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public DoctorBean getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorBean doctor) {
        this.doctor = doctor;
    }

    public Apointment getApointment() {
        return apointment;
    }

    public void setApointment(Apointment apointment) {
        this.apointment = apointment;
    }
   
    
    
    
    public String changeMedicin(Patient patient, DoctorBean doctor, Apointment apointment){
    
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            this.setDrName(doctor.getName());
            this.setDrEmail(doctor.getEmail());
            this.setDrGender(doctor.getGender());
            this.setDrPhone(doctor.getPhone());
            this.setName(apointment.getFirstName());
            this.setEmail(apointment.getEmail());
            this.setPhone(apointment.getPhone());
            this.setId(apointment.getId());
            this.setDate(apointment.getDate());
            session.saveOrUpdate(patient);
        } catch (Exception e) {
        }
        
        
    return null;
    }


    
    
    
}
