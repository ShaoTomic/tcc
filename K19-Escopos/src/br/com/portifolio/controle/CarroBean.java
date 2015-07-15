package br.com.portifolio.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.portifolio.modelo.Carro;

@ManagedBean(name="carroBean")
@SessionScoped
public class CarroBean {
	
	private List<Carro> carros = new ArrayList<Carro>();
	private Carro carro = new Carro();
	
	public void adicionarCarro(){
		this.carros.add(this.carro);
		this.carro = new Carro();
	}
	
	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	
	
}
