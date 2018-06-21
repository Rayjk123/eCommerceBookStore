$(document).ready(function(){

    // Sub Menu JQuery Hiding and Showing
    $('#genre').hover(function(){
        $('.sub-menu').show();
    });

    $('.shop-menu').click(function() {
       $('.sub-menu').hide();
    });

    // $('#genre').onmouseleave(function(e){
    //     // $(this).click();
    //     $(this).next('div').hide();
    //     // e.stopPropagation();
    //     // e.preventDefault();
    // });
});