package br.com.caio.imdb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeContudoDoIMDB implements ExtratorDeContudo {

	public List<Conteudo> extraiContudos(String json) {
		
		// extrair os dados que nos interessam (titulo, poster, classifica��o)
		var parser = new JsonParser();
		List<Map<String, String>> listaDeAtributos = parser.parse(json); 
		
		List<Conteudo> conteudos = new ArrayList<>();
		
	// popular a lista de conteudos
		for (Map<String, String> atributos : listaDeAtributos) {
			 String titulo = atributos.get("title");
			 String urlImagem = atributos.get("image").replaceAll("(@+) (.*).jpg$", "$1.jpg");;
			
			 var conteudo = new Conteudo(titulo, urlImagem);
			
			conteudos.add(conteudo);
		}
		
		return conteudos;
		
	}
	
}
