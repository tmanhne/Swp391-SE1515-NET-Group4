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
                            <div>
                                <select name="year">
                                <c:forEach var="year" items="${requestScope.years}">
                                    <c:if test="${year eq requestScope.selyear}">
                                        <option value="${year}" selected>${year}</option>
                                    </c:if>
                                    <c:if test="${year != requestScope.selyear}">
                                        <option value="${year}">${year}</option>
                                    </c:if>
                                </c:forEach>
                                </select>
                                <select name="date">
                                <c:forEach var="date" items="${requestScope.dates}">
                                    <c:if test="${date eq requestScope.seldate}">
                                        <option value="${date}" selected>${date}</option>
                                    </c:if>
                                    <c:if test="${date != requestScope.seldate}">
                                            <option value="${date}">${date}</option>
                                    </c:if>
                                     
                                </c:forEach>
                                </select>
                                <button type="submit" value="search" name="search">Search</button>
                                <p style="color: red">${requestScope.mess}</p>
                            <div>
                            <table>
                                <tr>             
                                    <th>Order ID</th>
                                    <th>Customer</th>
                                    <th>Order Date</th>
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
                                    <td>${order.getShip()}</td>
                                    <td>${order.getPaymentMethod()}</td>

                                    <td><button type="submit" value="${order.getOrderID()}" name="accept">Accept</button></td>
                                    <td><button type="submit" value="${order.getOrderID()}" name="deny">Deny</button></td>

                                </tr>
                            </c:forEach>
                        </table>
                            <div>
                        <c:if test="${(requestScope.totalPage!=null)}">
                            <c:forEach var="i" begin="1" end="${requestScope.totalPage}" step="1">
                                <c:if test="${i==requestScope.page}">
                                    <strong>${i}<strong>
                                </c:if>
                                <c:if test="${i!=requestScope.page}">
                                    <a href="billmanager?page=${i}" >${i}</a>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="../view/footer.jsp"></jsp:include>
    </body>
</html>
