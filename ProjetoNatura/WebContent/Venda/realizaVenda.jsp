
<%@page import="br.com.projetoNatura.entidade.Produto"%>
<%@page import="br.com.projetoNatura.entidade.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Realização de Venda</title>
</head>

<body>

<div align="center">
<img width="350px" height=250px" src="/../ProjetoNatura/imagens/compra-online-natura.jpg"/><br>
<h1>Venda</h1>
	<form action="/ProjetoNatura/Venda" method="post">

	Cliente: <select name="id" required="required">
			
				<option value="">Procurar</option>
				<%
				List<Cliente> lista = (List<Cliente>) request.getAttribute("lista");
				
				for(Cliente clientevo : lista){
				%>	
				<option value="<%= clientevo.getId()%>"><%= clientevo.getNome() %></option>
				<%
				}
				%>
			</select><br><br>
			
	Produto: <select name="codigoProduto" required="required">
			
				<option value="">Selecione</option>
				<%
				List<Produto> lista1 = (List<Produto>) request.getAttribute("lista1");
				
				for(Produto produtovo : lista1){
				%>	
				<option value="<%= produtovo.getCodigoProduto()%>"><%= produtovo.getNome() %></option>
				<%
				}
				%>
			</select><br><br>

	Descrição: <textarea cols=40 rows="5" name="descricao" maxlength="200" wrap="hard" ></textarea>
		
		<input type="hidden" name="acao" value="realizaVenda">
		<BR><BR><BR>
		<input type="submit" name="enviar" value="Vender" class="myButton2">
		<input type="reset" value="Limpar" class="myButton2">
	
	</form>
	
		<br>
		
		   <p><input type="button" onclick="location='../../ProjetoNatura/Menu.jsp'" value="Menu Principal"><br>
</div>
</body>
</html>