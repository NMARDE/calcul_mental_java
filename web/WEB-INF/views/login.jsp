<%--
  Created by IntelliJ IDEA.
  User: ssylla
  Date: 07/01/2020
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<title>Mental Math</title>
		<link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,500,500i,600,600i,700,700i&display=swap" rel="stylesheet">

		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

		<link rel="stylesheet" href="./css/animate.css">

		<link rel="stylesheet" href="./css/owl.carousel.min.css">
		<link rel="stylesheet" href="./css/owl.theme.default.min.css">
		<link rel="stylesheet" href="./css/magnific-popup.css">

		<link rel="stylesheet" href="./css/bootstrap-datepicker.css">
		<link rel="stylesheet" href="./css/jquery.timepicker.css">

		<link rel="stylesheet" href="./css/flaticon.css">
		<link rel="stylesheet" href="./css/style.css">
	</head>
	<body>

	<div class="hero-wrap js-fullheight" style="background-image: url('img/fond.jpg');" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div class="row no-gutters slider-text js-fullheight align-items-center justify-content-start" data-scrollax-parent="true">
			</div>
		</div>
	</div>

	<div class="container">
		<div class="card card-container">
			<h3>Connexion</h3>
		<div class="row small-5 small-centered">
			<c:if test="${!empty loginBean.message}">
				<div class="callout alert">
					<p>${loginBean.message}</p>
				</div>

			</c:if>
		</div>
			<form method="POST" class="form-signin" action="login">
				<input type="text"  name="form-username" class="form-control" placeholder="Entrez votre identifiant" value ="" required autofocus>
			</br>
				<input type="password"  name="form-password" class="form-control" placeholder="Entrez votre mot de passe" value="" required>
				<button class="btn btn-lg btn-primary btn-block btn-signin">Se connecter</button>
				<button class="btn btn-lg btn-primary btn-block btn-signin">S'inscrire</button>
			</form>
		</div>
		</div>
	</div>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
			<script src="js/jquery.min.js"></script>
			<script src="js/jquery-migrate-3.0.1.min.js"></script>
			<script src="js/popper.min.js"></script>
			<script src="js/bootstrap.min.js"></script>
			<script src="js/jquery.easing.1.3.js"></script>
			<script src="js/jquery.waypoints.min.js"></script>
			<script src="js/jquery.stellar.min.js"></script>
			<script src="js/jquery.animateNumber.min.js"></script>
			<script src="js/bootstrap-datepicker.js"></script>
			<script src="js/jquery.timepicker.min.js"></script>
			<script src="js/owl.carousel.min.js"></script>
			<script src="js/jquery.magnific-popup.min.js"></script>
			<script src="js/scrollax.min.js"></script>
			<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
			<script src="js/google-map.js"></script>
			<script src="js/main.js"></script>
		<script>
			$(document).foundation();
			document.documentElement.setAttribute('data-useragent', navigator.userAgent);
		</script>
	</body>
</html>
