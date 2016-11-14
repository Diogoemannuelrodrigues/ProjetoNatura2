package br.com.projetoNatura.entidade;

public class Usuario {
	private int usarioId;
	private String usarioLogin;
	private String usarioSenha;

	public int getUsarioId() {
		return usarioId;
	}

	public void setUsarioId(int usarioId) {
		this.usarioId = usarioId;
	}

	public String getUsarioLogin() {
		return usarioLogin;
	}

	public void setUsarioLogin(String usarioLogin) {
		this.usarioLogin = usarioLogin;
	}

	public String getUsarioSenha() {
		return usarioSenha;
	}

	public void setUsarioSenha(String usarioSenha) {
		this.usarioSenha = usarioSenha;
	}

}
