<%--
  Created by IntelliJ IDEA.
  User: marde
  Date: 22/04/2020
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accueil</title>
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

<jsp:useBean id="PartieBean" class="model.PartieBean" scope="request"></jsp:useBean>
<div class="hero-wrap js-fullheight" style="background-image: url('img/fond.jpg');" data-stellar-background-ratio="0.5">
    <div class="overlay"></div>
    <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-start" data-scrollax-parent="true">
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-6">
                    <div class ="card card-container">
                        <form method="POST">
                        <h3>Nouvelle partie</h3>
                    </br>
                        <p>Choisir sa difficulté</p>
                        <select class="form-control" name="select-difficulte" >
                        <option value="LEVEL1">Facile</option>
                        <option value="LEVEL2">Moyen</option>
                        <option value="LEVEL3">Difficile</option>
                        </select>
                    </br>
                        <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Jouer</button>
                    </div>
                    </form>
                </div>
                <div class="col-md-6">
                    <div class ="card card-container">
                        <h3>Les 10 meilleurs joueurs</h3>
                    </br>
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>Pseudo</th>
                                <th>Score</th>
                                <th>Temps</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="partie" items="${PartieBean.bestScores}">
                                <tr>
                                    <td>${partie.User.nomUser}</td>
                                    <td>${partie.score}</td>
                                    <td>${partie.email}</td>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
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
