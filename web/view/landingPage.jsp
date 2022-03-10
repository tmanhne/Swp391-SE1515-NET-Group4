<%-- 
    Document   : LangdingPage
    Created on : Jan 19, 2022, 8:18:01 PM
    Author     : vudm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./public/style/landingPage.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <script>
            function addToCart() {
                alert("Add Successfull!");
            }
        </script>
        <div>
            <jsp:include page="header.jsp"></jsp:include>

                <div id="home">
                    <div id="home-content">
                        <div id="home-content-left">
                        <c:forEach items="${requestScope.books}" var="book">
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
                    <div id="home-content-right">
                        <span class="title">  Hot!!! </span>
                        <c:forEach items="${requestScope.bestSellerBooks}" var="book">
                            <div class="best-seller-book-container">
                                <div class="book-thumbnail">
                                    <a href="#"><img class="thumbnail-image" src="${book.getImagePath()}"></a>
                                </div>
                                <div class="book-info">
                                    <div class="book-title">
                                        <a href="#">${book.getProductName()}</a>
                                        <c:forEach items="${book.getAuthors()}" var="author" varStatus="loop">
                                            <span class="author">${author}</span>
                                        </c:forEach>
                                    </div>
                                </div>
                                <div class="buy-section">
                                    <form action="AddToCart" method="POST" class="button-container">
                                        <input type="hidden" value="${book.getProductID()}" name="id" >
                                        <input onclick="addToCart()" type="submit" value="Buy" class="form-button">
                                    </form>
                                    <div class="price">${book.getUnitPrice()}$</div>
                                </div>
                            </div>
                        </c:forEach>
                        <span class="title">  Highest Price!!!  </span>
                        <c:forEach items="${requestScope.highestPricerBooks}" var="book">
                            <div class="best-seller-book-container">
                                <div class="book-thumbnail">
                                    <a href="#"><img class="thumbnail-image" src="${book.getImagePath()}"></a>
                                </div>
                                <div class="book-info">
                                    <div class="book-title">
                                        <a href="#">${book.getProductName()}</a>
                                        <c:forEach items="${book.getAuthors()}" var="author" varStatus="loop">
                                            <span class="author">${author}</span>
                                        </c:forEach>
                                    </div>
                                </div>
                                <div class="buy-section">
                                    <form action="AddToCart" method="POST" class="button-container">
                                        <input type="hidden" value="${book.getProductID()}" name="id" >
                                        <input type="submit" value="Buy" class="form-button">
                                    </form>
                                    <div class="price">${book.getUnitPrice()}$</div>
                                </div>

                            </div>
                        </c:forEach>

                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>
