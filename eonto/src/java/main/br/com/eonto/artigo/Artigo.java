package br.com.eonto.artigo;

import br.com.eonto.agent.EOSOntResourceAnnotation;

public class Artigo {

	private String localName;
	private EOSOntResourceAnnotation anotacao;
	private double preco;
	private String imagem;
	
	public Artigo(){
		
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

		
	public EOSOntResourceAnnotation getAnotacao() {
		return anotacao;
	}

	public void setAnotacao(EOSOntResourceAnnotation anotacao) {
		this.anotacao = anotacao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
		
	


	
}
