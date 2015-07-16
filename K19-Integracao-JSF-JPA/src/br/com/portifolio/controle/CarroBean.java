package br.com.portifolio.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import br.com.portifolio.modelo.Carro;
import br.com.portifolio.repositorio.CarroRepositorio;



@ManagedBean(name="carroBean")
public class CarroBean {
	
	private Carro carro = new Carro();
	
	
	public CarroBean() {
	}

	public void adicionarCarro(){
		EntityManager manager = this.getEntityManager();
		CarroRepositorio repositorio = new CarroRepositorio(manager);
		
		repositorio.adiciona(this.carro);
		this.carro = new Carro(); 
	}
	
	public List<Carro> getCarros(){
		EntityManager manager = this.getEntityManager();
		CarroRepositorio repositorio = new CarroRepositorio(manager);
		return repositorio.buscarTodos();
	}
	
	private EntityManager getEntityManager(){
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpServletRequest request  = (HttpServletRequest) ec.getRequest();
		EntityManager manager = (EntityManager) request.getAttribute("EntityManager");
		return manager;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	
}
