$(document).ready(function(){
    var headerHtml = "<!--Nav Bar-->\n" +
        "        <ul class=\"navbar-nav mr-auto\">\n" +
        "            <li class=\"nav-item active\">\n" +
        "                <a class=\"nav-link\">Reports: <span class=\"sr-only\">(current)</span></a>\n" +
        "            </li>\n" +
        "            <li class=\"nav-item active\">\n" +
        "                <a class=\"nav-link\" href=\"#\">End of Day Sales <span class=\"sr-only\">(current)</span></a>\n" +
        "            </li>\n" +
        "            <li class=\"nav-item active\">\n" +
        "                <a class=\"nav-link\" href=\"#\">Low Inventory <span class=\"sr-only\">(current)</span></a>\n" +
        "            </li>\n" +
        "            <li class=\"nav-item active\">\n" +
        "                <a class=\"nav-link\" href=\"#\">Book Sales  <span class=\"sr-only\">(current)</span></a>\n" +
        "            </li>\n" +
        "            <li class=\"nav-item active\">\n" +
        "                <a class=\"nav-link\" href=\"#\">Publisher Sales <span class=\"sr-only\">(current)</span></a>\n" +
        "            </li>\n" +
        "</nav>";
    
   $("#ownerBar").append(headerHtml);
});