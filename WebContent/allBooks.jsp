<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${message}" var="message" scope="session"/>
<div class="container margin-top-50">
<form action="CartServlet" method="post" id="BookForm"></form>

    <h3>${message}</h3>
    
    <table class="table table-hover">
        <!-- Table Header Row-->
        <tr>
            <!-- Book Image TD -->
            <td></td>
            <!-- Book Title TD-->
             <td class="center-text">
                Title
            </td>
            <!-- Book Author TD-->
             <td class="center-text">
                Author
            </td>
            <!-- Book Publisher TD-->
             <td class="center-text">
                Publisher
            </td>
            <!--Book Price TD-->
             <td class="center-text">
                Price
            </td>
            <!--Book Quantity TD-->
             <td class="center-text">
                Quantity
            </td>
            <td></td>
        </tr>
        <c:forEach items="${books}" var="book">
	        <!-- Book Detail Table Row-->
	        <tr>
	            <!-- Book Image TD -->
	            <td>
	                <div class="cart-div-height center-text">
	                	<a href="BookDetailServlet?param=${book.isbn}">
	                    	<img class="shopping-cart-img" src="${book.image}">
	                    </a>
	                    <input type="hidden" form="BookForm" name="isbn" value="${book.getIsbn()}" />
	                </div>
	            </td>
	            <!-- Book Title TD-->
	            <td>
	                <div class="cart-div-height center-text">${book.title}</div>
	            </td>
	            <!-- Book Author TD-->
	            <td>
	                <div class="cart-div-height center-text">${book.author}</div>
	            </td>
	            <!-- Book Author TD-->
	            <td>
	                <div class="cart-div-height center-text">${book.publisher}</div>
	            </td>
	            <!--Book Price TD-->
	            <td>
	                <div class="cart-div-height center-text">
	               	 	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	                	$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${book.getPrice()}"/>
	                </div>
	            </td>
	            <td>
	            	<div class="cart-div-height center-text">
	            		<select form="BookForm" name="qty_${book.getIsbn()}">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                    </select>
	            	</div>
	            <td>
	            <td>
               		<button class="login-button" type="submit" form="BookForm" name="action" value="add_${book.getIsbn()}">Add to Cart</button><br>
	            </td>
	        </tr>
        </c:forEach>
    </table>
    <!--  
    <div class="float-right">
        <p id="total-price">Total Price: $8.50</p>
        <form action="CheckoutServlet" method="post">
            <input type="submit" value="Proceed To Checkout"><br>
        </form>
    </div>
    -->
</div>

</body>
</html>