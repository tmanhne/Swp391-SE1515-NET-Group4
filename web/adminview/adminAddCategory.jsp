<%-- 
    Document   : adminEditProduct
    Created on : Feb 16, 2022, 2:43:29 PM
    Author     : t.manh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Edit Product</title>
        <link href="./public/style/landingAdmin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="../view/headerAdmin.jsp"></jsp:include>


            <div id="admin-main-content">
            <jsp:include page="../view/leftMenuAdmin.jsp"></jsp:include>
                <div class="admin-manager-detail">
                    <div class="header-main">
                        <p>Admin Add Category </p>
                    </div>
                    <div class="mess">                          
                        <p>
                        ${requestScope.mess}
                    </p>  
                </div>
                <form action="AdminAddCategory" method="post">
                    <div class="table-listProduct">
                        <div class="divTable">
                            <div class="divTableBody">
                                <div class="divTableRow">
                                    <div class="divTableCell">Category ID: </div>
                                    <div class="divTableCell">
                                        <input type="text" class="form-control" name="categoryId" value="${requestScope.category.getCategoryID()}">
                                    </div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Category Name: </div>
                                    <div class="divTableCell">
                                        <input type="text" name="categoryName" value="${requestScope.category.getCategoryName()}" > 
                                        <br>
                                        <p style="color: red;">${requestScope.cateName}</p>
                                    </div>
                                </div>                          
                            </div>
                        </div>
                    </div>
                    <div class="submit_edit">
                        <button type="submit" value="Add" name="submit">Submit</button> 
                    </div>  
                </form>

            </div>
        </div> 
    </form
</body>
</html>
