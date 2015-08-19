package maisPopularidade;
import java.util.ArrayList;

import exception.UserException;

public class Controle {
	
	private ArrayList<Usuario> usuariosCadastrados;
	private Usuario usuarioLogado;
	
	public Controle() {
		this.usuariosCadastrados = new ArrayList<Usuario>();
		this.usuarioLogado = null;
	}
	
	public void aniciaSistema() {
	}
	
	public void fechaSistema() {
	}
	
	public String cadastraUsuario(String nome, String email, String senha, String dataNasc, String imagem) throws UserException {
		Usuario novoUsuario = new Usuario(nome, email, senha, dataNasc, imagem);
        armazenaUsuario(novoUsuario);
        return novoUsuario.getEmail();     
	}
	
	public void armazenaUsuario(Usuario novoUsuario) {
		if (!this.usuariosCadastrados.contains(novoUsuario)) {
			this.usuariosCadastrados.add(novoUsuario);	
		}
	}
	
	public void login(String email, String senha) {
		if (getUsuarioLogado().equals(null)) {
		   Usuario usuarioProcurado = procuraUsuarioPeloEmail(email);
			if (usuarioProcurado != null) {
				if (usuarioProcurado.getEmail().equals(email) & usuarioProcurado.getSenha().equals(senha)) {
					setUsuarioLogado(usuarioProcurado);
				}
			}
		}
	}
		
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public void logout() {
		setUsuarioLogado(null);
	}
	
	public void removeUsuario(Usuario usuario) {
		if(this.usuariosCadastrados.contains(usuario)) {
			this.usuariosCadastrados.remove(usuario);
		}
	}
	
	public ArrayList<Usuario> getUsuariosCadastrados() {
		return usuariosCadastrados;
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	public Usuario procuraUsuario(Usuario usuario) {
		if (this.usuariosCadastrados.contains(usuario)) {
			return usuario;	
		}return null;	
	}
	
	public int retornaIndiceDoUsuario(String email) {
		for (Usuario usuario : usuariosCadastrados) {
			if (usuario.getEmail().equals(email)) {
				return this.usuariosCadastrados.indexOf(usuario);
			}
		} return -1;
	}
	
	public Usuario procuraUsuarioPeloEmail(String email) {
		int index = retornaIndiceDoUsuario(email);
		if (index != -1) {
			return usuariosCadastrados.get(index);
		} else {
			return null;
		}
	}
	
	public String getInfoUsuario(String atributo, String usuario) throws  UserException{
		Usuario usuarioProcurado = procuraUsuarioPeloEmail(usuario);
		if (usuarioProcurado != null) {
			if (atributo.equalsIgnoreCase("email")) {
				return usuarioProcurado.getEmail();
			} else if (atributo.equalsIgnoreCase("nome")) {
				return usuarioProcurado.getNome();
			} else if (atributo.equalsIgnoreCase("Data de Nascimento")) {
				String[] data = usuarioProcurado.getDataNasc().split("/");
				String dataUsuario = "";
				for (int i = 0; i < data.length-1; i--) {
					System.out.println(data[i]); 
				} return dataUsuario;
			} else if (atributo.equalsIgnoreCase("foto") || atributo.equalsIgnoreCase("imagem")) {
				return usuarioProcurado.getImagem();
			} else if (atributo.equalsIgnoreCase("senha")) {
				throw new UserException("A senha dx usuarix eh protegida.");
			}
		}
		return null;
	}
	
}

