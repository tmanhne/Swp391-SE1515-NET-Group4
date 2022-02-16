<%-- 
    Document   : AddCategory
    Created on : Feb 10, 2022, 3:36:39 AM
    Author     : phamthithi
--%>

<%@page import="dao.CategoryDAO"%>
<%@page import="model.Category"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category</title>
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

        </style>
    </head>
    <body>
        <jsp:include page="headerforadmin.jsp"></jsp:include>
            <h1>The List of Categories</h1>
        <%
            CategoryDAO cdb = new CategoryDAO();
            List<Category> list = cdb.getCategory();

            //Phan trang
            int start = 0;
            int end = 3;
            if (list.size() < 3) {
                end = list.size();
            }
            if (request.getParameter("start") != null) {
                start = Integer.parseInt(request.getParameter("start"));
            }
            if (request.getParameter("end") != null) {
                end = Integer.parseInt(request.getParameter("end"));
            }
            List<Category> pageList = cdb.getCategoryByPage(list, start, end);
        %>
        <form action="" method="post">
            <a href="AddCategory.jsp">Add New</a>
            <table border="1px">
                <tr>
                    <th>ID</th>
                    <th>Name</th>

                </tr>
                <%
                    String id = "";
                    String name = "";
                    String describe = "";
                    for (Category c : pageList) {
                        id = c.getCategoryID();
                        name = c.getCategoryName();

                %>
                <tr>
                    <td><%=id%></td>
                    <td><%=name%></td>

                    <td>
                        <a href="#">Delete</a>&nbsp&nbsp;
                        <a href="#">Edit</a>
                    </td>
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
                    <a href="category?start=<%=a%>&end=<%=b%>"><%=i%></a>
                </li>
                <%
                    }
                %>
            </ul>
        </form>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</body>
</html>
