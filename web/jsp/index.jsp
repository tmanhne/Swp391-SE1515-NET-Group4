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
        <link href="./assets/css/carousel.css" rel="stylesheet">
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
                        <li class="active"><a href="home">Home</a></li>
                        <li><a href="store?cid=0&sortid=0&page=1">Store</a></li>
                        <li><a href="blog">Blog</a></li>
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

        <!--Carousel-->
        <%@include file="/components/carousel.jsp"%>

        <hr class="offset-lg">
        <hr class="offset-md">

        <!--Desktop product-->
        <section class="products">
            <div class="container">
                <h2 class="h2 upp align-center"> Desktop </h2>
                <hr class="offset-lg">

                <div class="row">

                    <c:forEach var="o" items="${requestScope.top3Laptops}">
                        <div class="col-sm-6 col-md-4 product">
                            <div class="body">
                                <img src="${o.firstImage.image}"/>

                                <div class="content align-center">
                                    <p class="price">$ ${o.price}</p>
                                    <h2 class="h3">${o.name}</h2>
                                    <hr class="offset-sm">

                                    <a href="detailProduct?pid=${o.id}">
                                        <button class="btn btn-link"> <i class="ion-android-open"></i> Details</button>
                                    </a>
                                    <a href="add2Cart?pid=${o.id}">
                                        <button class="btn btn-primary btn-sm rounded"> <i class="ion-bag"></i> Add to cart</button>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                    <div class="align-right align-center-xs">
                        <hr class="offset-sm">
                        <a href="store?cid=1&sortid=0&page=1"> <h5 class="upp">View all desktop </h5> </a>
                    </div>
                </div>
        </section>

        <!--Hybrid product-->
        <section class="products">
            <div class="container">
                <h2 class="h2 upp align-center"> Hybrid devices</h2>
                <hr class="offset-lg">

                <div class="row">

                    <c:forEach var="o" items="${requestScope.top3Hybrids}">
                        <div class="col-sm-6 col-md-4 product">
                            <div class="body">
                                <img src="${o.firstImage.image}"/>

                                <div class="content align-center">
                                    <p class="price">$ ${o.price}</p>
                                    <h2 class="h3">${o.name}</h2>
                                    <hr class="offset-sm">

                                    <button class="btn btn-link"> <i class="ion-android-open"></i> Details</button>
                                    <button class="btn btn-primary btn-sm rounded"> <i class="ion-bag"></i> Add to cart</button>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                    <div class="align-right align-center-xs">
                        <hr class="offset-sm">
                        <a href="store?cid=2&sortid=0&page=1"> <h5 class="upp">View all devices </h5> </a>
                    </div>
                </div>
        </section>

        <!--Tablet product-->
        <section class="products">
            <div class="container">
                <h2 class="h2 upp align-center"> Tablets</h2>
                <hr class="offset-lg">

                <div class="row">

                    <c:forEach var="o" items="${requestScope.top3Tablets}">
                        <div class="col-sm-6 col-md-4 product">
                            <div class="body">
                                <img src="${o.firstImage.image}"/>

                                <div class="content align-center">
                                    <p class="price">$ ${o.price}</p>
                                    <h2 class="h3">${o.name}</h2>
                                    <hr class="offset-sm">

                                    <button class="btn btn-link"> <i class="ion-android-open"></i> Details</button>
                                    <button class="btn btn-primary btn-sm rounded"> <i class="ion-bag"></i> Add to cart</button>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
                <div class="align-right align-center-xs">
                    <hr class="offset-sm">
                    <a href="store?cid=3&sortid=0&page=1"> <h5 class="upp">View all tablets </h5> </a>
                </div>

            </div>
        </section>

        <!--Blog-->
        <section class="blog">
            <div class="container">
                <h2 class="h2 upp align-center"> Blog Headlines </h2>
                <hr class="offset-lg">

                <div class="row">

                    <div class="col-sm-6 col-md-6 item">

                        <div class="body">
                            <a href="#">
                                <img src="./assets/img/blog/img1.jpg" title="Apple Devices" alt="Apple Devices">
                            </a>

                            <div class="caption">
                                <h2 class="h3">The next generation of Multi-Touch</h2>
                                <label> 07.01.2017</label>
                                <hr class="offset-sm">

                                <p>
                                    The original iPhone introduced the world to Multi-Touch, forever changing the way people experience technology. With 3D Touch, you can do things that were never possible before. It senses how deeply you press the display, letting you do all kinds of essential things more quickly and simply. And it gives you real-time feedback in the form of subtle taps from the all-new Taptic Engine.
                                </p>
                                <hr class="offset-sm">

                                <a href="#"> View article </a>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-6 item">

                        <div class="body">
                            <a href="#">
                                <img src="./assets/img/blog/img2.jpg" title="Coffee" alt="Coffee">
                            </a>

                            <div class="caption">
                                <h2 class="h3">MacBook Pro - brand new day for business.</h2>
                                <label> 02.01.2017</label>
                                <hr class="offset-sm">

                                <p>
                                    Organizations everywhere are realizing the potential that Mac brings to their employees by giving them the freedom to use the tools they already know and love. Software and hardware made for each other. Because Apple designs both the software and hardware, every Mac delivers the best possible experience for employees.
                                </p>
                                <hr class="offset-sm">

                                <a href="#"> View article <i class="ion-ios-arrow-right"></i> </a>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="align-right align-center-xs">
                    <hr class="offset-sm">
                    <a href="./blog/"> <h5 class="upp">View all articles </h5> </a>
                </div>
            </div>
        </section>


        <hr class="offset-lg">
        <hr class="offset-sm">

        <!--Footer-->
        <%@include file="/components/footer.jsp"%>

        <!-- Modal Sign In-->
        <%@include file="/components/modal-signin.jsp"%>

        <!-- Modal-Registration-->
        <%@include file="/components/modal-registration.jsp"%>

        <!-- Modal-Forgot Password-->
        <%@include file="/components/modal-forgotpassword.jsp"%>

        <!-- Modal-New Pass-->
        <%@include file="/components/modal-newpass.jsp"%>

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

        <c:if test="${requestScope.checkLogin eq true}">
            <script type="text/javascript" src="./assets/js/login.js"></script>
        </c:if>

        <c:if test="${requestScope.checkRegister eq true}">
            <script type="text/javascript" src="./assets/js/register.js"></script>
        </c:if>

        <c:if test="${requestScope.checkForgotPassword eq true}">
            <script type="text/javascript" src="./assets/js/forgotpassword.js"></script>
        </c:if>

        <c:if test="${requestScope.checkRecovery eq true}">
            <script type="text/javascript" src="./assets/js/newpass.js"></script>
        </c:if>

    </body>
</html>