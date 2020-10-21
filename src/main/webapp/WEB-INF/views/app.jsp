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

			<form action="creditar" method="post">
  			 <button type="submit" name="valor">Realizar Credito</button>
			</form>
			<form action="debitar" method="post">
  			 <button type="submit" name="valor">Realizar Debito</button>
			</form>
		
		<ul>
			<li><a href="#">Realizar Transferência</a></li>
		</ul>
	</div>

</body>
</html>