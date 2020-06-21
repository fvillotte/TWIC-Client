<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    	<meta name="description" content="" />
    	<meta name="author" content="" />
    	<title>Info Ville</title>
    	<link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
    	<!-- Font Awesome icons (free version)-->
    	<script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
    	<!-- Google fonts-->
    	<link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet" />
    	<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet" />
    	<!-- Core theme CSS (includes Bootstrap)-->
    	<link href="Bootstrap/css/styles.css" rel="stylesheet" />
	</head>
	<body id="page-top">
		<!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="index.html">Villes de France</a><button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">Menu<i class="fas fa-bars"></i></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="ListerVillesServlet">Distance entre deux villes</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="TableauVillesServlet">Modifier les informations d'une ville</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="index.html">Contact</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Masthead-->
        <header class="masthead">
            <div class="container d-flex h-100 align-items-center">
                <div class="mx-auto text-center">
                	<h1 class="mx-auto my-0 text-uppercase"> </h1> <br> <br>
                    <form method="post" action="ModifierVilleServlet">
                    	<label class="text-white-50">Nom Commune</label>
						<div class="input-group mb-3 mr-sm-2">
							<input type="text" name="nomCommuneT" class="form-control"
								id="nomCommune" value="${VilleSelectionnee.getNomCommune()}">
						</div>
						<label class="text-white-50">Code Commune</label>
						<div class="input-group mb-3 mr-sm-2">
							<input type="text" name="codeCommuneT" class="form-control"
								id="codeCommune" value="${VilleSelectionnee.getCodeCommune()}">
						</div>
						<label class="text-white-50">Code Postal</label>
						<div class="input-group mb-3 mr-sm-2">
							<input type="text" name="codePostalT" class="form-control"
								id="codePostal" value="${VilleSelectionnee.getCodePostal()}">
						</div>
						<label class="text-white-50">Libelle Acheminement</label>
						<div class="input-group mb-3 mr-sm-2">
							<input type="text" name="libelleAcheminementT" class="form-control"
								id="libelleAcheminement" value="${VilleSelectionnee.getLibelleAcheminement()}">
						</div>
						<label class="text-white-50">Ligne_5</label>
						<div class="input-group mb-3 mr-sm-2">
							<input type="text" name="ligne_5T" class="form-control"
								id="ligne_5" value="${VilleSelectionnee.getLigne_5()}">
						</div>
						<label class="text-white-50">Longitude</label>
						<div class="input-group mb-3 mr-sm-2">
							<input type="text" name="longitudeT" class="form-control"
								id="longitude" value="${VilleSelectionnee.getLongitude()}">
						</div>
						<label class="text-white-50">Latitude</label>
						<div class="input-group mb-3 mr-sm-2">
							<input type="text" name="latitudeT" class="form-control"
								id="latitude" value="${VilleSelectionnee.getLatitude()}">
						</div>
                        <button name="codeCommuneIni" type="submit" class="btn btn-primary mb-2" value="${VilleSelectionnee.getCodeCommune()}">Modifier</button>
                       	<p class="text-white-50"> </p>
                    </form>
                </div>
            </div>
        </header>
		
		
		<!-- Footer-->
        <footer class="footer bg-black small text-center text-white-50"><div class="container">Copyright © VillesDeFrance2020</div></footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
	</body>
</html>