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
    	<title>Distance Villes</title>
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
                    <h1 class="mx-auto my-0 text-uppercase">Distance</h1>
                    <h2 class="text-white-50 mx-auto mt-2 mb-5">La distance qui sépare ${Ville1} et ${Ville2} est de ${Distance} Km</h2>
                    <form method="post" action="ListerVillesServlet">
                        <button type="submit" class="btn btn-primary mb-2">Essayer d'autres villes</button>
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