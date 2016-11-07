package br.com.projetoNatura.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetoNatura.conexao.Conexao;
import br.com.projetoNatura.entidade.Cliente;
import br.com.projetoNatura.entidade.Produto;

public class ClienteDao {
	Connection conexao = null;

	public void cadastrarCliente(Cliente cliente) {

		try {
			conexao = Conexao.getConnection();
			PreparedStatement stm = conexao
					.prepareStatement("insert into cliente (nome, endereco, telefone, cpf,email) values(?,?,?,?,?)");
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getEndereco());
			stm.setString(3, cliente.getTelefone());
			stm.setString(4, cliente.getCpf());
			stm.setString(5, cliente.getEmail());
			stm.execute();
			stm.close();
			conexao.close();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	public Cliente consultarPorId(int id) {
		
		Cliente cliente = new Cliente();
		try {
			Connection con = Conexao.getConnection();
			PreparedStatement stm = con.prepareStatement("select * from cliente where id = ?");
			stm.setInt(1, id);
			ResultSet rSet = stm.executeQuery();
			while (rSet.next()) {
				
				cliente.setId(rSet.getInt("id"));
				cliente.setNome(rSet.getString("nome"));
				cliente.setTelefone(rSet.getString("telefone"));
				cliente.setEndereco(rSet.getString("endereco"));
				cliente.setCpf(rSet.getString("cpf"));
				cliente.setEmail(rSet.getString("email"));
				rSet.close();
				stm.close();
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}

	public static void alterarCliente(Cliente cliente) {

		try {
			Connection con = Conexao.getConnection();
			PreparedStatement stm = con.prepareStatement(
					"UPDATE cliente set nome = ? , endereco = ?, telefone = ?, cpf = ?, email = ? WHERE id = ?");
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getEndereco());
			stm.setString(3, cliente.getTelefone());
			stm.setString(4, cliente.getCpf());
			stm.setString(5, cliente.getEmail());
			stm.setInt(6, cliente.getId());
			stm.executeUpdate();
			stm.close();
			con.close();

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Cliente> clientes() throws ClassNotFoundException, SQLException {
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		String sql = "select * from cliente order by id";
		try {
			conexao = Conexao.getConnection();
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet result = stm.executeQuery();
			while (result.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(result.getInt("id"));
				cliente.setNome(result.getString("nome"));
				cliente.setTelefone(result.getString("telefone"));
				cliente.setEndereco(result.getString("endereco"));
				cliente.setCpf(result.getString("cpf"));
				cliente.setEmail(result.getString("email"));
				listaCliente.add(cliente);
			}
			result.close();
			conexao.close();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return listaCliente;
	}

	public void excluirCliente(Cliente cliente) {
		String sql = "delete from cliente WHERE id=?";
		try {
			Connection con = Conexao.getConnection();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, cliente.getId());
			stm.execute();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}