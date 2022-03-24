<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title> Unistore Pro &middot; Premium Store</title>
        <link href="./public/style/changePass.css" rel="stylesheet" type="text/css"/>
        
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
        <jsp:include page="header.jsp"></jsp:include>
            <div class="white">
                <div class="container checkout">
                    <h1>Change Password</h1>
                    <hr class="offset-sm">
                </div>
            </div>
            <div style="margin: 20px 20px;">
                <form action="changePassword" method="post" enctype="multipart/form-data" >
                    <div class="form-group">
                        <label>Email </label>
                        <input type="text" class="form-control" name="id" value="${requestScope.book.getProductID()}" required>
                </div>
                <div class="form-group">
                    <label>Current password</label>
                    <input type="text" class="form-control" name="name" value="${requestScope.book.getProductName()}" required>
                </div>
                <div class="form-group">
                    <label>New Password</label>
                    <input type="text" class="form-control" name="description" value="${requestScope.book.getDescription()}" required>
                </div>
                <div class="form-group">
                    <label>Re-Enter new Password</label>
                    <input type="number" class="form-control" name="unitPrice" value="${requestScope.unitPrice}" required>
                </div>         
                <div class="form-btn">
                    <input class="btn btn-primary center-block" type="submit" value="Save change"/>
                    <div class="backPage">
                        <a href="home">Back</a>
                    </div>   
                </div>
            </form>
        </div>
        
    </body>
</html>