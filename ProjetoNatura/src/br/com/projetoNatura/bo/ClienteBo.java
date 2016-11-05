package br.com.projetoNatura.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.projetoNatura.Dao.ClienteDao;
import br.com.projetoNatura.entidade.Cliente;

public class ClienteBo {

	public boolean cadastar(Cliente cliente) {
		ClienteDao dao = new ClienteDao();
		dao.cadastrarCliente(cliente);
		return true;

	}

	public static List<Cliente> consultarTodos() throws ClassNotFoundException, SQLException {
		ClienteDao dao = new ClienteDao();
		return dao.clientes();
	}

	public void alterarCliente(Cliente cliente) {
		ClienteDao dao = new ClienteDao();
		dao.alterarCliente(cliente);
	}

	public Cliente consultarPorId(int id){
		ClienteDao dao = new ClienteDao();	
		return dao.consultarPorId(id); 
	}
	
	public void excluirCliente(Cliente cliente){
		ClienteDao dao = new ClienteDao();
		dao.excluirCliente(cliente);
	
	}

}
