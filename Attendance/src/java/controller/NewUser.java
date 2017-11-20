/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.UserBean;
import data.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.NewUserBean;
import data.NewUserDAO;

/**
 *
 * @author rahmi
 */
@WebServlet(name = "NewUser", urlPatterns = {"/NewUser"})
public class NewUser extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            NewUserBean user = new NewUserBean();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);


            user = NewUserDAO.adduser(user);
            if (user.isValid()) {
            response.sendRedirect("useradded.jsp"); //logged-in page 
            }else{
                response.sendRedirect("nonewuser.jsp");
            }            

        } catch (Throwable theException) {
            System.out.println(theException);
        }
    }

}
