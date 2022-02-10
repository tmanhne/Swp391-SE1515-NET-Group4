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
        <%@include file="/components/navbar.jsp"%>

        <div class="blog-item">
            <hr class="offset-lg visible-xs">
            <hr class="offset-lg visible-xs">

            <img src="./assets/img/blog/item-photo.jpg" alt="Apple 3D Touch" class="hidden-xs" />
            <img src="./assets/img/blog/item-photo-xs.jpg" alt="Apple 3D Touch" class="visible-xs" />

            <div class="white">
                <hr class="offset-md">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2">
                            <h1>${blog.name}</h1>
                            <br>
                            <img src="${blog.image}" style="width: 50rem; height:100%; margin: 0 auto;">
                            <br>
                            <br>
                            <br>
                            <p>
                                ${blog.description}
                            </p>
                            <br>
                            <button class="btn btn-primary btn-sm facebook"> <i class="ion-social-facebook"></i> Share </button>
                            <button class="btn btn-primary btn-sm twitter"> <i class="ion-social-twitter"></i> Retweet</button>
                            <button class="btn btn-primary btn-sm googleplus"> <i class="ion-social-googleplus"></i> Plus </button>
                        </div>
                    </div>
                </div>
                <hr class="offset-lg">
                <hr class="offset-lg">
            </div>
            <hr class="offset-md">

            <div class="container">
                <div class="row">
                    <div class="col-sm-8 col-sm-offset-2">
                        <div class="comments">
                            <h2 class="h3">What do you think? (#2)</h2>
                            <hr class="offset-sm">
                            <button class="btn btn-default" data-toggle="modal" data-target="#Modal-Comment"> <i class="ion-android-textsms"></i> Add comment </button>
                            <hr class="offset-md">


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
                        </div>
                    </div>
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


        <script type="text/javascript">
            $(document).ready(function () {
            });
        </script>

    </body>
</html>