package br.com.portifolio.modelo;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="produto")
public class Produto {
	
	private String nome;
	private double preco;
			
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}
