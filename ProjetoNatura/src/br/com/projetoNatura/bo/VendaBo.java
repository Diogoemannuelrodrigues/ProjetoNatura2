package br.com.projetoNatura.bo;

import java.util.List;

import br.com.projetoNatura.Dao.VendaDAO;
import br.com.projetoNatura.entidade.Venda;

public class VendaBo {
	VendaDAO dao = new VendaDAO();
	
	public List<Venda> listarVenda(){
		return dao.mostrarVendas(); 
	}
	
	public void realizarVenda(Venda venda){
		dao.realizaVenda(venda);
	}
	

}
