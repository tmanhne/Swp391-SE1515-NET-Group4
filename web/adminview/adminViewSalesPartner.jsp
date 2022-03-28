<%-- 
    Document   : adminViewSalesPartner
    Created on : Mar 26, 2022, 2:28:09 PM
    Author     : vudm
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="java.util.List"%>
<%@page import="model.SalesPartner"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Sales Partner</title>
    </head>
    <link href="./public/style/landingAdmin.css" rel="stylesheet" type="text/css"/>
    <body>
        <jsp:include page="../view/headerAdmin.jsp"></jsp:include>
            <div id="admin-main-content">
            <jsp:include page="../view/leftMenuAdmin.jsp"></jsp:include>
                <div class="admin-manager-detail">
                    <div class="header-main">
                        <p>View Sales Partner</p>
                    </div>
                    <div class="table-listProduct">
                        <table>
                            <tr>             
                                <th>PartnerID</th>
                                <th>Name</th>
                                <th>Address</th>
                                <th>Status</th>
                                <th>View</th>
                                <th>Edit</th>

                            </tr>
                        <c:forEach var="rpt" items="${requestScope.listPage}">
                            <tr>
                                <td>${rpt.getPartnerID()}</td>
                                <td>${rpt.getPartnerName()}</td>
                                <td>${rpt.getAddress()}</td>
                                <td>${rpt.getStatus()}</td>
                                
                                <%--  <td><img src="${product.getPathImage()}"style="width: 100%"/></td>--%> 

                                <td><a href="AdminViewSalesPartnerDetail?partnerID=${rpt.getPartnerID()}">View</a></td>
                                <td><a href="AdminEditSalesPartner?partnerID=${rpt.getPartnerID()}">Edit</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                    <div class="pagination-page">
                    <c:forEach begin="1" end="${endPage}" var="i">
                        <a href="AdminViewSalesPartner?index=${i}">${i}</a>
                    </c:forEach>
                </div>
            </div>
        </div>
                <jsp:include page="../view/footerAdmin.jsp"></jsp:include>
    </body>
</html>
