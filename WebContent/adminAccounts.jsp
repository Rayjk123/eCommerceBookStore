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
    <h3>Manage Accounts</h3>
    <form action="adminAddAccount.jsp" method="post">
    	<button type="submit" class="btn btn-link" name="action" value="add">Add Account</button>
    </form>
    <form action="AdminAccountsServlet" method="post" id="AccountsForm"></form>
    <table class="table table-hover">
        <!-- Table Header Row-->
        <tr>
        	<!-- Edit Button TD -->
        	<td></td>
        	<!-- Delete Button TD -->
        	<td></td>
            <!-- User email -->
            <td class="center-text">
            	Email
            </td>
            <!-- User First Name -->
            <td class="center-text">
            	First Name
            </td>
            <!-- User Last Name-->
             <td class="center-text">
                Last Name
            </td>
            <!-- User Shipping Address -->
             <td class="center-text">
                Shipping Address
            </td>
            <!-- Billing Address -->
            <td class="center-text">
                Billing Address
            </td>
            <!-- Permission -->
             <td class="center-text">
                Permission
            </td>
            <!-- Subscription Preference -->
            <td class="center-text">
                Subscription
            </td>
        </tr>
        <!-- Book Detail Table Row-->
        <c:forEach items="${users}" var="users">
        <tr>
        	<!-- Edit Button TD -->
        	<td>
                <div class="cart-div-height center-text"> 
                	<button form="AccountsForm" type="submit" class="btn btn-link" name="action" value="edit">Edit</button>
                </div>
            </td>
            <!-- Delete Button TD -->
        	<td>
                <div class="cart-div-height center-text"> 
                	<button form="AccountsForm" type="submit" class="btn btn-link" name="action" value="delete">Delete</button>
                </div>
            </td>
        	<!-- User email -->
            <td>
                <div class="cart-div-height center-text">
                	<div class="inventory-div-height">${users.getEmail()}</div>
                	<input type="hidden" form="AccountsForm" name="email" value="${users.getEmail()}" />
	            </div>
            </td>
            <!-- User First Name -->
            <td>
                <div class="inventory-div-height">${users.getFirstName()}</div>
            </td>
            <!-- Last Name-->
            <td>
                <div class="inventory-div-height">${users.getLastName()}</div>
            </td>
            <!-- Shipping Address-->
            <td>
                <div class="inventory-div-height">${users.getShippingAddress()}</div>
            </td>
            <!-- Billing Address-->
            <td>
                <div class="inventory-div-height">${users.getBillingAddress()}</div>
            </td>
            <!--Permission-->
            <td>
                <div class="inventory-div-height">${users.getPermission()}</div>
            </td>
            <!--Subscription-->
            <td>
                <div class="inventory-div-height">${users.getSubscription()}</div>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>