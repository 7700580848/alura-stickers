package com.alura.alurastickers;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) throws Exception {
	//	SpringApplication.run(AluraStickersApplication.class, args);
		
		// a variavel abaixo irá retornar um emoji estrela
        String emoji = "\u2b50";
        
		// Fazer uma conexão https e buscar os conteudos
		// String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
		// ExtratorDeConteudoDoIMDB extrator = new ExtratorDeConteudoDoIMDB();
		
		//String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2023-03-29&end_date=2023-03-29";
		//ExtratorDeConteudoDaNasa extrator = new ExtratorDeConteudoDaNasa();
		
		String url = "http://localhost:8080/Linguagens";
		ExtratorDeConteudoDeLinguagens extrator = new ExtratorDeConteudoDeLinguagens();
		
		var http = new ClienteHttp();
		String json = http.buscaDados(url);
		
			
		// Exibir e manipular os dados
		List<Conteudo> conteudos = extrator.extraiConteudos(json);
		
		var geradora = new GeradoraDeFigurinhas();
		
		for (Conteudo conteudo : conteudos) {
			
		//	Integer numeroEstrelinhas = conteudo.getRating().intValue();
			
	 		InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			String nomeArquivo = conteudo.getTitulo().replace(":", "-") + ".png";
			
			geradora.cria(inputStream, nomeArquivo);
			
	//		String s = emoji; 
	//		for (int i = 1; i < numeroEstrelinhas; i++) {
	//			s = s + emoji; 
	//		}
			
			System.out.println("\u001b[1mFilme:\u001b[m " + conteudo.getTitulo());
	//		System.out.println("\u001b[1mRank:\u001b[m " +conteudo.getRating());
	//		System.out.println("\u001B[33m" + "\u001b[1m" + s + "\u001b[m "+ "\u001B[0m");
			System.out.println();

			
		}
		
	}

}
