<%@ page import="java.util.List" %>
<%@ page import="ru.itis.inform.models.Dish" %>
<%@ page import="ru.itis.inform.models.Product" %><%--
  Created by IntelliJ IDEA.
  User: Nurami
  Date: 06.11.2016
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"  %>
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
    <title>Dishes</title>
</head>
<body>
<% if (session.getAttribute("login")!=null) {%>
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
<form name="form1" method="POST">
    <%if (request.getAttribute("flag")!=null){%>
    <output class="text-center"><%=request.getAttribute("flag")%></output>
    <%}%>
    <label for="select1">Choose dish</label>
    <br>
    <div id="p2">
    <select id="select1"  name="select1" class="form-control" >
        <% List<Dish> list = (List) request.getAttribute("dishes");
            for (int i=0; i<list.size(); i++) {%>
        <option id="p2" value="<%=list.get(i).getName()%>"><%=list.get(i).getName()%></option>
        <%};%>
    </select>
    </div>
    <br>

    <button type="submit" formaction="/dishes" formmethod="post"  class="btn btn-default"  id="p2">Get</button>
    <%if ((session.getAttribute("role")!=null)&&(session.getAttribute("role").equals("admin"))){%>
    <button type="submit" formaction="/changedish" formmethod="get" class="btn btn-default"  id="p2">Change</button>
    <button type="submit" formaction="/delete" id="p2" formmethod="post" class="btn btn-default">Delete</button>
    <%}%>
</form>

    <% String dish = (String) request.getAttribute("dish");
        if (dish!=null){ %>
    <label><%=dish%></label>
    <br>
    <label for="textarea1" class="text-center">Recipe</label>
    <br>
<textarea id="textarea1" cols="86" rows="10" readonly class="form-control"><%=request.getAttribute("recipe")%></textarea>
<label>Ingredients:</label>
<br>
    <form action="/service" method="get">
<%  List<Product> list1 = (List)request.getAttribute("products");
    List list2 =(List) request.getAttribute("amounts");
    for (int i=0; i<list1.size(); i++){%>
        <label><%=list1.get(i).getName()%> - <%=list2.get(i)%> шт</label>
    <input class="hidden" name="ch1" value="<%=list1.get(i).getName()%>">
    <input class="hidden" name="ch2" value="<%=list2.get(i)%>" >
        <br>
    <%}%>
        <br>
        <button type="submit">Check Storage</button>
    </form>
<%}%>
</div>
<br>
<output>
</output>

<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
<%}
else{%>
<script>
window.location="/signin"
</script>
<%}%>

</body>
</html>
