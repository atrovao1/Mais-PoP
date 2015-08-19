package maisPopularidade;

import exception.UserException;

public class Usuario {
	
	private String nome;
	private String dataNasc;
	private String email;
	private String senha;
	private String imagem;
	
	public Usuario(String nome, String email, String senha, String dataNasc, String imagem) throws UserException {
		
		if (!verificaNome(nome)) {
			throw new UserException("Erro no cadastro de Usuarios. Nome dx usuarix nao pode ser vazio.");
		}
		
		if (!verificaEmail(email)) {
			throw new UserException("Erro no cadastro de Usuarios. Formato de e-mail esta invalido.");	
		}
		
		if (senha.equals("") || senha.equals(null)) {
			throw new UserException("Erro no cadastro de Usuarios. Formato de senha esta invalido.");	
		}
		
		if (!verificaFormatoDataNasc(dataNasc)) {
			throw new UserException("Erro no cadastro de Usuarios. Formato de data esta invalida.");	
		}
		
		if (!verificaValorDataNasc(dataNasc)) {
			throw new UserException ("Erro no cadastro de Usuarios. Data nao existe.");
		}
		
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.email = email;
		this.senha = senha;
		this.imagem = imagem;
	}
	
	 
	private boolean verificaNome(String nome) {
		if (nome == null || nome.trim().isEmpty()){
			return false;
		}
		return true; 
	 }
	
	private boolean verificaEmail(String email) {
		if (verificaNome(email) & email.contains("@") & email.indexOf("@") != 0) {
			if(email.endsWith(".com") || email.endsWith(".com.br")) {
				return true;
			}
		}return false;
	}
	
	private boolean verificaFormatoDataNasc(String dataNasc) {
		if (verificaNome(dataNasc) & dataNasc.length() == 10) {
			for (int i = 0; i < dataNasc.length()-2; i= i+2) {
				if (dataNasc.indexOf("/") == i) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean verificaValorDataNasc(String dataNasc) {
		if (verificaFormatoDataNasc(dataNasc)) {
			String dia = dataNasc.substring(0, 2);
			String mes = dataNasc.substring(3, 5);
			String ano = dataNasc.substring(6, 10);
			if (Integer.parseInt(ano) > 1915 &  Integer.parseInt(ano) < 2016) {
				if (mes.equals("01") ||mes.equals("03") ||mes.equals("05") ||mes.equals("06") || mes.equals("08")
					|| mes.equals("10") || mes.equals("12")) {
					if (Integer.parseInt(dia) <= 31 & Integer.parseInt(dia) > 0) {
						return true;
					}
					else return false;
				} else if (mes.equals("04") ||mes.equals("07") ||mes.equals("09") ||mes.equals("11")) {
					if (Integer.parseInt(dia) <= 30 & Integer.parseInt(dia) > 0) {
						return true;
					}
					else return false;	
				} else if (mes.equals("02")) {
					boolean bissexto = ((Integer.parseInt(ano) % 400 == 0) || (Integer.parseInt(ano)
							% 4 == 0 && Integer.parseInt(ano) % 100 != 0));
					if (bissexto) {
						if (Integer.parseInt(dia) <= 29 & Integer.parseInt(dia) > 0) {
							return true;
						}else return false;
					} else if (!bissexto) {
						if (Integer.parseInt(dia) <= 28 & Integer.parseInt(dia) > 0) {
							return true;
					 } else return false;
				 }
			 }
		   }
		}
		return false;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
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

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	

}
