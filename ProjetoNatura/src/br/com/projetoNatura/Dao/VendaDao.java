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
import br.com.projetoNatura.entidade.Venda;

public class VendaDao {

	public static boolean realizaVenda(Venda venda) {

		try {
			Connection con = null;
			con = new Conexao().getConnection();

			PreparedStatement stm = con
					.prepareStatement("INSERT INTO venda (descricao, idCliente, codigoProduto) values (?, ?, ?)");
			stm.setString(1, venda.getDescricao());
			stm.setInt(2, venda.getCliente().getId());
			stm.setInt(3, venda.getProduto().getCodigoProduto());

			stm.execute();

			return true;
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("error cadastrar venda - DAO");
			return false;
		}
	}

	public List<Venda> listar() {

		java.util.List<Venda> vendas = new ArrayList<Venda>();

		try {
			Connection con = null;
			con = new Conexao().getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM venda v JOIN cliente c ON "
					+ "(c.id = v.idCliente)" + "JOIN produto p ON (p.codigoProduto = v.codigoProduto)"
				);
			ResultSet resultado = pst.executeQuery();

			while (resultado.next()) {
				Venda venda = new Venda();

				Produto produto = new Produto();
				produto.setCodigoProduto(resultado.getInt("p.codigoProduto"));
				produto.setNome(resultado.getString("p.nome"));
				produto.setPreco(resultado.getDouble("p.preco"));

				Cliente cliente = new Cliente();
				cliente.setId(resultado.getInt("c.id"));
				cliente.setNome(resultado.getString("c.nome"));
				cliente.setCpf(resultado.getString("c.cpf"));
				cliente.setTelefone(resultado.getString("c.telefone"));

				venda.setIdVenda(resultado.getInt("v.idVenda"));
				venda.setDescricao(resultado.getString("v.descricao"));

				venda.setProduto(produto);
				venda.setCliente(cliente);

				vendas.add(venda);
			}
			pst.close();
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("error cadastrar venda - DAO");

		}
		return vendas;
	}

	public void excluir(Venda venda) {
		String sql = "delete from venda WHERE idVenda=?";
		try {
			Connection con = Conexao.getConnection();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, venda.getIdVenda());
			stm.execute();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
