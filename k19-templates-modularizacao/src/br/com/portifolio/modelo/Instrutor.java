package br.com.portifolio.modelo;

public class Instrutor {
	
	private String nome;
	private String dataDeNascimento;
	
	public Instrutor(){
	}
	
	public Instrutor(String nome, String dataDeNascimento){
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	
}
