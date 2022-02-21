<%-- 
    Document   : Cart
    Created on : Jun 25, 2021, 10:08:00 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <body>
        <form action="cart" method="POST">
            <table border="0">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th></th>
                        <th>Name</th>
                        <th>Unit price</th>
                        <th>Quantity</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${requestScope.books != null}">
                        <c:forEach var="book" items="${requestScope.books}">
                            <tr>
                                <td>${book.getProductID()}</td>
                                <td><img src="${book.getPathImage()}"/></td>
                                <td><a href="#">${book.getProductName()}</a></td>
                                <td>${book.getUnitPrice()}</td>
                                <td>
                                    <button type="submit" value="${book.getProductID()}" name="increase">+</button>
                                    ${book.getQuantity()}
                                    <button type="submit" value="${book.getProductID()}" name="decrease" >-</button>
                                </td>
                                <td><button type="submit" value="${book.getProductID()}" name="delete" >Xóa</button></td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </tbody>
            </table>
        </form>

        <div>Thành tiền</div>
        <form name="buy" action="cart" method="POST">
            <ul>
                <li><strong>Tổng tiền hàng</strong><strong>${totalAmount}</strong></li>
                <li><strong>Phí vận chuyển</strong><strong>${ship}</strong></li>
                <li><strong>Tổng thanh toán</strong>
                    <h5>${totalPayment}</h5>
                </li>

            </ul><input type="submit" value="Mua Hàng" />
            ${mess}
        </form>


    </body>
</html>
