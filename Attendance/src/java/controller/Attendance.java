/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.NewUserBean;
import data.NewUserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import business.AttendanceBean;
import data.AttendanceDAO;

/**
 *
 * @author rahmi
 */
@WebServlet(name = "Attendance", urlPatterns = {"/Attendance"})
public class Attendance extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
   
            String rate3 = request.getParameter("rate3");
       
            HttpSession sess = request.getSession(false); //use false to use the existing session
            String email = (String) sess.getAttribute("email");//this will return username anytime in the session
            System.out.println(email);

            AttendanceBean user = new AttendanceBean();
            user.setRate3(rate3);
            user.setEmail(email);
            user = AttendanceDAO.adduserattend(user);
            if (user.isValid()) {
                response.sendRedirect("entryrecorded.jsp"); //logged-in page 
            }else {
                
                response.sendRedirect("nonewuser.jsp");
            }            
            

        
    }
}
