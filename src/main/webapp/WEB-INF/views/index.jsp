<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="default.css">

<title>Sistema Bancario GCM</title>

</head>
<body>
	<div class="header">
	<h1>Sistema Bancario GCM</h1>
	</div>
	<hr>

	<div class="form">
		<form action="app" method="post">
			<h4 style="color: red">${erro}</h4>
			<div>
				<label>Digite o Número da Conta:</label><br/>
				<input id="numero" name="numero"><br/>
				<input type="submit" class="menu" value="Enviar"><br/>
			</div>
		</form>
	</div>

</body>
</html>