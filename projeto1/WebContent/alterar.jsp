<!DOCTYPE html>
<%@ page import="java.util.*,projeto1.*" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "notas.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% int id_autor = (int) request.getAttribute("id_autor"); %>
	<% int id = (int) request.getAttribute("id"); %>
	<% String nome = (String) request.getAttribute("nome"); %>
	<% String nome_autor = (String) request.getAttribute("nome_autor"); %>
	<% String nota = (String) request.getAttribute("nota"); %>
	<div class="cadastrinho">
		<h3>Alterar nota</h3>
		<form action="./AlterarNotaServlet" method="post"> 
			<input class="pequenos" type="hidden" name="id"  value="<%=id%>"> 
			<input class="pequenos" type="hidden" name="id_autor"  value="<%=id_autor%>"> 
			
	        <input class="pequenos" type="hidden" name="nome" value="<%=nome%>"> 
			
			<input class="pequenos" type="hidden" name="nome_autor" value="<%=nome_autor%>"> 
			
			<input class="pequenos" type="hidden" name="nota" value="<%=nota%>"> 
			
			Nota: <input class="pequenos" type="text" name="nova_nota" value="<%=nota%>"> 
			<br>
			<input type="submit" name="alterar" value="Alterar">
		</form>
	</div>	
	
		
		
	</body>
</html>