<%@page import="br.com.projetoNatura.entidade.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Produto</title>
</head>
<body>
<%Produto produto;%>
<%produto = (Produto) request.getAttribute("produto"); %>
<form action="../../ProjetoNatura/Produto?acao=AlterarProduto" method="post">
<div align="CENTER">
<h1>Alterar:</h1>
	
<fieldset style="width: 25%">
<legend>Cadastro-Produtos</legend></br>

<input type="hidden" name="acao" value="AlterarProduto"/>

<input type="hidden" size="25" name="id" value="<%=produto.getCodigoProduto() %>">
		<input type="hidden" name="acao" value="AlterarProduto" />
		Nome:           <input type="text" name="nome" value="<%=produto.getNome() %>"> </br>
		Descricao:      <input type="text" name="descricao"value="<%=produto.getDescricao() %>"></br>
		Preço:          <input type="text" name="preco"value="<%=produto.getPreco()%>"></br>
		             </br><input type="submit" value="Alterar">
		             
		             
    <p><input type="button" onclick="location='../../ProjetoNatura/Menu.jsp'" value="Menu Principal"><br>
		             
</div>
<div>
<!-- <body background="home/diogoemannuel/Área de trabalho/ImagensNatura/maxresdefault.jpg"></body> -->
</div>
</fieldset>
</form>
</body>
</html>