<%-- 
    Document   : question
    Created on : Feb 24, 2017, 11:05:38 AM
    Author     : rahmi
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>


<%-- Code to Display Question--%>
<section class="question_section">
    <h3><span id="studies">Question</span></h3>


    <%--Code to rating the Question --%>
    <%--Code to rating the Question --%>

    <label class="pad_top">Date:</label>
    <script>
        var tD = new Date();
        var datestr = (tD.getMonth() + 1) + "/" + tD.getDate() + "/" + tD.getFullYear();
        document.write("<input type='text' name='textField' value='" + datestr + "' readonly>");
    </script>
     <form action="Attendance" method="post">
    <div id="question_select"><p>Press Yes if present</p>
        <input class=radiobutton type="radio"  name="rate3" value="yes" />&nbsp;&nbsp;    yes<br>
        <input class=radiobutton type="radio"  name="rate3" value="no" />&nbsp;&nbsp;    no<br>
        <input type="submit" value = "submit" id="question_submit"/><br>

    </div>
   
       
              

    
            </form>

</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>