<%-- 
    Document   : show
    Created on : Mar 17, 2022, 12:31:50 AM
    Author     : phamthithi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./public/style/landingPage.css" rel="stylesheet" type="text/css"/>
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
            />
        <link href="./public/style/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <script>
            function addToCart() {
                alert("Add Successfull!");
            }
        </script>
        <div>
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

            <div id="home-content-left">
                <c:forEach items="${requestScope.listP}" var="book">
                    <div class="book-container">
                        <div class="book-container-header">
                            <div class="book-thumbnail">
                                <a href="#"><img class="thumbnail-image" src="${book.getImagePath()}"></a>
                            </div>
                            <div class="book-info">
                                <div class="book-title">
                                    <a class="book-name" href="/Swp391-SE1515-NET-Group4/viewDetail?id=${book.getProductID()}">${book.getProductName()}</a>
                                    <c:forEach items="${book.getAuthors()}" var="author">
                                        <span class="author">${author}</span>
                                    </c:forEach>
                                </div>
                                <div class="description">${book.getDescription()}</div>
                            </div>
                        </div> 
                        <div class="book-container-footer">
                            <form action="AddToCart" method="POST">
                                <input type="hidden" value="${book.getProductID()}" name="id">
                                <input onclick="addToCart()" type="submit" value="Buy" class="form-button">
                            </form>
                            <div class="price">${book.getUnitPrice()}$</div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="clearfix"></div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
