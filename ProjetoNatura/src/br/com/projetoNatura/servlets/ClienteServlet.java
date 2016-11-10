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

	Cliente cliente = new Cliente();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

		String acao = req.getParameter("acao");

		if (acao.equals("excluir")) {
			cliente.setId(Integer.parseInt(req.getParameter("id")));
			clienteBo.excluirCliente(cliente);
			resp.sendRedirect("/ProjetoNatura/cliente?acao=consultarTodos");

		} else if (acao.equals("consultarPorId")) {
			cliente = clienteBo.consultarPorId(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("cliente", cliente);

			req.getRequestDispatcher("/Cliente/alterarCliente.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String acao = req.getParameter("acao");

		if (acao.equals("cadastrar")) {
			cliente.setNome(req.getParameter("nome"));
			cliente.setTelefone(req.getParameter("telefone"));
			cliente.setEndereco(req.getParameter("endereco"));
			cliente.setCpf(req.getParameter("cpf"));
			cliente.setEmail(req.getParameter("email"));
			clienteBo.cadastar(cliente);
			req.getRequestDispatcher("resultado/ClienteCadastrado.jsp").forward(req, resp);
			
		} else if (acao.equals("consultarTodos")) {
			try {
				List<Cliente> clientes = clienteBo.consultarTodos();
				req.setAttribute("clientes", clientes);
				req.getRequestDispatcher("Cliente/Listar.jsp").forward(req, resp);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		} else if (acao.equals("alterarCliente")) {
			cliente.setId(Integer.parseInt(req.getParameter("id")));
			cliente.setNome(req.getParameter("nome"));
			cliente.setTelefone(req.getParameter("telefone"));
			cliente.setEndereco(req.getParameter("endereco"));
			cliente.setCpf(req.getParameter("cpf"));
			cliente.setEmail(req.getParameter("email"));

			clienteBo.alterarCliente(cliente);
			resp.sendRedirect("../ProjetoNatura/cliente?acao=consultarTodos");

		
		}
	}
}