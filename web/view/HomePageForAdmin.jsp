<%-- 
    Document   : HomePageForAdmin
    Created on : Feb 10, 2022, 5:12:02 PM
    Author     : phamthithi
--%>

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
        <link href="./public/style/home.css" rel="stylesheet" type="text/css"/>
        <style>

            .pagination{

                display: inline-block;

            }

            .pagination a{

                float: left;

                text-decoration: none;

                padding: 8px 16px;

            }

            .pagination a.active{

                background-color: #4CAF50;

                color: white;

            }

            .pagination a:hover:not(.active){

                background-color: chocolate;

            }
            .addnew{
                float:right;
                margin-right: 140px;
                font-weight: bold;
            }
        </style>
    </head>
    <body>

        <jsp:include page="headerforadmin.jsp"></jsp:include>
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
        <div>
            <a class="addnew">Add new product</a>
            <h1>The list of Products</h1>
            <table>
                <tr>
                    <th>BookID</th>
                    <th>BookName</th>
                    <th>Image</th>
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
                    <td><img src="<%=p.getPathImage()%>"style="width: 90%;height: 90%;"/></td>
                    <td><%=p.getDescription()%></td>
                    <td><%=p.getUnitPrice()%></td>
                    <td><%=p.getUnitInStock()%></td>
                    <td><%=p.getAuthors()%></td>                   
                    <td><%=p.isIsContinue()%></td>
                    <td><a href="#">Edit</a></td>
                </tr>
                <%
                    }
                %>
            </table>
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

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
