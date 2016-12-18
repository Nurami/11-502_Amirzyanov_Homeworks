<%@ page import="java.util.List" %>
<%@ page import="ru.itis.inform.models.Product" %><%--
  Created by IntelliJ IDEA.
  User: Nurami
  Date: 17.12.2016
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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
    <title>ChangeProduct</title>
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
    <form method="post" action="/changedish">
        <%String dish = (String)request.getAttribute("dish");%>
        <input type="text" class="form-control" name="dish1" value="<%=dish%>">
        <br>
        <input type="hidden" name="dish" value="<%=dish%>">
        <label for="textarea1" class="text-center">Recipe</label>
        <br>
        <textarea id="textarea1" name="recipe" cols="86" rows="10" class="form-control"><%=request.getAttribute("recipe")%></textarea>
        <br>
        <select class="form-control col-xs-2" name="product">
            <%List<Product> list = (List) request.getAttribute("products");
            for (int i=0; i<list.size(); i++){%>
            <option><%=list.get(i).getName()%></option>
            <%}%>
        </select>
        <br>
        <div class="text-center "><input class="form-control" type="number" name="amount"></div>
        <br>
        <button type="submit" class="btn btn-default" id="p2">Change</button>

    </form>
</div>

</body>
</html>
