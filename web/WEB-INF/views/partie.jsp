<%--
  Created by IntelliJ IDEA.
  User: marde
  Date: 22/04/2020
  Time: 09:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Partie en cours</title>
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

<jsp:useBean id="currentGame" class="bo.Partie" scope="session"></jsp:useBean>
<div class="hero-wrap js-fullheight" style="background-image: url('img/fond.jpg');" data-stellar-background-ratio="0.5">
    <div class="overlay"></div>
    <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-start" data-scrollax-parent="true">
        </div>
    </div>
</div>

<div class="container" style="margin-top: -120px;">
    <div class="row">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-6" >
                    <div class="card card-container">
                        <h3>Calcul mental</h3>
                        <form method="POST">
                            <label>Expression à calculer :</label> <h4>${currentGame.listExpressions.get(sessionScope.currentExIn).afficherExpression()}</h4>
                            <input type="text" class="form-control" name="form-response" id="form-response" required pattern="^[+-]?[0-9]{1,9}(?:.[0-9]{0,16})?"></span>
                            </br>
                            <button class="btn btn-block btn-primary" type="submit">Valider</button>
                        </form>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card card-container">
                        <h3>Règles du jeu</h3>
                        <p>Les calculs à effectuer seront générés <span style="font-weight: bold">automatiquement</span>.
                            Ils pourront contenir <span style="font-weight: bold">plusieurs</span> opérateurs et <span style="font-weight: bold">plusieurs</span> opérandes.
                            On considère une expression post-fixée sous forme d’une chaine de caractères pouvant comprendre :</p>
                        <p>- les opérations binaires : <span style="font-weight: bold">+, -, *, /</span></p>
                         <p>- les opérateurs unaires inverse et racine carrée notés <span style="font-weight: bold">inv</span> et <span style="font-weight: bold">rac</span></p>

                        <p> Exemple d'expression de difficulté <span style="font-weight: bold"> DIFFICILE </span> :</p>
                        <p style="font-weight: bold">-> 35 7 + 8 * rac</p>

                        <p> Pour effectuer le calcul, on va effectuer la première opération qui est : <span style="font-weight: bold">35 7</span> + qui est égal à <span style="font-weight: bold">42</span> (35+7).</p>
                        <p> Ensuite le résultat de cette opération sera utilisée pour la prochaine opération qui est <span style="font-weight: bold">42 8 *</span> qui est égal à <span style="font-weight: bold">336</span> (42 * 8).</p>
                        <p>Et rebelote avec la dernière opération qui est <span style="font-weight: bold">336 rac</span> qui est égal à environ <span style="font-weight: bold">18,330302780</span> (racine carrée de 336)</p>
                </div>
            </div>
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
