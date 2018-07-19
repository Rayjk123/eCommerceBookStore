<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="boundary.GetBookServlet" %> 
<%@page import="domain_layer.Book" %>   
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

<!-- Books display div -->
<div class="container margin-top-50">
	<table class="table table-hover">
		<tr>
			<td><!-- Book Image TD --></td>
			<td><!-- Book info TD --></td>
			<td><!-- Book Description TD --></td>
		</tr>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<c:forEach items="${results}" var="book">
			<tr>
				<td>
					<div class="col-12 col-sm-6 col-md-4">
            			<img id="image" src="${book.getImage()}"/>
        			</div>
        		</td>
        		<td>
        			<p><strong>${book.getTitle()}</strong></p>
        			<p>By: ${book.getAuthor()}</p>
        			<p>Price: ${book.getPrice()}</p>
        		</td>
        		<td>
        			<p class="overflow half-height">
        				${book.getDescription()}
        			</p>
        		</td>
        	</tr>
        </c:forEach>	
	</table>
</div>
</body>
</html>