<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Clientes</title>
</head>
<body>
<form action="../../ProjetoNatura/cliente" method="post">
<div align="CENTER">
<h1>Cadastro.:</h1>
<img width="350px" height="250px" src="/../ProjetoNatura/imagens/clientes.jpg"/><br>

<fieldset style="width: 35%">

<legend>Cadastro-Clientes:</legend></br>
		Nome-Cliente.:           <input type="text" name="nome"></br>
		Telefone.:      <input type="text" name="telefone"></br>
		Endere�o.:          <input type="text" name="endereco"></br>
		CPF.:          <input type="text" name="cpf"></br>
		E-mail.:          <input type="text" name="email"></br>
		
	<input  type="hidden" name="acao" value="cadastrar">
		             </br><input type="submit" value="cadastrar"><br>

<p><input type="button" onclick="location='../../ProjetoNatura/cliente?acao=consultarTodos'" value="Listar"><br>

		             
<p><input type="button" onclick="location='../../ProjetoNatura/Menu.jsp'" value="Menu Principal"><br>


</fieldset>


</div>
</form>
</body>
</html>