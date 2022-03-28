<%-- 
    Document   : profile
    Created on : Feb 20, 2022, 9:56:05 PM
    Author     : phamthithi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <style>
            .container{
                padding-top: 1%;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <form action="profile" method="post">
                <div class="container rounded bg-white mt-5 mb-5">

                    <div class="col-md-5" style="max-width: 50%;">
                        <div class="p-3 py-5">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h4 class="text-center" style="font-size: 32px;">Profile Settings</h4>
                            </div>

                            <div class="row mt-3">
                                <div class="col-md-12">
                                    <label class="labels" style="font-size: 16px;">UserName</label>
                                    <input type="text" class="form-control" placeholder="UserName" value="${account.userName}" name="username"readonly>
                                </div>
                            <div class="col-md-12">
                                <label class="labels" style="font-size: 16px;">Password</label>
                                <input type="password" class="form-control" placeholder="Password" value="${account.password}"name="password">   
                                <a href="changePassword">Change Password</a>
                            </div>
                            <div class="col-md-12">
                                <label class="labels" style="font-size: 16px;">Email</label>
                                <input type="text" class="form-control" placeholder="Email" value="${account.email}"name="email">

                            </div>
                            <div class="col-md-12">
                                <label class="labels" style="font-size: 16px;">Phone number</label>
                                <input type="text" class="form-control" placeholder="Phone number" value="${account.phone}"name="phone">
                            </div>
                            <div class="col-md-12">
                                <label class="labels mb-3" style="font-size: 16px;">Checkout History</label><br>
                                <a style="border: 1px solid black; padding: 5px;" href="checkouthistory">Go to history</a>
                            </div>

                        </div>
                        <div class="mt-5 text-center"style="padding-top: 3%;padding-bottom: 3%;color: red;">
                            <input style=" width: 100px; 
                                   margin: 0 auto;
                                   padding: 5px;" 
                                   type="submit" class="form-control" value="Save"/> ${requestScope.messResponse}</div>
                    </div>
                </div>
            </div>
        </form>

    </body>
    <jsp:include page="footer.jsp"></jsp:include>
</html>
