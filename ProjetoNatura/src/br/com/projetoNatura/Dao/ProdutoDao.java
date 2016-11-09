package br.com.projetoNatura.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import br.com.projetoNatura.conexao.Conexao;
import br.com.projetoNatura.entidade.Cliente;
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

public Produto consultarProduto(int codigoProduto) {
	Produto produto = new Produto();		
		try {
			Connection con = Conexao.getConnection();
			PreparedStatement stm = con.prepareStatement("select * from produto where codigoProduto = ?");
			stm.setInt(1, codigoProduto);
			ResultSet rSet = stm.executeQuery();
			while (rSet.next()) {
				
				produto.setCodigoProduto(rSet.getInt("codigoProduto"));
				produto.setNome(rSet.getString("nome"));
				produto.setDescricao(rSet.getString("descricao"));
				produto.setPreco(rSet.getInt("preco"));
				rSet.close();
				stm.close();
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return produto;
	}

	public static void alterarProduto(Produto produto) {
		try {
			Connection con = Conexao.getConnection();
			PreparedStatement stm = con.prepareStatement("UPDATE produto set nome = ?, descricao = ?,"
							+ " preco = ? where codigoProduto = ?");
			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());
			stm.setDouble(3, produto.getPreco());
			stm.setInt(4, produto.getCodigoProduto());

			stm.executeUpdate();
			System.out.println("Alterado com sucesso:.");
		} catch (ClassNotFoundException | SQLException |InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

	}

	public void excluirProduto(Produto produto) {
		String sql = "delete from produto WHERE codigoProduto=?";
		try {
			Connection con = Conexao.getConnection();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, produto.getCodigoProduto());
			stm.execute();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
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
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
}