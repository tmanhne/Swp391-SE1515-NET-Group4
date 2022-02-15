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
        <a href="adminProduct">
            <button class="btn btn-primary btn-sm rounded"> Back </button>
        </a>
        <br/>
        <div style="margin: 20px 20px;">
            <form action="adminEditProduct" method="post">
                <div class="form-group">
                    <label>ID</label>
                    <input type="text" class="form-control" name="id" value="${product.id}" readonly>
                </div>
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" class="form-control" name="name" value="${product.name}" required>
                </div>
                <div class="form-group">
                    <label>Price</label>
                    <input type="number" class="form-control" name="price" value="${product.price}" required>
                </div>
                <div class="form-group">
                    <label>Description</label>
                    <input type="text" class="form-control" name="description" value="${product.description}" required>
                </div>
                <div class="form-group">
                    <label>Quantity Stock</label>
                    <input type="number" class="form-control" name="quantity_stock" value="${product.quantity_stock}" required>
                </div>
                <div class="form-group">
                    <label>Operating System</label>
                    <input type="text" class="form-control" name="operating_system" value="${product.operating_system}" required>
                </div>
                <div class="form-group">
                    <label>Display Resolution</label>
                    <input type="text" class="form-control" name="display_resolution" value="${product.display_resolution}" required>
                </div>
                <div class="form-group">
                    <label>Processor</label>
                    <input type="text" class="form-control" name="processor" value="${product.processor}" required>
                </div>
                <div class="form-group">
                    <label>Processor Technology</label>
                    <input type="text" class="form-control" name="processor_technology" value="${product.processor_technology}" required>
                </div>
                <div class="form-group">
                    <label>Graphics</label>
                    <input type="text" class="form-control" name="graphics" value="${product.graphics}" required>
                </div>
                <div class="form-group">
                    <label>Memory</label>
                    <input type="text" class="form-control" name="memory" value="${product.memory}" required>
                </div>
                <div class="form-group">
                    <label>Hard Drive</label>
                    <input type="text" class="form-control" name="hard_drive" value="${product.hard_drive}" required>
                </div>
                <div class="form-group">
                    <label>Wireless</label>
                    <input type="text" class="form-control" name="wireless" value="${product.wireless}" required>
                </div>
                <div class="form-group">
                    <label>Power Supply</label>
                    <input type="text" class="form-control" name="power_supply" value="${product.power_supply}" required>
                </div>
                <div class="form-group">
                    <label>Battery</label>
                    <input type="text" class="form-control" name="battery" value="${product.power_supply}" required>
                </div>
                <div class="form-group">
                    <label>Category</label>
                    <select class="form-control" name="cateid">
                        <c:forEach var="o" items="${requestScope.categories}">
                            <option value="${o.cid}" ${o.cid == product.category.cid ? "selected" : ""}>${o.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <br/>
                <hr/>
                <input class="btn btn-primary center-block" type="submit" value="Save"/>
            </form>
        </div>
    </body>
</html>

