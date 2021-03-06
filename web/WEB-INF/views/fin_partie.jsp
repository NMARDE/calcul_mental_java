<%--
  Created by IntelliJ IDEA.
  User: marde
  Date: 02/05/2020
  Time: 12:23
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
<jsp:useBean id="partieBean" class="model.PartieBean" scope="request"></jsp:useBean>
<div class="hero-wrap js-fullheight" style="background-image: url('img/fond.jpg');" data-stellar-background-ratio="0.5">
    <div class="overlay"></div>
    <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-start" data-scrollax-parent="true">
        </div>
    </div>
</div>

<div class="container">
    <div class="card card-container" style="margin-top: -900px;">
        <h3>Fin de partie</h3>
        <h4>Votre score est de : ${currentGame.score}</h4>

        <h3>Les 10 meilleurs joueurs</h3>
        </br>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Pseudo</th>
                <th>Score</th>
                <th>Difficulté</th>
                <th>Temps</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="partie" items="${partieBean.bestScores}">
                <tr>
                    <td>${partie.user.nom}</td>
                    <td>${partie.score}</td>
                    <td>${partie.niveau}</td>
                    <td>${partie.temps}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a class="btn btn-block btn-primary" href="<c:url value="/accueil" />">Retour à l'accueil</a>
    </div>
</div>

</body>
</html>
