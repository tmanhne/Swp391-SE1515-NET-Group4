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
        
            <div id="admin-main-content">
            <jsp:include page="../view/leftMenuAdmin.jsp"></jsp:include>
                <div class="admin-manager-detail">
                    <div class="header-main">
                        <p>Report Detail</p>
                    </div>
                    <div class="table-listProduct">
                        <table>
                            <tr>             
                                <th>Title</th>
                                <th>Customer'sName</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Insurance</th>
                                <th>Descriptions</th>
                                <th>Status</th>
                                <th>AccountID</th>
                                <th>Time</th>

                            </tr>
                        <c:forEach var="rpt" items="${requestScope.reports}">
                            <tr>
                                <td>${rpt.getTitle()}</td>
                                <td>${rpt.getCustomerName()}</td>
                                <td>${rpt.getEmail()}</td>
                                <td>${rpt.getPhone()}</td>
                                <td>${rpt.getInsurance()}</td>
                                <td>${rpt.getDescriptions()}</td>
                                <td>${rpt.getStatus()}</td>
                                <td>${rpt.getAccountID()}</td>
                                <td>${rpt.getTime()}</td>
                                
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
