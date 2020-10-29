<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="default.css">

<title>Sistema Bancario GCM - Creditar</title>

</head>
<body>
	<jsp:include page='template/header.jsp'>
		<jsp:param name="funcionalidade" value="Creditar"/>
	</jsp:include>
	<div class="form">
		<form action="creditar" method="post">
			<h4 style="color: red">${erro}</h4>
			<div>
				<input type="hidden" name="numero" value="${conta}" />
				<label>Digite o valor a ser creditado:</label><br/>
				<input id="valor" name="valor"><br/>
				<input type="submit" class="menu" value="Creditar"><br/>
			</div>
		</form>
	</div>

</body>
</html>