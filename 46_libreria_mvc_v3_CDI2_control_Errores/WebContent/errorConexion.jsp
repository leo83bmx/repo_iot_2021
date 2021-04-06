<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>No se ha podido completar la operacion</h1>
<h3>${requestScope.mensajeError}</h3>
<a href="Controller?option=toSalir">Salir</a>
</center>
</body>
</html>