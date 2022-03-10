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
        <jsp:include page="header.jsp"></jsp:include>
        <div class="body-cart">
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
                    <input type="hidden" name="page" value="${requestScope.page}"/>
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
                                            <strong><span class="item-quantity">4</span> x ${book.getProductName()}</strong>
                                        </h1>
                                        <p>Product Code: ${book.getProductID()}</p>
                                    </div>
                                </div>
                                <div class="price">${book.getUnitPrice()}</div>
                                <div class="quantity">
                                    <input type="number" value="${book.getQuantity()}" class="quantity-field"/>
                                </div>

                                <div class="subtotal">
                                    <button type="submit" value="${book.getProductID()}" name="increase">+</button>
                                    ${book.getQuantity()*book.getUnitPrice()}
                                    <button type="submit" value="${book.getProductID()}" name="decrease" >-</button>
                                </div>
                                <div class="remove">
                                    <button type="submit" value="${book.getProductID()}" name="delete" >Remove</button>
                                </div>
                            </div>    
                        </c:forEach>
                    </c:if>
                    <div>
                        <c:if test="${(requestScope.epage!=null)}">
                            <c:forEach var="i" begin="${requestScope.bpage}" end="${requestScope.epage}" step="1">
                                <c:if test="${i==requestScope.page}">
                                    <strong>${i}<strong>
                                </c:if>
                                <c:if test="${i!=requestScope.page}">
                                    <a href="cart?page=${i}" >${i}</a>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </div>
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
                          ${requestScope.totalAmount}
                      </div>
                  </div>
                  <div class="summary-delivery">
                      <div class="summary-ship">Ship</div>
                      <div class="total-ship" id="basket-total">${requestScope.ship}</div>
                  </div>
                  <div class="summary-delivery">
                    <div class="summary-ship">Order Date</div>
                    <div class="date-ship" id="basket-total">12:02</div>
                </div>
                <div class="summary-delivery">
                  <div class="summary-ship">Address</div>
                  <input class="address" id="basket-total"></input>
              </div>
                <div class="summary-delivery">
                  <div class="summary-ship">Payment</div>
                  <div class="payment-method" id="basket-total">Cash</div>
              </div>
                  <div class="summary-total">
                      <div class="total-title">Total</div>
                      <div class="total-value final-value" id="basket-total">
                          ${requestScope.totalAmount+requestScope.ship}
                      </div>
                  </div>
                  <div class="summary-checkout">
                      <button type="submit" class="checkout-cta">Checkout Cart</button>
                      ${requestScope.mess}
                  </div>
              </div>
          </aside> 
            </form>
        </div>
    </body>
</html>
