package br.com.projetoNatura.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.Response;

import br.com.projetoNatura.bo.ClienteBo;
import br.com.projetoNatura.entidade.Cliente;
import br.com.projetoNatura.entidade.Produto;

public class ClienteServlet extends HttpServlet {

	ClienteBo clienteBo = new ClienteBo();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
//Teste para dar um novo comit
	//vamos fazer teste
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");
		Cliente cliente = new Cliente();
		ClienteBo clienteBo = new ClienteBo();	
	
		if (acao.equals("cadastrar")) {
			cliente.setNome(req.getParameter("nome"));
			cliente.setTelefone(req.getParameter("telefone"));
			cliente.setEndereco(req.getParameter("endereco"));
			cliente.setCpf(req.getParameter("cpf"));
			cliente.setEmail(req.getParameter("email"));
			clienteBo.cadastar(cliente);
//teste final
			req.getRequestDispatcher("resultado/ClienteCadastrado.jsp").forward(req, resp);

		}else if(acao !=null && acao.equals("consultarTodos")){
			try{
				List<Cliente> clientes = clienteBo.consultarTodos();
				req.setAttribute("clientes", clientes);
				req.getRequestDispatcher("Cliente/Listar.jsp").forward(req, resp);
			}catch (ClassNotFoundException | SQLException e){
				e.printStackTrace();
			}	
		}else if (acao !=null && acao.equals("alterarCliente")) {
			cliente.setId(Integer.parseInt(req.getParameter("Id")));
			cliente.setNome(req.getParameter("nome"));
			cliente.setTelefone(req.getParameter("telefone"));
			cliente.setEndereco(req.getParameter("endereco"));
			cliente.setCpf(req.getParameter("cpf"));
			cliente.setEmail(req.getParameter("email"));

			clienteBo.alterarCliente(cliente);
			resp.sendRedirect("../ProjetoNatura/resultado/alterado.jsp");
			
		}else if(acao != null && acao.equals("excluir")){
//			cliente.setId(req.getParameter("id");
			clienteBo.excluirCliente(cliente);
		}else if(acao != null && acao.equals("consultarPorId")){
			cliente=clienteBo.consultarPorId(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("cliente", cliente);
			
			req.getRequestDispatcher("../Cliente/alterarCliente.jsp").forward(req, resp);
		}else {
			System.out.println("in here");
		}
	}
}