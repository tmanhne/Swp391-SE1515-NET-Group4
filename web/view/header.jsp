<%-- 
    Document   : header
    Created on : Jan 18, 2022, 5:18:01 PM
    Author     : vudm
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <link href="./public/style/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="header">
            <div class="row">
                <div class="dropdown">
                    <button class="dropbtn">List</button>
                    <div class="dropdown-content">
                        <form action="StoryController" method="GET">
                            <button>Story</button>
                        </form>
                        <form action="BookController" method="GET">
                            <button>Book</button>
                        </form>
                        <form action="NovelController" method="GET">
                            <button>Novel</button>
                        </form>
                    </div>
                </div>
                <div id="header-left">
                    <a href="home">BookShops Online</a>
                </div>
                <div id="header-middle">
                    <form action="search" method="POST">
                        <span class="glyphicon glyphicon-search"></span>
                        <input type="text" placeholder="Find books"  name="search" value="${requestScope.searchname}">
                        <button type="submit">Search</button>
                    </form>  
                </div>

                <div id="header-right">

                    <% if (session.getAttribute("account") == null) { %>
                    <a href="/FinalAssignment/register">Register</a>
                    <a href="Login">Login</a>
                    <% } else {%>
                    <a href="/FinalAssignment/logout">Logout</a>
                    <a href="#" class="account">${sessionScope.Username}</a>
                    <a href="/FinalAssignment/update">update</a>
                    <a href="profile">Profile</a>
                    <% }%>
                    <a href="/FinalAssignment/cart"><span class="glyphicon glyphicon-shopping-cart" style="padding: 0px 10px;"></span></a>
                </div>
            </div>
        </div>
        <div id="break-line" ></div>
    </body>
</html>
