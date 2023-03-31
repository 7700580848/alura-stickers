package com.alura.alurastickers;

public class Conteudo {

	private final String titulo;
	private final String urlImagem;
	private Double rating;
	private String rank;
	

	public Conteudo(String titulo, String urlImagem, Double rating, String rank) {
		super();
		this.titulo = titulo;
		this.urlImagem = urlImagem;
		this.rating = rating;
		this.rank = rank;
	}
	
	public Conteudo(String titulo, String urlImagem) {
		this.titulo = titulo;
		this.urlImagem = urlImagem;
	}
	
	public Conteudo(String titulo, String urlImagem, String rank) {
		this.titulo = titulo;
		this.urlImagem = urlImagem;
		this.rank = rank;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public Double getRating() {
		return rating;
	}

	public String getRank() {
		return rank;
	}

	
	
	
	
}
