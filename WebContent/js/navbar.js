$(document).ready(function(){
    var headerHtml = "<!--Nav Bar-->\n" +
        "<nav class=\"navbar sticky-top navbar-expand-lg navbar-light bg-light\">\n" +
        "    <a class=\"navbar-brand fancy-font logo-font\" href=\"#\">Bookly</a>\n" +
        "    <!--Collapse Icon-->\n" +
        "    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarMenu\"\n" +
        "            aria-controls=\"navbarMenu\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
        "        <span class=\"navbar-toggler-icon\"></span>\n" +
        "    </button>\n" +
        "\n" +
        "    <!--Items in Navbar-->\n" +
        "    <div class=\"collapse navbar-collapse\" id=\"navbarMenu\">\n" +
        "\n" +
        "        <ul class=\"navbar-nav mr-auto\">\n" +
        "            <li class=\"nav-item active\">\n" +
        "                <a class=\"nav-link\" href=\"index.html\">Home <span class=\"sr-only\">(current)</span></a>\n" +
        "            </li>\n" +
        "            <!--Dropdown Menu Link-->\n" +
        "            <li class=\"nav-item dropdown\">\n" +
        "                <a class=\"nav-link\" href=\"BrowseAllBooks\">Browse Books<span class=\"sr-only\">(current)</span></a>\n" +
        "            </li>\n" +
        "            <li class=\"nav-item\">\n" +
        "                <a class=\"nav-link\" href=\"#\">About</a>\n" +
        "            </li>\n" +
        "        </ul>\n" +
        "    </div>\n" +
        "\n" +
        "    <!--Search Bar-->\n" +
        "    <form method=\"post\" action=\"/search\" class=\"form-inline\">\n" +
        "        <select class=\"form-control\" name=\"category\">\n" +
        "            <option value=\"Book Title\">Book Title</option>\n" +
        "            <option value=\"Author\">Author</option>\n" +
        "            <option value=\"ISBN\">ISBN</option>\n" +
        "        </select>\n" +
        "        <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\n" +
        "        <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Search</button>\n" +
        "    </form>\n" +
        "\n" +
        "    <div class=\"login-area\">\n" +
        "        <a class=\"nav-item\" href=\"EditProfile\" ><img src=\"https://s3.us-east-2.amazonaws.com/csci4050/login-logo.png\" width=\"30\" height=\"30\"/></a>\n" +
        "    </div>\n" +
        "    <div class=\"cart-area\">\n" +
        "        <a class=\"nav-item\" href=\"CartServlet\" ><img src=\"https://s3.us-east-2.amazonaws.com/csci4050/shopping-bag.png\" width=\"30\" height=\"30\"/></a>\n" +
        "    </div>\n" +
        "</nav>";
    
   $("#navbar").append(headerHtml);
});