<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title> Unistore Pro &middot; Premium Store</title>
        <link href="./public/style/landingAdmin.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="./assets/img/icons/browser-tab-icon.png">


    </head>
    <body>
        <jsp:include page="../view/headerAdmin.jsp"></jsp:include>
            <div id="admin-main-content">
            <jsp:include page="../view/leftMenuAdmin.jsp"></jsp:include>
                <div class="admin-manager-detail">
                    <div class="header-main"> 
                        <p>Add Discount Product</p>
                    </div>             
                    <div style="margin: 20px 20px;">
                        <form action="AdminAddDiscount" method="post">
                            <strong>Code:</strong> 
                            <input type="text" name="discountCODE" value="${discountCODE}"  />
                        <strong>Select Language:</strong>
                        <select name="customer" >
                            <c:forEach var="customer" items="${requestScope.customers}">
                                <option value="${customer.customerName}" >${customer.customerName}</option>
                            </c:forEach>
                        </select>
                        <input style="margin-bottom: 5px;" type="submit" value="Add" name="btn-add-memberDiscount" />
                        <br>
                        <c:choose>
                            <c:when test="${requestScope.customersSelected.length()>0}">
                                <table border="1" style="width: 100%; margin-bottom: 10px;">                             
                                    <tr>
                                        <th style="padding: 5px;">Member</th>
                                        <th>Action</th>
                                    </tr>

                                    <c:forTokens items="${requestScope.customersSelected}" delims="," var="customer">  
                                        <tr>
                                            <td>${customer}</td>
                                            <td> <button type="submit" value="${customer}" name="deleteIDCustomer" >Delete</button></td>
                                        </tr> 
                                    </c:forTokens> 
                                </table>
                            </c:when>

                        </c:choose>
                        <strong>Discount: </strong> <input type="number" name="discount" value="${null == discount ? 0 : discount}" /><strong>Percent(%)</strong>
                        <br>
                        <button type="submit"  name="save" >Save</button>${requestScope.message}
                        <input type="hidden" name="customersSelected" value="${requestScope.customersSelected}" />


                    </form>
                </div>

            </div>
        </div> 
    </body>
</html>

