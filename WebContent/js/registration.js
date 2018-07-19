$(function() {


    $('#billing-check-box').click(function() {
        if ($('#billing-check-box').is(':checked')) {
            $('#billing-address').hide();
        } else {
            $('#billing-address').show();
        }
    });

});