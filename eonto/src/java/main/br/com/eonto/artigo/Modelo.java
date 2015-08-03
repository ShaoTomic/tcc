package br.com.eonto.artigo;

import java.util.List;

import br.com.eonto.agent.EOSOntResourceAnnotation;

public class Modelo {
	
	private String localName;
	private EOSOntResourceAnnotation anotacao;
	private List<String> cores;
	private String tamanho;
	private int quantidade;
	private String imagem;
	
	

	@Override
	public String toString() {
		return "Modelo [localName=" + localName + ", cores=" + cores
				+ ", quantidade=" + quantidade + ", imagem=" + imagem + "]";
	}

	public Modelo(){

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

	public List<String> getCores() {
		return cores;
	}

	public void setCores(List<String> cores) {
		this.cores = cores;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	
	
}
