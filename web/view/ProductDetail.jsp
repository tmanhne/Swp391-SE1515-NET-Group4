<%-- 
    Document   : ProductDetai
    Created on : Jul 6, 2021, 3:08:55 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="./public/style/productCommet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>


            <!-- Navbar -->

            <!--Main layout-->
            <main class="mt-5 pt-4">
                <div class="container dark-grey-text mt-5">

                    <!--Grid row-->
                    <div class="row wow fadeIn">

                        <!--Grid column-->
                        <div class="col-md-6 mb-4">

                            <img src="${book.getImagePath()}" class="img-fluid" alt="">

                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-md-6 mb-4">

                        <!--Content-->
                        <div class="p-4">


                            <p class="lead font-weight-bold">${book.getProductName()}</p>
                            <c:forEach items="${book.getAuthors()}" var="author" varStatus="loop">
                                <span class="author">${author}</span>
                            </c:forEach>
                            <p class="lead">
                                <span>${book.getUnitPrice()}₫</span>
                            </p>

                            <p>${book.getDescription()}</p>
                            <p>
                            <form method="POST" action="AddToCart">
                                <c:if test="${book.isIsContinue()}">
                                    <input type="hidden" name="id" value="${book.getProductID()}" />
                                    <a>
                                        <button class="btn btn-primary btn-md my-0 p" type="submit">Buy Now</button>
                                    </a>
                                </form>
                                <br>
                                <!-- Default input -->
                                <a href="/Swp391-SE1515-NET-Group4/home">
                                    <button class="btn btn-primary btn-md my-0 p" type="submit">Back</button>
                                </a>
                            </c:if>
                            <c:if test="${not book.isIsContinue()}">
                                <p class="lead font-weight-bold">Product is discontinued</p>
                            </c:if>


                            </p>


                        </div>
                        <!--Content-->

                    </div>
                    <!--Grid column-->

                </div>
                <!--Grid row-->

                <hr>

                <!--Grid row-->
                <div class="row d-flex justify-content-center wow fadeIn">

                    <!--Grid column-->
                    <div class="col-md-6 text-center">

                        <h4 class="my-4 h4">Additional information</h4>



                    </div>
                    <!--Grid column-->

                </div>
                <!--Grid row-->

                <!--Grid row-->
                <div class="row wow fadeIn">

                    <!--Grid column-->
                    <div class="col-lg-4 col-md-12 mb-4">

                        <img src="${book.getImagePath()}" class="img-fluid" alt="">


                    </div>

                    <!--Grid column-->

                </div>
                <!--Grid row-->
                
               <!--Link tham khao-->
                <!--https://www.bootdey.com/snippets/view/Blog-Comments-With-Form#html--> 
                <!--Grid row-->
                <div class="row wow fadeIn">
                        
                    <!--Grid column-->
                    <div class="col-lg-4 col-md-12 mb-4">

                        <div class="container">
                            <div class="be-comment-block">
                                <h1 class="comments-title">Comments (${requestScope.feedBacks.size()})</h1>
                                <!--comment-->
                                <c:forEach var="feedBack" items="${requestScope.feedBacks}">
                                    <div class="be-comment">
                                        <div class="be-img-comment">	
                                            <a href="blog-detail-2.html">
                                                <img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="" class="be-ava-comment">
                                            </a>
                                        </div>
                                        <div class="be-comment-content">

                                            <span class="be-comment-name">
                                                <a href="blog-detail-2.html">${feedBack.customerName}</a>
                                            </span>
                                            <span class="be-comment-time">
                                                <i class="fa fa-clock-o"></i>
                                                ${feedBack.feedbackDate}
                                            </span>
                                            <p class="be-comment-text">
                                               ${feedBack.description}
                                            </p>
                                        </div>
                                    </div>
                                </c:forEach>
                                
                                <form action="viewDetail" method="post" class="form-block">
                                    <div class="row">
                                        <div class="col-xs-12 col-sm-6 fl_icon">
                                                <div class="rate">
                                            <input type="radio" id="star5" name="rate" value="5" />
                                            <label for="star5" title="text">5 stars</label>
                                            <input type="radio" id="star4" name="rate" value="4" />
                                            <label for="star4" title="text">4 stars</label>
                                            <input type="radio" id="star3" name="rate" value="3" />
                                            <label for="star3" title="text">3 stars</label>
                                            <input type="radio" id="star2" name="rate" value="2" />
                                            <label for="star2" title="text">2 stars</label>
                                            <input type="radio" id="star1" name="rate" value="1" />
                                            <label for="star1" title="text">1 star</label>
                                          </div>
                                        </div>
                                        <div class="col-xs-12">									
                                            <div class="form-group">
                                                <textarea class="form-input" required="" placeholder="Add you comment here" name="text-comment"></textarea>
                                            </div>
                                        </div>
                                        <input class="btn btn-primary pull-right" type="submit" value="Submit" name="btn-submit-comment" />
                                    </div>
                                </form>
                            </div>
                        </div> 


                    </div>

                    <!--Grid column-->

                </div>
                <!--Grid row-->

            </div>
        </main>
        <!--Main layout-->

        <!--Footer-->
        <footer class="page-footer text-center font-small mt-4 wow fadeIn">

            <!--Call to action-->
            <div class="pt-4">
                <a class="btn btn-outline-white" href="https://mdbootstrap.com/docs/jquery/getting-started/download/" target="_blank"
                   role="button">Download MDB
                    <i class="fas fa-download ml-2"></i>
                </a>
                <a class="btn btn-outline-white" href="https://mdbootstrap.com/education/bootstrap/" target="_blank" role="button">Start
                    free tutorial
                    <i class="fas fa-graduation-cap ml-2"></i>
                </a>
            </div>
            <!--/.Call to action-->

            <hr class="my-4">

            <!-- Social icons -->
            <div class="pb-4">
                <a href="https://www.facebook.com/mdbootstrap" target="_blank">
                    <i class="fab fa-facebook-f mr-3"></i>
                </a>

                <a href="https://twitter.com/MDBootstrap" target="_blank">
                    <i class="fab fa-twitter mr-3"></i>
                </a>

                <a href="https://www.youtube.com/watch?v=7MUISDJ5ZZ4" target="_blank">
                    <i class="fab fa-youtube mr-3"></i>
                </a>

                <a href="https://plus.google.com/u/0/b/107863090883699620484" target="_blank">
                    <i class="fab fa-google-plus-g mr-3"></i>
                </a>

                <a href="https://dribbble.com/mdbootstrap" target="_blank">
                    <i class="fab fa-dribbble mr-3"></i>
                </a>

                <a href="https://pinterest.com/mdbootstrap" target="_blank">
                    <i class="fab fa-pinterest mr-3"></i>
                </a>

                <a href="https://github.com/mdbootstrap/bootstrap-material-design" target="_blank">
                    <i class="fab fa-github mr-3"></i>
                </a>

                <a href="http://codepen.io/mdbootstrap/" target="_blank">
                    <i class="fab fa-codepen mr-3"></i>
                </a>
            </div>
            <!-- Social icons -->

            <!--Copyright-->
            <div class="footer-copyright py-3">
                © 2018 Copyright:
                <a href="https://mdbootstrap.com/education/bootstrap/" target="_blank"> MDBootstrap.com </a>
            </div>
            <!--/.Copyright-->

        </footer>
        <!--/.Footer-->
    </body>
</html>
