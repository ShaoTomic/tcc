package br.com.portifolio.controle;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="usuarioBean")
public class UsuarioBean {
	private String nome;
	private int idade;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
}
