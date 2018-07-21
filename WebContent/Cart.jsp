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

<div class="container margin-top-50">
    <h3>Shopping Cart</h3>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <form action="CartServlet" method="post" id="bookForm"></form>
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
            <td></td>
        </tr>
        <c:forEach items="${books}" var="book">
	        <!-- Book Detail Table Row-->
	        <tr>
	            <!-- Book Image TD -->
	            <td>
	                <div class="cart-div-height center-text">
	                	<a href="BookDetailServlet?param=${book.getIsbn()}">
	                    	<img class="shopping-cart-img" src="${book.getImage()}">
	                    </a>
	                </div>
	            </td>
	            <!-- Book Title TD-->
	            <td>
	                <div class="cart-div-height center-text">
	                	${book.getTitle()}
	                	<input type="hidden" form="bookForm" name="isbn" value="${book.getIsbn()}" />
	                </div>
	            </td>
	            <!-- Book Author TD-->
	            <td>
	                <div class="cart-div-height center-text">${book.getAuthor()}</div>
	            </td>
	            <!-- Book Author TD-->
	            <td>
	                <div class="cart-div-height center-text">${book.getPublisher()}</div>
	            </td>
	            <!--Book Price TD-->
	            <td>
	                <div class="cart-div-height center-text">
	                	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
						$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${book.getPrice()}"/>
					</div>
	            </td>
	            <td>
	            	<input form="bookForm" class="reg-input" type="text" name="qty" value="${book.getQty()}" required>
	            <td>
	            <td>
	            	<button form="bookForm" class="login-button" type="submit" name="action" value="edit">Set Quantity</button>
	            </td> 
	            <td>
	            	<button form="bookForm" class="login-button" type="submit" name="action" value="delete">Delete</button>
	            </td>
	        </tr>
        </c:forEach>
    </table>
    <div class="float-right">
        <p id="total-price">
        	<c:set value="${cartTotal}" var="total" scope="session" />
        	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
			$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${total}"/> 
        <form action="CheckoutServlet" method="post">
            <input type="submit" value="Proceed To Checkout"><br>
        </form>
    </div>
</div>

</body>
</html>