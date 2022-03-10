<%-- 
    Document   : adminViewFeedBack
    Created on : Feb 27, 2022, 12:12:04 PM
    Author     : Thongchu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin View FeedBack</title>
        <link href="./public/style/landingAdmin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="../view/headerAdmin.jsp"></jsp:include>


            <div id="admin-main-content">
            <jsp:include page="../view/leftMenuAdmin.jsp"></jsp:include>
                <div class="admin-manager-detail">
                    <div class="header-main">
                        <p>Admin View Feedback </p>
                    </div>
                    <div class="mess">                          
                        <p>
                        ${requestScope.mess}
                    </p>  
                </div>
                <form action="AdminViewFeedBack" method="post">

                    Customer :
                    <select name="customerID">
                        <option value="all">All</option>
                        <c:forEach var="customer" items="${requestScope.customers}">
                            <c:if test="${customer.customerID == requestScope.customerPara}">
                                <option value="${customer.customerID}" selected>${customer.customerName}</option>
                            </c:if>
                            <c:if test="${customer.customerID != requestScope.customerPara}">
                                <option value="${customer.customerID}" >${customer.customerName}</option>
                            </c:if>  
                        </c:forEach>
                    </select>
                    Product :
                    <select name="productID">
                        <option value="all">All</option>
                        <c:forEach var="product" items="${requestScope.products}">
                            <c:if test="${product.productID == requestScope.productPara}">
                                <option value="${product.productID}" selected>${product.productName}</option>
                            </c:if>
                            <c:if test="${customer.customerID != requestScope.productPara}">
                                <option value="${product.productID}">${product.productName}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                    Ratting :
                   <select name="rattingID">
                        <option value="all">All</option>
                        <c:forTokens items="1,2,3,4,5" delims="," var="rate">  
                            <c:if test="${rate == requestScope.rattingPara}">
                                <option value="${rate}" selected>${rate}</option>
                            </c:if>
                            <c:if test="${rate != requestScope.rattingPara}">
                                <option value="${rate}" >${rate}</option>
                            </c:if>  
                        </c:forTokens> 
                    </select>

                    <input type="submit" value="Search" name="searchViewFeedBack"  />
                    <c:choose>
                        <c:when test="${null != message}">
                            <div style="color: red">${message}</div>
                        </c:when>
                        <c:otherwise>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Customer</th>
                                        <th>Date</th>
                                        <th>Description</th>
                                        <th>Product</th>
                                        <th>Ratting</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="feedBack" items="${requestScope.feedBacks}">
                                        <tr>
                                            <td>${feedBack.customerName}</td>
                                            <td>${feedBack.feedbackDate}</td>
                                            <td>${feedBack.description}</td>
                                            <td>${feedBack.productName}</td>
                                            <td>${feedBack.ratting}</td>
                                        </tr>
                                    </c:forEach>


                                </tbody>
                            </table>
                        </c:otherwise>
                    </c:choose>


                </form>

            </div>
        </div> 
    </form
</body>
</html>
