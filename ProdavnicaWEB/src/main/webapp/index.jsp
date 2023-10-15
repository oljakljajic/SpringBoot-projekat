<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
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
<div class="main">
		<img src="${pageContext.request.contextPath}/img/laptop.png"
			class="center" />
			<div class="center" style="font-size: 25px; text-align: center;">
			Prodavnica laptopova!
</div>
</div>
<div class="sidenav">
<a href="/Prodavnica/Onama.jsp">O nama</a> <a
			href="/Prodavnica/auth/getSve">Prodavnica</a> <a
			href="/Prodavnica/Kontakt.jsp">Kontakt</a>
<a href="/Prodavnica/auth/loginPage">Login</a> <br>
</div>

</body>
</html>