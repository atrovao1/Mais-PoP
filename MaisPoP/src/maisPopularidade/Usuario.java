package maisPopularidade;

import java.util.ArrayList;

import exception.UserException;

public class Usuario {

	private String nome;
	private String dataNasc;
	private String email;
	private String senha;
	private String imagem;
	private ArrayList posts;
	public Valida valida;

	public Usuario(String nome, String email, String senha, String dataNasc, String imagem) 
		   throws UserException {
		
		this.valida = new Valida();
		
		if (!valida.nome(nome)) {
			throw new UserException(
					"Erro no cadastro de Usuarios. Nome dx usuarix nao pode ser vazio.");
		}

		if (!valida.email(email)) {
			throw new UserException(
					"Erro no cadastro de Usuarios. Formato de e-mail esta invalido.");
		}

		if (!valida.senha(senha)) {
			throw new UserException(
					"Erro no cadastro de Usuarios. Formato de senha esta invalido.");
		}

		if (!valida.formatoDataNasc(dataNasc)) {
			throw new UserException(
					"Erro no cadastro de Usuarios. Formato de data esta invalida.");
		}

		if (!valida.valorDataNasc(dataNasc)) {
			throw new UserException(
					"Erro no cadastro de Usuarios. Data nao existe.");
		}

		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dataNasc = dataNasc;
		this.posts = new ArrayList<Post>();
		this.imagem = imagem;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public void adicionaPost(Post novopost) {
		this.posts.add(novopost);
		}
	
	public ArrayList<Post> getPosts() {
		return posts;
	}
	
	public String getPost(String atributo, int index) {
		if (atributo.equalsIgnoreCase("mensagem")){
			return getPosts().get(index).getMensagem();
			
		} else if(atributo.equalsIgnoreCase("data")){
			
			return getPosts().get(index).getData();
			
		} else if (atributo.equalsIgnoreCase("hashtags")){
			return getPosts().get(index).getHashtag();
		}
		return null;	
	}
	
	public Post getPostPeloIndex(int index) throws Exception {
		if (index >= posts.size()) {
			throw new Exception("");
		}
		return (Post) posts.get(index);
	}

}
