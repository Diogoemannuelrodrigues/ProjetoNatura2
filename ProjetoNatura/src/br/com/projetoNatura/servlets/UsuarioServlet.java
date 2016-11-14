package br.com.projetoNatura.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.projetoNatura.Dao.UsuarioDao;
import br.com.projetoNatura.entidade.Usuario;

public class UsuarioServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	Usuario usuario = new Usuario();
	/**
	 * 
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sessao = req.getSession(false);
		if(sessao != null){
			sessao.invalidate();
		}
		resp.sendRedirect("Login.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		usuario.setUsarioLogin(login);
		usuario.setUsarioSenha(senha);
		
		UsuarioDao usuarioDao = new UsuarioDao();
		if(usuarioDao.autenticar(usuario) == true){
			HttpSession sessao = req.getSession();
			sessao.setAttribute("logado", usuario);
			req.getRequestDispatcher("Menu.jsp").forward(req, resp);
		}else{
			resp.sendRedirect("Login.jsp");
		}
		
	}
}
