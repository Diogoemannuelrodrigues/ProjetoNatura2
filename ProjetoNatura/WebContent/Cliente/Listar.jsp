<%@page import="br.com.projetoNatura.entidade.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ListarCliente</title>
</head>
<body>
<form>
<div align="CENTER">
<% List<Cliente> clientes = (List<Cliente>)request.getAttribute("clientes");%>
<h1>Listar Clientes</h1> 

<div><img width="350px" height="250px" src="/../ProjetoNatura/imagens/clientes.jpg"/></div><br><br>
<table border="1">
		<tr>
		<div align="center">
			<td>Id.:</td>
			<a><td>Nome-Cliente.:</td></a>
			<td>Endereco.:</td>
			<td>Cpf.:</td>
			<td>E-mail.:</td>
			<td></td>
		</tr>
		
		<%for (Cliente cliente: clientes) {%>
			<%
			out.print("<tr>"); 
			out.print("<td>"+cliente.getId()+"</td>");
			out.print("<td>"+cliente.getNome()+"</td>"); 
			out.print("<td>"+cliente.getEndereco()+"</td>");
			out.print("<td>"+cliente.getCpf()+"</td>");
			out.print("<td>"+cliente.getEmail()+"</td>");
			out.print("<td><a href='ProjetoNatura/Cliente?acao=consultarTodos="+cliente.getId()+"'>Alterar</a></td>"); 
			out.print("<td><a href='ProjetoNatura/Cliente?acao=excluir&id="+cliente.getId()+"'>Excluir</a></td>");
			out.print("</tr>");
			
		}
		%>
		</table>
		
			<p><input type="button" onclick="location='../../ProjetoNatura/Cliente/CadastroCliente.jsp'" value="Voltar"><br>
		             <p><input type="button" onclick="location='../../ProjetoNatura/Menu.jsp'" value="Menu Principal"><br>
</div align="center">

</form>
</body>
</html>