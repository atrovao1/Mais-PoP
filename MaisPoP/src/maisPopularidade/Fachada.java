package maisPopularidade;

import easyaccept.EasyAccept;
import exception.SystemException;
import exception.UserException;


public class Fachada {
	
	private Controle controle;
	
	public Fachada() {
		this.controle = new Controle();
	}
	
	public static void main(String[] args) {
		      args = new String[] {"maisPopularidade.Fachada",
				"MaisPop/resources/Scripts de Teste" + "/usecase_1.txt",
				"MaisPop/resources/Scripts de Teste" + "/usecase_2.txt",
				"MaisPop/resources/Scripts de Teste" + "/usecase_3.txt",
				"MaisPop/resources/Scripts de Teste" + "/usecase_4.txt"

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
	
	public void login(String email, String senha) throws SystemException {
		 controle.login(email, senha);
	}
	
	public void logout() throws SystemException {
		controle.logout();
	}
	public String getInfoUsuario(String atributo, String usuario) throws SystemException {
		return controle.getInfoUsuario(atributo, usuario);
	}
	
	public String getInfoUsuario(String atributo) throws SystemException {
		return controle.getInfoUsuario(atributo);
	}
	
	public void removeUsuario(String usuario) {
		controle.removeUsuario(usuario);
	}
	
	public void fechaSistema() throws SystemException {
		controle.fechaSistema();
	}
	
	public void atualizaPerfil(String atributo, String valor) throws SystemException {
		controle.atualizaPerfil(atributo, valor);
	}
	
	public void atualizaPerfil(String atributo, String valor, String velhaSenha) throws SystemException {
		controle.atualizaPerfil(atributo, valor, velhaSenha);
	}
	
	public void criaPost(String mensagem, String data) throws Exception {
		controle.criaPost(mensagem, data);
	}
	
	public Post getPost(int index) throws Exception {
		return controle.getPost(index);
	}
	
	public String getPost(String atributo, int index){
		return controle.getPost(atributo, index);
	}
	
}

