<%-- 
    Document   : HomePageForAdmin
    Created on : Feb 10, 2022, 5:12:02 PM
    Author     : phamthithi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Book"%>
<%@page import="dao.BooksDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page For Admin</title>
        <link href="./public/style/landingAdmin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <jsp:include page="headerAdmin.jsp"></jsp:include>
        <%
            List<Book> list = new ArrayList<Book>();
            BooksDAO pdao = new BooksDAO();
            if (request.getAttribute("list") != null) {
                list = (List<Book>) request.getAttribute("list");
            } else {
                list = pdao.getAllBooks();
            }
            int start = 0;
            int end;
            end = list.size() < 3 ? list.size() : 3;
            start = request.getParameter("start") != null ? Integer.parseInt(request.getParameter("start")) : start;
            end = request.getParameter("end") != null ? Integer.parseInt(request.getParameter("end")) : end;
            List<Book> pageList = new ArrayList<Book>();
            pageList = pdao.getBookByPage(list, start, end);
        %>


        <div id="admin-main-content">
            <div class="admin-manager">
                <div class="list-manager">
                    <a href="#">Manager Products</a>
                </div>
                <div class="list-manager">
                    <a href="#">Manager Bills</a>
                </div>
                <div class="list-manager">
                    <a href="#">Add New Product</a>
                </div>
            </div>
            <div class="admin-manager-detail">
                <div class="header-main">
                    <p>The List of Products</p>
                </div>
                <div class="table-listProduct">
                    <table>
                        <tr>             
                            <th>BookID</th>
                            <th>BookName</th>
                            <th>Description</th>
                            <th>Unit Price</th>
                            <th>UnitInStock</th>
                            <th>Author</th>
                            <th>IsContinue</th>
                            <th>Edit</th>

                        </tr>
                        <%
                            for (Book p : pageList) {

                        %>

                        <tr>
                            <td><%=p.getProductID()%></td>
                            <td><%=p.getProductName()%></td>                 
                            <td><%=p.getDescription()%></td>
                            <td><%=p.getUnitPrice()%></td>
                            <td><%=p.getUnitInStock()%></td>
                            <td><%=p.getAuthors()%></td>                   
                            <td><%=p.isIsContinues()%></td>
                            <td><a href="AdminEditProduct?pid=<%=p.getProductID()%>">Edit</a></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </div>
                <div class="pagination-page">
                    <ul>
                        <%
                            //navigation
                            //start ->a; end->b
                            int a, b;
                            int numOfPage = list.size() / 3;
                            if ((numOfPage * 3) < list.size()) {
                                numOfPage++;
                            }
                            for (int i = 1; i <= numOfPage; i++) {
                                a = (i - 1) * 3;
                                b = i * 3;
                                if (b > list.size()) {
                                    b = list.size();
                                }
                        %>
                        <li class="pagination">
                            <a href="homeadmin?start=<%=a%>&end=<%=b%>"><%=i%></a>
                        </li>
                        <%
                            }
                        %>
                    </ul>   
                </div>
            </div>
        </div>


    </body>
</html>
