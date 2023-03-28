package br.com.caio.imdb;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorDeSticker {
	
	public void cria(InputStream inputStream, String nomeArquivo) throws IOException {
		
		// leitura da imagem
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
		// cria uma nova imagem em memória com transparência e tamanho novo
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		//copiar imagem original para novo imagem (em memória)
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		// configurar a fonte do texto
		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
		graphics.setColor(Color.BLUE);
		graphics.setFont(fonte);
		
		// escrever uma frase na nova imagem
		graphics.drawString("TOPZERA", 150, novaAltura - 100);
		
		// escreve a nova imagem em um arquivo
		ImageIO.write(novaImagem, "png", new File(nomeArquivo));
	
	}

}
