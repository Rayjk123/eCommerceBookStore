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
    <h3>Manage Inventory</h3>
    <form action="adminAddInventory.jsp" method="post">
    	<button type="submit" class="btn btn-link" name="action" value="add">Add Book</button>
    </form>
    <form action="AdminInventoryServlet" method="post" id="InventoryForm"></form>
    <table class="table table-hover">
        <!-- Table Header Row-->
        <tr>
        	<!-- Edit Button TD -->
        	<td></td>
        	<!-- Delete Button TD -->
        	<td></td>
            <!-- Book Image TD -->
            <td class="center-text">
            	Image
            </td>
            <!-- Book ISBN TD -->
            <td class="center-text">
            	ISBN
            </td>
            <!-- Book Title TD-->
             <td class="center-text">
                Title
            </td>
            <!-- Book Author TD-->
             <td class="center-text">
                Author
            </td>
            <!-- Book Vendor TD-->
            <td class="center-text">
                Vendor
            </td>
            <!--Book Price TD-->
             <td class="center-text">
                Price
            </td>
            <!-- Promo Price -->
            <td class="center-text">
                Promo Price
            </td>
            <!-- Promo Code -->
            <td class="center-text">
                Promo Code
            </td>
            <!--Book Quantity TD-->
            <td class="center-text">
                Quantity
            </td>
            <!--Book Quantity On Hold TD-->
            <td class="center-text">
                On Hold
            </td>
        </tr>
        <!-- Book Detail Table Row-->
        <c:forEach items="${books}" var="book">
        <tr>
        	<!-- Edit Button TD -->
        	<td>
                <div class="cart-div-height center-text"> 
                	<button form="InventoryForm" type="submit" class="btn btn-link" name="action" value="edit_${book.getIsbn()}">Edit</button>
                </div>
            </td>
            <!-- Delete Button TD -->
        	<td>
                <div class="cart-div-height center-text"> 
                	<button form="InventoryForm" type="submit" class="btn btn-link" name="action" value="delete_${book.getIsbn()}">Delete</button>
                </div>
            </td>
        	<!-- Book Image TD -->
            <td>
                <div class="cart-div-height center-text">
                	<a href="AdminInventoryServlet?action=detail&isbn=${book.getIsbn()}">
                	<img class="inventory-img" src="${book.getImage()}">
                	</a>
	            </div>
            </td>
            <!-- Book ISBN TD -->
            <td>
                <div class="inventory-div-height">${book.getIsbn()}</div>
                <input type="hidden" form="InventoryForm" name="isbn" value="${book.getIsbn()}" />
            </td>
            <!-- Book Title TD-->
            <td>
                <div class="inventory-div-height">${book.getTitle()}</div>
            </td>
            <!-- Book Author TD-->
            <td>
                <div class="inventory-div-height">${book.getAuthor()}</div>
            </td>
            <!-- Book Vendor TD-->
            <td>
                <div class="inventory-div-height">${book.getVendor()}</div>
            </td>
            <!--Book Price TD-->
            <td>
                <div class="inventory-div-height">$${book.getPrice()}</div>
            </td>
            <!--Book Promo Price TD-->
            <td>
                <div class="inventory-div-height">$${book.getPromoPrice()}</div>
            </td>
            <!--Book Promo Code TD-->
            <td>
                <div class="inventory-div-height">${book.getPromoCode()}</div>
            </td>
            <!--Book Quantity TD-->
            <td>
                <div class="inventory-div-height">${book.getStock()}</div>
            </td>
            <!--Book Quantity On Hold TD-->
            <td>
                <div class="inventory-div-height">${book.getHold()}</div>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>