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
        <%@include file="/components/navbar.jsp"%>

        <!--Carousel-->
        <%@include file="/components/carousel.jsp"%>

        <!--About first-->
        <div class="white">
            <hr class="offset-lg">
            <hr class="offset-lg">
            <hr class="offset-lg">
            <hr class="offset-lg hidden-xs hidden-sm">

            <div class="container about">
                <div class="row">
                    <div class="col-sm-6 hidden-sm hidden-md hidden-lg">
                        <img src="./assets/img/about/anytime-mobility.png" alt="Anywhere, anytime mobility" title="Anywhere, anytime mobility"/>
                    </div>
                    <div class="col-sm-6">
                        <hr class="offset-lg hidden-xs hidden-sm">
                        <hr class="offset-lg hidden-xs hidden-sm">
                        <h2 class="featurette-heading">Anywhere, anytime mobility.</h2>
                        <hr class="offset-md">

                        <p class="lead">
                            School, home, or on the road, the slim design, and latest processors give you everything you need to take on the world.
                            Conveniently store up to 100GB of your files and content with the included 2-years of Google Drive access.
                            With up to 9.5 hours of long lasting battery, search, stream, chat, and more for hours without recharging.
                        </p>
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
            <hr class="offset-lg hidden-xs">
        </div>
        
        <hr class="offset-lg">
        <hr class="offset-lg">

        <!--About second-->
        <div class="">
            <hr class="offset-lg hidden-xs">
            <hr class="offset-lg hidden-xs">
            <div class="container about">
                <div class="row">
                    <div class="col-sm-6">
                        <hr class="offset-lg visible-sm">
                        <img src="./assets/img/about/new-entertainment.png" alt="Anywhere, anytime mobility" title="Anywhere, anytime mobility"/>
                    </div>
                    <div class="col-sm-6">
                        <hr class="offset-lg hidden-xs hidden-sm">
                        <hr class="offset-lg hidden-xs hidden-sm">
                        <h2 class="featurette-heading">Entertainment at your fingertips.</h2>
                        <hr class="offset-md">

                        <p class="lead">
                            Capture all the details with vibrant clarity, even in low light. Enjoy the nuances of face-to-face conversations, 
                            thanks to the HD Webcam. Lay back and get comfortable with your favorite movies and shows. 
                            The HD IPS screens delivers your entertainment in stunning quality, from any angle.
                        </p>
                    </div>
                </div>
            </div>
            <hr class="offset-lg">
            <hr class="offset-lg">
        </div>

        <hr class="offset-lg hidden-xs">
        <hr class="offset-lg hidden-xs">
        <hr class="offset-lg hidden-xs">

        <!--About third-->
        <div class="white">
            <hr class="offset-lg hidden-xs">
            <hr class="offset-lg hidden-xs">
            <hr class="offset-lg">

            <div class="container about">
                <div class="row">
                    <div class="col-sm-6 hidden-sm hidden-md hidden-lg">
                        <img src="./assets/img/about/sleek-and-colorful.png" alt="Sleek and colorful" title="Sleek and colorful"/>
                    </div>
                    <div class="col-sm-6">
                        <hr class="offset-lg hidden-xs hidden-sm">
                        <hr class="offset-lg hidden-xs hidden-sm">
                        <h2 class="featurette-heading">Sleek and powerfull.</h2>
                        <hr class="offset-md">

                        <p class="lead">
                            With the brand new laptops running lightning-fast Windows 10, the best of Microsoft is at hand on a colorfully 
                            sleek and stylish notebook. Express yourself with an HD 29.5 cm (11.6") diagonal screen in a slim package, 
                            styled in smoke silver or sky blue.
                        </p>
                    </div>
                    <div class="col-sm-6 hidden-xs">
                        <hr class="offset-lg visible-sm">
                        <img src="./assets/img/about/sleek-and-colorful.png" alt="Sleek and colorful" title="Sleek and colorful"/>
                    </div>
                </div>
            </div>

            <hr class="offset-lg">
            <hr class="offset-lg hidden-xs">
            <hr class="offset-lg hidden-xs">
        </div>

        <hr class="offset-lg hidden-xs">
        <hr class="offset-lg">

        <!--Contact us-->
        <div class="container align-center">
            <h1 class="upp"> Contact us </h1>
            <p> Please insert question to a form below. </p>
            <hr class="offset-md">

            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4">
                    <form class="contact" action="#" method="post">
                        <textarea class="form-control" name="message" placeholder="Message" required="" rows="5"></textarea>
                        <br>

                        <input type="email" name="email" value="" placeholder="E-mail" required="" class="form-control" />
                        <br>

                        <button type="submit" class="btn btn-primary justify"> Send question</button>
                    </form>
                </div>
            </div>
            <br>
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