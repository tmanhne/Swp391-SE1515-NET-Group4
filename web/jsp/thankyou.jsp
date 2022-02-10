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

        <!--Nav bar-->
        <%@include file="/components/navbar.jsp"%>

        <!--About first-->
        <div class="white">
            <hr class="offset-lg">
            <hr class="offset-lg">
            <hr class="offset-lg">
            <hr class="offset-lg hidden-xs hidden-sm">
            <hr class="offset-lg hidden-xs hidden-sm">
            <hr class="offset-lg hidden-xs hidden-sm">

            <div class="container about">
                <div class="row">
                    <div class="col-sm-6 hidden-sm hidden-md hidden-lg">
                        <img src="./assets/img/about/anytime-mobility.png" alt="Anywhere, anytime mobility" title="Anywhere, anytime mobility"/>
                    </div>
                    <div class="col-sm-6">
                        <hr class="offset-lg hidden-xs hidden-sm">
                        <hr class="offset-lg hidden-xs hidden-sm">
                        <h1 class="featurette-heading">Thank You For Your Order</h1>
                        <hr class="offset-md">

                        <h3>
                            Your Order Is Confirmed!
                        </h3>

                        <a class="btn btn-primary" href="home" role="button">Back To Home Page</a>
                    </div>
                    <div class="col-sm-6 hidden-xs">
                        <hr class="offset-lg visible-sm">
                        <hr class="offset-lg visible-sm">
                        <img src="./assets/img/about/anytime-mobility.png" alt="Anywhere, anytime mobility" title="Anywhere, anytime mobility"/>
                    </div>
                </div>
            </div>

            <hr class="offset-lg">
            <hr class="offset-lg">
            <hr class="offset-lg">
            <hr class="offset-lg hidden-xs">
            <hr class="offset-lg hidden-xs">
            <hr class="offset-lg hidden-xs">
        </div>

        <!--Footer-->
        <%@include file="/components/footer.jsp"%>

        <!--Script-->
        <script src="./assets/js/jquery-latest.min.js"></script>

        <script type="text/javascript" src="./assets/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="./assets/js/core.js"></script>
        <script type="text/javascript" src="./assets/js/store.js"></script>
        <script type="text/javascript" src="./assets/js/carousel.js"></script>
        <script type="text/javascript" src="./assets/js/jquery.touchSwipe.min.js"></script>

        <script type="text/javascript" src="./assets/js/custom-scroll/jquery.mCustomScrollbar.concat.min.js"></script>


        <script type="text/javascript" src="./assets/js/jquery-ui-1.11.4.js"></script>
        <script type="text/javascript" src="./assets/js/jquery.ui.touch-punch.js"></script>
    </body>
</html>
