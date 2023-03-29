package br.com.caio.imdb;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {

		// Fazendo uma conex�o HTTP e buscar os top 250 filmes
		// String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
		String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
		
		ClienteHttp http = new ClienteHttp();
		String json = http.buscaDados(url);
		
		
		
		// Exibir e manipular dados
		ExtratorDeConteudoDaNasa extrator = new ExtratorDeConteudoDaNasa();
		List<Conteudo> conteudos = extrator.extraiContudos(json);
		
		GeradorDeSticker geradorDeSticker = new GeradorDeSticker();
		for (int i = 0; i <3; i++) {
			
			Conteudo conteudo = conteudos.get(i);
			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			String nomeArquivo = "saida/" + conteudo.getTitulo() + " .png";
			
			geradorDeSticker.cria(inputStream, nomeArquivo);
			
			System.out.println(conteudo.getTitulo());	
			System.out.println();
		}
	}

}
