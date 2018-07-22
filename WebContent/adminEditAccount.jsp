<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  
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
    <script src="js/adminBar.js"></script>
    <script src="js/navbar.js"></script>
</head>

<body>
<!--NAVBAR HTML-->
<div id="navbar"></div>
<div id="adminBar"></div>
<h1 class="center-text">Add Item</h1>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${user}" var="user" scope="session" />
<div class="half-width">
	<form action="AdminAccountsServlet" method="post">
		<label class="reg-label">Email:</label><input class="reg-input" type="text" name="email" required value="${user.getEmail()}"><br>
        <label class="reg-label">Password: </label><input class="reg-input" type="password" name="password" required value="${user.getPassword()}"><br>
        <label class="reg-label">First name: </label><input class="reg-input" type="text" name="firstname" required value="${user.getFirstName()}"><br>
        <label class="reg-label">Last name: </label><input class="reg-input" type="text" name="lastname" required value="${user.getLastName()}"><br>
        <label class="reg-label">Permission: </label><select class="reg-input" name="permission" required>
            	<option selected="selected">${user.getPermission()}</option>
            	<option value="AL">customer</option>
           		<option value="AK">admin</option>
            </select>
        <br>
        <label class="reg-label">Subscription: </label><select class="reg-input" name="subscription" required>
            	<option selected="selected">${user.getSubscription()}</option>
            	<option value="AL">yes</option>
            	<option value="AK">no</option>
            </select>
        <br>
        <br>
        <br>
        <b>Shipping Address:</b><br/>
        <label class="reg-label">Street: </label><input class="reg-input" type="text" name="street" required value="${user.getStreetShipping()}"><br>
        <label class="reg-label">City: </label><input class="reg-input" type="text" name="city" required value="${user.getCityShipping()}"><br>
        <label class="reg-label">State: </label>
        <select class="reg-input" name="state" required>
        	<option selected="selected">${user.getStateShipping()}</option>
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
        </select>
        <br>
        <label class="reg-label">Zip Code: </label><input class="reg-input" type="text" name="zip" required value="${user.getZipShipping()}">
        <br>
        <br>
        <br>
        <b>Billing Address:</b>
        <br>
        <div id="billing-address">
            <label class="reg-label">Street: </label><input class="reg-input" type="text" name="b-street" value="${user.getStreetBilling()}"><br>
            <label class="reg-label">City: </label><input class="reg-input" type="text" name="b-city" value="${user.getCityBilling()}"><br>
            <label class="reg-label">State: </label>
            <select class="reg-input" name="b-state">
            	<option selected="selected">${user.getStateBilling()}</option>
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
            </select>
            <br>
            <label class="reg-label">Zip Code: </label><input class="reg-input" type="text" name="b-zip"  value="${user.getZipBilling()}">
        </div>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div class="center-text">
            <button class="reg-label" type="submit" name="action" value="edit">Confirm</button>
			<button class="reg-label" type="submit" name="action" value="cancel">Cancel</button>
        </div>
        
	</form>



</div>
    