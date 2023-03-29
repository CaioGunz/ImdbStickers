package br.com.caio.imdb;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import javax.management.RuntimeErrorException;

public class ClienteHttp {
	
	public String buscaDados(String url) {
		
		try {
		URI endereco = URI.create(url);
		var cliente = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(endereco).GET().build();
		var response = cliente.send(request, BodyHandlers.ofString());
		String body = response.body();
		System.out.println(body);
		
		return body;
		
		} catch (IOException | InterruptedException ex) {
			throw new RuntimeException(ex);
		}
	}
	

}
