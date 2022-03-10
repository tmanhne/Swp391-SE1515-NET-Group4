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
                        <form action="adminAddProduct" method="post" enctype="multipart/form-data" >
                            <div class="form-group">
                                <label>Product ID </label>
                                <input type="text" class="form-control" name="id" value="${requestScope.book.getProductID()}" required>
                        </div>
                        <div class="form-group">
                            <label>Name</label>
                            <input type="text" class="form-control" name="name" value="${requestScope.book.getProductName()}" required>
                        </div>
                        <div class="form-group">
                            <label>Description</label>
                            <input type="text" class="form-control" name="description" value="${requestScope.book.getDescription()}" required>
                        </div>
                        <div class="form-group">
                            <label>Unit Price</label>
                            <input type="number" class="form-control" name="unitPrice" value="${requestScope.unitPrice}" required>
                        </div>
                        <div class="form-group">
                            <label>Unit In Stock</label>
                            <input type="number" class="form-control" name="unitInStock" value="${requestScope.UnitInStock}" required>
                        </div>
                        <div class="form-group">
                            <label>Is Continue</label>
                            <select class="form-control" name="isContinue">
                                <c:if test="${null!=requestScope.book.isIsContinue()&&!requestScope.book.isIsContinue()}">
                                    <option value = "Yes" selected>Yes</option>
                                    <option value = "No" >No</option>
                                </c:if>
                                <c:if test="${null==requestScope.book.isIsContinue()||!requestScope.book.isIsContinue()}">
                                    <option value = "Yes" selected>Yes</option>
                                    <option value = "No" >No</option>
                                </c:if>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Category</label>
                            <select class="form-control" name="categoryID">
                                <c:forEach var="o" items="${requestScope.categories}">
                                    <c:if test="${requestScope.cateSelected==o.categoryID}">
                                        <option value="${o.categoryID}" selected>${o.categoryName}</option>
                                    </c:if>
                                    <c:if test="${requestScope.cateSelected!=o.categoryID}">
                                        <option value="${o.categoryID}">${o.categoryName}</option>
                                    </c:if>
                                </c:forEach>

                            </select>
                        </div>
                        <div class="form-group">
                            <label>Image Path</label>
                            <!--<input type="text" name="description" />-->
                            <input type="file" class="form-control" name="image" required>
                            <c:if test="${null!=requestScope.book.getImagePath()}">
                                <br><img src="${requestScope.book.getImagePath()}" style="width: 150px;height: 150px;"/>
                            </c:if>
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

