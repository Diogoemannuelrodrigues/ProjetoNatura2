package br.com.projetoNatura.servlets;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/*" })
public class FiltroLogin implements Filter {

    public FiltroLogin() {

    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//casting do httpservletrequest
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		//capturando sessao
		HttpSession sessao = httpServletRequest.getSession();
		String url = httpServletRequest.getRequestURI();
		
		if(sessao.getAttribute("logado")!=null || url.lastIndexOf("Login.jsp")>-1 || url.lastIndexOf("usuario")>-1){
			
			chain.doFilter(request, response);
		}else{
			((HttpServletResponse) response).sendRedirect("Login.jsp");
		}
		
		
	
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}