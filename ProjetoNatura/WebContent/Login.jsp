<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tela login</title>
</head>
<body>

<br><br><br><br>
<fieldset style="width: 50%; margin-left: 25%">
<legend>Login</legend>
	<form action="usuario"method="post">

		<div align="center">
		<img src="imagens/natura-logo.jpg"height="150"width="150" WIDTH=20% /><br><br>

		<td> Login <input type="text" name="login" /></td><br><br>
		<td> Senha <input type="password" name="senha" /></td>
		<br><br>
		<input type="submit" value="Logar" />
		<input type="reset" value="Limpar" class="myButton2">
		</div>
	</form>
</fieldset>
	
</body>
</html>