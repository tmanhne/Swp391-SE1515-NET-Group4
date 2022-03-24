<%-- 
    Document   : enterOtp
    Created on : Mar 24, 2022, 4:01:27 PM
    Author     : t.manh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title> Unistore Pro &middot; Premium Store</title>
        <link href="./public/style/forgotPasswordOTP.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="body_forgot">
                <h3>Enter OTP</h3>
                <form>
                    <div class="send_otp">
                        <label for="email">Enter OTP</label>
                        <input type="text" id="email" name="otp">
                        <a type="submit" href="">Change Password</a>
                        <p>Message notification</p>
                    </div>
                </form>
            </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
