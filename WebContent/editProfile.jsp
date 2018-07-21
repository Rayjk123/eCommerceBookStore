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
	    <form action="EditProfile" method="post">
	        <label class="reg-label">* Email:</label><input class="reg-input" type="text" name="email" value="djtrump@somedomain.com" required><br>
	        <label class="reg-label">* Password: </label><input class="reg-input" type="password" name="password" value="*********" required><br>
	        <label class="reg-label">* Repeat Password: </label><input class="reg-input" type="password" name="password" value="*********" required><br>
	        <label class="reg-label">* First name: </label><input class="reg-input" type="text" name="firstname" value="Donald" required><br>
	        <label class="reg-label">* Last name: </label><input class="reg-input" type="text" name="lastname" value="Trump" required><br>
	        <br>
	        <br>
	        Shipping Address:<br>
	        <label class="reg-label">* Street: </label><input class="reg-input" type="text" name="street" value="1600 Pennsylvania Ave NW" required><br>
	        <label class="reg-label">* City: </label><input class="reg-input" type="text" name="city" value="Washington" required><br>
	        <label class="reg-label">* State: </label>
	        <select class="reg-input" name="state" required>
	            <option value="AL">Alabama</option>
	            <option value="AK">Alaska</option>
	            <option value="AZ">Arizona</option>
	            <option value="AR">Arkansas</option>
	            <option value="CA">California</option>
	            <option value="CO">Colorado</option>
	            <option value="CT">Connecticut</option>
	            <option value="DE">Delaware</option>
	            <option value="DC">District Of Columbia</option>
	            <option value="FL">Florida</option>
	            <option value="GA">Georgia</option>
	            <option value="HI">Hawaii</option>
	            <option value="ID">Idaho</option>
	            <option value="IL">Illinois</option>
	            <option value="IN">Indiana</option>
	            <option value="IA">Iowa</option>
	            <option value="KS">Kansas</option>
	            <option value="KY">Kentucky</option>
	            <option value="LA">Louisiana</option>
	            <option value="ME">Maine</option>
	            <option value="MD">Maryland</option>
	            <option value="MA">Massachusetts</option>
	            <option value="MI">Michigan</option>
	            <option value="MN">Minnesota</option>
	            <option value="MS">Mississippi</option>
	            <option value="MO">Missouri</option>
	            <option value="MT">Montana</option>
	            <option value="NE">Nebraska</option>
	            <option value="NV">Nevada</option>
	            <option value="NH">New Hampshire</option>
	            <option value="NJ">New Jersey</option>
	            <option value="NM">New Mexico</option>
	            <option value="NY">New York</option>
	            <option value="NC">North Carolina</option>
	            <option value="ND">North Dakota</option>
	            <option value="OH">Ohio</option>
	            <option value="OK">Oklahoma</option>
	            <option value="OR">Oregon</option>
	            <option value="PA">Pennsylvania</option>
	            <option value="RI">Rhode Island</option>
	            <option value="SC">South Carolina</option>
	            <option value="SD">South Dakota</option>
	            <option value="TN">Tennessee</option>
	            <option value="TX">Texas</option>
	            <option value="UT">Utah</option>
	            <option value="VT">Vermont</option>
	            <option value="VA">Virginia</option>
	            <option value="WA">Washington</option>
	            <option value="WV">West Virginia</option>
	            <option value="WI">Wisconsin</option>
	            <option value="WY">Wyoming</option>
	            <option selected="selected">DC</option>
	        </select>
	        <br>
	        <label class="reg-label">* Zip Code: </label><input class="reg-input" type="text" name="zip" value="20500" required>
	        <br>
	        <br>
	        <br>
	        <b>Payment Method</b>
	        <br>
	        <label class="reg-label">Select to Store Credit Card</label><input class="reg-input" type="checkbox" name="paymentLater">
	        <br>
	        <br>
	        <br>
	        <label class="reg-label">Credit Card Number</label><input class="reg-input" type="text" name="ccNumber" value="****-****-****-1234" required><br>
	        <label class="reg-label">Expiration: </label><input class="reg-input" type="text" name="ccExpiration" value="01/2021" required><br>
	        <br>
	        <b>Billing Address:</b>
	        <br>
	        <label class="reg-label">Same as Shipping</label><input class="reg-input" type="checkbox" name="sameAsBilling" checked>
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