<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/style.css">
<meta charset="UTF-8">
<meta charset="UTF-8">
<title>Unos proizvodjaca</title>
</head>
<body>
<div class="sidenav">
		<a href="/Prodavnica/Onama.jsp">O nama</a>  <a
			href="/Prodavnica/Kontakt.jsp">Kontakt</a>
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
	<div class="center" style="font-size: 25px; text-align: center;">
	Novi proizvodjac:<br>
	<form action="/Prodavnica/admin/saveProizvodjac" method="post">
		Naziv:<input type="text" name="imeProizvodjac"><br>
		Adresa:<input type="text" name="adresaProizvodjac"><br>
		<input type="submit" value="Dodaj">
	</form>
	
	<c:if test="${!empty proizvodjac}">
		Uspesno dodat! ${proizvodjac.imeProizvodjac} 
	</c:if>
	</div>
	</div>
</body>
</html>