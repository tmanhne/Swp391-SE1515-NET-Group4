<%-- 
    Document   : report
    Created on : Feb 28, 2022, 3:41:54 PM
    Author     : vudm
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./public/style/report.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>

        <h3 class="titleReport">Report Form</h3>

        <div class="container">
            <form action="ReportController" method="POST">
                <c:choose>
                    <c:when test="${requestScope.title != null}">
                        <label for="fname">Title</label>
                        <input type="text" id="fname" name="title" placeholder="Title.." value="${requestScope.title}">

                        <label for="lname">Customer's Name</label>
                        <input type="text" id="lname" name="customerName" placeholder="Cutomer name.." value="${requestScope.customerName}">

                        <label for="fname">Email</label>
                        <input type="text" id="fname" name="email" placeholder="Email.." value="${requestScope.email}">

                        <label for="lname">Phone</label>
                        <input type="text" id="lname" name="phone" placeholder="Phone Number.." value="${requestScope.phone}">

                        <label for="country">Insurance</label>
                        <select id="country" name="insurance">
                            <option value="None">None</option>
                            <option value="6 months">6 months</option>
                            <option value="1 year" selected="selected">1 year</option>
                        </select>

                        <label for="subject">Descriptions</label>
                        <textarea type="text" id="subject" name="descriptions" placeholder="Write something.." style="height:200px" value="${requestScope.descriptions}"></textarea>

                    </c:when>

                    <c:otherwise>
                        <label for="fname">Title</label>
                        <input type="text" id="fname" name="title" placeholder="Title..">

                        <label for="lname">Customer's Name</label>
                        <input type="text" id="lname" name="customerName" placeholder="Cutomer name..">

                        <label for="fname">Email</label>
                        <input type="text" id="fname" name="email" placeholder="Email..">

                        <label for="lname">Phone</label>
                        <input type="text" id="lname" name="phone" placeholder="Phone Number..">

                        <label for="country">Insurance</label>
                        <select id="country" name="insurance">
                            <option value="None">None</option>
                            <option value="6 months">6 months</option>
                            <option value="1 year" selected="selected">1 year</option>
                        </select>

                        <label for="subject">Descriptions</label>
                        <textarea id="subject" name="descriptions" placeholder="Write something.." style="height:200px"></textarea>

                    </c:otherwise>
                </c:choose>
                <div style="color: red;">${notification}</div>
                <input type="submit" value="Submit">
            </form>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
        <!--        change name-->
    </body>
</html>
