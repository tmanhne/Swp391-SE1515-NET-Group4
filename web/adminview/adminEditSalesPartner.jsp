<%-- 
    Document   : adminEditSalesPartner
    Created on : Mar 26, 2022, 3:56:59 PM
    Author     : vudm
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Sales Partner</title>
        <link href="./public/style/landingAdmin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="../view/headerAdmin.jsp"></jsp:include>
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
                    <form action="AdminEditSalesPartner"method="POST">
                    <div class="table-listProduct">
                       
                        <table>
                            <tr>
                                <th>PartnerID</th>
                                <th>Name</th>
                                <th>Address</th>
                                <th>Status</th>
                                

                            </tr>
                            
                        <c:forEach var="rpt" items="${requestScope.salesPartner}">
                            <tr>
                                <td><input type="text" class="form-control" style="text-align: center;" name="partnerID" value="${rpt.getPartnerID()}" readonly></td>
                                <td>${rpt.getPartnerName()}</td>
                                <td>${rpt.getAddress()}</td>
                                <td><div class="divTableCell">
                                         <select name="partnerStatus" class="controls">
                                                <option value="${rpt.getStatus()}" selected="selected">${rpt.getStatus()}</option>
                                                <option value="Pending">Pending</option>
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
                <div class="backPage">
                        <a href="AdminViewSalesPartner">Back</a>
                    </div>
            </div>
                
        </div>
                <jsp:include page="../view/footerAdmin.jsp"></jsp:include>
    </body>
</html>
