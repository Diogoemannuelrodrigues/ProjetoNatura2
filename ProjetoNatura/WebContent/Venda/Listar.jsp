<%@page import="br.com.projetoNatura.entidade.Venda"%>
<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relat�rio de Vendas</title>
</head>
<body>
<div align="center">
	<div id='imprimir' align="center">
		<br>
		<br> <img width="450px" height="250px"
			src="/../ProjetoNatura/imagens/compra-online-natura.jpg" />

		<h1>Listagem de Consultas</h1>


		<table border="1">
			<tr>
				<div align="center">
					<td>Id Venda</td> <a><td>Nome cliente</td></a> <a><td>CPF
							Cliente</td></a> <a>
						<td>Telefone</td>
					</a> <a>
						<td>Produto Comprado</td>
					</a>
					<td>Valor do Produto</td>
					<td>Descri��o</td>
					<td><font color="RED">Actions</td>
			</tr>

			<%
				List<Venda> vendas = (List<Venda>) request.getAttribute("lista");

				for (Venda venda : vendas) {
			%>
			<tr>
				<td align="center"><%=venda.getIdVenda()%></td>
				<td align="center"><%=venda.getCliente().getNome()%></td>
				<td align="center"><%=venda.getCliente().getCpf()%></td>
				<td align="center"><%=venda.getCliente().getTelefone()%></td>
				<td align="center"><%=venda.getProduto().getNome()%></td>
				<td align="center"><%=venda.getProduto().getPreco()%></td>
				<td align="center"><%=venda.getDescricao()%></td>
				<td><a
					href="/ProjetoNatura/Venda?acao=excluir&id=<%=venda.getIdVenda()%>"><font color="RED">Excluir</a></td>
				<>
			</tr>
			<%
				}
			%>
		</table>


		<p>
			<input type="button"
				onclick="location='../../ProjetoNatura/Menu.jsp'"
				value="Menu Principal"><br>
	</div align="center">

</div>
</body>
</html>

