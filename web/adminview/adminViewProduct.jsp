<%-- 
    Document   : adminProduct
    Created on : Feb 16, 2022, 2:53:47 PM
    Author     : t.manh
--%>

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
            <form action="AdminViewProduct" method="post">
                <div id="admin-main-content">
                <jsp:include page="../view/leftMenuAdmin.jsp"></jsp:include>
                    <div class="admin-manager-detail">
                        <div class="header-main">
                            <p>View Product Detail</p>
                        </div>                    
                        <div class="table-listProduct">
                            <div class="divTable">
                                <div class="divTableBody">
                                    <div class="divTableRow">
                                        <div class="divTableCell">BookID</div>
                                        <div class="divTableCell">
                                        ${book.getProductID()}
                                    </div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">BookName</div>
                                    <div class="divTableCell">${book.getProductName()}</div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Image</div>
                                    <div class="divTableCell"><img src="${book.getImagePath()}"style="width: 150px;height: 150px;"/></div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Create Date</div>
                                    <div class="divTableCell">${book.getCreateDate()}</div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Description</div>
                                    <div class="divTableCell">${book.getDescription()}</div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Unit Price</div>
                                    <div class="divTableCell">
                                        ${book.getUnitPrice()}
                                    </div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">UnitInStock</div>
                                    <div class="divTableCell">${book.getUnitInStock()}</div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Author</div>
                                    <div class="divTableCell"> ${book.getAuthors()}
                                    </div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">IsContinue</div>
                                    <div class="divTableCell">${book.isIsContinue()}</div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Ratting</div>
                                    <div class="divTableCell">${book.getRatting()}</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="backPage">
                        <a href="homeadmin">Back</a>
                    </div>
                </div>
            </div> 
        </form>

    </body>
</html>
