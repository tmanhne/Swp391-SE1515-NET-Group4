<%-- 
    Document   : adminEditProduct
    Created on : Feb 16, 2022, 2:43:29 PM
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
        <jsp:include page="../view/headerAdmin.jsp"></jsp:include>
            <form action="AdminEditProduct" method="post" enctype="multipart/form-data" >
                <div id="admin-main-content">
                <jsp:include page="../view/leftMenuAdmin.jsp"></jsp:include>
                    <div class="admin-manager-detail">
                        <div class="header-main">
                            <p>The List of Products</p>
                        </div>
                        <div class="mess">                          
                            <p>
                            ${requestScope.mess}
                        </p>  
                    </div>

                    <div class="table-listProduct">
                        <div class="divTable">
                            <div class="divTableBody">
                                <div class="divTableRow">
                                    <div class="divTableCell">BookID</div>
                                    <div class="divTableCell">
                                        <input type="text" class="form-control" name="productId" value="${requestScope.book.getProductID()}" readonly>
                                    </div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Image</div>
                                    <div class="divTableCell">
                                        <img src="${requestScope.book.getImagePath()}" style="width: 150px;height: 150px;"/> 
                                        <br>
                                        <input type="file" name="image" placeholder="Image"/><br>
                                    </div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">BookName</div>
                                    <div class="divTableCell">
                                        <input type="text" name="productName" value="${requestScope.book.getProductName()}" > 
                                        <br>
                                        <p>${requestScope.pName}</p>
                                    </div>

                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Description</div>
                                    <div class="divTableCell">
                                        <input type="text" name="description" value="${requestScope.book.getDescription()}" >
                                        <br>
                                        <p>${requestScope.pDes}</p>
                                    </div>

                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Unit Price</div>
                                    <div class="divTableCell">
                                        <input type="text" name="unitPrice" value="${requestScope.book.getUnitPrice()}" >
                                        <br>
                                        <p>${requestScope.uPrice}</p>
                                    </div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">UnitInStock</div>
                                    <div class="divTableCell">
                                        <input type="text" name="unitInStock" value="${requestScope.book.getUnitInStock()}" >
                                        <br>
                                        <p>${requestScope.uInStock}</p>
                                    </div>
                                </div>

                                <div class="divTableRow">
                                    <div class="divTableCell">IsContinue</div>
                                    <div class="divTableCell    ">
                                        <div class="checkbox">
                                            Yes <input type="radio"  name="isContinue" value="Yes" checked>
                                        </div>

                                        <div class="checkbox">
                                            No <input type="radio"  name="isContinue" value="No">
                                        </div>
                                    </div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Ratting</div>
                                    <div class="divTableCell">
                                        <input type="text" name="ratting" value="${requestScope.book.getRatting()}" >
                                        <p>${requestScope.ratting}</p></div>
                                </div>                             
                            </div>
                        </div>
                    </div>
                    <div class="submit_edit">
                        <button type="submit" value="Submit" name="submit">Submit</button> 
                        <div class="backPage">
                            <a href="homeadmin">Back</a>
                        </div>
                    </div>
                </div>
            </div> 
        </form>
    </body>
</html>
