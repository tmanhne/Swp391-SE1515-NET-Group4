<%-- 
    Document   : checkoutHistory
    Created on : Mar 13, 2022, 2:24:21 PM
    Author     : Hfyl
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <div style="width: 70%; margin: 0 auto;">

            <c:if test="${null==requestScope.orders}">
                <h5>There has no records</h5>
            </c:if>
            <c:if test="${null!=requestScope.orders}">
                <table border="1" style="width: 100%">
                    <thead>
                        <tr>
                            <th>OrderID</th>
                            <th>Order Date</th>
                            <th>Status</th>
                            <th>Payment Method</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="order" items="${requestScope.orders}">

                            <tr>
                                <td>${order.getOrderID()}</td>
                                <td>${order.getOrderDate()}</td>
                                <td>${order.getStatus()}</td>
                                <td>${order.getPaymentMethod()}</td>
                                <td><a href="orderdetail?id=${order.getOrderID()}">Detail</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div>
                    <c:if test="${(requestScope.totalPage!=null)}">
                        <c:forEach var="i" begin="1" end="${requestScope.totalPage}" step="1">
                            <c:if test="${i==requestScope.page}">
                                <strong>${i}<strong>
                                    </c:if>
                                    <c:if test="${i!=requestScope.page}">
                                        <a href="checkouthistory?page=${i}" >${i}</a>
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </c:if>
                        </div>
                        </div>
                        <jsp:include page="footer.jsp"></jsp:include>
                        </body>

                        </html>
