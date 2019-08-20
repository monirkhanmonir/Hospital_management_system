
package com.hospital_manage.bean;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    public static Connection getConnection(){
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management","root","123456");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      return con;
    }
    public static void main(String[] args) {
        Connection con = getConnection();
        if(con!=null){
            System.out.println("ok");
        }else{
            System.out.println("no");
        }
    }
}
