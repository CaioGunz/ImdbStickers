package br.com.caio.imdb;

import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.net.URI;
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
		for (Map<String, String> filme : listaDeFilmes) {
			System.out.println(filme.get("title"));	
			System.out.println(filme.get("image"));
			System.out.println(filme.get("imdbRating"));
			System.out.println();
		}
	}

}
