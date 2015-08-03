package br.com.eonto.artigo;

import java.util.List;

import org.junit.Test;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class ModeloTest {

    private String owl = "<http://www.w3.org/2002/07/owl#>";
    private String rdfs= "<http://www.w3.org/2000/01/rdf-schema#>";
    private String rdf = "<http://www.w3.org/1999/02/22-rdf-syntax-ns#>";
    private String xsd = "<http://www.w3.org/2001/XMLSchema#>";
    private String eos = "PREFIX eos: <http://www.semanticweb.org/jacksparow/ontologies/2015/2/modelo#> \n";
	
	@Test
	public void listarModelos(){
	
		OntModel model = ModelFactory.createOntologyModel();
		String ont = "file:/home/jacksparow/Desenvolvimento/TCC_Data/data/modeloFinal.ttl";
		model.read( ont );
		
		ModeloDAO modeloDAO = new ModeloDAO();
		
		List<Modelo> modelos = modeloDAO.listar("artigo1", model);
		
		for (Modelo modelo : modelos) {
			System.out.println(modelo.getCores().size());
		}
		
		model.close();
	}

}
