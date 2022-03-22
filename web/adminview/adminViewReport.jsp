<%-- 
    Document   : adminViewReport
    Created on : Mar 5, 2022, 11:28:11 AM
    Author     : vudm
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="java.util.List"%>
<%@page import="model.Reports"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reports</title>
    </head>
    <link href="./public/style/landingAdmin.css" rel="stylesheet" type="text/css"/>
    <body>
        <jsp:include page="../view/headerAdmin.jsp"></jsp:include>
    <script>
        function myFunction() {
            alert("Delete ok!");
            }
        
    </script>
     
            <div id="admin-main-content">
            <jsp:include page="../view/leftMenuAdmin.jsp"></jsp:include>
                <div class="admin-manager-detail">
                    <div class="header-main">
                        <p>The List Report And Insurance</p>
                    </div>
                    <div class="table-listProduct">
                        <table>
                            <tr>             
                                <th>ReportID</th>
                                <th>Title</th>
                                <th>Customer'sName</th>
                                <th>Status</th>
                                <th>View</th>
                                <th>Edit</th>
                                <th>Delete</th>

                            </tr>
                        <c:forEach var="rpt" items="${requestScope.listPage}">
                            <tr>
                                <td>${rpt.getReportID()}</td>
                                <td>${rpt.getTitle()}</td>
                                <td>${rpt.getCustomerName()}</td>
                                <td>${rpt.getStatus()}</td>
                                
                                <%--  <td><img src="${product.getPathImage()}"style="width: 100%"/></td>--%> 

                                <td><a href="AdminViewReportDetail?rid=${rpt.getReportID()}">View</a></td>
                                <td><a href="AdminEditReportController?rid=${rpt.getReportID()}">Edit</a></td>
                                <td><a href="adminDeleteReport?rid=${rpt.getReportID()}" onclick="myFunction()">Delete </a></td >
                            
                                
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                    <div class="pagination-page">
                    <c:forEach begin="1" end="${endPage}" var="i">
                        <a href="adminViewReport?index=${i}">${i}</a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>
