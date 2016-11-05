package br.com.projetoNatura.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection getConnection()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String url = "jdbc:mysql://localhost:3306/natura?user=root&password=9193jeane8330";
		Connection conexao = DriverManager.getConnection(url);
		System.out.println("PAssando na classe conexao");
		return conexao;
		
	}
}


