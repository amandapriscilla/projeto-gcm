<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Sistema Bancario GCM - Debitar</title>
</head>
<body>
	<h1>Sistema Bancario GCM - Debitar</h1>
	<h4>Conta: ${conta}</h4>
	<h4>Saldo: ${saldo}</h4>
	<hr>

	<div class="form">
		<form action="debitar" method="post">
			<h4 style="color: red">${erro}</h4>
			<div>
				<input type="hidden" name="numero" value="${conta}" />
				<label>Digite o valor a ser debitado:</label><br/>
				<input id="numero" name="valor"><br/>
				<input type="submit" value="Debitar"><br/>
			</div>
		</form>
	</div>

</body>
</html>