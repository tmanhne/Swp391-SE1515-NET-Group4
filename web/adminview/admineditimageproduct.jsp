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
        <form action="addRemoveImage" method="post">
            <div style="margin: 20px 20px;">
                <div class="form-group">
                    <label>New Image</label>
                    <input type="text" class="form-control" name="image" value="" required>
                    <input type="hidden" name="pid" value="${product.id}"/>
                    <input type="submit" value="Add"/>
                </div>
            </div>
        </form>
        <br/>
        <br/>
        <c:forEach var="o" items="${requestScope.images}">
            <div class="form-group">
                <input type="text" class="form-control" name="image" value="${o.image}" readonly>
                <img src="${o.image}" style="width: 300px; height: 300px;"/>
                <a href="addRemoveImage?imgid=${o.pi_id}">
                    <button class="btn btn-primary btn-sm rounded"> Remove </button>
                </a>
            </div>
        </c:forEach>
    </body>
</html>
