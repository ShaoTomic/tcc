package br.com.portifolio.modelo;

public class Produto {
	
	private String nome;
	private double valor;
	private String descricao;
	private String imagem;
		
	public Produto(){
		
	}
	
	public Produto(String nome, double valor, String descricao, String imagem){
		this.nome = nome;
		this.valor = valor;
		this.descricao = descricao;
		this.imagem = imagem;
	}
	
	
	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
