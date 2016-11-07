<%@page import="br.com.projetoNatura.entidade.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar dados do Cliente </title>
</head>
<body>
<% Cliente cliente;%>
<% cliente = (Cliente) request.getAttribute("cliente"); %>

<form action="/ProjetoNatura/cliente?acao=alterarCliente" method="post">  
<input type="hidden" name="acao" value="alterarCliente"/>
<input  type="hidden"  size ="25" name="id" value="<%=cliente.getId()%>" />
<div align="center">
<div><img width="350px" height="250px" src="/../ProjetoNatura/imagens/clientes.jpg"/></div>
		<br><br>
		
        
 					
           	Nome <input  type="text"  size ="25" name="nome" value="<%=cliente.getNome()%>" ><br>
		    
		    Telefone:<input  type="text"  size ="25" name="telefone" value="<%=cliente.getTelefone()%>"><br>

			Endereço:<input  type="text"  size ="25" name="endereco" value="<%=cliente.getEndereco()%>" ><br>
			
			Cpf:<input  type="text"  size ="25" name="cpf" value="<%=cliente.getCpf()%>" ><br>
			
			E-mail:<input  type="text"  size ="25" name="email" value="<%=cliente.getEmail()%>" ><br><br>
					
					<input type="submit" name="alterar" value="Alterar"/> 
					
<!-- 					<input type="button" onclick="location='../../ProjetoNatura/Cliente?acao=consultarTodos'" value=""> -->
										
		             <p><input type="button" onclick="location='../../ProjetoNatura/Menu.jsp'" value="Menu Principal"><br>
</div>


			
</form>	
</body>
</html>
