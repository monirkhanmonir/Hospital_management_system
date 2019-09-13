
package com.hospital_manage.bean;

import com.hospital_manage.util.NewHibernateUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.Transaction;


@ManagedBean
@ViewScoped
@Entity
@Table(name = "massage")
public class Massage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
   @Column(name = "name")
   private String name;
   @Column(name = "email")
   private String email;
   @Column(name = "subject")
   private String subject;
   @Column(name = "msg")
   private String msg;

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String saveMassage(Massage msg){
    
     Session session =    NewHibernateUtil.getSessionFactory().openSession();
        Transaction ts = null;
        try {
            ts =session.beginTransaction();
            session.save(msg);
            
            ts.commit();
            this.setEmail("");
            this.setName("");
            this.setSubject("");
            this.setMsg("");
            
            
            return "contractUs";
        } catch (Exception e) {
        }
    
    return null;
    }
   
   
   
}
