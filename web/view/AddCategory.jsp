<%-- 
    Document   : AddCategory
    Created on : Feb 10, 2022, 3:36:39 AM
    Author     : phamthithi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category</title>
        <link href="./public/style/landingAdmin.css" rel="stylesheet" type="text/css"/>
     
    </head>
    <body>
        <jsp:include page="headerAdmin.jsp"></jsp:include>


            <div id="admin-main-content">
                <div class="admin-manager">
                    <div class="list-manager">
                        <a href="#">Manager Products</a>
                    </div>
                    <div class="list-manager">
                        <a href="#">Manager Bills</a>
                    </div>
                    <div class="list-manager">
                        <a href="#">Add New Product</a>
                    </div>
                    <div class="list-manager">
                        <a href="category">Category</a>
                    </div>
                </div>
                <div class="admin-manager-detail">
                    <div class="header-main">
                        <p>Category Product</p>
                      
                    </div>
                      <h4><a href="#">Add new category</a></h4>
                    <div class="table-listCategory">
                        <table>
                            <tr>             
                                <th>Category ID</th>
                                <th>Category Name</th>
                                <th>Edit</th>

                            </tr>

                            <c:forEach var="cate" items="${requestScope.list}">
                                <tr>
                                    <td>${cate.getId()}</td>
                                    <td>${cate.getName()}</td>
                                    <td><a href="#">Edit</a></td>
                                </tr>
                            </c:forEach>

                    </table>
                </div>

            </div>
        </div> 

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</body>
</html>
