/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.NewUserBean;
import business.UserBean;
import static data.UserDAO.currentCon;
import static data.UserDAO.rs;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import utility.ConnectionManager;

/**
 *
 * @author rahmi
 */
public class NewUserDAO {

    static Connection currentCon = null;
    static ResultSet rs = null;

    public static NewUserBean adduser(NewUserBean bean) {

        //preparing some objects for connection 
        Statement stmt = null;
        String name = bean.getName();
        String email = bean.getEmail();
        String password = bean.getPassword();

        String searchQuery
                = "INSERT INTO users (name, email, password)"
                + " VALUES (?, ?, ?)";
        // "System.out.println" prints in the console; Normally used to trace the process
        System.out.println("Your user name is " + email);
        System.out.println("Your password is " + password);
        System.out.println("Query: " + searchQuery);

        try {
            currentCon = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = null;
            int recordsAdded = 0;
            preparedStatement = currentCon.prepareStatement(searchQuery);
            preparedStatement.setString(1, bean.getName());
            preparedStatement.setString(2, bean.getEmail());
            preparedStatement.setString(3, bean.getPassword());

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

    public static NewUserBean getuser(NewUserBean bean) {

        //preparing some objects for connection 
        Statement stmt = null;
        String name = bean.getName();
        String email = bean.getEmail();
        String password = bean.getPassword();

        String searchQuery
                = "select * from users where email='"
                + email
                + "'";

        // "System.out.println" prints in the console; Normally used to trace the process
        System.out.println("Your user name is " + email);
        System.out.println("Your password is " + password);
        System.out.println("Query: " + searchQuery);

        try {
            //connect to DB 
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            if (rs.next()) {
                bean.setEmail(rs.getString("email"));
            }
           
        } catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        } //some exception handling
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

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
