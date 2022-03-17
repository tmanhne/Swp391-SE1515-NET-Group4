<%-- 
    Document   : adminViewReportDetail
    Created on : Mar 5, 2022, 2:50:24 PM
    Author     : vudm
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report Detail</title>
        <link href="./public/style/landingAdmin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="../view/headerAdmin.jsp"></jsp:include>
                <div id="admin-main-content">
                <jsp:include page="../view/leftMenuAdmin.jsp"></jsp:include>
                    <div class="admin-manager-detail">
                        <div class="header-main">
                            <p>Report Detail</p>
                        </div>                    
                        <div class="table-listProduct">
                            <c:forEach var="rpt" items="${requestScope.reports}">
                            <div class="divTable">
                                <div class="divTableBody">
                                    <div class="divTableRow">
                                        <div class="divTableCell">Title</div>
                                        <div class="divTableCell">
                                        ${rpt.getTitle()}
                                    </div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Customer'sName</div>
                                    <div class="divTableCell">${rpt.getCustomerName()}</div>
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
                                    <div class="divTableCell">Insurance</div>
                                    <div class="divTableCell">${rpt.getInsurance()}</div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Descriptions</div>
                                    <div class="divTableCell">
                                        ${rpt.getDescriptions()}
                                    </div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Status</div>
                                    <div class="divTableCell">${rpt.getStatus()}</div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">AccountID</div>
                                    <div class="divTableCell"> ${rpt.getAccountID()}
                                    </div>
                                </div>
                                <div class="divTableRow">
                                    <div class="divTableCell">Time</div>
                                    <div class="divTableCell">${rpt.getTime()}</div>
                                </div>
                            </div>
                        </div>
                                </c:forEach>
                    </div>
                    <div class="backPage">
                        <a href="adminViewReport">Back</a>
                    </div>
                </div>
            </div> 
    </body>
</html>
