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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<form action="CheckoutServlet" id="CheckoutForm" method="post"></form>
<form action="CartServlet" id="bookForm" method="post" ></form>
<h1>Please Review Order Information</h1>
<div class="container margin-top-50">
	
	<h3>Payment and Shipping Information</h3>
	<c:set value="${user}" var="user" scope="session" />
        <br>
        <b>Shipping Address:</b><br/>
        <label class="reg-label">First name: </label><input form="CheckoutForm" class="reg-input" type="text" name="firstname" required value="${user.getFirstName()}"><br>
        <label class="reg-label">Last name: </label><input  form="CheckoutForm" class="reg-input" type="text" name="lastname" required value="${user.getLastName()}"><br>
        <label class="reg-label">Street: </label><input  form="CheckoutForm" class="reg-input" type="text" name="street" required value="${user.getStreetShipping()}"><br>
        <label class="reg-label">City: </label><input form="CheckoutForm" class="reg-input" type="text" name="city" required value="${user.getCityShipping()}"><br>
        <label class="reg-label">State: </label>
        <select form="CheckoutForm" class="reg-input" name="state" required>
        	<option selected="selected">${user.getStateBilling()}</option>
            <option value="AL" label="Alabama"></option>
            <option value="AK" label="Alaska"></option>
            <option value="AZ" label="Arizona"></option>
            <option value="AR" label="Arkansas"></option>
            <option value="CA" label="California"></option>
            <option value="CO" label="Colorado"></option>
            <option value="CT" label="Connecticut"></option>
            <option value="DE" label="Delaware"></option>
            <option value="DC" label="District Of Columbia"></option>
            <option value="FL" label="Florida"></option>
            <option value="GA" label="Georgia"></option>
            <option value="HI" label="Hawaii"></option>
            <option value="ID" label="Idaho"></option>
            <option value="IL" label="Illinois"></option>
            <option value="IN" label="Indiana"></option>
            <option value="IA" label="Iowa"></option>
            <option value="KS" label="Kansas"></option>
            <option value="KY" label="Kentucky"></option>
            <option value="LA" label="Louisiana"></option>
            <option value="ME" label="Maine"></option>
            <option value="MD" label="Maryland"></option>
            <option value="MA" label="Massachusetts"></option>
            <option value="MI" label="Michigan"></option>
            <option value="MN" label="Minnesota"></option>
            <option value="MS" label="Mississippi"></option>
            <option value="MO" label="Missouri"></option>
            <option value="MT" label="Montana"></option>
            <option value="NE" label="Nebraska"></option>
            <option value="NV" label="Nevada"></option>
            <option value="NH" label="New Hampshire"></option>
            <option value="NJ" label="New Jersey"></option>
            <option value="NM" label="New Mexico"></option>
            <option value="NY" label="New York"></option>
            <option value="NC" label="North Carolina"></option>
            <option value="ND" label="North Dakota"></option>
            <option value="OH" label="Ohio"></option>
            <option value="OK" label="Oklahoma"></option>
            <option value="OR" label="Oregon"></option>
            <option value="PA" label="Pennsylvania"></option>
            <option value="RI" label="Rhode Island"></option>
            <option value="SC" label="South Carolina"></option>
            <option value="SD" label="South Dakota"></option>
            <option value="TN" label="Tennessee"></option>
            <option value="TX" label="Texas"></option>
            <option value="UT" label="Utah"></option>
            <option value="VT" label="Vermont"></option>
            <option value="VA" label="Virginia"></option>
            <option value="WA" label="Washington"></option>
            <option value="WV" label="West Virginia"></option>
            <option value="WI" label="Wisconsin"></option>
            <option value="WY" label="Wyoming"></option>
        </select>
        <br>
        <label class="reg-label">Zip Code: </label><input form="CheckoutForm" class="reg-input" type="text" name="zip" required value="${user.getZipShipping()}">
        <br>
        <br>
        <br>
        <b>Payment Method:</b>
        <br>
        <label class="reg-label">Reserve For Pickup and Cash Payment</label><input form="CheckoutForm" class="reg-input" type="checkbox" name="storePickup" value="yes">
        <br>
        <c:set value="${card}" var="card" scope="session" />
        <label class="reg-label">Credit Card Number</label><input form="CheckoutForm" class="reg-input" type="text" name="ccNumber" value="${card.getCardNumber()}"><br>
        <label class="reg-label">Security Code</label><input form="CheckoutForm" class="reg-input" type="text" name="ccSecurity" value="${card.getCardSecurityCode()}"><br>
        <label class="reg-label">Expiration: </label>
        <div class="reg-input">
        	<select form="CheckoutForm" name="exp-month">
        		<option selected="selected">${card.getExpirationMonth()}</option>
	            <option value="01">01</option>
	            <option value="02">02</option>
	            <option value="03">03</option>
	            <option value="04">04</option>
	            <option value="05">05</option>
	            <option value="06">06</option>
	            <option value="07">07</option>
	            <option value="08">08</option>
	            <option value="09">09</option>
	            <option value="10">10</option>
	            <option value="11">11</option>
	            <option value="12">12</option>
	        </select>
	        <select form="CheckoutForm" name="exp-year">
	        	<option selected="selected">${card.getExpirationYear()}</option>
	            <option value="2018">18</option>
	            <option value="2019">19</option>
	            <option value="2020">20</option>
	            <option value="2021">21</option>
	            <option value="2022">22</option>
	            <option value="2023">23</option>
	            <option value="2024">24</option>
	            <option value="2025">25</option>
	        </select>
        </div>
        <br>
        <br>
        <br>
        <b>Billing Address:</b>
        <br>
        <label class="reg-label">Same as Shipping</label><input form="CheckoutForm" id="billing-check-box" class="reg-input" type="checkbox" name="sameAsBilling">
        <div id="billing-address">
        	<label class="reg-label">Street: </label><input form="CheckoutForm" class="reg-input" type="text" name="b-street" required value="${user.getStreetBilling()}"><br>
            <label class="reg-label">City: </label><input form="CheckoutForm" class="reg-input" type="text" name="b-city" required value="${user.getCityBilling()}"><br>
            <label class="reg-label">State: </label>
            <select form="CheckoutForm" class="reg-input" name="b-state">
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
            <label class="reg-label">Zip Code: </label><input form="CheckoutForm" class="reg-input" type="text" name="b-zip" value="${user.getZipBilling()}">
            <br>
            <br>
            <br>
            <br>
        </div>
</div>
<div class="container margin-top-50">
    <h3>Order Contents</h3>
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
	            	<div class="cart-div-height center-text">${book.getQty()}</div>
	            <td>
	        </tr>
        </c:forEach>
    </table>
</div>
<div class="center-div half-width">
	<c:set value="${cartTotal}" var="subtotal" scope="session" />
	<p>Sub-total:	$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${subtotal}"/></p>
	<c:set value="${taxesCost}" var="taxes" scope="session" />
	<p>Tax:			$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${taxes}"/></p>
	<c:set value="${shippingCost}" var="shipping" scope="session" />
	<p>Shipping: 	$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${shipping}"/></p>
	<c:set value="${orderTotal}" var="total" scope="session" />
	<p>Total:		$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${total}"/></p>
	<button form="CheckoutForm" class="login-button" type="submit" name="action" value="submit">Submit Order</button>
	<button form="bookForm" class="login-button" type="submit">Back to Cart</button>
</div>

</body>
</html>