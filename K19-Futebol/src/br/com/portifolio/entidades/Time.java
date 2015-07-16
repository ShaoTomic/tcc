package br.com.portifolio.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Time {
	
	@Id @GeneratedValue
	private Long id;
	
	private String nome;
	
	private String tecnico;
	
	public Time(){}
	
	@Override
	public String toString() {
		return "Time [id=" + id + ", nome=" + nome + ", tecnico=" + tecnico
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}
	
	
	
}
