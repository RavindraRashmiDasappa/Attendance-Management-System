<%-- 
    Document   : header
    Created on : Feb 20, 2017, 6:29:54 PM
    Author     : Rashmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%-- title of the Page--%>
        <title>Attendance Management</title>
        <%-- importing CSS stylesheet --%>
        <link rel="stylesheet" href="styles/main.css">
    </head>
    <body>
        <%-- Code to specify Header section of the page--%>
        <div id="header">
            <nav id="header_menu">
                <ul  class="left" >
                    <li>Attendance Management</li>
                </ul>
                <ul class="right">
                    <c:if test="${param.user == null}">
                        <li><a href="login.jsp">Login</a></li>
                    </c:if>
                </ul>

            </nav>



        </div>

