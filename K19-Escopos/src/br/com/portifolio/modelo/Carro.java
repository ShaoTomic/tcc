package br.com.portifolio.modelo;

import javax.faces.bean.ManagedBean;


@ManagedBean(name="carro")
public class Carro {
	private String marca;
	private String modelo;
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
}
