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
        <c:if test="${sessionScope.account.is_admin eq true}">
            <%@include file="/components/adminnavbar.jsp"%>
        </c:if>

        <c:if test="${sessionScope.account.is_admin != true}">
            <%@include file="/components/navbar.jsp"%>
        </c:if>
        <hr class="offset-top">

        <div class="white">
            <div class="container checkout">
                <h1>Profile</h1>
                <hr class="offset-sm">
            </div>
        </div>
        <hr class="offset-md">

        <div class="container checkout">


            <div class="row">
                <form action="changePassword" method="post">

                    <div class="col-md-7 ml-6">
                        <div class="row group">
                            <div class="col-sm-4"><h2 class="h4">Email</h2></div>
                            <div class="col-sm-8"> <input type="text" class="form-control" name="email" value="${sessionScope.account.email}" required="" placeholder="" readonly/></div>
                        </div>

                        <div class="row group">
                            <div class="col-sm-4"><h2 class="h4">Password</h2></div>
                            <div class="col-sm-8"> <input type="password" class="form-control" name="password" value="******" required="" placeholder="" readonly/></div>
                            <input type="hidden" class="form-control" name="password" value${sessionScope.account.password}/>
                        </div>

                        <div class="row group">
                            <div class="col-sm-2 ml-10"> <input type="submit" class="form-control" value="Edit"/></div>
                        </div>
                </form>

                <form action="editProfile" method="post">
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
                        <div class="col-sm-8"> <input type="text" class="form-control" name="address" value="${sessionScope.account.address}" required="" placeholder="" readonly/></div>
                    </div>

                    <div class="row group">
                        <div class="col-sm-2 ml-10"> <input type="submit" class="form-control" value="Edit"/></div>
                    </div>
                </form>

                <div class="row group">
                </div>

                <hr class="offset-lg visible-xs visible-sm">
                <hr class="offset-lg visible-xs">
            </div>

        </div>
    </div>

    <hr class="offset-lg">
    <hr class="offset-sm">

    <!--Footer-->
    <%@include file="/components/footer.jsp"%>

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