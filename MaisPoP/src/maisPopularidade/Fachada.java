package maisPopularidade;

import easyaccept.EasyAccept;
import exception.UserException;


public class Fachada {
	
	private Controle controle;
	
	public Fachada() {
		this.controle = new Controle();
	}
	
	public static void main(String[] args) {
		args = new String[] {"maisPopularidade.Fachada",
				"resources/Scripts de Teste"
				+ "/usecase_1.txt"};
		    EasyAccept.main(args);
	}
	
	public void iniciaSistema() {
		controle.aniciaSistema();
	}
	
	public void fechaSistema() {
		controle.fechaSistema();
	}
	
	public String cadastraUsuario(String nome, String email, String senha, String dataNasc, String imagem) throws UserException {
			return controle.cadastraUsuario(nome, email, senha, dataNasc, imagem);	
	}
	
	public String cadastraUsuario(String nome, String dataNasc, String email, String senha) throws Exception {
			return controle.cadastraUsuario(nome, dataNasc, email, senha, "default");
	}
	
	public void login(String email, String senha) {
		controle.login(email, senha);
	}
	
	public void logout() {
		controle.logout();
	}
	
	public String getInfoUsuario(String atributo, String usuario) throws UserException {
		return controle.getInfoUsuario(atributo, usuario);
	}
	
	public void removeUsuario(Usuario usuario) {
		controle.removeUsuario(usuario);
	}
	

}

