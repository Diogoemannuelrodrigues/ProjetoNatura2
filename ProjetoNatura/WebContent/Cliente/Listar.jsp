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

<div align="center">
<% List<Cliente> clientes = (List<Cliente>)request.getAttribute("clientes");%>
<h1>Listar Clientes</h1> 

<div><img width="350px" height="250px" src="/../ProjetoNatura/imagens/clientes.jpg"/></div><br><br>
<table border="1">
		<tr>
		<div align="center">
			<a><td><font color="Orange"><div align="middle">Id</td>
			<a><td><font color="Orange"><div align="middle">Nome cliente</td></a>
			<a><td><font color="Orange"><div align="middle">Telefone</td></a>
			<td><font color="Orange"><div align="middle">Endereco</td>
			<td><font color="Orange"><div align="middle">Cpf</td>
			<td><font color="Orange"><div align="middle">E-mail</td>
			<td><font color="Orange"><div align="middle">Action</td>
		</tr>
		
		<%for (Cliente cliente: clientes) {%>
			<tr>
			<td><%=cliente.getId()%></td>
			<td><%=cliente.getNome()%></td>
			<td><%=cliente.getTelefone()%></td>
			<td><%=cliente.getEndereco()%></td>
			<td><%=cliente.getCpf()%></td>
			<td><%=cliente.getEmail()%></td>
			<td><a href="/ProjetoNatura/cliente?acao=consultarPorId&id=<%= cliente.getId()%>"><font color="BLUE">Alterar</a>
			<a href="/ProjetoNatura/cliente?acao=excluir&id=<%= cliente.getId()%>"><font color="RED">Excluir</a></td>
			</tr>
		<% 		
		}
		%>

		</table>
		
<p><input type="button" onclick="location='../../../ProjetoNatura/Cliente/CadastroCliente.jsp'" value="Voltar"><br>
		   <p><input type="button" onclick="location='../../ProjetoNatura/Menu.jsp'" value="Menu Principal"><br>
</div align="center">


</body>
</html>
