/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

/**
 *
 * @author rahmi
 */
import java.sql.*;
import java.util.*;

public class ConnectionManager {

    static Connection con;
    static String url;

    public static Connection getConnection() {

        try {
            String url = "jdbc:postgresql://localhost:5432/attendance";
            // assuming "DataSource" is your DataSource name

            Class.forName("org.postgresql.Driver");

            try {
                con = DriverManager.getConnection(url, "postgres", "rashmi");

                // assuming your SQL Server's	username is "username"               
                // and password is "password"
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return con;
    }
}
