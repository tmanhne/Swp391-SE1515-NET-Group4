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
        <link href="./public/style/cart.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <main>
            <div class="basket">
                <div class="basket-labels">
                    <ul>
                        <li class="item item-heading">Item</li>
                        <li class="price">Price</li>
                        <li class="quantity">Quantity</li>
                        <li class="subtotal">Subtotal</li>
                    </ul>
                </div>

                <form action="cart" method="POST">   
                    <c:if test="${requestScope.books != null}">
                        <c:forEach var="book" items="${requestScope.books}">
                            <div class="basket-product">
                                <div class="item">
                                    <div class="product-image">
                                        <img
                                            src="${book.getPathImage()}"
                                            alt="Placholder Image 2"
                                            class="product-frame"
                                            />
                                    </div>
                                    <div class="product-details">
                                        <h1>
                                            <strong
                                                ><span class="item-quantity">4</span> x ${book.getProductName()}</strong
                                            >
                                            Lace Sleeve Cuff Dress
                                        </h1>
                                        <p><strong>Navy, Size 18</strong></p>
                                        <p>Product Code - ${book.getProductID()}</p>
                                    </div>
                                </div>
                                <div class="price">${book.getUnitPrice()}</div>
                                <div class="quantity">
                                    <input
                                        type="number"
                                        value="1"
                                        min="1"
                                        class="quantity-field"
                                        />
                                </div>
                                
                                <div class="subtotal">${book.getQuantity()}</div>
                                <div class="remove">
                                    <button type="submit" value="${book.getProductID()}">Remove</button>
                                </div>
                            </div>    
                        </c:forEach>
                    </c:if>
                </form>
            </div>

            <form name="buy" action="cart" method="POST">
                <aside>
                    <div class="summary">
                        <div class="summary-total-items">
                            <span class="total-items"></span> Items in your Bag
                        </div>
                        <div class="summary-subtotal">
                            <div class="subtotal-title">Subtotal</div>
                            <div class="subtotal-value final-value" id="basket-subtotal">
                                ${totalAmount}
                            </div>
                        </div>
                        <div class="summary-delivery">
                            <div class="summary-ship">Ship</div>
                            <div class="total-ship" id="basket-total">${ship}</div>
                        </div>
                        <div class="summary-total">
                            <div class="total-title">Total</div>
                            <div class="total-value final-value" id="basket-total">
                                ${totalPayment}
                            </div>
                        </div>
                        <div class="summary-checkout">
                            <button type="submit" class="checkout-cta">Checkout Cart</button>
                            ${mess}
                        </div>
                    </div>
                </aside>  
            </form>
        </main>
        <!--        <form action="cart" method="POST">
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
    </form>-->

    </body>
</html>
