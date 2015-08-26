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
	
	public ArrayList<Usuario> getUsuariosCadastrados() {
		return usuariosCadastrados;
	}

	public void login(String email, String senha) throws UserException {
		if (usuarioLogado == null) {
			Usuario usuarioProcurado = procuraUsuarioPeloEmail(email);
			if (usuarioProcurado != null) {
				if (usuarioProcurado.getEmail().equals(email) & usuarioProcurado.getSenha().equals(senha)) {
					setUsuarioLogado(usuarioProcurado);
					
				} else if (senha != usuarioProcurado.getSenha()) {
					throw new UserException(
							"Nao foi possivel realizar login. Senha invalida.");
				
				} else if (email != usuarioProcurado.getEmail()) {
					throw new UserException(
							"Nao foi possivel realizar login. Um usuarix com email "
									+ email + " nao esta cadastradx.");
					}
			} else {
				throw new UserException(
						"Nao foi possivel realizar login. Um usuarix com email "
								+ email + " nao esta cadastradx.");
				}
		} else {
			throw new UserException(
					"Nao foi possivel realizar login. Um usuarix ja esta logadx: "
							+ "" + usuarioLogado.getNome() + ".");
		}
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	public Usuario procuraUsuario(Usuario usuario) {
		if (this.usuariosCadastrados.contains(usuario)) {
			return usuario;
		}
		return null;
	}

	public int retornaIndiceDoUsuario(String email) {
		for (Usuario usuario : usuariosCadastrados) {
			if (usuario.getEmail().equals(email)) {
				return this.usuariosCadastrados.indexOf(usuario);
			}
		}
		return -1;
	}

	public Usuario procuraUsuarioPeloEmail(String email) {
		int index = retornaIndiceDoUsuario(email);
		if (index != -1) {
			return usuariosCadastrados.get(index);
		} else {
			return null;
		}
	}
	
	public void logout() throws UserException {
		if (usuarioLogado != null) {
			setUsuarioLogado(null);
		} else {
			throw new UserException(
					"Nao eh possivel realizar logout. Nenhum usuarix esta logadx no +pop.");
		}
	}

	public void removeUsuario(String usuario) {
		Usuario usuarioParaRemover = procuraUsuarioPeloEmail(usuario);
		if(usuarioParaRemover != null) {
			usuariosCadastrados.remove(usuarioParaRemover);
		}
	}

	public String getInfoUsuario(String atributo, String usuario) throws UserException {
		Usuario usuarioProcurado = procuraUsuarioPeloEmail(usuario);
		if (usuarioProcurado != null) {
			if (atributo.equalsIgnoreCase("email")) {
				return usuarioProcurado.getEmail();
				
			} else if (atributo.equalsIgnoreCase("nome")) {
				return usuarioProcurado.getNome();
				
			} else if (atributo.equalsIgnoreCase("Data de Nascimento")) {
				String[] data = usuarioProcurado.getDataNasc().split("/");
				String dataUsuario = "";
				for (int i = data.length - 1; i >= 0; i--) {
					if (i == 0) {
						dataUsuario = dataUsuario + data[i];
					} else {
						dataUsuario = dataUsuario + data[i] + "-";
					}
				}
				return dataUsuario;
				
			} else if (atributo.equalsIgnoreCase("foto")
					|| atributo.equalsIgnoreCase("imagem")) {
				return usuarioProcurado.getImagem();
				
			} else if (atributo.equalsIgnoreCase("senha")) {
				throw new UserException("A senha dx usuarix eh protegida.");
			}
		} else {
			throw new UserException("Um usuarix com email " + usuario
					+ " nao esta cadastradx.");
		}
		return null;
	}

	public String getInfoUsuario(String atributo) throws UserException {
		if (usuarioLogado != null) {
			if (atributo.equalsIgnoreCase("email")) {
				return usuarioLogado.getEmail();
				
			} else if (atributo.equalsIgnoreCase("nome")) {
				return usuarioLogado.getNome();
				
			} else if (atributo.equalsIgnoreCase("data de nascimento")) {
				String[] data = usuarioLogado.getDataNasc().split("/");
				String dataUsuario = "";
				for (int i = data.length - 1; i >= 0; i--) {
					if (i == 0) {
						dataUsuario = dataUsuario + data[i];
					} else {
						dataUsuario = dataUsuario + data[i] + "-";
					}
				}
				return dataUsuario;
				
			} else if (atributo.equalsIgnoreCase("foto") || atributo.equalsIgnoreCase("imagem")) {
				return usuarioLogado.getImagem();
				
			} else if (atributo.equalsIgnoreCase("senha")) {
				throw new UserException("A senha dx usuarix eh protegida.");
			}
		}
		return null;
	}
	
	public void fechaSistema() throws UserException {
		if (usuarioLogado != null) {
			throw new UserException("Nao foi possivel fechar o sistema. Um usuarix ainda esta logadx.");
		}
	}
	
	public void atualizaPerfil(String atributo, String valor) throws UserException {
		if (usuarioLogado != null) {
			if (atributo.equalsIgnoreCase("email") || atributo.equalsIgnoreCase("E-mail")) {
				if(usuarioLogado.verificaEmail(valor)){
					usuarioLogado.setEmail(valor);
				} else {
					throw new UserException("Erro na atualizacao de perfil. Formato de e-mail esta invalido.");
			}
			
		} else if (atributo.equalsIgnoreCase("nome")) {
			if (usuarioLogado.verificaNome(valor)) {
				usuarioLogado.setNome(valor);
			} else {
				throw new UserException("Erro na atualizacao de perfil. Nome dx usuarix nao pode ser vazio.");
			}
			
		} else if (atributo.equalsIgnoreCase("data de nascimento")) {
			if (!usuarioLogado.verificaFormatoDataNasc(valor)) {
				throw new UserException("Erro na atualizacao de perfil. Formato de data esta invalida.");
			}else if (!usuarioLogado.verificaValorDataNasc(valor)) {
				throw new UserException("Erro na atualizacao de perfil. Data nao existe.");
			} else{
				usuarioLogado.setDataNasc(valor);
				}
			
		} else if (atributo.equalsIgnoreCase("foto") || atributo.equalsIgnoreCase("imagem")) {
			usuarioLogado.setImagem(valor);
		}
			}else {
				throw new UserException("Nao eh possivel atualizar um perfil. Nenhum usuarix esta logadx no +pop.");
			}
	}
	
	public void atualizaPerfil(String atributo, String valor, String velhaSenha) throws UserException {
		if (usuarioLogado != null) {
			if (atributo.equalsIgnoreCase("Senha")) {
				if (usuarioLogado.getSenha().equals(velhaSenha)) {
					usuarioLogado.setSenha(valor);
			} else  {
				throw new UserException("Erro na atualizacao de perfil. A senha fornecida esta incorreta.");
			}
		}	
	}else {
		throw new UserException("Nao eh possivel atualizar um perfil. Nenhum usuarix esta logadx no +pop.");
	}
				}
	
}
