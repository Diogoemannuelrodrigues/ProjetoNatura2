package br.com.projetoNatura.bo;

import java.util.List;

import br.com.projetoNatura.Dao.VendaDAO;
import br.com.projetoNatura.entidade.Venda;

public class VendaBo {
	
	public List<Venda> listarVenda(){
		return VendaDAO.mostrarVendas(); 
	}

}
