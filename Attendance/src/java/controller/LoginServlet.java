/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.NewUserBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.UserBean;
import data.UserDAO;
import javax.servlet.http.*;

/**
 *
 * @author rahmi
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        try {

            String email = request.getParameter("un");
            String password = request.getParameter("pw");

            UserBean user = new UserBean();
            user.setEmail(email);
            user.setPassword(password);

            HttpSession sess = request.getSession();
            sess.setAttribute("email", email);
            sess.setAttribute("password", password);

            user = UserDAO.login(user);

            if (user.isValid()) {

                response.sendRedirect("userpage.jsp"); //logged-in page      		
            } else {
                response.sendRedirect("invalidLogin.jsp"); //error page 
            }

        } catch (Throwable theException) {
            System.out.println(theException);
        }
    }
}
