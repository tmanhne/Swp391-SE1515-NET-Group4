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
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
            />
        <link href="./public/style/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="topnav">
            <a href="home">Book Shop Online</a>
            <div class="dropdown">
                <button class="dropbtn">Category</button>
                <div class="dropdown-content">
                    <div class="item">
                        <c:forEach var="cate" items="${requestScope.list}">
                            <form action="listProductByCategory" method="GET">
                                <a href="listProductDetail?categoryID=${cate.getCategoryID()}">${cate.getCategoryName()}</a>
                            </form>
                        </c:forEach>
                    </div>


                </div>
            </div>
            <div class="search-container">
                <form action="search" method="POST">
                    <input type="text" placeholder="Search.." name="search" value="${requestScope.searchname}" />
                    <button type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>

            <div class="control-container">
                <c:if test="${null!=sessionScope.account}">
                    <a href="logout">Logout</a>
                    <a href="/FinalAssignment/update">update</a>
                    <a href="profile">Hello ${sessionScope.account.getUserName()}</a>
                </c:if>
                <c:if test="${null==sessionScope.account}">
                    <a href="SignUpController">Register</a>
                    <a href="Login">Login</a>
                </c:if>

                <a href="cart"><i class="fa fa-shopping-cart"></i></a>
            </div>
        </div>
    </body>
</html>
