package br.com.projetoNatura.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetoNatura.conexao.Conexao;
import br.com.projetoNatura.entidade.Cliente;
import br.com.projetoNatura.entidade.Venda;

public class VendaDAO {

	public void realizaVenda(Venda venda) {

		try {
			Connection con = Conexao.getConnection();
			PreparedStatement stm = con.prepareStatement("insert into venda (codigoProduto, idCliente, descricao) values (?,?,?)");
			stm.setInt(1, venda.getProduto().getCodigoProduto());
			stm.setInt(2, venda.getCliente().getId());
			stm.setString(3, venda.getDescricao());
			stm.execute();
			stm.close();
			con.close();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
}
		
		public static List<Venda> mostrarVendas(){
			List<Venda> vendas = new ArrayList<Venda>();
			Venda venda = new Venda();
			Cliente cliente = new Cliente();
			ClienteDao dao = new ClienteDao();
			ProdutoDao daoP = new ProdutoDao();
			try{
				Connection con = Conexao.getConnection();
				PreparedStatement stm = con.prepareStatement("select * from venda "); //arrumar depois igual o do josue
				ResultSet sul = stm.executeQuery();
				while(sul.next()){
					venda.setCliente(dao.consultarPorId(sul.getInt("id")));
					venda.setProduto(daoP.consultarProduto(sul.getInt("codigoProduto")));
					venda.setDescricao(sul.getString("descricao"));
					vendas.add(venda);
				}
				sul.close();
				stm.close();
				con.close();
				
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return vendas;
		}
	}


