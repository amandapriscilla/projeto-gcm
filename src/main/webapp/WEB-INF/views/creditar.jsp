<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Sistema Bancario GCM - Depósito</title>
<style>
	.form, .header{
		margin: 10px;
	}
	.menu {
		display: block;
		margin: 10px;
	}
</style>
</head>
<body>
	<div class="header">
	<h1>Sistema Bancario GCM - Depósito</h1>
	<h4>Conta: ${conta}</h4>
	<h4>Saldo: ${saldo}</h4>
	</div>
	<hr>

	<div class="form">
		<form action="depositar" method="post">
			<h4 style="color: red">${erro}</h4>
			<div>
				<input type="hidden" name="numero" value="${conta}" />
				<label>Digite o valor a ser depositado:</label><br/>
				<input id="valor" name="valor"><br/>
				<input type="submit" class="menu" value="Depositar"><br/>
			</div>
		</form>
	</div>

</body>
</html>