<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="boundary.GetBook" %>    
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
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set value="${results}" var="book" scope="session" />
    <form action="AddToCart" method="post">
        <!-- Book Image Column -->
        <div class="col-12 col-sm-6 col-md-4">
            <img id="image" src="${book.getImage()}"/>
        </div>
        <!-- Book Detail Column -->
        <div class="col-12 col-sm-6 col-md-4">
            <p><strong>${book.getTitle()}</strong></p>
            <p>Author: ${book.getAuthor()}</p>
            <p>ISBN: ${book.getISBN()}</p>
            <p>Price: $${book.getPrice()}</p>
            <p>Description:</p>
            <p class="overflow half-height">
            	${book.getDescription()}
            </p>
                <input class="login-button" type="submit" value="Add To Cart"><br>
        </div>
    </form>
</div>
</div>
    
      
</body>
</html>