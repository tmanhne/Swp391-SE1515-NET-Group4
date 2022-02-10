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


        <hr class="offset-top">

        <div class="white">
            <div class="container checkout">
                <h1>FAQ</h1>
                <hr class="offset-sm">
            </div>
        </div>
        <hr class="offset-md">

        <div class="container faq">
            <div class="row">
                <div class="col-sm-6">
                    <a class="" role="button" data-toggle="collapse" href="#question1" aria-expanded="true" aria-controls="question1">
                        <h1 class="h3">How much should I bid?</h1>
                    </a>

                    <div class="collapse" id="question1">
                        <div class="well">
                            <p>
                                Unistore is great for finding deals, as long as you know what you're looking for and how much the item is worth. Having that information is vital to placing bids in correct amount and saving lots of money.
                            </p>
                        </div>
                    </div>
                    <br>
                    <!-- //// -->

                    <a class="" role="button" data-toggle="collapse" href="#question3" aria-expanded="false" aria-controls="question3">
                        <h1 class="h3">What's the best way to find my favorite items?</h1>
                    </a>

                    <div class="collapse" id="question3">
                        <div class="well">
                            <p>
                                If you're sick of trying to remember your searches for all the different types of spellings, all the different sellers you like, and all the different things you collect, Unistore provides you with an easy way to remember - My Unistore.
                            </p>
                        </div>
                    </div>
                    <br>
                    <!-- //// -->

                    <a class="" role="button" data-toggle="collapse" href="#question5" aria-expanded="false" aria-controls="question5">
                        <h1 class="h3">What should I use to pay?</h1>
                    </a>

                    <div class="collapse" id="question5">
                        <div class="well">
                            <p>
                                Although we've heard of issues with PayPal, we still recommend them for nearly all purchases. Nearly all sellers accept PayPal payment, and many purchases are automatically covered for fraud protection. Please check PayPal.com for details on their account protection tips and fraud protection services.
                            </p>
                        </div>
                    </div>
                    <br>
                    <!-- //// -->
                </div>
                <div class="col-sm-6">
                    <a class="" role="button" data-toggle="collapse" href="#question2" aria-expanded="true" aria-controls="question2">
                        <h1 class="h3">What's the best way to search?</h1>
                    </a>

                    <div class="collapse" id="question2">
                        <div class="well">
                            <p>
                                Unistore search engine is pretty good but can be a bit overwhelming if you're not sure what you're looking for, or if you're just browsing. Unistore is constantly working at upgrading its search engine to make things easier to find (it's in their best interest to have as many buyers for items as possible).
                            </p>
                        </div>
                    </div>
                    <br>
                    <!-- //// -->

                    <a class="" role="button" data-toggle="collapse" href="#question4" aria-expanded="false" aria-controls="question4">
                        <h1 class="h3">What's a good shipping rate/method?</h1>
                    </a>

                    <div class="collapse" id="question4">
                        <div class="well">
                            <p>
                                If possible, check with the seller to ask how they'll pack the item. I once received a used laptop that was literally scotch-taped into a used, ripped, USPS priority box that was too small so part of the computer was sticking out - with no padding what-so-ever. If you're getting breakable items, make sure the seller will pack it correctly.
                            </p>
                        </div>
                    </div>
                    <br>
                    <!-- //// -->

                    <a class="" role="button" data-toggle="collapse" href="#question6" aria-expanded="false" aria-controls="question6">
                        <h1 class="h3">What should I do if the item is defective/broken/wrong?</h1>
                    </a>

                    <div class="collapse" id="question6">
                        <div class="well">
                            <p>
                                The first thing to do is to double check the item - make sure it actually is broken. You'll probably need to go over the item description on eBay to verify that it didn't arrive as promised. Next, contact the seller directly and describe the issue with the item.
                            </p>
                        </div>
                    </div>
                    <br>
                    <!-- //// -->
                </div>
            </div>
        </div>
        <hr class="offset-lg">
        <hr class="offset-lg">


        <div class="features white">
            <div class="container">
                <div class="row">
                    <hr class="offset-lg hidden-xs">
                    <hr class="offset-lg">

                    <div class="col-xs-12 col-sm-4 col-sm-offset-2 col-md-3 col-md-offset-3">
                        <div class="item">
                            <i class="ion-ios-chatboxes-outline"></i>
                            <h1>8000 555-44-65 <br> <span>whatsuping now</span></h1>
                            <hr class="offset-md visible-xs">
                        </div>
                    </div>

                    <div class="col-xs-12 col-sm-4 col-md-3">
                        <div class="item">
                            <i class="ion-ios-filing-outline"></i>
                            <h1>sup@example.com <br> <span>send your question</span></h1>
                        </div>
                    </div>

                    <hr class="offset-lg">
                    <hr class="offset-lg hidden-xs">
                </div>
            </div>
        </div>
        <hr class="offset-lg hidden-xs">
        <hr class="offset-lg">

        <div class="container align-center">
            <h1 class="upp"> Need our help? </h1>
            <p> Please insert question to a form below. </p>
            <hr class="offset-md">

            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4">
                    <form class="contact" action="index.php" method="post">
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

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="./assets/js/jquery-latest.min.js"></script>

        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="./assets/js/bootstrap.min.js"></script>
        <script src="./assets/js/core.js"></script>
        <script src="./assets/js/store.js"></script>
        <script src="./assets/js/checkout.js"></script>

        <script type="text/javascript" src="./assets/js/custom-scroll/jquery.mCustomScrollbar.concat.min.js"></script>

        <script type="text/javascript" src="./assets/js/jquery-ui-1.11.4.js"></script>
        <script type="text/javascript" src="./assets/js/jquery.ui.touch-punch.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                setTimeout(function () {
                    $('.container.faq').find('.col-sm-6 > a:nth-child(1)').trigger('click');
                }, 500);
            });
        </script>
    </body>
</html>