<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/style.css">
<meta charset="UTF-8">
<meta charset="UTF-8">
<title>Prikaz proizvoda po kategorijama</title>
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
	<div class="center" style="font-size: 15px; text-align: center;">
	<form action="/Prodavnica/prodavnica/getProKat" method="get">
		Kategorija:<select name="idKategorija">
			<c:forEach var="k" items="${kategorije}">
				<option value="${k.idKategorija}">${k.naziv}</option>
			</c:forEach>
		</select>
		<input value="Prikazi" type="submit">
	</form>
	${odabranaKategorija.naziv}<br>
<c:if test="${!empty odabraniProizvod}">
	<table border="3">
		<tr>
			<th>Naziv proizvoda</th>
			<th>Cena</th>
			<th>Kolicina</th>
			<th>Opis</th>
			<th>Proizvodjac</th>
			<th>Kategorija</th>
			<th>Dodaj u omiljeno</th>
			<th>Oceni proizvod</th>
			<th>Kupi proizvod</th>
		</tr>
		<c:forEach var="p" items="${odabraniProizvod}">
		<tr>
			<td>${p.nazivP}</td>
			<td>${p.cenaP}</td>
			<td>${p.kolicinaP}</td>
			<td>${p.opis}</td>
			<td>${p.proizvodjac.imeProizvodjac}</td>
			<td>${p.kategorija.naziv}</td>
			<td><a href="/Prodavnica/prodavnica/saveOmiljenoKat?idProizvod=${p.idProizvod}">Dodaj u omiljeno</a></td>
			<td><a href="/Prodavnica/prodavnica/dodajOcenu?idProizvod=${p.idProizvod}">Oceni proizvod</a>
			<c:if test="${p.kolicinaP != 0}">
				<td><a href="/Prodavnica/prodavnica/saveUKorpuKat?idProizvod=${p.idProizvod}">Kupi</a></td>
			</c:if>
			<c:if test="${p.kolicinaP == 0}">
				<td>Nema na stanju</td>
			</c:if>
		</tr>
		</c:forEach>
	</table>
</c:if>
<c:if test="${!empty potvrda}">
	${potvrda}
</c:if>


<c:if test="${!empty potvrdaKorpa}">
		${potvrdaKorpa}
	</c:if>
	</div>
	</div>
</body>
</html>