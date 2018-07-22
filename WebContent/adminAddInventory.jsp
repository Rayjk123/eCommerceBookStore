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
<div class="half-width">
	<form action="AdminInventoryServlet" method="post">
		<label class="reg-label">ISBN: </label><input class="reg-input" type="number" name="isbn" required><br>
		<label class="reg-label">Title: </label><input class="reg-input" type="text" name="title" required><br>
		<label class="reg-label">Author: </label><input class="reg-input" type="text" name="author" required><br>
		<label class="reg-label">Price: </label><input class="reg-input" type="number" step="0.01" name="price" required><br>
		<label class="reg-label">Genre: </label><input class="reg-input" type="text" name="genre" required><br>
		<label class="reg-label">Publisher: </label><input class="reg-input" type="text" name="publisher" required><br>
		<label class="reg-label">Vendor: </label><input class="reg-input" type="text" name="vendor" required><br>
		<label class="reg-label">Stock: </label><input class="reg-input" type="number" name="stock" required><br>
		<label class="reg-label">Promo Code: </label><input class="reg-input" type="text" name="promocode" required><br>
		<label class="reg-label">Promo Price: </label><input class="reg-input" step="0.01" type="number"  name="promoprice" required><br>
		<label class="reg-label">Image: </label><input class="reg-input" type="text" name="image" required><br>
		<label class="reg-label">Description: </label><textarea class="reg-input" maxlength="1000" name="description" style="width:250px;height:150px;" required></textarea><br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<button class="reg-label" type="submit" name="action" value="add">Add</button>
		<button class="reg-label" type="submit" name="action" value="cancel">Cancel</button>
        
	</form>



</div>
    