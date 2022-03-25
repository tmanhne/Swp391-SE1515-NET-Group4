<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title> Forgot password</title>
        <link href="./public/style/forgotPasswordOTP.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="body_forgot">
                <h3>Forgot password</h3>
                <form method="POST" action="forgotpassword">
                    <div class="send_otp">
                        <label for="email">Enter your email:</label>
                        <input type="email" id="email" name="email" value="${requestScope.email}">
                        <input type="submit" value="Send OTP" />
                        <p>${requestScope.mess}</p>
                    </div>
                </form>
            </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>