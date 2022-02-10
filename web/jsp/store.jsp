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
                        <li><a href="home">Home</a></li>
                        <li class="active"><a href="store?cid=0&sortid=0&page=1">Store</a></li>
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

        <br/>
        <br/>
        <br/>
        <br/>

        <div class="container">
            <div class="row">
                <!-- Filter -->
                <div class="col-sm-4 col-md-3">
                    <hr class="offset-lg">

                    <div class="filter">
                        <form action="store?cid=${cateid}&sortid=${sortid}&page=${page}" method="get">

                            <div class="item">
                                <div class="title">
                                    <h1 class="h4">Sort By</h1>
                                </div>

                                <div class="controls align-center">

                                    <select name="sortid">
                                        <option value="0" ${sortid == 0 ? "selected" : ""}>-----All-----</option>
                                        <option value="1" ${sortid == 1 ? "selected" : ""}>A to Z</option>
                                        <option value="2" ${sortid == 2 ? "selected" : ""}>Z to A</option>
                                        <option value="3" ${sortid == 3 ? "selected" : ""}>Price: Low - High</option>
                                        <option value="4" ${sortid == 4 ? "selected" : ""}>Price: High - Low</option>
                                    </select>

                                </div>
                                <br/>
                            </div>

                            <div class="item">
                                <div class="title">
                                    <h1 class="h4">Type</h1>
                                </div>

                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="cid" value="0" ${cateid == 0 ? "checked" : ""}>
                                    <label class="form-check-label text-success bold ml-1">
                                        All
                                    </label>
                                    <br/>
                                    <input class="form-check-input" type="radio" name="cid" value="1" ${cateid == 1 ? "checked" : ""}>
                                    <label class="form-check-label text-success bold ml-1">
                                        Laptops
                                    </label>
                                    <br/>
                                    <input class="form-check-input" type="radio" name="cid" value="2" ${cateid == 2 ? "checked" : ""}>
                                    <label class="form-check-label text-success bold ml-1">
                                        Tablets
                                    </label>
                                    <br/>
                                    <input class="form-check-input" type="radio" name="cid" value="3" ${cateid == 3 ? "checked" : ""}>
                                    <label class="form-check-label text-success bold ml-1">
                                        Hybrids
                                    </label>
                                    <br/>
                                </div>
                            </div>
                            <br/>
                            <input type="hidden" name="page" value="1"/>
                            <input class="btn btn-primary btn-sm rounded ml-6" type="submit" value="Search"/>
                        </form>
                    </div>
                </div>

                <!-- /// -->

                <!-- Products -->
                <div class="col-sm-8 col-md-9">
                    <hr class="offset-lg">

                    <div class="products">
                        <div class="row">

                            <c:forEach var="o" items="${requestScope.allProducts}">

                                <div class="col-sm-6 col-md-4 product">
                                    <div class="body">
                                        <a href="detailProduct?pid=${o.id}"><img src="${o.firstImage.image}" alt="${o.name}"/></a>
                                        <br/>
                                        <div class="content">
                                            <h1 class="h3">${o.name}</h1>
                                            <p class="price">$ ${o.price}</p>
                                            <label>${o.category.name}</label>
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

                    <nav>
                        <ul class="pagination">
                            <c:if test="${numberPage != 1}">
                                <c:forEach var="page" begin="1" end="${numberPage}">

                                    <c:if test="${pageCurrent == page}">
                                        <li class="page-item active"><a class="page-link">${page}</a></li>
                                        </c:if>

                                    <c:if test="${pageCurrent != page}">
                                        <li class="page-item"><a class="page-link" href="store?cid=${cateid}&sortid=${sortid}&page=${page}">${page}</a></li>
                                        </c:if>

                                </c:forEach>
                            </c:if>
                        </ul>
                    </nav>
                </div>
                <!-- /// -->
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