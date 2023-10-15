<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
  href="${pageContext.request.contextPath}/styles/style.css">
<meta charset="UTF-8">
<title>Filtriraj</title>
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
	<form action="/Prodavnica/prodavnica/getFiltriranje" method="get">
		Kategorija:<input type="text" name="naziv"><br>
		Cena proizvoda:<input type="number" name="cenaP"><br>
		<input type="submit" value="Izgenerisi">
	</form>
	</div>
	</div>
</body>
</html>