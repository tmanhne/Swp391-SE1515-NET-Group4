<%-- 
    Document   : header
    Created on : Jan 18, 2022, 5:18:01 PM
    Author     : admin
--%>

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
                        <form action="/BookShopsOnline/StoryController" method="POST">
                            <button>Story</button>
                        </form>
                        <form action="/BookShopsOnline/BookController" method="POST">
                            <button>Book</button>
                        </form>
                        <form action="/BookShopsOnline/NovelController" method="POST">
                            <button>Novel</button>
                        </form>
                    </div>
                </div>
                <div id="header-left">
                    <a href="/BookShopsOnline/LandingPageController">BookShops Online</a>
                </div>
                <div id="header-middle">
                    <form action="/BookStore/search" method="POST">
                        <span class="glyphicon glyphicon-search"></span>
                        <input type="text" placeholder="Find books"  name="search">
                        <button type="submit">Search</button>
                    </form>  
                </div>

                <div id="header-right">

                    <% if (session.getAttribute("account") == null) { %>
                    <a href="/BookStore/register">Register</a>
                    <a href="/BookStore/login">Login</a>
                    <% } else {%>
                    <a href="/BookStore/logout">Logout</a>
                    <a href="#" class="account">${sessionScope.account.username}</a>
                    <a href="/BookStore/update">update</a>
                    <% }%>
                    <a href="/BookStore/cart"><span class="glyphicon glyphicon-shopping-cart" style="padding: 0px 10px;"></span></a>
                </div>
            </div>
        </div>
        <div id="break-line" ></div>
    </body>
</html>
