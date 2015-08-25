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
				"resources/Scripts de Teste" + "/usecase_1.txt",
				"resources/Scripts de Teste" + "/usecase_2.txt"
		};
		    EasyAccept.main(args);
	}
	
	public void iniciaSistema() {
		controle.aniciaSistema();
	}
	
	public String cadastraUsuario(String nome, String email, String senha, String dataNasc, String imagem) throws UserException {
			return controle.cadastraUsuario(nome, email, senha, dataNasc, imagem);	
	}
	
	public String cadastraUsuario(String nome, String dataNasc, String email, String senha) throws Exception {
			return controle.cadastraUsuario(nome, dataNasc, email, senha, "resources/default.jpg");
	}
	
	public void login(String email, String senha) throws UserException {
		 controle.login(email, senha);
	}
	
	public void logout() throws UserException {
		controle.logout();
	}
	
	public String getInfoUsuario(String atributo, String usuario) throws UserException {
		return controle.getInfoUsuario(atributo, usuario);
	}
	
	public String getInfoUsuario(String atributo) throws UserException {
		return controle.getInfoUsuario(atributo);
	}
	
	public void removeUsuario(String usuario) {
		controle.removeUsuario(usuario);
	}
	
	public void fechaSistema() throws UserException {
		controle.fechaSistema();
	}
	
	public void atualizaPerfil(String atributo, String valor) throws UserException {
		controle.atualizaPerfil(atributo, valor);
	}
	
	public void atualizaPerfil(String atributo, String valor, String velhaSenha) throws UserException {
		controle.atualizaPerfil(atributo, valor, velhaSenha);
	}
	
	
	

}

