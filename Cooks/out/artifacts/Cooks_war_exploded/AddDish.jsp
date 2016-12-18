<%@ page import="java.util.List" %>
<%@ page import="ru.itis.inform.models.Product" %><%--
  Created by IntelliJ IDEA.
  User: Nurami
  Date: 24.11.2016
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=cp1251" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <style>
        body {
            background: url(/image/bg.jpg);
            font-size: large;
        }
        #p1{
            font-weight: bold;
            text-decoration: none;
        }
        #div1{
            opacity: 0.6;
            background: #dbdbd8;
            padding: 50px;
            margin: 80px;
        }
    </style>
    <title>AddDish</title>
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

<script type="text/javascript" src="js/bootstrap.js"></script>
<div id="div1" class="text-center">
    <%if (request.getAttribute("flag")!=null){%>
    <h1>
    <output><%=request.getAttribute("flag")%></output>
    </h1>
    <%}%>
<form name="form2" action="" method="POST">
    <p>
        <b>
            You can add a new dish with recipe
        </b>
    </p>
    <p>
        Add name of dish:
    </p>
    <input id="input2" name="input2" type="text" class="form-control">
    <p>
        Add recipe of dish:
    </p>
    <textarea name="textarea2" id="textarea2" cols="86" rows="5" class="form-control"></textarea>
    <br>
    <button type="submit">Add!</button>
    <br>
    <br>
    <select name="s1">
        <option selected> Choose Product</option>
        <%List<Product> list = (List) request.getAttribute("products");
        for (int i=0; i<list.size(); i++) {%>
        <option value="<%=list.get(i).getName()%>"><%=list.get(i).getName()%></option>
        <%}%>
    </select> <input name="i1" >
    <br>
    <select name="s2">
        <option selected> Choose Product</option>
        <%for (int i=0; i<list.size(); i++) {%>
        <option value="<%=list.get(i).getName()%>"><%=list.get(i).getName()%></option>
        <%}%>
    </select> <input name="i2">
    <br>
    <select name="s3">
        <option selected> Choose Product</option>
        <%for (int i=0; i<list.size(); i++) {%>
        <option value="<%=list.get(i).getName()%>"><%=list.get(i).getName()%></option>
        <%}%>
    </select> <input name="i3">
    <br>
    <select name="s4">
        <option selected> Choose Product</option>
        <%for (int i=0; i<list.size(); i++) {%>
        <option value="<%=list.get(i).getName()%>"><%=list.get(i).getName()%></option>
        <%}%>
    </select> <input name="i4">
    <br>
    <select name="s5">
        <option selected> Choose Product</option>
        <%for (int i=0; i<list.size(); i++) {%>
        <option value="<%=list.get(i).getName()%>"><%=list.get(i).getName()%></option>
        <%}%>
    </select> <input name="i5">
    <br>
    <select name="s6">
        <option selected> Choose Product</option>
        <%for (int i=0; i<list.size(); i++) {%>
        <option value="<%=list.get(i).getName()%>"><%=list.get(i).getName()%></option>
        <%}%>
    </select> <input name="i6">
    <br>
    <select name="s7">
        <option selected> Choose Product</option>
        <%for (int i=0; i<list.size(); i++) {%>
        <option value="<%=list.get(i).getName()%>"><%=list.get(i).getName()%></option>
        <%}%>
    </select> <input name="i7">
    <br>



</form>
</div>
</body>
<%}
else{%>
<script>
    document.location = "/index";
</script>
<%}%>

</body>
</html>
