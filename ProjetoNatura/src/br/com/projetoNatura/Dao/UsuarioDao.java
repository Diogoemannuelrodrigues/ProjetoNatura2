package br.com.projetoNatura.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.projetoNatura.conexao.Conexao;
import br.com.projetoNatura.entidade.Usuario;

public class UsuarioDao {

	public boolean autenticar(Usuario usuario){
		String sql = "select * from usuario where usuariologin = ? and usuariosenha = ?";
		boolean ret = false;
		try {
			Connection conexao = Conexao.getConnection();
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setString(1, usuario.getUsarioLogin());
			stm.setString(2, usuario.getUsarioSenha());

			ResultSet resultado = stm.executeQuery();
			if(resultado.next()){
				ret = true;
			}
			
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ret;
		
	}
}


