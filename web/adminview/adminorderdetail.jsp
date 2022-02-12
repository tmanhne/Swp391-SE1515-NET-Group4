<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title> Unistore Pro &middot; Premium Store</title>

        <link rel="icon" href="./assets/img/icons/browser-tab-icon.png">

        <!-- Bootstrap -->
        <link href="./assets/css/bootstrap.css" rel="stylesheet">
        <link href="./assets/css/custom.css" rel="stylesheet">
        <link href="./assets/css/carousel.css" rel="stylesheet">
        <link href="./assets/ionicons-2.0.1/css/ionicons.css" rel="stylesheet">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <link href='https://fonts.googleapis.com/css?family=Catamaran:400,100,300' rel='stylesheet' type='text/css'>

        <link href="./assets/css/custom-scroll/jquery.mCustomScrollbar.css" rel="stylesheet">
    </head>
    <body>
        <!--Very top-->
        <%@include file="/components/very-top.jsp"%>

        <%@include file="/components/adminnavbar.jsp"%>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <a href="adminOrder">
            <button class="btn btn-primary btn-sm rounded"> Back </button>
        </a>
        <br/>
        <div style="margin-left: 50px;">
            <h5>Email: ${o.account.email}</h5>
            <h5>Name: ${o.account.name}</h5>
            <h5>Phone: ${o.account.phone}</h5>
            <h5>Address: ${o.account.address}</h5>
            <h5>Date: ${o.date}</h5>
            <h5>Status: ${o.status}</h5>
        </div>
        <br/>
        <table class="table">
            <thead>
                <tr>    
                    <th>ID Product</th>
                    <th>Name Product</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="o" items="${requestScope.o.listOrderDetail}">
                    <tr>    
                        <td>${o.product.id}</td>
                        <td>${o.product.name}</td>
                        <td>${o.quantity}</td>
                        <td>${o.price}</td>
                        <td>${o.total}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <h2 style="text-align: right; margin-right: 50px;" >Total: $ ${total}</h2>
    </body>
</html>
