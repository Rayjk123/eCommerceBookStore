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

<!-- Navbar Content -->
<div id="navbar"></div>

<!--Header Content Start-->
<div class="container">
    <div id="header-content">
        <!--<img class="header-background" src="https://s3.us-east-2.amazonaws.com/csci4050/AwesomeBookImage.jpg"/>-->
        <div class="header-info">
            <h1 class="fancy-font header-font">Best New Fiction Books of 2018</h1>
            <p><a class="btn btn-primary btn-lg" href="BrowseAllBooks" role="button">Check It Out</a></p>
        </div>
    </div>
</div>
<!--Header Content End-->

<!-- ##### Top Catagory Area Start ##### -->
<div class="section-padding-80">
    <div class="container">
        <div class="row justify-content-center">
            <!-- Single Catagory -->
            <div class="col-12 col-sm-6 col-md-4">
                <a href="BrowseAllBooks?genre=Fantasy">
                    <img class="item" src="https://s3.us-east-2.amazonaws.com/csci4050/Fantasy-Image.jpg">
                </a>
            </div>
            <!-- Single Catagory -->
            <div class="col-12 col-sm-6 col-md-4">
                <a href="BrowseAllBooks?genre=Horror">
                    <img class="item" src="https://s3.us-east-2.amazonaws.com/csci4050/Horror-Image.jpg">
                </a>
            </div>
            <!-- Single Catagory -->
            <div class="col-12 col-sm-6 col-md-4">
                <a href="BrowseAllBooks?genre=Romance">
                    <img class="item" src="https://s3.us-east-2.amazonaws.com/csci4050/Romance-Image.jpg">
                </a>
            </div>
        </div>
    </div>
</div>
<!-- ##### Top Catagory Area End ##### -->

</body>
</html>