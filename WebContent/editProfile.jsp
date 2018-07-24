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

<h1 class="center-text">Edit Profile</h1>
<div class="center-div half-width">
    * inputs are required
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:forEach items="${customers}" var="customer">
	    <form action="EditProfileServlet" method="post">
	        <label class="reg-label">${customer.email}</label><br>
	        <label class="reg-label">* Password: </label><input class="reg-input" type="password" name="password" value="${customer.password}" required><br>
	        <label class="reg-label">* First name: </label><input class="reg-input" type="text" name="firstname" value="${customer.firstName}" required><br>
	        <label class="reg-label">* Last name: </label><input class="reg-input" type="text" name="lastname" value="${customer.lastName}" required><br>
	        <br>
	        <br>
	        Shipping Address:<br>
	        <label class="reg-label">* Street: </label><input class="reg-input" type="text" name="sStreet" value="${customer.shippingAddress}" required><br>
	        <br>
	        <b>Payment Method</b>
	        <br>
	        <br>
	        <label class="reg-label">Credit Card Number</label><input class="reg-input" type="text" name="ccNumber" value="${customer.ccNumber}" required><br>
	        <label class="reg-label">Expiration: </label><input class="reg-input" type="text" name="ccExpiration" value="${customer.ccExpiration}" required><br>
	        <label class="reg-label">Security: </label><input class="reg-input" type="text" name="security" value="${customer.securityCode}" required><br>
	        <br>
	        <b>Billing Address:</b>
	        <br>
	        <label class="reg-label">* Street: </label><input class="reg-input" type="text" name="bStreet" value="${customer.billingAddress}" required><br>
	        <br>
	        <br>
	        <br>
	        <div class="center-text">
	            <input class="padding-top-50px" type="submit" value="Save">
	        </div>
	        <div class="center-text">
	            <input class="padding-top-50px" type="submit" value="Cancel">
	        </div>
	    </form>
    </c:forEach>
</div>

</body>
</html>