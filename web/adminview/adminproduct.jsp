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
        <a href="adminHome">
            <button class="btn btn-primary btn-sm rounded"> Back </button>
        </a>
        <a href="adminAddProduct">
            <button class="btn btn-primary btn-sm rounded center-block"> Add New Product </button>
        </a>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Description</th>
                    <th scope="col">Quantity Stock</th>
                    <th scope="col">Operating system</th>
                    <th scope="col">Display Resolution</th>
                    <th scope="col">Processor</th>
                    <th scope="col">Processor Technology</th>
                    <th scope="col">Graphics</th>
                    <th scope="col">Memory</th>
                    <th scope="col">Hard Drive</th>
                    <th scope="col">Wireless</th>
                    <th scope="col">Power Supply</th>
                    <th scope="col">Battery</th>
                    <th scope="col">Category</th>
                    <th scope="col">Image</th>
                    <th scope="col">Edit</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="o" items="${requestScope.products}">
                    <tr>
                        <td>${o.id}</td>
                        <td>${o.name}</td>
                        <td>${o.price}</td>
                        <td>${o.description}</td>
                        <td>${o.quantity_stock}</td>
                        <td>${o.operating_system}</td>
                        <td>${o.display_resolution}</td>
                        <td>${o.processor}</td>
                        <td>${o.processor_technology}</td>
                        <td>${o.graphics}</td>
                        <td>${o.memory}</td>
                        <td>${o.hard_drive}</td>
                        <td>${o.wireless}</td>
                        <td>${o.power_supply}</td>
                        <td>${o.battery}</td>
                        <td>${o.category.name}</td>
                        <td><img src="${o.firstImage.image}" style="width: 300px; height: 300px;"></td>

                        <td>            
                            <a href="adminEditProduct?pid=${o.id}">
                                <button class="btn btn-primary btn-sm rounded"> Edit Information </button>
                            </a>
                            <br/><br/>
                            <a href="adminEditImage?pid=${o.id}">
                                <button class="btn btn-primary btn-sm rounded"> Edit Image </button>
                            </a>
                            <br/><br/>
                            <a href="removeProduct?pid=${o.id}">
                                <button class="btn btn-danger btn-sm rounded"> Remove </button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
