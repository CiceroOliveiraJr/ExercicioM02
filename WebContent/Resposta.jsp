<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resposta</title>
</head>
<body>
		
	<h1>Resposta</h1>
	
	<% 
	
	
	String nome = request.getParameter("nome");
	String cpf = request.getParameter("cpf");
	String email = request.getParameter("email");
	String datanascimento = request.getParameter("datanascimento");
	String sexo = request.getParameter("sexo");
	String nomesocial = request.getParameter("nomesocial");
	String apelido = request.getParameter("apelido");
	String telefone = request.getParameter("telefone");
	
	
	out.print("<b>Nome:</b> " +nome+ "<br/>");
	out.print("<b>CPF:</b> " +cpf+ "<br/>" );
	out.print("<b>E-mail:</b> " +email+ "<br/>");
	out.print("<b>Data de Nascimento:</b> " +datanascimento+ "<br/>");
	out.print("<b>Sexo:</b> " +sexo+ "<br/>");
	out.print("<b>Nome Social:</b> " +nomesocial+ "<br/>");
	out.print("<b>Apelido:</b> " +apelido+ "<br/>");
	out.print("<b>Telefone:</b> " +telefone+ "<br/>");
	out.print("<hr>");
	
	
	%>

</body>
</html>