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
                <div class="row">

                    <div class="col-md-5 border-right">
                        <div class="p-3 py-5">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h4 class="text-center">Profile Settings</h4>
                            </div>

                            <div class="row mt-3">
                                <div class="col-md-12">
                                    <label class="labels">UserName</label>
                                    <input type="text" class="form-control" placeholder="UserName" value="${account.userName}" name="username">
                                </div>
                                <div class="col-md-12"style="column-count: 2;">
                                    <label class="labels">Password</label>
                                    <input type="password" class="form-control" placeholder="Password" value="sjasan@sdchjldc"name="password">
                                    <div style="padding-top: 13%;"><a href="changePassword">Change password</a></div>
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Email</label>
                                    <input type="text" class="form-control" placeholder="Email" value="${account.email}"name="email">
                                   
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Phone number</label>
                                    <input type="text" class="form-control" placeholder="Phone number" value="${account.phone}"name="phone">
                                </div>


                            </div>
                                <div class="mt-5 text-center"style="padding-top: 3%;padding-bottom: 3%;"><button class="btn btn-primary profile-button" type="button">Save Profile</button></div>
                           
                        </div>
                    </div>
                    <label>${requestScope.Message}</label><br/>
                </div>
            </div>
        </form>
                
    </body>
      <jsp:include page="footer.jsp"></jsp:include>
</html>
