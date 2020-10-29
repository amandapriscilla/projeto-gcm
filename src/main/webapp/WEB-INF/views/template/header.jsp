<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
     prefix="c" %>
<div class="header">
	<h1>Sistema Bancario GCM - ${param.funcionalidade}</h1>
	<h4>Conta: ${conta}</h4>
	<h4>Saldo: ${saldo}</h4>
	<c:if test="${not empty bonus}">
	<h4>Bônus: ${bonus}</h4>
	</c:if>
</div>
<hr>