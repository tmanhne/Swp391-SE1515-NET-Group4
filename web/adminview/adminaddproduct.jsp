<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title> Unistore Pro &middot; Premium Store</title>
        <link href="./public/style/landingAdmin.css" rel="stylesheet" type="text/css"/>
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
        <jsp:include page="../view/headerAdmin.jsp"></jsp:include>
            <div id="admin-main-content">
            <jsp:include page="../view/leftMenuAdmin.jsp"></jsp:include>
                <div class="admin-manager-detail">
                    <div class="header-main">
                        <p>Add Product</p>
                    </div>             
                    <div style="margin: 20px 20px;">
                        <form action="adminAddProduct" method="post">
                            <div class="form-group">
                                <label>Product ID </label>
                                <input type="text" class="form-control" name="id" value="" required>
                            </div>
                            <div class="form-group">
                                <label>Name</label>
                                <input type="text" class="form-control" name="name" value="" required>
                            </div>
                            <div class="form-group">
                                <label>Description</label>
                                <input type="text" class="form-control" name="description" value="" required>
                            </div>
                            <div class="form-group">
                                <label>Quantity Stock</label>
                                <input type="number" class="form-control" name="unitPrice" value="" required>
                            </div>
                            <div class="form-group">
                                <label>Operating System</label>
                                <input type="number" class="form-control" name="unitInStock" value="" required>
                            </div>
                            <div class="form-group">
                                <label>Category</label>
                                <select class="form-control" name="isContinue">
                                    <option value = "1" >Yes</option>
                                    <option value = "0" >No</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Category</label>
                                <select class="form-control" name="categoryID">
                                <c:forEach var="o" items="${requestScope.categories}">
                                    <option value="${o.categoryID}">${o.categoryName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Image Path</label>
                            <!--<input type="text" name="description" />-->
                            <input type="text" class="form-control" name="image" value="" required>
                        </div>     
                        <div class="form-btn">
                            <input class="btn btn-primary center-block" type="submit" value="Add"/>
                            <div class="backPage">
                                <a href="homeadmin">Back</a>
                            </div>   
                        </div>
                    </form>
                </div>
            </div>
        </div> 
    </body>
</html>

