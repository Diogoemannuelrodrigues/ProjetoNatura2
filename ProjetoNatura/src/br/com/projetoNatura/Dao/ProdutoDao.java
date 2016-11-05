package br.com.projetoNatura.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import br.com.projetoNatura.conexao.Conexao;
import br.com.projetoNatura.entidade.Produto;

public class ProdutoDao {

	Connection con = null;

	public void cadastrarProduto(Produto produto) {
		String sql = "insert into Produto (nome,descricao, preco) values (?,?,?)";
		try {
			try {
				con = Conexao.getConnection();
				PreparedStatement stm = con.prepareStatement(sql);
				stm.setString(1, produto.getNome());
				stm.setString(2, produto.getDescricao());
				stm.setDouble(3, produto.getPreco());
				stm.execute();
				con.close();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
		}

	}

	public Produto buscarProdutoPorId(int id) throws ClassNotFoundException, SQLException {
		// Produto produto = null;
		// Connection con = Conexao.getConexao();
		String sql = "select * from produto where id = ?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet set = stm.executeQuery();
			while (set.next()) {
				Produto produto = new Produto();
				produto.setCodigoProduto(set.getInt("codigoProduto"));
				produto.setNome(set.getString("nome"));
				produto.setDescricao(set.getString("descricao"));
				produto.setPreco(set.getDouble(("preco")));

			}
			System.out.println("Encontrado");

			set.close();
			stm.close();
		} catch (SQLException e) {
			throw new RuntimeErrorException(null, "Nao foi encontrado produto com esse id");
		}
		return null;
	}

	// public static void alterarProduto(Produto produto) throws
	// ClassNotFoundException, SQLException {
	// //Connection con = Conexao.getConexao();
	// try {
	// PreparedStatement stm = con.prepareStatement("UPDATE produto set nome =
	// ?, descricao = ?, preco = ? where codigoProduto = ?");
	// stm.setString(1, produto.getNome());
	// stm.setString(2, produto.getDescricao());
	// stm.setDouble(4, produto.getPreco());
	// stm.setInt(4, produto.getCodigoProduto());
	//
	// stm.execute();
	// System.out.println("Alterado com sucesso:.");
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//
	// }

	public void excluirProduto(Produto produto) {
		String sql = "delete from produto where id=?";
		try {
			Connection con = Conexao.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, produto.getCodigoProduto());
			ps.execute();
		} catch (Exception e) {
			System.out.println("Produto Excluido com sucesso");
			e.printStackTrace();
		}
	}

	public List<Produto> produtos() {
		List<Produto> lista = new ArrayList<Produto>();
		String sql = "select * from produto order by codigoProduto";		
			try {
				con = Conexao.getConnection();
				PreparedStatement stm = con.prepareStatement(sql);
				ResultSet result = stm.executeQuery();
				while (result.next()) {
					Produto produto = new Produto();
					produto.setNome(result.getString("nome"));
					produto.setCodigoProduto(result.getInt("codigoProduto"));
					produto.setDescricao(result.getString("descricao"));
					produto.setPreco(result.getDouble("preco"));
					lista.add(produto);
				}
				result.close();
				con.close();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException  | SQLException e) {
				e.printStackTrace();
			}

		return lista;
	}
}