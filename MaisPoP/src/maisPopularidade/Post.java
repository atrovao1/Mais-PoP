package maisPopularidade;

import java.util.ArrayList;

public class Post {
	
	private String mensagem;
	private String hashtag;
	private String data;
	private Valida valida;
	
	public Post(String mensagem, String data) throws Exception {
		this.valida = new Valida();
		if (!valida.conteudoPost(mensagem)) {
			throw new Exception("Conteudo do post nao pode ser nulo ou vazio.");
		}
		if (separaMensagem(mensagem).length()>= 200){
			throw new Exception("Nao eh possivel criar o post. O limite maximo da mensagem sao 200 caracteres.");	
		}
		if (mensagem.contains("#")) {
			String hashtagErro = valida.hashtags(mensagem);
			if (hashtagErro != null) {
				throw new Exception("Nao eh possivel criar o post. As hashtags devem comecar com '#'."
						+  " Erro na hashtag: '" + hashtagErro + "'.");
			}
		}
		
		this.mensagem = mensagem;
		this.hashtag = hashtag;
		this.data = data;
	}
	
		public String separaMensagem(String conteudo) {
			ArrayList<String> mensagem = new ArrayList<String>();
			String[] palavras = conteudo.split(" ");
			for (String palavra : palavras) {
				if (!palavra.startsWith("#") )//&& !palavra.startsWith("<"))
					mensagem.add(palavra);
			}
			return String.join(" ", mensagem);
		}
		
		public String separaHashtags(String conteudo) {
			ArrayList<String> hashtags = new ArrayList<String>();
			String[] palavras = conteudo.split(" ");
			for (String palavra : palavras) {
				if (palavra.startsWith("#"))
					hashtags.add(palavra);
			}
			return String.join(",", hashtags);
		}
		
		public String separaMidia(String conteudo) {
			ArrayList<String> midias = new ArrayList<String>();
			String[] palavras = conteudo.split(" ");
			for (String palavra : palavras) {
				if (palavra.startsWith("<"))
					midias.add(palavra);
			}
			return String.join(" ", midias);
		}
		
		public String formataDataPost(){
			String data = this.data.substring(0, 10);
			String hora = this.data.substring(10, this.data.length());
			String[] dataPost = data.split("/");
			String dataUsuario = "";
			for (int i = dataPost.length - 1; i >= 0; i--) {
				if (i == 0) {
					dataUsuario = dataUsuario + dataPost[i];
				} else {
					dataUsuario = dataUsuario + dataPost[i] + "-";
				}
			}
			return dataUsuario + hora ;
		}
		
		

		public String getMensagem() {
				return separaMensagem(mensagem);
		}

		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}

		public String getData() {
			return formataDataPost();
		}

		public void setData(String data) {
			this.data = data;
		}
		
		public String getHashtag(){
			return separaHashtags(mensagem);
		}

		@Override
		public String toString() {
			return mensagem  + " (" + formataDataPost() + ")";
		}
		
		

}
