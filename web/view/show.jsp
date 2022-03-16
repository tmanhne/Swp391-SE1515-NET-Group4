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
    </head>
    <body>
        <script>
            function addToCart() {
                alert("Add Successfull!");
            }
        </script>
        <div>
            <!--        change name-->
            <jsp:include page="header.jsp"></jsp:include>
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
    </div>
</body>
</html>
