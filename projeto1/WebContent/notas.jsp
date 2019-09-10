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
	
	
	<% int id = (int) request.getAttribute("id"); %>
	<% String nome = (String) request.getAttribute("nome"); %>
	<div class="cadastrinho">
		<h3>Cadastrar nova nota</h3>
		<form action="./NotaServlet" method="post"> 
			<input class="pequenos" type="hidden" name="id"  value="<%=id%>"> 
	        <input class="pequenos" type="hidden" name="nome" value="<%=nome%>"> 
			Nota: <input type="text" name="nota"> 
			<input type="submit" name="cadastro">
			<br>
		</form>
	</div>	
	
	<div class="notas">
		<% DAO dao = new DAO();
 			List<Notas> notas = dao.getLista();
 			for (Notas nota : notas ) { %>
 			<div class="listinha">
	 			<article class="nota"><%=nota.getNota()%></article>
				<footer class="autor">Autor: <%=nota.getAutor()%></footer>
				<footer class="autor">ID: <%=nota.getIdAutor()%></footer>	
				<form action="./ApagarNotaServlet" method="post"> 
					<input class="pequenos" type="hidden" name="id_autor"  value="<%=nota.getIdAutor()%>"> 
					<input class="pequenos" type="hidden" name="id" value="<%=id%>"> 
			        <input class="pequenos" type="hidden" name="nome_autor" value="<%=nota.getAutor()%>"> 
					<input class="pequenos" type="hidden" name="nome" value="<%=nome%>"> 
					<input class="pequenos" type="hidden" name="nota" value="<%=nota.getNota()%>"> 
					<input type="submit" name="apagar" value="Apagar">
				</form>
				
				<form action="./AlterarServlet" method="post"> 
					<input class="pequenos" type="hidden" name="id_autor"  value="<%=nota.getIdAutor()%>"> 
				
					<input class="pequenos" type="hidden" name="id" value="<%=id%>"> 
					
			        <input class="pequenos" type="hidden" name="nome_autor" value="<%=nota.getAutor()%>"> 
					
					<input class="pequenos" type="hidden" name="nome" value="<%=nome%>"> 
					
					<input class="pequenos" type="hidden" name="nota" value="<%=nota.getNota()%>"> 
				
					<input type="submit" name="alterar" value="Alterar">
				</form>
				
			
			</div>
			<% } %>
	
	</div>
		
		
	</body>
</html>