<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="sidenav">
		<a href="/Prodavnica/Onama.jsp">O nama</a> <a
			href="/Prodavnica/auth/getSve">Prodavnica</a> <a
			href="/Prodavnica/Kontakt.jsp">Kontakt</a>
	</div>

	<div class="main">

		<div class="center" style="font-size: 20px; text-align: left;">

			<sf:form modelAttribute="user" action="register" method="post">
				<table>
					<tr>
						<td>Ime:</td>
						<td><sf:input path="ime" /></td>
					</tr>
					<tr>
						<td>Prezime:</td>
						<td><sf:input path="prezime" /></td>
					</tr>
					<tr>
						<td>Korisnicko ime:</td>
						<td><sf:input path="username" /></td>
					</tr>
					<tr>
						<td>Lozinka:</td>
						<td><sf:password path="password" /></td>
					</tr>
					<tr>
						<td><sf:select path="ulogas" items="${roles}"
								itemValue="idUloga" itemLabel="naziv" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Sacuvaj"></td>
					</tr>
				</table>
			</sf:form>
		</div>
	</div>
</body>
</html>