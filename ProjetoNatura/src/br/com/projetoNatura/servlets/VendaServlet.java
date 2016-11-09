package br.com.projetoNatura.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoNatura.bo.ClienteBo;
import br.com.projetoNatura.bo.ProdutoBo;
import br.com.projetoNatura.entidade.Cliente;
import br.com.projetoNatura.entidade.Produto;
import br.com.projetoNatura.entidade.Venda;

public class VendaServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");
		if(acao.equals("listar")){
			try {
				List<Cliente> clientes = ClienteBo.consultarTodos();
				req.setAttribute("clientes", clientes);
				List<Produto> produtos = ProdutoBo.produtos();
				req.setAttribute("produtos", produtos);

				req.getRequestDispatcher("../ProjetoNatura/Venda/realizarVenda.jsp").forward(req, resp);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}else if(acao.equals("realizarVenda")){
			
		}
	
	}

}
