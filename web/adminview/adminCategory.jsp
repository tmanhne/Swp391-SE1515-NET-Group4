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
                        <p>The List of Category</p>
                    </div>
                    <div class="table-listProduct">
                        <table>
                            <tr>             
                                <th>Category ID</th>
                                <th>Category</th>
                                <th>Add</th>
                            </tr>

                        <c:forEach var="cate" items="${requestScope.list}">
                            <tr>
                                <td style="padding: 10px;">${cate.getCategoryID()}</td>
                                <td>${cate.getCategoryName()}</td>
                                <td><a href="adminEditCategory?cId=${cate.getCategoryID()}">Edit</a></td>
                                
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="contain-add">
                    <a class="add-Cate" href="AdminAddCategory">Add</a>  
                </div>
            </div>
        </div>
        <jsp:include page="../view/footerAdmin.jsp"></jsp:include>
    </body>
</html>
