package br.com.portifolio.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ListarEditorasJPA {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager manager = factory.createEntityManager();
		
		EditoraRepository editoraRepository = new EditoraRepository(manager);
		List<Editora> editoras = editoraRepository.listar();
		
		for(Editora e : editoras){
			System.out.println("EDITORA: " + e.getNome() + " - " + e.getEmail());
		}
		
		manager.close();
		factory.close();
		
	}
}
