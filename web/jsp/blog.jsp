<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title> Unistore Pro &middot; Premium Store</title>

        <link rel="icon" href="./assets/img/icons/browser-tab-icon.png">

        <!-- Bootstrap -->
        <link href="./assets/css/bootstrap.css" rel="stylesheet">
        <link href="./assets/css/custom.css" rel="stylesheet">
        <link href="./assets/ionicons-2.0.1/css/ionicons.css" rel="stylesheet">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <link href='https://fonts.googleapis.com/css?family=Catamaran:400,100,300' rel='stylesheet' type='text/css'>

        <link href="./assets/css/custom-scroll/jquery.mCustomScrollbar.css" rel="stylesheet">
    </head>
    <body>
        <!--Cart-->
        <%@include file="/components/cart.jsp"%>

        <!--Very top-->
        <%@include file="/components/very-top.jsp"%>

        <!--Nav bar-->
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="home"> Unistore Pro </a>
                    <a class="navbar-brand pull-right hidden-sm hidden-md hidden-lg" href="#open-cart"> <i class="ion-bag"></i> 7 </a>
                </div>

                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="home">Home</a></li>
                        <li><a href="store?cid=0&sortid=0&page=1">Store</a></li>
                        <li class="active"><a href="blog">Blog</a></li>
                        <li><a href="contacts">Contacts</a></li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                More <i class="ion-android-arrow-dropdown"></i>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="aboutUs">About Us</a></li>
                                <li><a href="checkOut">Checkout</a></li>
                                <li><a href="faq">FAQ</a></li>
                                <li><a href="gallery">Gallery</a></li>
                                <li role="separator" class="divider"></li>
                                <li class="dropdown-header">Variations</li>
                                <li><a href="#">Article Photo</a></li>
                                <li><a href="#">Article Video</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!--/.nav-collapse -->


                <div class="search hidden-xs" data-style="hidden">
                    <div class="input">
                        <button type="button"><i class="ion-ios-search"></i></button>

                        <input type="text" name="search" value="" placeholder="Type here.." />
                    </div>
                </div>
            </div><!--/.container-fluid -->
        </nav>

        <hr class="offset-md">
        <hr class="offset-md">
        <hr class="offset-md">
        <hr class="offset-md">

        <div class="blog">
            <div class="container">
                <div class="row">
                    <c:forEach var="o" items="${requestScope.blogs}">
                        <div class="col-sm-6 col-md-6 item">

                            <div class="body">

                                <a href="viewArticle?aid=${o.id}">
                                    <img src="${o.image}">
                                </a>

                                <div class="caption">
                                    <h1 class="h3">${o.name}</h1>
                                    <label> ${o.date}</label>
                                    <hr class="offset-sm">

                                    <p>
                                        ${o.description}
                                    </p>
                                    <hr class="offset-sm">

                                    <a href="viewArticle?aid=${o.id}"> View article <i class="ion-ios-arrow-right"></i> </a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

            </div>
        </div>

        <hr class="offset-lg">
        <hr class="offset-sm">

        <!--Footer-->
        <%@include file="/components/footer.jsp"%>

        <!-- Modal -->
        <!-- Modal Sign In-->
        <%@include file="/components/modal-signin.jsp"%>

        <!-- Modal-Registration-->
        <%@include file="/components/modal-registration.jsp"%>

        <!-- Modal-Forgot Password-->
        <%@include file="/components/modal-forgotpassword.jsp"%>
        
         <!-- Modal-New Pass-->
        <%@include file="/components/modal-newpass.jsp"%>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="./assets/js/jquery-latest.min.js"></script>

        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="./assets/js/bootstrap.min.js"></script>
        <script src="./assets/js/core.js"></script>
        <script src="./assets/js/store.js"></script>

        <script type="text/javascript" src="./assets/js/custom-scroll/jquery.mCustomScrollbar.concat.min.js"></script>

        <script type="text/javascript" src="./assets/js/jquery-ui-1.11.4.js"></script>
        <script type="text/javascript" src="./assets/js/jquery.ui.touch-punch.js"></script>


    </body>
</html>