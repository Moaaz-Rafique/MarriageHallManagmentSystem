/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject;

import java.io.File;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author s
 */
public class CRUDOperations {

    ConnectionToDB con = new ConnectionToDB();
    Connection con_obj = con.EstablishConnection();
    Statement stmt = null; // insert update delete
    PreparedStatement pstmt = null;//select
    ResultSet res = null;
    String name, pwd;

    public MarriageHall fetchNarriageHall(int id) {
        MarriageHall m = null;
        String sql = "select * from Hall where ID = '" + id + "' ";

        try {
            pstmt = con_obj.prepareStatement(sql);
            res = pstmt.executeQuery();

            while (res.next()) {
                m = new MarriageHall(res.getString("Name"), res.getString("Price"), res.getInt("Capacity"),
                        res.getString("Location"), res.getString("Contact"), res.getString("Date"), new File(res.getString("Image")));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Error");
        }
        return m;
    }

    public boolean addMarriageHall(MarriageHall m) {
        boolean b = false;
        //sql Syntax of inserting data
        //insert into Table_Name (col1, col2, col3,... col_n) values (var1, var2,var3,..... , var_n)
        String sql = "insert into Hall(Name,Price,Capacity,Location,Contact,Date, Image) values ('"
                + m.getName() + "','"
                + m.getPrice() + "','"
                + m.getCapacityPeople() + "','"
                + m.getLocation() + "','"
                + m.getContact() + "','"
                + m.getDate() + "','"
                + m.getImgP().getAbsolutePath() + "')";
        try {
            stmt = con_obj.createStatement();// to convert above string into compatible sql/database  query

            int res = stmt.executeUpdate(sql);// after excecuting above query the number of record effects is returned so if not 0 means rec is added
            if (res > 0) {
                b = true;
            } else {
                b = false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex); // catching exception in case of expcetion
        }
        return b;
    }

    public User fetchUser(int id) {
        User m = null;
        String sql = "select * from User where ID = '" + id + "' ";

        try {
            pstmt = con_obj.prepareStatement(sql);
            res = pstmt.executeQuery();

            while (res.next()) {
                m = new User(res.getString("Name"), res.getString("Password"),
                        res.getString("Type"), res.getString("Contact"), new File(res.getString("Image")));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Error");
        }
        return m;
    }

    public boolean addUser(User u) {
        boolean b = false;
        //sql Syntax of inserting data
        //insert into Table_Name (col1, col2, col3,... col_n) values (var1, var2,var3,..... , var_n)
        String sql = "insert into User(Name,Password,Type,Contact, Image) values ('"
                + u.getName() + "','"
                + u.getPassword() + "','"
                + u.getUserType() + "','"
                + u.getContact() + "','"
                + u.getImgP().getAbsolutePath() + "')";
        try {
            stmt = con_obj.createStatement();// to convert above string into compatible sql/database  query

            int res = stmt.executeUpdate(sql);// after excecuting above query the number of record effects is returned so if not 0 means rec is added
            if (res > 0) {
                b = true;
            } else {
                b = false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex); // catching exception in case of expcetion
        }
        return b;
    }

    public int countRows(String table) {
        String sql = "select count(*) from Hall ";
        int rows = 0;    
        try {
            pstmt = con_obj.prepareStatement(sql);
            res = pstmt.executeQuery();
            rows = res.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(CRUDOperations.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return rows;
    }
}
