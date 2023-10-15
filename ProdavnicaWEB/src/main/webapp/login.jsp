<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/style.css">
<meta charset="UTF-8">
<title>Prijava</title>
</head>


<body>
	<div class="sidenav">
		<a href="/Prodavnica/Onama.jsp">O nama</a> <a
			href="/Prodavnica/auth/getSve">Prodavnica</a> <a
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
			<a href="/Prodavnica/auth/logout">Odjava</a>
		</security:authorize>

	</div>

	<div class="main">
		 <img src="${pageContext.request.contextPath}/img/laptop.png" class="center"/> 
		<div class="center" style="font-size: 25px; text-align: center;">

			<c:url var="loginUrl" value="/login" />
			<c:if test="${not empty param.error}">
				<div class="alert alert-danger">
					<p>Pogresni podaci.</p>
				</div>
			</c:if>
			<form action="${loginUrl}" method="post">
				<table>
					<tr>
						<td>Korisnicko ime</td>
						<td><input type="text" name="username"
							placeholder="Unesite korisnicko ime" required></td>
					</tr>
					<tr>
						<td>Sifra</td>
						<td><input type="password" name="password"
							placeholder="Unesite sifru" required></td>
					</tr>
					<tr>
						<td>Zapamti me:</td>
						<td><input type="checkbox" name="remember-me" /></td>
					</tr>
					<tr>
						<td><input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /></td>
						<td><input type="submit" value="Prijava"></td>
					</tr>
				</table>
				<br /> <br /> Nemate nalog? <a href="/Prodavnica/auth/registerUser">Registrujte
					se</a>
			</form>
		</div>
	</div>

</body>
</html>