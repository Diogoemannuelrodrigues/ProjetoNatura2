<%@page import="br.com.projetoNatura.bo.ProdutoBo"%>
<%@page import="br.com.projetoNatura.entidade.Produto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar</title>
</head>
<body>
<form>
<div align="CENTER">
<%List<Produto> produtos = (List<Produto>) request.getAttribute("produtos"); %>
<h1>Listar Produtos</h1>
<div><img width="350px" height="250px" src="/../ProjetoNatura/imagens/Pedidos-Natura-221010.jpg"/></div>
<br><br>
<table border="1">
		<tr>
		<div align="center">
			<a><td><font color="Orange"><div align="middle">Nome-Produto</td></a>
			<a><td><font color="Orange"><div align="middle">Descricao</td>
			<a><td><font color="Orange"><div align="middle">Preco</td>
			<td><font color="Orange"><div align="middle">Action</td>
			<td><font color="Orange"><div align="middle">Action</td>
		</tr>
	
	<% for (Produto produto : produtos){%>
	<% 
	out.print("<tr>"); 
	out.print("<td>"+produto.getNome()+"</td>"); 
	out.print("<td>"+produto.getDescricao()+"</td>");
	out.print("<td>"+produto.getPreco()+"</td>");
	out.print("<td><a href='Produto?acao=consultarProduto&id="+produto.getCodigoProduto()+"'>Alterar</a></td>"); 
	out.print("<td><a href='Produto?acao=excluir&codigoProduto="+produto.getCodigoProduto()+"'>Excluir</a></td>");
	out.print("</tr>"); 
	
	
	}
	%>
	</table>
	
	<p><input type="button" onclick="location='../ProjetoNatura/Produto/Cadastro.jsp'" value="Voltar"><br>
	
	
	<p><input type="button" onclick="location='../../ProjetoNatura/Menu.jsp'" value="Menu Principal"><br>
	</div>
	<br>
</form>
</body>
</html>