<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <script src="js/adminBar.js"></script>
    <script src="js/navbar.js"></script>
</head>

<body>
<!--NAVBAR HTML-->
<div id="navbar"></div>
<div id="adminBar"></div>
<div class="margin-top-50">
    <h3>Manage Orders</h3>
    <form action="AdminOrdersServlet" method="post" id="OrderForm"></form>
    <table class="table table-hover">
        <!-- Table Header Row-->
        <tr>
        	<!-- Update Status Button TD -->
        	<td></td>
        	<!-- Status -->
            <td class="center-text">
                Status
            </td>
            <!-- Email TD -->
            <td class="center-text">
            	Email
            </td>
            <!-- Date TD -->
            <td class="center-text">
            	Date
            </td>
            <!-- Total TD-->
            <td class="center-text">
                Total
            </td>
            <!-- Shipping TD-->
            <td class="center-text">
                Shipping Address
            </td>
            <!-- Payment Card TD-->
            <td class="center-text">
                Payment Card
            </td>
            <!--Billing Address TD-->
            <td class="center-text">
                Billing Address
            </td>
        </tr>
        <!-- Order Detail Table Row-->
        <c:forEach items="${orders}" var="order">
        <tr>
        	<!-- Update Button TD -->
        	<td>
                <div class="cart-div-height center-text"> 
                	<button form="OrderForm" type="submit" class="btn btn-link" name="action" value="update">Edit</button>
                </div>
            </td>
            <!-- Status TD-->
            <td>
                <div class="inventory-div-height">
                	<select form="OrderForm" class="reg-input" name="status" required>
                		<option selected="selected">${order.getStatus()}</option>
                		<option value="Hold">Hold</option>
                		<option value="Purge">Purge</option>
                		<option value="Online Payment Processed">Online Payment Processed</option>
                		<option value="Shipped">Shipped</option>
                		<option value="Cancelled">Cancelled</option>
                	</select>
                </div>
            </td>
        	<!-- Email TD -->
            <td>
                <div class="cart-div-height center-text">${order.getEmail()}</div>
                <input type="hidden" form="OrderForm" name="date" value="${order.getEmail()}" />
            </td>
            <!-- Date TD -->
            <td>
                <div class="inventory-div-height">${order.getDate()}</div>
                <input type="hidden" form="OrderForm" name="date" value="${order.getDate()}" />
            </td>
            <!-- Total TD-->
            <td>
                <div class="inventory-div-height">$${order.getTotal()}</div>
            	<input type="hidden" form="OrderForm" name="total" value="${order.getTotal()}" />
            </td>
            <!-- Shipping Address TD-->
            <td>
                <div class="inventory-div-height">${order.getShippingAddress()}</div>
            </td>
            <!-- Payment Card TD-->
            <td>
                <div class="inventory-div-height">${order.getPaymentCard()}</div>
            </td>
            <!--Billing Address TD-->
            <td>
                <div class="inventory-div-height">${order.getBillingAddress()}</div>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>