<%-- 
    Document   : Login
    Created on : Feb 16, 2022, 3:18:43 PM
    Author     : vudm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./public/style/login.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
        <div class="container">
    <div class="row">
        <div class="offset-md-2 col-lg-5 col-md-7 offset-lg-4 offset-md-3">
            <div class="panel">
                <div class="panel-heading">
                    <h3 class="pt-3 font-weight-bold">Login</h3>
                </div>
                <div class="panel-body p-3">
                    <form action="Login" method="POST">
                        <div class="form-group py-2">
                            <div class="input-field" > <span class="far fa-user p-2"></span> <input  name="username" type="text" placeholder="Username or Email" required> </div>
                        </div>
                        <div class="form-group py-1 pb-2">
                            <div class="input-field"> <span class="fas fa-lock px-2"></span> <input name="password"  type="password" placeholder="Enter your Password" required> <button class="btn bg-white text-muted"> <span class="far fa-eye-slash"></span> </button> </div>
                        </div>
                        <div class="form-inline" type="checkbox" name="remember"> <input type="checkbox" name="remember" id="remember"/> <label name="remember" for="remember" class="text-muted">Remember me</label> <a href="#" id="forgot" class="font-weight-bold">Forgot password?</a> </div>
                        <label>${requestScope.Message}</label><br/>
                        <button class="btn btn-primary btn-block mt-3">Login</button>
                        <div class="text-center pt-4 text-muted">Don't have an account? <a href="view/SignUp.jsp">Sign up</a> </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
    </body>
</html>
