<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "entrando.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h3>Bem vindo ao Projeto1!</h3>
		<div>
			<form action="./LoginServlet" method="post">
				Usuário: <input type="text" name="usuariologin"> 
				<br>
				Senha:   <input type="password" name="senhalogin"> 
				<br>
				<input type="submit" name="login">
			</form>
		</div>	
		<a href='/NotasLegais/cadastro.jsp'>Ainda não é cadastrado? Cadastre-se!</a>
	</body>
</html>