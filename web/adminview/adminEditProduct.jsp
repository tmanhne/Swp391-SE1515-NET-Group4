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
            <form action="AdminEditProduct" method="post">
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
                                        <input type="text" class="form-control" name="productId" value="${book.getProductID()}" readonly>
                                    </div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">BookName</div>
                                    <div class="divTableCell"><input type="text" name="productName" value="${book.getProductName()}" ></div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Description</div>
                                    <div class="divTableCell"><input type="text" name="description" value="${book.getDescription()}" ></div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Unit Price</div>
                                    <div class="divTableCell">
                                        <input type="text" name="unitPrice" value="${book.getUnitPrice()}" >
                                    </div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">UnitInStock</div>
                                    <div class="divTableCell"><input type="text" name="unitInStock" value="${book.getUnitInStock()}" ></div>
                                </div>

                                <div class="divTableRow">
                                    <div class="divTableCell">IsContinue</div>
                                    <div class="divTableCell"><input type="text" name="isContinues" value="${book.isIsContinue()}" ></div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Ratting</div>
                                    <div class="divTableCell"><input type="text" name="ratting" value="${book.getRatting()}" ></div>
                                </div>                             
                            </div>
                        </div>
                    </div>
                    <div class="submit_edit">
                        <button type="submit" value="Submit" name="submit">Submit</button> 
                    </div>
                </div>
            </div> 
        </form>
    </body>
</html>
