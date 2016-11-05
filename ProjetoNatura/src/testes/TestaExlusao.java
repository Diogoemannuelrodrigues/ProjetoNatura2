package testes;

import br.com.projetoNatura.Dao.ClienteDao;
import br.com.projetoNatura.entidade.Cliente;

public class TestaExlusao {

	public static void main(String[] args) {
		testaExcluir();
	}

	public static void testaExcluir() {
		ClienteDao clientedao = new ClienteDao();
		Cliente cliente = new Cliente();
		cliente.setId(1);
		clientedao.excluirCliente(cliente);
		
	}
}
