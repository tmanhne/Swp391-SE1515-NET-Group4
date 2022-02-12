<%-- 
    Document   : AdminEditProduct
    Created on : Feb 12, 2022, 10:40:04 AM
    Author     : t.manh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Edit Product</title>
        <link href="./public/style/landingAdmin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="headerAdmin.jsp"></jsp:include>
            <form action="AdminEditProduct" method="post">
                <div id="admin-main-content">
                    <div class="admin-manager">
                        <div class="list-manager">
                            <a href="#">Manager Products</a>
                        </div>
                        <div class="list-manager">
                            <a href="#">Manager Bills</a>
                        </div>
                        <div class="list-manager">
                            <a href="AddCategory.jsp">Add New Product</a>
                        </div>
                    </div>
                    <div class="admin-manager-detail">
                        <div class="header-main">
                            <p>The List of Products</p>
                        </div>
                        <div class="table-listProduct">
                            <table>
                                <tr>             
                                    <th>BookID</th>
                                    <th>BookName</th>
                                    <th>Description</th>
                                    <th>Unit Price</th>
                                    <th>UnitInStock</th>
                                    <th>Author</th>
                                    <th>IsContinue</th>
                                    <th>Edit</th>

                                </tr>

                                <tr>
                                <td>
                                        <h5>${book.getProductID()}</h5>
                                </td>
                                <td> 
                                    <input type="text" name="id" value="${book.getProductName()}" readonly>
                                </td>                 
                                <td>
                                    <input type="text" name="id" value="${book.getDescription()}" readonly>

                                </td>
                                <td>
                                    <input type="text" name="id" value="${book.getUnitPrice()}" readonly>
                                </td>
                                <td>
                                    <input type="text" name="id" value="${book.getUnitInStock()}" readonly>
                                </td>
                                <td>
                                    <input type="text" name="id" value="${book.getAuthors()}" readonly>
                                </td>                   
                                <td>
                                    <input type="text" name="id" value="${book.isIsContinues()}" readonly>
                                </td>
                                <td><a href="#">Save</a></td>
                            </tr>

                        </table>
                    </div>

                </div>
            </div> 
        </form>

    </body>
</html>
