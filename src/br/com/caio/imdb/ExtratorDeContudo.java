package br.com.caio.imdb;

import java.util.List;

public interface ExtratorDeContudo {

	List<Conteudo> extraiContudos(String json);
	
}
