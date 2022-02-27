<%-- 
    Document   : adminViewFeedBack
    Created on : Feb 27, 2022, 12:12:04 PM
    Author     : Thongchu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../view/headerAdmin.jsp"></jsp:include>
            <form action="AdminViewProduct" method="post">
                <div id="admin-main-content">
                <jsp:include page="../view/leftMenuAdmin.jsp"></jsp:include>
                    <div class="admin-manager-detail">
                        <div class="header-main">
                            <p>The List of Products</p>
                        </div>                    
                        
                </div>
            </div> 
        </form>
    </body>
</html>
