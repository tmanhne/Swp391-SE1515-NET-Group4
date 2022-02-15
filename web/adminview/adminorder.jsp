<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title> Unistore Pro &middot; Premium Store</title>

        <link rel="icon" href="./assets/img/icons/browser-tab-icon.png">

        <!-- Bootstrap -->
        <link href="./assets/css/bootstrap.css" rel="stylesheet">
        <link href="./assets/css/custom.css" rel="stylesheet">
        <link href="./assets/css/carousel.css" rel="stylesheet">
        <link href="./assets/ionicons-2.0.1/css/ionicons.css" rel="stylesheet">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <link href='https://fonts.googleapis.com/css?family=Catamaran:400,100,300' rel='stylesheet' type='text/css'>

        <link href="./assets/css/custom-scroll/jquery.mCustomScrollbar.css" rel="stylesheet">
    </head>
    <body>
        <!--Very top-->
        <%@include file="/components/very-top.jsp"%>

        <%@include file="/components/adminnavbar.jsp"%>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <a href="adminHome">
            <button class="btn btn-primary btn-sm rounded"> Back </button>
        </a>
        <br/>
        <br/>
        <form action="adminOrderSort" method="get" name="formName">
            <select class="form-control" name="sort" onchange="formSubmit()" style="width: 30%;">
                <option value="1" ${sortid eq 1 ? "selected" : ""}>ID Increasing</option>
                <option value="2" ${sortid eq 2 ? "selected" : ""}>ID Descresing</option>
                <option value="3" ${sortid eq 3 ? "selected" : ""}>Status Increase</option>
                <option value="4" ${sortid eq 4 ? "selected" : ""}>Status Descresing</option>
                <option value="5" ${sortid eq 5 ? "selected" : ""}>Pending</option>
                <option value="6" ${sortid eq 6 ? "selected" : ""}>Processing</option>
                <option value="7" ${sortid eq 7 ? "selected" : ""}>Success</option>
                <option value="8" ${sortid eq 8 ? "selected" : ""}>Canceled</option>
            </select>
        </form>
        <br/>
        <br/>
        <table class="table">
            <thead>
                <tr>    
                    <th>ID</th>
                    <th>Date</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Status</th>
                    <th>Change Status</th>
                    <th>Detail</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="o" items="${requestScope.orders}">
                    <tr>    
                        <td>${o.oid}</td>
                        <td>${o.date eq null ? "Unknown" : o.date}</td>
                        <td>${o.account.name }</td>
                        <td>${o.account.email}</td>
                        <td>${o.status}</td>
                        <td>
                            <a href="adminChangeStatusOrderProcess?oid=${o.oid}">
                                <button class="btn btn-primary btn-sm rounded" ${o.status != "Canceled" ? "" : "Disabled"}> Processing </button>
                            </a>
                            <a href="adminChangeStatusOrderSuccess?oid=${o.oid}">
                                <button class="btn btn-success btn-sm rounded" ${o.status != "Canceled" ? "" : "Disabled"}> Success </button>
                            </a>
                            <a href="adminChangeStatusOrderCanceled?oid=${o.oid}">
                                <button class="btn btn-danger btn-sm rounded" ${o.status == "Canceled" ? "Disabled" : ""}> Canceled </button>
                            </a>
                        </td>
                        <td>
                            <a href="adminDetailOrder?oid=${o.oid}">
                                <button class="btn btn-primary btn-sm rounded"> Detail </button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <script type="text/javascript">
            function formSubmit(){
                formName.submit();
            }
        </script>
    </body>
</html>
