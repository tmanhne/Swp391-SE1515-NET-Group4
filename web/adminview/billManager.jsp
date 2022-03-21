<%-- 
    Document   : billManager
    Created on : Mar 12, 2022, 3:17:54 PM
    Author     : Hfyl
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./public/style/landingAdmin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="../view/headerAdmin.jsp"></jsp:include>
            <div id="admin-main-content">
            <jsp:include page="../view/leftMenuAdmin.jsp"></jsp:include>
                <div class="admin-manager-detail">
                    <div class="header-main">
                        <p>Orders list</p>
                    </div>
                    <div class="table-listProduct">
                        <form method="POST" action="billmanager">
                            <table>
                                <tr>             
                                    <th>Order ID</th>
                                    <th>Customer</th>
                                    <th>Order Date</th>
                                    <th>Cost</th>
                                    <th>Ship</th>
                                    <th>Payment Method</th>
                                    <th></th>
                                    <th></th>
                                </tr>

                            <c:forEach var="order" items="${requestScope.orders}">
                                <tr>
                                    <td>${order.getOrderID()}</td>
                                    <td>${order.getCustomer()}</td>
                                    <td>${order.getOrderDate()}</td>
                                    <td>${order.getUnitPrice()}</td>
                                    <td>${order.getShip()}</td>
                                    <td>${order.getPaymentMethod()}</td>

                                    <td><button type="submit" value="${order.getOrderID()}" name="accept">Accept</button></td>
                                    <td><button type="submit" value="${order.getOrderID()}" name="deny">Deny</button></td>

                                </tr>
                            </c:forEach>
                        </table>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="../view/footer.jsp"></jsp:include>
    </body>
</html>
