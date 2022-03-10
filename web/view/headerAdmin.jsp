<%-- 
    Document   : header
    Created on : Jan 18, 2022, 5:18:01 PM
    Author     : admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <link href="./public/style/headerAdmin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="header">
            <div class="row">

                <div class="header-logo">
                    <a href="homeadmin">Admin Manager</a>
                </div>
                <div class="search-input">
                    <form action="homeadmin" method="POST">
                        <span class="glyphicon glyphicon-search"></span>
                        <input type="text" placeholder="Find books" name="search" value="${requestScope.searchname}" />
                        <button type="submit">Search</button>
                    </form>
                </div>
                <div class="group-manager">
                    <c:if test="${null!=sessionScope.account}">
                        <a href="logout">Logout</a>
                        <p style="display: inline">Hello ${sessionScope.account.getUserName()}</p>
                    </c:if>
                </div>
            </div>
        </div>

    </body>
</html>
