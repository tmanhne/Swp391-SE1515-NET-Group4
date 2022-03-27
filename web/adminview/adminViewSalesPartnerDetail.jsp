<%-- 
    Document   : adminViewSalesPartnerDetail
    Created on : Mar 26, 2022, 4:32:58 PM
    Author     : vudm
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sales Partner Detail</title>
        <link href="./public/style/landingAdmin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="../view/headerAdmin.jsp"></jsp:include>
                <div id="admin-main-content">
                <jsp:include page="../view/leftMenuAdmin.jsp"></jsp:include>
                    <div class="admin-manager-detail">
                        <div class="header-main">
                            <p>Sales Partner Detail</p>
                        </div>                    
                        <div class="table-listProduct">
                            <c:forEach var="rpt" items="${requestScope.salesPartner}">
                            <div class="divTable">
                                <div class="divTableBody">
                                    <div class="divTableRow">
                                        <div class="divTableCell">Name</div>
                                        <div class="divTableCell">
                                        ${rpt.getPartnerName()}
                                    </div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Address</div>
                                    <div class="divTableCell">${rpt.getAddress()}</div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Product</div>
                                    <div class="divTableCell">${rpt.getProduct()}</div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Email</div>
                                    <div class="divTableCell">${rpt.getEmail()}</div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell" style="width: 20%">Phone</div>
                                    <div class="divTableCell">${rpt.getPhone()}</div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Descriptions</div>
                                    <div class="divTableCell">
                                        ${rpt.getDescription()}
                                    </div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Status</div>
                                    <div class="divTableCell">${rpt.getStatus()}</div>
                                </div>
                            </div>
                        </div>
                                </c:forEach>
                    </div>
                    <div class="backPage">
                        <a href="AdminViewSalesPartner">Back</a>
                    </div>
                </div>
            </div> 
                    <jsp:include page="../view/footerAdmin.jsp"></jsp:include>
    </body>
</html>
