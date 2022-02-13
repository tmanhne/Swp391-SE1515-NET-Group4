<%-- 
    Document   : HomePageForAdmin
    Created on : Feb 10, 2022, 5:12:02 PM
    Author     : phamthithi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Book"%>
<%@page import="dao.BooksDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page For Admin</title>
        <link href="./public/style/landingAdmin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <jsp:include page="headerAdmin.jsp"></jsp:include>
       


        <div id="admin-main-content">
            <div class="admin-manager">
                <div class="list-manager">
                    <a href="#">Manager Products</a>
                </div>
                <div class="list-manager">
                    <a href="#">Manager Bills</a>
                </div>
                <div class="list-manager">
                    <a href="#">Add New Product</a>
                </div>
            </div>
            <div class="admin-manager-detail">
                <div class="header-main">
                    <p>The List of Products</p>
                </div>
                <div class="table-listProduct">
                  <table>
                        <tr>             
                            <th>BookID</th>
                            <th>BookName</th>
                            <th>Description</th>
                            <th>Unit Price</th>
                            <th>UnitInStock</th>
                       
                            <th>Author</th>
                            <th>IsContinue</th>
                            <th>Edit</th>

                        </tr>
                         <c:forEach var="product" items="${requestScope.list}">
                        <tr>
                            <td>${product.getProductID()}</td>
                            <td>${product.getProductName()}</td>
                            <td>${product.getDescription()}</td>
                            <td>${product.getUnitPrice()}</td>
                            <td>${product.getUnitInStock()}</td>
                          <%--  <td><img src="${product.getPathImage()}"style="width: 100%"/></td>--%>
                           
                              <td>${product.getAuthors()}</td>
                             <td>${product.isIsContinues()}</td>
                            <td><a>Edit</a></td>
                        </tr>
                    </c:forEach>
                    </table>
                </div>
                <div class="pagination-page">
                 
                </div>
            </div>
        </div>
         <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
