<%-- 
    Document   : salesPartner
    Created on : Mar 26, 2022, 2:29:14 PM
    Author     : admin
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

        <h3 class="titleReport">Sales Partner Form</h3>

        <div class="container">
            <form action="SalesPartnerController" method="POST">
                <c:choose>
                    <c:when test="${requestScope.partnerName != null}">
                        <label for="fname">Partner Name</label>
                        <input type="text" id="fname" name="partnerName" placeholder="Name.." value="${requestScope.partnerName}">

                        <label for="lname">Address</label>
                        <input type="text" id="lname" name="address" placeholder="Address.." value="${requestScope.address}">

                        <label for="fname">Product</label>
                        <input type="text" id="fname" name="product" placeholder="Product.." value="${requestScope.product}">

                        <label for="lname">Email</label>
                        <input type="text" id="lname" name="email" placeholder="Email.." value="${requestScope.email}">

                        <label for="lname">Phone</label>
                        <input type="text" id="lname" name="phone" placeholder="Phone Number.." value="${requestScope.phone}">

                        <label for="subject">Descriptions</label>
                        <textarea  id="subject" name="descriptions" placeholder="Write something.." style="height:200px" value="${requestScope.descriptions}"></textarea>

                    </c:when>

                    <c:otherwise>
                        <label for="fname">Partner Name</label>
                        <input type="text" id="fname" name="partnerName" placeholder="Name..">

                        <label for="lname">Address</label>
                        <input type="text" id="lname" name="address" placeholder="Cutomer name..">

                        <label for="fname">Product</label>
                        <input type="text" id="fname" name="product" placeholder="Product..">

                        <label for="lname">Email</label>
                        <input type="text" id="lname" name="email" placeholder="Email..">

                        <label for="lname">Phone</label>
                        <input type="text" id="lname" name="phone" placeholder="Phone Number..">

                        <label for="subject">Descriptions</label>
                        <textarea  id="subject" name="descriptions" placeholder="Write something.." style="height:200px"></textarea>

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
