package br.com.portifolio.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InserirEditoraJPA {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager manager = factory.createEntityManager();
		
		EditoraRepository er = new EditoraRepository(manager);
		
		Editora novaEditora = new Editora();
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o nome da editora:");
		novaEditora.setNome(entrada.nextLine());
		
		System.out.println("Digite o email da editora:");
		novaEditora.setEmail(entrada.nextLine());
		
		er.adicionar(novaEditora);
		
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}
}
