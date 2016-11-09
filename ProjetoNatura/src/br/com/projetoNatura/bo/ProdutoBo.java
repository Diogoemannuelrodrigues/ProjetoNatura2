package br.com.projetoNatura.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.projetoNatura.Dao.ClienteDao;
import br.com.projetoNatura.Dao.ProdutoDao;
import br.com.projetoNatura.Exception.DescricaoException;
import br.com.projetoNatura.Exception.NomeException;
import br.com.projetoNatura.entidade.Cliente;
import br.com.projetoNatura.entidade.Produto;

public class ProdutoBo {
	
	ProdutoDao dao = new ProdutoDao();
	
	public void cadastrarProduto(Produto produto) throws ClassNotFoundException, SQLException {
		dao.cadastrarProduto(produto);
	}

	public Produto consultarProduto(int codigoProduto) {
		return dao.buscarProdutoPorId(codigoProduto);

	}
	
	public void alterarProduto( Produto produto) {
		dao.alterarProduto(produto);
	}
	
	public static List<Produto> produtos () throws ClassNotFoundException, SQLException{
		ProdutoDao dao = new ProdutoDao();
		return dao.produtos();
	}
	
	public void excluir(Produto produto){
		ProdutoDao dao = new ProdutoDao();
		dao.excluirProduto(produto);
	
	}
	
	

}
