<%-- 
    Document   : header
    Created on : Jan 18, 2022, 5:18:01 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <link href="./public/style/headerforadmin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="break-line" >
            <div id="header-left">
                    <a href="homeadmin">BookShopOnlineForAdmin</a>
                </div>
            <a href="homeadmin">Home</a>
            <a href="#">Order</a>
             <a href="#">Login</a>
           
        </div>
        <div id="header">
            <div class="row">
                <div class="dropdown">
                    <a href="category"> <button class="dropbtn">All Categories</button></a>
                    <div class="dropdown-content">
                        <form action="StoryController" method="GET">
                            <button>Story</button>
                        </form>
                        <form action="BookController" method="GET">
                            <button>Book</button>
                        </form>
                        <form action="NovelController" method="GET">
                            <button>Novel</button>
                        </form>
                    </div>
                </div>
               
                <div id="header-middle">
                    <form action="homeadmin" method="POST">
                        <span class="glyphicon glyphicon-search"></span>
                        <input type="text" placeholder="Find books"  name="search" value="${requestScope.searchname}">
                        <button type="submit">Search</button>
                    </form>  
                    
                </div>

                <div id="header-right">
                    
                 
                </div>
            </div>
        </div>

    </body>
</html>
