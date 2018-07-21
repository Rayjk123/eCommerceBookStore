$(document).ready(function(){
    var headerHtml = "<!--Nav Bar-->\n" +
        "        <ul class=\"navbar-nav mr-auto\">\n" +
        "            <li class=\"nav-item active\">\n" +
        "                <a class=\"nav-link\">Admin Tools: <span class=\"sr-only\">(current)</span></a>\n" +
        "            </li>\n" +
        "            <li class=\"nav-item active\">\n" +
        "                <a class=\"nav-link\" href=\"AdminInventoryServlet\">Manage Inventory  <span class=\"sr-only\">(current)</span></a>\n" +
        "            </li>\n" +
        "            <li class=\"nav-item active\">\n" +
        "                <a class=\"nav-link\" href=\"#\">Manage Accounts  <span class=\"sr-only\">(current)</span></a>\n" +
        "            </li>\n" +
        "            <li class=\"nav-item active\">\n" +
        "                <a class=\"nav-link\" href=\"#\">Manage Orders  <span class=\"sr-only\">(current)</span></a>\n" +
        "            </li>\n" +
        "</nav>";
    
   $("#adminBar").append(headerHtml);
});