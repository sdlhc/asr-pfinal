<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Sentiment - Listar</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Zeta Template Project - Services">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/fontawesome-free-5.0.1/css/fontawesome-all.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="styles/services_styles.css">
<link rel="stylesheet" type="text/css" href="styles/services_responsive.css">
</head>

<body>

<div class="super_container">
	
	<!-- Header -->

	<header class="header d-flex flex-row justify-content-end align-items-center first">

		<!-- Logo -->
		<div class="logo_container mr-auto">
			<div class="logo">
				<a href="#"><span>s</span>sentiment<span>.</span></a>
			</div>
		</div>

		<!-- Main Navigation -->
		<nav class="main_nav justify-self-end">
			<ul class="nav_items">
				<li><a href="index.html"><span>subir archivo</span></a></li>
				<li class="active"><a href="listar"><span>listar</span></a></li>
			</ul>
		</nav>

		<!-- Hamburger -->
		<div class="hamburger_container">
			<span class="hamburger_text">Menu</span>
			<span class="hamburger_icon"></span>
		</div>

	</header>

	<!-- Menu -->

	<div class="fs_menu_overlay"></div>
	<div class="fs_menu_container">
		<div class="fs_menu_shapes"><img src="images/menu_shapes.png" alt=""></div>
		<nav class="fs_menu_nav">
			<ul class="fs_menu_list">
				<li><a href="index.html"><span><span>S</span>Subir Archivo</span></a></li>
				<li><a href="listar"><span><span>L</span>Listar</span></a></li>
			</ul>
		</nav>
		<div class="fs_social_container d-flex flex-row justify-content-end align-items-center">
			<ul class="fs_social">
				<li><a href="#"><i class="fab fa-pinterest trans_300"></i></a></li>
				<li><a href="#"><i class="fab fa-facebook-f trans_300"></i></a></li>
				<li><a href="#"><i class="fab fa-twitter trans_300"></i></a></li>
				<li><a href="#"><i class="fab fa-dribbble trans_300"></i></a></li>
				<li><a href="#"><i class="fab fa-behance trans_300"></i></a></li>
				<li><a href="#"><i class="fab fa-linkedin-in trans_300"></i></a></li>
			</ul>
		</div>
	</div>

	<div class="container second">
			<div class="row">
				<h1></h1>
			</div>
			<div class="row">
				<table class="table table-hover">
						    <thead>
						      <tr>
						        <th>Fecha</th>
						        <th>Texto</th>
						        <th>Sentimiento</th>
						        <th>Puntuación</th>
						      </tr>
						    </thead>
						    <tbody>
						     
						   	  <c:forEach items="${requestScope.palabras}" var="palabra">
						         <tr ${palabra._id!=requestScope.nuevaPalabra ? '' : 'class="bg-warning"'}>
						            <td>${palabra.fechaFormateada}</td>
							        <td>${palabra.espanol}</td>
							        <td>${palabra.tono}</td>
							        <td>${palabra.puntuacionTono}</td>
							      </tr>
						      </c:forEach>
						    </tbody>
						  </table>

			</div>

			<div class="row">
				<div class="col text-center">
					<div class="button services_button">
						<a href="services.html" class="d-flex flex-row align-items-center justify-content-center">
							discover<img src="images/arrow_right.svg" alt="">
						</a>
					</div>
				</div>
			</div>
		</div>

</div>

<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/greensock/TweenMax.min.js"></script>
<script src="plugins/greensock/TimelineMax.min.js"></script>
<script src="plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="plugins/greensock/animation.gsap.min.js"></script>
<script src="plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="plugins/parallax.js-1.5.0/parallax.min.js"></script>
<script src="plugins/progressbar/progressbar.min.js"></script>
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="js/services_custom.js"></script>
</body>

</html>