<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/style.css">
<meta charset="UTF-8">
<title>Prodavnica laptopova</title>
</head>
<body>
	<div class="sidenav">
		<a href="/Prodavnica/Onama.jsp">O nama</a> 
			 <a href="/Prodavnica/Kontakt.jsp">Kontakt</a>
		<security:authorize access="isAuthenticated()">
			<a href="/Prodavnica/prodavnica/getProizvodi">Prikazi proizvode</a>
			<br>
			<a href="/Prodavnica/admin/unosProizvodjaca">Unos proizvodjaca</a>
			<br>
			<a href="/Prodavnica/admin/unosKategorije">Unos kategorije</a>
			<br>
			<a href="/Prodavnica/admin/unosProizvoda">Unos proizvoda</a>
			<br>
			<a href="/Prodavnica/prodavnica/getKategorije">Prikazi proizvode
				po kategoriji</a>
			<br>
			<a href="/Prodavnica/prodavnica/getOcene">Prikazi ocene za
				proizvode</a>
			<br>
			<a href="/Prodavnica/admin/unosNoveKolicine">Unesi novu
				kolicinu</a>
			<br>
			<a href="/Prodavnica/prodavnica/vratiKorpu">Pogledajte vasu korpu</a>
			<br>
			<a href="/Prodavnica/prikaz/Filtriranje.jsp">Filtriranje</a><br>
			<a href="/Prodavnica/auth/logout">Odjava</a>
		</security:authorize>

	</div>
	<div class="main">
		<img src="${pageContext.request.contextPath}/img/laptop.png"
			class="center" />
		<div class="center" style="font-size: 25px; text-align: center;">
			Dobrodosli
			<security:authorize access="isAuthenticated()">
				<security:authentication property="principal.username" />
			</security:authorize>
		</div>
	</div>
</body>
</html>