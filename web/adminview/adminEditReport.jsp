<%-- 
    Document   : adminEditReport
    Created on : Mar 5, 2022, 11:29:15 AM
    Author     : vudm
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Report</title>
        <link href="./public/style/landingAdmin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <script>
            function updateOk() {
                alert("Update Successfull!");
            }
        </script>
        <div id="admin-main-content">
            <jsp:include page="../view/leftMenuAdmin.jsp"></jsp:include>
                <div class="admin-manager-detail">
                    <div class="header-main">
                        <p>Edit Report</p>
                    </div>
                    <form action="AdminEditReportController"method="POST">
                    <div class="table-listProduct">
                       
                        <table>
                            <tr>
                                <th>ReportID</th>
                                <th>Title</th>
                                <th>Customer'sName</th>
                                <th>Status</th>
                                

                            </tr>
                            
                        <c:forEach var="rpt" items="${requestScope.reports}">
                            <tr>
                                <td><input type="text" class="form-control" name="reportId" value="${rpt.getReportID()}" readonly></td>
                                <td>${rpt.getTitle()}</td>
                                <td>${rpt.getCustomerName()}</td>
                                <td><div class="divTableCell">
                                         <select name="reportStatus" class="controls">
                                                <option value="${rpt.getStatus()}" selected="selected">${rpt.getStatus()}</option>
                                                <option value="Peding">Pending</option>
                                                <option value="Doing">Doing</option>
                                                <option value="Completed" >Completed</option>
                                        </select>

                                    </div></td>
                                <%--  <td><img src="${product.getPathImage()}"style="width: 100%"/></td>--%>
                            
                                <td><button value="save" onclick="updateOk()">Save</button></td>
                            
                            </tr>
                        </c:forEach>
                    </table>
                        <label>${requestScope.mess}</label>
                </div>
                 </form>
            </div>
        </div>
    </body>
</html>
