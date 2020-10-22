<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Sistema Bancario GCM - App</title>
</head>
<body>
	<h1>Sistema Bancario GCM - App</h1>
	<h4>Conta: ${conta}</h4>
	<h4>Saldo: ${saldo}</h4>
	<hr>

	<div class="form">

		<h3>Menu</h3>
			<form method="post">
				<input type="hidden" name="numero" value="${conta}" />
				<button type="submit" onclick="form.action='creditar';">Realizar Credito</button>
				<button type="submit" onclick="form.action='debitar';">Realizar Debito</button>
			 	<button type="submit" onclick="form.action='transferir';">Realizar Transferência</button>
			 	<button type="submit" onclick="form.action='index'">Sair</button>
			</form>
	</div>

</body>
</html>