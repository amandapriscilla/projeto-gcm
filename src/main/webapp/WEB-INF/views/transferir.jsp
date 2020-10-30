<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="default.css">

<title>Sistema Bancario GCM - Transferir</title>

</head>
<body>
	<jsp:include page='template/header.jsp'>
		<jsp:param name="funcionalidade" value="Transferir"/>
	</jsp:include>

	<div class="form">
		<form action="transferir" method="post">
			<h4 style="color: red">${erro}</h4>
			<div>
				<input type="hidden" name="numero" value="${conta}" />
				<label>Digite o valor a ser debitado da conta ${conta}:</label><br/>
				<input type="text" name="valor"><br/>
				<label>Digite o numero da conta de destino:</label><br/>
				<input type="text" name="destino"><br/>
				<input type="submit" class="menu" value="Transferir"><br/>
			</div>
		</form>
	</div>

</body>
</html>