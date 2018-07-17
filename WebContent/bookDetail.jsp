<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="logic_layer.Query" %>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bookly</title>

    <!--Boot Strap stuff-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
            integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
            crossorigin="anonymous"></script>

    <!--Fonts-->
    <link href="https://fonts.googleapis.com/css?family=BioRhyme+Expanded:400,700" rel="stylesheet">

    <!--Custom CSS and JS-->
    <link href="index.css" rel="stylesheet">
    <script src="js/index.js"></script>
    <script src="js/navbar.js"></script>
</head>
<body>
<!--NAVBAR HTML-->
<div id="navbar"></div>

<h1>Book Details</h1>
<div class="container margin-top-50">
    <div class="row justify-content-center">
    <%
    	int isbn = (int)request.getAttribute("isbn");
    	Query db = new Query();
    	ResultSet rs = db.getBook(isbn);
    
    %>
    
    <form action="AddToCart" method="post">
    	<input class="login-button" type="submit" value="Add To Cart"><br>
        <!-- Book Image Column -->
        <div class="col-12 col-sm-6 col-md-4">
            <img id="image" src="<%rs.getString("image");%>"/>
        </div>
        <!-- Book Detail Column -->
        <div class="col-12 col-sm-6 col-md-4">
            <p><strong><%rs.getString("title"); %></strong></p>
            <p>Author: <%rs.getString("author"); %></p>
            <p>ISBN: <%rs.getString("isbn"); %></p>
            <p>Price: <%rs.getDouble("price"); %></p>
            <p>Description:</p>
            <p class="overflow half-height">
            	<%rs.getString("description"); %>
            </p>
                <input class="login-button" type="submit" value="Add To Cart"><br>
        </div>
    </form>
</div>
</div>
    
      
</body>
</html>