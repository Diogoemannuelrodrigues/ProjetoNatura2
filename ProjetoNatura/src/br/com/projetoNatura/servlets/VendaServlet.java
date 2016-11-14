package br.com.projetoNatura.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.projetoNatura.bo.ClienteBo;
import br.com.projetoNatura.bo.ProdutoBo;
import br.com.projetoNatura.bo.VendaBo;
import br.com.projetoNatura.entidade.Cliente;
import br.com.projetoNatura.entidade.Produto;
import br.com.projetoNatura.entidade.Venda;

public class VendaServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		Cliente cliente = new Cliente();
		ClienteBo clientebo = new ClienteBo();
		Produto produto = new Produto();
		ProdutoBo produtobo = new ProdutoBo();
		Venda venda = new Venda();
		VendaBo vendabo = new VendaBo();

		if (req.getParameter("acao").equals("realizaVenda")) {

			Cliente clientevo = new Cliente();
			clientevo.setId(Integer.parseInt(req.getParameter("id")));

			Produto produtovo = new Produto();
			produtovo.setCodigoProduto(Integer.parseInt(req.getParameter("codigoProduto")));

			venda.setProduto(produtovo);
			venda.setCliente(clientevo);

			venda.setDescricao(req.getParameter("descricao"));

			vendabo.realizaVenda(venda);

			resp.sendRedirect("/ProjetoNatura/Venda?acao=listar");
		}

		if (req.getParameter("acao").equals("listar")) {

			List<Venda> vendas = vendabo.listar();

			req.setAttribute("lista", vendas);

			RequestDispatcher saida = req.getRequestDispatcher("/Venda/Listar.jsp");
			saida.forward(req, resp);
		}
		 if(req.getParameter("acao").equals("excluir")){
				
				venda.setIdVenda(Integer.parseInt(req.getParameter("id")));
				vendabo.excluir(venda);
				resp.sendRedirect("/ProjetoNatura/Venda?acao=listar");
			}

		if (req.getParameter("acao").equals("vender")) {

			List<Cliente> lista = null;
			try {
				lista = clientebo.consultarTodos();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			req.setAttribute("lista", lista);

			List<Produto> lista1 = null;
			try {
				lista1 = produtobo.produtos();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			req.setAttribute("lista1", lista1);

			RequestDispatcher saida = req.getRequestDispatcher("/Venda/realizaVenda.jsp");
			saida.forward(req, resp);
		}

	}

	public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
//		Cliente cliente = new Cliente();
//		HttpSession sessao = req.getSession();
//		sessao.setMaxInactiveInterval(3000);
//		sessao.setAttribute("nome", cliente.getNome());
		
		doPost(req, response);

	}

}
