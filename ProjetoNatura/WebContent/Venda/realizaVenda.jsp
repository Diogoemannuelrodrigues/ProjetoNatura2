<%@page import="br.com.projetoNatura.entidade.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="br.com.projetoNatura.entidade.Produto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Realiza venda</title>
<%List<Produto> produtos = (List<Produto>) request.getAttribute("produtos"); %>
<% List<Cliente> clientes = (List<Cliente>)request.getAttribute("clientes");%>
</head>
<body>
	<form action="../../ProjetoNatura/Venda" method="post">
		<div align="CENTER">
			<h1>VENDA:</h1>

			<fieldset style="width: 35%">
				<legend>Venda</legend>
				<td>
				<div>
				<select name="codigoProduto">
					<%for (Produto produto: produtos){ %>
						<option value="<%produto.getCodigoProduto(); %>">
						<%=produto.getNome() %>
						</option>
					<% }%> 
				</div>
				<select name="id">
					<%for (Cliente cliente: clientes){ %>
						<option value="<%cliente.getId(); %>">
						<%=cliente.getNome() %>
						</option>
					<% }%> 
				</div>
				<input type="submit" value="vender"><br>
				<p>
					<input type="button"
						onclick="location='../../ProjetoNatura/Menu.jsp'"
						value="Menu Principal"><br>
			</fieldset>


		</div>
	</form>
</body>
</html>