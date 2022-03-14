<%-- 
    Document   : orderDetail
    Created on : Mar 13, 2022, 3:33:17 PM
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
                <h5 style="color: red">${requestScope.mess}</h5>
            <c:if test="${null!=requestScope.order}">
                <div>
                    <form action="orderdetail" method="POST">
                        <table border="0" style="width: 100%">
                            <tr>
                                <th>OrderID: ${requestScope.order.getOrderID()}</th>
                                <th>Order Date: ${requestScope.order.getOrderDate()}</th>
                                <th>Status: ${requestScope.order.getStatus()}</th>
                                <th>Ship:${requestScope.order.getShip()}</th>
                                <th>Payment Method: ${requestScope.order.getPaymentMethod()}</th>
                                    <c:if test="${requestScope.order.getStatus()eq'Waitting'}">
                                    <th><button name="cancel" type="submit" value="${requestScope.order.getOrderID()}">Cancel order</button></th>
                                    </c:if>
                            </tr>
                        </table>
                    </form>
                </div>
                <table border="1" style="width: 100%">
                    <thead>
                        <tr>
                            <th>ProductID</th>
                            <th>Product Name</th>
                            <th>Image</th>
                            <th>Quantity</th>
                            <th>Unit Price</th>
                            <th>Sub total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="product" items="${requestScope.orderdetails}">
                            <tr>
                                <td>${product.getProductID()}</td>
                                <td>${product.getProductName()}</td>
                                <td><img src="${product.getImagePath()}" style="width: 150px;height: 150px;" alt="Product image"/></td>
                                <td>${product.getQuantity()}</td>
                                <td>${product.getUnitPrice()}</td>
                                <td>${product.getUnitPrice()*product.getQuantity()}</td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td>Total:</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>${requestScope.total}</td>
                        </tr>
                    </tbody>
                </table>
            </c:if>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>

</html>
