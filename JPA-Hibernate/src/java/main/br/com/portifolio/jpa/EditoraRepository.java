package br.com.portifolio.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

//DDD Domain Drive Design
public class EditoraRepository {
	private EntityManager manager;
	
	public EditoraRepository(EntityManager manager){
		this.manager = manager;
	}
	
	public void adicionar(Editora e){
		this.manager.persist(e);
	}
	
	public Editora busca(Long id){
		return this.manager.find(Editora.class, id);
	}
	
	public List<Editora> listar(){
		Query query = this.manager.createQuery("SELECT e FROM Editora e");
		return query.getResultList();
	}
}
