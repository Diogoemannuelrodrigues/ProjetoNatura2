<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro Produto</title> 
</head>
<body>
<form action="../../ProjetoNatura/Produto" method="post">

<div align="CENTER">
<div><img width="399px" height="250px" src="/../ProjetoNatura/imagens/natuP.jpg"/></div>
<h1>Cadastro</h1>
<br><fieldset style="width: 25%">
<legend>Cadastro-Produtos:</legend></br>
		<input type="hidden" name="acao" value="cadastrar" />
		Nome.:           <input type="text" name="nome"></br>
		Descricao.:      <input type="text" name="descricao"></br>
		Preço.:          <input type="text" name="preco"></br>
		             </br><input type="submit" value="Cadastrar"><br>
		             
		             </br><input type="button" onclick="location='../../ProjetoNatura/Produto?acao=consultarTodos'" value="Listar"><br>
		             
		             <p><input type="button" onclick="location='../../ProjetoNatura/Menu.jsp'" value="Menu Principal"><br>
</div>
<div>
</div>
</form>
</body>
</html>

