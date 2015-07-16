package br.com.portifolio.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.portifolio.modelo.Carro;



public class CarroRepositorio {

	private EntityManager manager;
	
	public CarroRepositorio(EntityManager manager) {
		this.manager = manager;
	}

	public void adiciona(Carro carro){
		this.manager.persist(carro);
	}
	
	public List<Carro> buscarTodos(){
		Query query = this.manager.createQuery("select x from Carro x");
		return query.getResultList();
	}
	
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	
}
