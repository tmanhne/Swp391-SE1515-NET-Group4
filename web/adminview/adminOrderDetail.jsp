<%-- 
    Document   : adminOrderDetail
    Created on : Mar 28, 2022, 12:38:48 AM
    Author     : t.manh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./public/style/landingAdmin.css" rel="stylesheet" type="text/css"/>
        <script src="./assets/js/table2excel.js"></script>
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
                    <c:if test="${null!=requestScope.order}">
                        <div>
                            <table id="tblStocks">
                                <tr>
                                    <th>
                                        Order ID: ${requestScope.order.getOrderID()}
                                    </th>
                                    <th>
                                        Order Date:  ${requestScope.order.getOrderDate()}
                                    </th>
                                    <th>

                                    </th>
                                    <th>
                                        Payment Method: ${requestScope.order.getPaymentMethod()}
                                    </th>
                                    <th>

                                    </th>                      
                                </tr>

                                <tr>             
                                    <th>Product ID</th>
                                    <th>Product Name</th>
                                    <th>Quantity</th>
                                    <th>Unit price</th>
                                    <th>Sub total</th>
                                </tr>

                                <c:forEach var="product" items="${requestScope.orderdetails}">
                                    <tr>
                                        <td style="padding: 5px;">
                                            ${product.getProductID()}
                                        </td>
                                        <td>${product.getProductName()}</td>
                                        <td>${product.getQuantity()}</td>
                                        <td>${product.getUnitPrice()}</td>
                                        <td>${product.getUnitPrice()*product.getQuantity()}</td>

                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td style="padding: 5px;">Total: </td>
                                    <td></td>
                                    <td></td>
                                    <td></td>                                
                                    <td>${requestScope.total}</td>
                                </tr>

                            </table>
                        </div>
                    </c:if>
                </div>
                <button style="margin-left: 20px;" onclick="exportData()">
                    <span class="glyphicon glyphicon-download"></span>
                    Export Bill
                </button>
            </div>
        </div>
        <jsp:include page="../view/footerAdmin.jsp"></jsp:include>
    </body>
</html>
