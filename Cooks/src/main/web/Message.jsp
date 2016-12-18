<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Nurami
  Date: 18.12.2016
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <style>
        body {
            background: url(/image/bg.jpg);
            font-size: large;
        }
        #p1{
            font-weight: bolder;
            text-decoration: none;
        }
        #div1{
            opacity: 0.6;
            background: #dbdbd8;
            padding: 50px;
            margin: 80px;
        }
        #p2{
            font-weight: bold;
        }
    </style>
    <title>Message</title>

</head>
<body>
<nav class="navbar navbar-default ">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header" >
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-text" id="p1" href="/index">Cooks</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

                <li><p class="navbar-text">Hello, <%= session.getAttribute("login")%></p></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="/products">Products</a></li>
                <li><a href="/dishes">Find Dish</a></li>
                <li><a href="/adddish">Add Dish</a></li>
                <li><a href="/signout">SignOut</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class="row text-center" id="div1">
    <%if (request.getAttribute("flag")!=null){%>
    <h1>
    <output id="p1"><%=request.getAttribute("flag")%></output>
    </h1>
    <%}%>
    <%if (request.getAttribute("result")!=null){%>
    <h1>
        <%String[] result = (String[]) request.getAttribute("result");
        for(int i=0; i<result.length; i++){%>
        <output id="p1"><%=result[i]%></output>
    </h1>
    <%}}%>

</div>

</body>
</html>
