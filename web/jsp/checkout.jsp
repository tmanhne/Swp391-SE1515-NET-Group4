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

        <!--Very top-->
        <%@include file="/components/very-top.jsp"%>

        <%@include file="/components/navbar.jsp"%>

        <hr class="offset-top">

        <div class="white">
            <div class="container checkout">
                <h1>Checkout order</h1>
                <hr class="offset-sm">
            </div>
        </div>
        <hr class="offset-md">

        <div class="container checkout">
            <form action="confirmOrder" method="post">

                <div class="row">
                    <div class="col-md-7">
                        <div class="row group">
                            <div class="col-sm-4"><h2 class="h4">Name</h2></div>
                            <div class="col-sm-8"> <input type="text" class="form-control" name="name" value="${sessionScope.account.name}" required="" placeholder="" readonly/></div>
                        </div>

                        <div class="row group">
                            <div class="col-sm-4"><h2 class="h4">Phone</h2></div>
                            <div class="col-sm-8"> <input type="text" class="form-control" name="phone" value="${sessionScope.account.phone}" required="" placeholder="" readonly/></div>
                        </div>

                        <div class="row group">
                            <div class="col-sm-4"><h2 class="h4">Address</h2></div>
                            <div class="col-sm-8"> <input type="email" class="form-control" name="address" value="${sessionScope.account.address}" required="" placeholder="" readonly/></div>
                        </div>

                        <hr class="offset-lg visible-xs visible-sm">
                        <hr class="offset-lg visible-xs">
                    </div>

                    <div class="col-md-5 white">
                        <hr class="offset-md visible-xs visible-sm">
                        <div class="checkout-cart">
                            <div class="content">

                                <c:forEach var="o" items="${sessionScope.cart.items}">

                                    <div class="media">
                                        <div class="media-left">
                                            <a href="detailProduct?pid=${o.product.id}">
                                                <img class="media-object" src="${o.product.firstImage.image}"/>
                                            </a>
                                        </div>
                                        <div class="media-body">
                                            <h2 class="h4 media-heading">${o.product.name}</h2>
                                            <p>${o.product.category.name}</p>
                                            <label>$ ${o.price}</label>
                                        </div>
                                        <div class="controls">
                                            <div class="input-group">
                                                <span class="input-group-btn">
                                                    <a href="minus?pid=${o.product.id}">
                                                        <button class="btn btn-default btn-sm" type="button" data-action="minus"><i class="ion-minus-round"></i></button>
                                                    </a>
                                                </span>
                                                <input type="text" class="form-control input-sm" name="quantity" value="${o.quantity}" readonly="">
                                                <span class="input-group-btn">
                                                    <a href="plus?pid=${o.product.id}">
                                                        <button class="btn btn-default btn-sm" type="button" data-action="plus"><i class="ion-plus-round"></i></button>
                                                    </a>
                                                </span>
                                            </div>

                                            <a href="removeProductFromCart?pid=${o.product.id}"> <i class="ion-trash-b"></i> Remove </a>
                                        </div>
                                    </div>
                                </c:forEach>

                            </div>
                        </div>
                        <hr class="offset-md visible-xs visible-sm">
                    </div>

                    <hr class="offset-lg hidden-xs">

                    <div class="col-sm-12 white">
                        <hr class="offset-md">
                        <div class="row">
                            <div class="col-xs-6 col-md-4">
                                <h3 class="h5 no-margin">Sub total: $ ${total}</h3>
                                <h3 class="h4 no-margin">Total: $ ${total}</h3>
                            </div>
                            <div class="col-md-4 hidden-xs">
                            </div>
                            <div class="col-xs-6 col-md-4">
                                <button class="btn btn-primary pull-right" type="submit">Confirm order</button>
                            </div>
                        </div>
                        <hr class="offset-md">
                    </div>

                </div>
            </form>
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

    </body>
</html>