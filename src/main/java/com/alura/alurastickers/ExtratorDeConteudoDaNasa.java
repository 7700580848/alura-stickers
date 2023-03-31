package com.alura.alurastickers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa {
	
	public List<Conteudo> extraiConteudos(String json) {
		
		// Pegar somente os dados que interessam (Título, poster, classificação)
		var parser = new JsonParser(); 
		List<Map<String, String>> listaDeAtributos = parser.parse(json);
		
		List<Conteudo> conteudos = new ArrayList<>();
		
		// Popular a lista de atributos
		for (Map<String, String> atributo : listaDeAtributos) {
			String urlImagem = atributo.get("url");
			String titulo = atributo.get("title"); 		
			
			var conteudo = new Conteudo(titulo, urlImagem);
			
			conteudos.add(conteudo);
		}
		
		return conteudos;
	}

}
