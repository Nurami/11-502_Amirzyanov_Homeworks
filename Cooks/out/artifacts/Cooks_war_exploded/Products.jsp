<%@ page import="java.util.List" %>
<%@ page import="ru.itis.inform.models.Product" %><%--
  Created by IntelliJ IDEA.
  User: Nurami
  Date: 18.12.2016
  Time: 19:22
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
        table {
            width: 100%; /* Ширина таблицы в процентах */
        }
        .col1 {
            width: 100px; /* Ширина ячейки */
        }
    </style>
    <title>Products</title>
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
        <table class="table-striped text-center table-bordered" >
            <caption id="p2"  class="text-center">Products</caption>
            <tr>
                <th class="text-center">Product</th>
                <th class="text-center">Price in RUB</th>
                <th class="text-center">Amount</th>
                <th class="text-center">Correct Amount</th>
            </tr>
            <%List<Product> list = (List) request.getAttribute("products");
                for (int i=0; i<list.size(); i++){%>
                <tr ><td ><%=list.get(i).getName()%></td> <input class="hidden" name="name" value="<%=list.get(i).getName()%>">
                    <td><%=list.get(i).getPrice()%></td>
                    <td><%=list.get(i).getAmount()%></td>
                    <td><input name="input" value="<%=list.get(i).getAmount()%>" style="width: 60px" type="number"> <button  type="submit">Change</button></td>
                </tr>
            <%}%>
        </table>
    </form>
</div>

<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
<%}
else{%>
<script>
    window.location="/signin"
</script>
<%}%>
</html>
