$(function () {
	$("#login-error").hide();
	
	$("#login-button").click(function() {
		console.log("Button Clicked");
		
		$.post("LoginValidation", $("#loginForm").serializeArray(), 
			function (response) {
				if (response == "true") {
					window.location.replace("index.jsp");
				} else {
					$("#login-error").show();
				}
			}
		);
	});
});