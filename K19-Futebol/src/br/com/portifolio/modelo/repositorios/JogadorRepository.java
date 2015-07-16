package br.com.portifolio.modelo.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.portifolio.entidades.Jogador;

public class JogadorRepository {
	
	private EntityManager manager;
	
	public JogadorRepository(EntityManager manager){
		this.manager = manager;
	}
	
	public void adiciona(Jogador jogador){
		this.manager.persist(jogador);
	}
	
	public void remove(Long id){
		Jogador jogador = this.procura(id);
		this.manager.remove(jogador);
	}
	
	public Jogador atualizar(Jogador jogador){
		return this.manager.merge(jogador);
	}
	
	public Jogador procura(Long id){
		return this.manager.find(Jogador.class, id);
	}
	
	public List<Jogador> getLista(){
		Query query = this.manager.createQuery("select X from Jogador x");
		return query.getResultList();
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	
}
