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
        <link href="./assets/css/carousel-product.css" rel="stylesheet">
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

        <hr class="offset-lg">
        <hr class="offset-lg">
        <hr class="offset-lg hidden-xs">


        <section class="product">
            <div class="container">
                <div class="row">
                    <div class="col-sm-7 col-md-7 white no-padding">
                        <div class="item center" data-marker="1">
                            <img src="${product.firstImage.image}" alt="" class="background" style=""/>
                        </div>

                    </div>
                    <div class="col-sm-5 col-md-5 no-padding-xs">
                        <div class="caption">
                            <img src="./assets/img/brands/microsoft.png" alt="Microsoft" class="brand hidden-xs hidden-sm" />

                            <h1>${product.name}</h1>

                            <p> &middot; ${product.operating_system}</p>
                            <p> &middot; ${product.display_resolution}</p>
                            <p> &middot; ${product.processor}</p>
                            <hr class="offset-md hidden-sm">
                            <hr class="offset-sm visible-sm">
                            <hr class="offset-xs visible-sm">

                            <p class="price">$ ${product.price}</p>
                            <hr class="offset-md">

                            <a href="add2Cart?pid=${product.id}">
                                <button class="btn btn-primary btn-sm rounded"> <i class="ion-bag"></i> Add to cart</button>
                            </a>
                        </div>
                    </div>
                </div>
                <hr class="offset-sm hidden-xs">

                <div class="row">
                    <div class="col-sm-7 white sm-padding">
                        <hr class="offset-sm visible-xs">

                        <h2 class="h1">${product.name}</h2>
                        <br>

                        <p>
                            ${product.description}
                        </p>
                        <br>

                        <h2>Product specifications</h2>
                        <br>

                        <div class="row specification">
                            <div class="col-sm-4"> <label>Operating system</label> </div>
                            <div class="col-sm-8"> <p>${product.operating_system}</p> </div>
                        </div>

                        <div class="row specification">
                            <div class="col-sm-4"> <label>Display</label> </div>
                            <div class="col-sm-8">
                                <p>
                                    ${product.display_resolution}
                                </p>
                            </div>
                        </div>

                        <div class="row specification">
                            <div class="col-sm-4"> <label>Processor</label> </div>
                            <div class="col-sm-8"> <p>${product.processor}</p> </div>
                        </div>

                        <div class="row specification">
                            <div class="col-sm-4"> <label>Processor technology</label> </div>
                            <div class="col-sm-8"> <p>${product.processor_technology}</p> </div>
                        </div>

                        <div class="row specification">
                            <div class="col-sm-4"> <label>Graphics</label> </div>
                            <div class="col-sm-8"> <p>${product.graphics}</p> </div>
                        </div>

                        <div class="row specification">
                            <div class="col-sm-4"> <label>Memory</label> </div>
                            <div class="col-sm-8"> <p>${product.memory}</p> </div>
                        </div>

                        <div class="row specification">
                            <div class="col-sm-4"> <label>Hard drive</label> </div>
                            <div class="col-sm-8"> <p>${product.hard_drive}</p> </div>
                        </div>

                        <div class="row specification">
                            <div class="col-sm-4"> <label>Wireless</label> </div>
                            <div class="col-sm-8">
                                <p>
                                    ${product.wireless}
                                </p>
                            </div>
                        </div>

                        <div class="row specification">
                            <div class="col-sm-4"> <label>Power supply</label> </div>
                            <div class="col-sm-8"> <p>${product.power_supply}</p> </div>
                        </div>

                        <div class="row specification">
                            <div class="col-sm-4"> <label>Battery</label> </div>
                            <div class="col-sm-8"> <p>${product.battery}</p> </div>
                        </div>

                        <hr class="offset-lg">
                    </div>
                    <div class="col-sm-5 no-padding-xs">
                        <div class="talk white">
                            <h2 class="h3">Do you have any questions?</h2>
                            <p class="">Whatsuping now with our manager</p>
                            <hr class="offset-md">

                            <a href="tel:+80005554465" class="btn btn-primary btn-sm"> <i class="ion-social-whatsapp"></i> 8000 555-44-65 </a>
                            <hr class="offset-md visible-xs">
                        </div>
                        <hr class="offset-sm hidden-xs">

                        <div class="comments white">
                            <h2 class="h3">What do you think? (#3)</h2>
                            <br>


                            <div class="wrapper">
                                <div class="content">
                                    <h3>Anne Hathaway</h3>
                                    <label>2 years ago</label>
                                    <p>
                                        Apple Music brings iTunes music streaming to the UK. But is it worth paying for? In our Apple Music review, we examine the service's features, UK pricing, audio quality and music library
                                    </p>


                                    <h3>Chris Hemsworth</h3>
                                    <label>Today</label>
                                    <p>
                                        Samsung's Galaxy S7 smartphone is getting serious hype. Here's what it does better than Apple's iPhone 6s.
                                    </p>


                                    <h3>Anne Hathaway</h3>
                                    <label>2 years ago</label>
                                    <p>
                                        Apple Music brings iTunes music streaming to the UK. But is it worth paying for? In our Apple Music review, we examine the service's features, UK pricing, audio quality and music library
                                    </p>
                                </div>
                            </div>
                            <hr class="offset-lg">
                            <hr class="offset-md">

                            <button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#Modal-Comment"> <i class="ion-chatbox-working"></i> Add comment </button>
                            <hr class="offset-md visible-xs">
                        </div>            
                    </div>
                </div>
            </div>
        </section>
        <hr class="offset-lg">

        <div class="container">
            <h2 class="upp align-center-xs"> Image products </h2>
            <hr class="offset-lg">
            <div class="align-center">
                <c:forEach var="o" items="${product.listImage}">
                    <img src="${o.image}" style="border-radius: 2rem;">
                    <hr class="offset-lg">
                </c:forEach> 
            </div>

        </div>

        <section class="products">
            <div class="container">
                <h2 class="upp align-center-xs"> Related products </h2>
                <hr class="offset-lg">

                <div class="row">

                    <c:forEach var="o" items="${requestScope.top4Products}">

                        <div class="col-sm-4 col-md-3 product">
                            <div class="body">
                                <a href="detailProduct?pid=${o.id}"><img src="${o.firstImage.image}" alt="${o.name}"/></a>

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

                </div>

            </div>
        </section>


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
        <script src="./assets/js/carousel-product.js"></script>
        <script type="text/javascript" src="./assets/js/jquery.touchSwipe.min.js"></script>

        <script type="text/javascript" src="./assets/js/custom-scroll/jquery.mCustomScrollbar.concat.min.js"></script>

        <script type="text/javascript" src="./assets/js/jquery-ui-1.11.4.js"></script>
        <script type="text/javascript" src="./assets/js/jquery.ui.touch-punch.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {
            });
        </script>

    </body>
</html>