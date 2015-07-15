package br.com.portifolio.modelo;

public class Curso {
	private Long id;
	private String sigla;
	private String nome;
	private String logo;
	
	public Curso(Long id, String sigla, String nome, String logo) {
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
		this.logo = logo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
	
	
}
