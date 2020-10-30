<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="default.css">
<style>
	.menu {
		min-width: 200px;
	}
</style>

<title>Sistema Bancario GCM - App</title>

</head>
<body>
	<jsp:include page='template/header.jsp'>
		<jsp:param name="funcionalidade" value="App"/>
	</jsp:include>

	<div class="form">

		<h3>Menu</h3>
			<form method="post">
				<input type="hidden" name="numero" value="${conta}" />
				<button type="submit" class="menu" onclick="form.action='depositar';">Realizar Depósito</button>
				<button type="submit" class="menu" onclick="form.action='debitar';">Realizar Debito</button>
			 	<button type="submit" class="menu" onclick="form.action='transferir';">Realizar Transferência</button>
			 	<button type="submit" class="menu" onclick="form.action='index'">Sair</button>
			</form>
	</div>
</body>
</html>