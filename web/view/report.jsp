<%-- 
    Document   : report
    Created on : Feb 28, 2022, 3:41:54 PM
    Author     : vudm
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./public/style/report.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>
            <!--                <div class="row">
                                <form class="form-horizontal" action="ReportController" method="POST">
            
        <c:choose>
            <c:when test="${requestScope.title != null}">
                <div class="span6">
                    <fieldset>
                        <legend>Report Form</legend>
            
                        <div class="control-group">
                            <label class="control-label" for="input01">Title</label>
                            <div class="controls">
                                <input type="text" name="title" class="input-xlarge" id="input01" value="${requestScope.title}">
                                <p class="help-block">Supporting help text</p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="input01">Customer's Name</label>
                            <div class="controls">
                                <input type="text" name="customerName" class="input-xlarge" id="input01" value="${requestScope.customerName}">
                                <p class="help-block">Supporting help text</p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="input01">Email</label>
                            <div class="controls">
                                <input type="text" name="email" class="input-xlarge" id="input01" value="${requestScope.email}">
                                <p class="help-block">Supporting help text</p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="input01">Phone</label>
                            <div class="controls">
                                <input type="text" name="phone" class="input-xlarge" id="input01" value="${requestScope.phone}">
                                <p class="help-block">Supporting help text</p>
                            </div>
                        </div> 
                        <div class="control-group">
                            <label class="control-label" for="input01">Insurance</label>
                                                        <div class="controls">
                                                            <input type="text" name="insurance" class="input-xlarge" id="input01">
                                                            <p class="help-block">Supporting help text</p>
                                                        </div>
                            <select name="insurance" class="controls">

                                <option value="None">None</option>
                                <option value="6 months">6 months</option>
                                <option value="1 year" selected="selected">1 year</option>
                            </select>
                        </div>   
                        <div class="control-group">
                            <label class="control-label" for="input01">Descriptions</label>
                            <div class="controls">
                                <textarea type="text" name="descriptions" class="input-xlarge" id="input01" value="${requestScope.descriptions}">
                                </textarea>
                                <p class="help-block">Supporting help text</p>
                            </div>
                        </div>           
                    </fieldset>

                </div>
            </c:when>
            <c:otherwise>
                <div class="span6">
                    <fieldset>
                        <legend>Report Form</legend>
                        <div class="control-group">
                            <label class="control-label" for="input01">Title</label>
                            <div class="controls">
                                <input type="text" name="title" class="input-xlarge" id="input01" required="">
                                <p class="help-block">Supporting help text</p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="input01">Customer's Name</label>
                            <div class="controls">
                                <input type="text" name="customerName" class="input-xlarge" id="input01" required="">
                                <p class="help-block">Supporting help text</p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="input01">Email</label>
                            <div class="controls">
                                <input type="text" name="email" class="input-xlarge" id="input01" required="">
                                <p class="help-block">Supporting help text</p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="input01">Phone</label>
                            <div class="controls">
                                <input type="text" name="phone" class="input-xlarge" id="input01" required="">
                                <p class="help-block">Supporting help text</p>
                            </div>
                        </div> 
                        <div class="control-group">
                            <label class="control-label" for="input01">Insurance</label>
                                                        <div class="controls">
                                                            <input type="text" name="insurance" class="input-xlarge" id="input01">
                                                            <p class="help-block">Supporting help text</p>
                                                        </div>
                            <select name="insurance" class="controls">
                                <option value="None">None</option>
                                <option value="6 months">6 months</option>
                                <option value="1 year" selected="selected">1 year</option>
                            </select>
                        </div>   
                        <div class="control-group">
                            <label class="control-label" for="input01">Descriptions</label>
                            <div class="controls">
                                <textarea type="text" name="descriptions" class="input-xlarge" id="input01">
                                </textarea>
                                <p class="help-block">Supporting help text</p>
                            </div>
                        </div>           
                    </fieldset>

                </div>
            </c:otherwise>
        </c:choose>


        <div style="color: red;">${notification}</div>
        <div class="span6">
            <button>Submit</button>
        </div>
    </form>
    <br>
    <a href="/Swp391-SE1515-NET-Group4/home" >
        <button class="btn btn-primary btn-md my-0 p" type="submit">Back Home</button>
    </a>
</div>-->
        <h3 class="titleReport">Report Form</h3>

        <div class="container">
            <form action="ReportController" method="POST">
                <c:choose>
                    <c:when test="${requestScope.title != null}">
                        <label for="fname">Title</label>
                        <input type="text" id="fname" name="title" placeholder="Title.." value="${requestScope.title}">

                        <label for="lname">Customer's Name</label>
                        <input type="text" id="lname" name="customerName" placeholder="Cutomer name.." value="${requestScope.customerName}">

                        <label for="fname">Email</label>
                        <input type="text" id="fname" name="email" placeholder="Email.." value="${requestScope.email}">

                        <label for="lname">Phone</label>
                        <input type="text" id="lname" name="phone" placeholder="Phone Number.." value="${requestScope.phone}">

                        <label for="country">Insurance</label>
                        <select id="country" name="insurance">
                            <option value="None">None</option>
                            <option value="6 months">6 months</option>
                            <option value="1 year" selected="selected">1 year</option>
                        </select>

                        <label for="subject">Descriptions</label>
                        <textarea type="text" id="subject" name="descriptions" placeholder="Write something.." style="height:200px" value="${requestScope.descriptions}"></textarea>

                    </c:when>

                    <c:otherwise>
                        <label for="fname">Title</label>
                        <input type="text" id="fname" name="title" placeholder="Title..">

                        <label for="lname">Customer's Name</label>
                        <input type="text" id="lname" name="customerName" placeholder="Cutomer name..">

                        <label for="fname">Email</label>
                        <input type="text" id="fname" name="email" placeholder="Email..">

                        <label for="lname">Phone</label>
                        <input type="text" id="lname" name="phone" placeholder="Phone Number..">

                        <label for="country">Insurance</label>
                        <select id="country" name="insurance">
                            <option value="None">None</option>
                            <option value="6 months">6 months</option>
                            <option value="1 year" selected="selected">1 year</option>
                        </select>

                        <label for="subject">Subject</label>
                        <textarea id="subject" name="descriptions" placeholder="Write something.." style="height:200px"></textarea>

                    </c:otherwise>
                </c:choose>
                <div style="color: red;">${notification}</div>
                <input type="submit" value="Submit">
            </form>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
        <!--        change name-->
    </body>
</html>
