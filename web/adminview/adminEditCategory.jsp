<%-- 
    Document   : adminCategory
    Created on : Feb 21, 2022, 3:14:17 PM
    Author     : t.manh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./public/style/landingAdmin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="../view/headerAdmin.jsp"></jsp:include>
            <div id="admin-main-content">
            <jsp:include page="../view/leftMenuAdmin.jsp"></jsp:include>
                <div class="admin-manager-detail">
                    <div class="header-main">
                        <p>Edit Category</p>
                    </div>
                    <div class="mess">                          
                        <p>
                        ${requestScope.mess}
                    </p>  </div>
                <form action="adminEditCategory" method="post">
                    <div class="table-listProduct">
                        <div class="divTable">
                            <div class="divTableBody">
                                <div class="divTableRow">
                                    <div class="divTableCell">CategoryId</div>
                                    <div class="divTableCell">
                                        <input type="text" class="form-control" name="categoryID" value="${requestScope.cate.getCategoryID()}" readonly>
                                    </div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">CatogoryName</div>
                                    <div class="divTableCell">
                                        <input type="text" name="categoryName" value="${requestScope.cate.getCategoryName()}" > 

                                        <p style="color: red;">${requestScope.cateName}</p>
                                    </div>
                                </div>                                            
                            </div>
                        </div>
                    </div>
                    <div class="submit_edit">
                        <button type="submit" value="Submit" name="submit">Submit</button> 
                        <div class="backPage">
                            <a href="AdminViewCategory">Back</a>
                        </div>
                    </div>  
                </form>

            </div>
        </div>
        <jsp:include page="../view/footer.jsp"></jsp:include>
    </body>
</html>
