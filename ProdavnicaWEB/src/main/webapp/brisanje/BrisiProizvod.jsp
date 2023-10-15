<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Brisi proizvod</title>
</head>
<body>
 <form action="/Prodavnica/prodavnica/deleteProizvod">
		<select name="idProizvod">
			<c:forEach var="p" items="${proizvodi}">
				<option value="${p.idProizvod}">${p.nazivP}</option>
			</c:forEach>
		</select>
		<input value="Obrisi" type="submit">
	</form>

	<c:if test="${!empty potvrda}">
		${potvrda} 
	</c:if>
</body>
</html>