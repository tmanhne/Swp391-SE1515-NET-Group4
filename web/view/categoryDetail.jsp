<%-- 
    Document   : categoryDetail
    Created on : Mar 8, 2022, 1:11:16 AM
    Author     : phamthithi
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./public/style/LandingPage.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <header>
        <style>

        </style>
    </header>

    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="container-fluid text-center">    
                <div class="row content">
                    <div class="col-sm-2 sidenav">
                        <ul class="list-group">
                        <c:forEach var="cate" items="${requestScope.list}">

                            <li>
                                <a href="categoryForCustomer?cId=${cate.getCategoryID()}">${cate.getCategoryName()}</a>
                            </li>



                        </c:forEach>


                    </ul>

                </div>
                <div class="col-sm-8 text-left"> 
                    <div class="divTable">
                        <div class="divTableBody">
                            <div class="divTableRow">
                                <div class="divTableCell">CategoryId</div>
                                <div class="divTableCell">
                                    <input type="text" name="categoryID" value="${requestScope.cate.getCategoryID()}" readonly>
                                </div>
                            </div>
                            <div class="divTableRow">
                                <div class="divTableCell">CatogoryName</div>
                                <div class="divTableCell">
                                    <input type="text" name="categoryName" value="${requestScope.cate.getCategoryName()}" > 


                                </div>
                            </div>                                            
                        </div>
                    </div>
                    <a href="home">Back</a>
                </div>

                <div class="col-sm-2 sidenav">


                </div>
            </div>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
