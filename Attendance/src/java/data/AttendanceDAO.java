/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.NewUserBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utility.ConnectionManager;
import business.AttendanceBean;
import java.util.Calendar;
/**
 *
 * @author rahmi
 */
public class AttendanceDAO {
    static Connection currentCon = null;
    static ResultSet rs = null;

    public static AttendanceBean adduserattend(AttendanceBean bean) {

        //preparing some objects for connection 
        Statement stmt = null;
        
        String email = bean.getEmail();
        String rate3 = bean.getRate3();
        Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
        String searchQuery
                = "INSERT INTO attend (email, rate3, timestamp)"
                + " VALUES (?,?,?)";
        // "System.out.println" prints in the console; Normally used to trace the process
        System.out.println("Your user name is " + email);
        System.out.println("Your choice is " + rate3);
        System.out.println("Query: " + searchQuery);

        try {
            currentCon = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = null;
            int recordsAdded = 0;
            preparedStatement = currentCon.prepareStatement(searchQuery);
            preparedStatement.setString(1, bean.getEmail());
            preparedStatement.setString(2, bean.getRate3());
            preparedStatement.setTimestamp(3, ourJavaTimestampObject);
            

            recordsAdded = preparedStatement.executeUpdate();

            if (recordsAdded > 0) {
                //System.out.println("Sorry, you are not a registered user! Please sign up first");
                bean.setValid(true);
            } //if user exists set the isValid variable to true
            else {

                bean.setValid(false);
            }
        } catch (SQLException e) {
            System.out.println("Error executing " + searchQuery + " statement: "
                    + e.getMessage());
            //return 0;
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }

        return bean;

    }

}
