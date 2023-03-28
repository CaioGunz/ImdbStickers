package br.com.caio.imdb;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {

		// Fazendo uma conexão HTTP e buscar os top 250 filmes
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
		URI endereco = URI.create(url);
		var cliente = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(endereco).GET().build();
		var response = cliente.send(request, BodyHandlers.ofString());
		String body = response.body();
		System.out.println(body);
		
		// extrair os dados que nos interessam (titulo, poster, classificação)
		var parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body); 
		
		// Exibir e manipular dados
		GeradorDeSticker geradorDeSticker = new GeradorDeSticker();
		for (Map<String, String> filme : listaDeFilmes) {
			
	        String urlImagem = filme.get("image");
	        String titulo = filme.get("title");
	        
			InputStream inputStream = new URL(urlImagem).openStream();
			String nomeArquivo = titulo + " .png";
			
			geradorDeSticker.cria(inputStream, nomeArquivo);
			
			System.out.println(titulo);	
			System.out.println();
		}
	}

}
