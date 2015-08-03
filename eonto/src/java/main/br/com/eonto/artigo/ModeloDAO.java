package br.com.eonto.artigo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import br.com.eonto.agent.EOSOntResourceAnnotation;

import com.clarkparsia.pellet.sparqldl.jena.SparqlDLExecutionFactory;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;

public class ModeloDAO {

	private String rdfs = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n";
	private String eos  = "PREFIX eos: <http://www.semanticweb.org/jacksparow/ontologies/2015/2/modelo#> \n";
	
	public List<Modelo> listar(String articleLocalName, OntModel model){
		
	   String query = "SELECT ?modelo ?corHexa ?tamanho ?quantidade ?imagem WHERE{ \n"
			+ 	"eos:"+articleLocalName+" eos:temModelo ?modelo. \n"
			+ 	"?modelo eos:temCor ?cor. \n"
			+	"?cor rdfs:isDefinedBy ?corHexa. \n"
			+ 	"?modelo eos:temTamanho ?tamanho. \n"
			+ 	"?modelo eos:temQuantidade ?quantidade. \n"
			+ 	"?modelo eos:temImagem ?imagem. \n"
			+ "} \n";
	
		Query finalQuery = QueryFactory.create(rdfs+eos+query);
		
		QueryExecution qe = SparqlDLExecutionFactory.create( finalQuery, model );

		ResultSet rs = qe.execSelect();
		
		List<Modelo> modelos = popularLista(rs);
		
		model.close();
		
		return modelos;

		
	}
	
	
	private List<Modelo> popularLista(ResultSet rs){
		
		QuerySolution qs;
	    List<Modelo> modelos = new ArrayList<Modelo>();
	    Modelo modelo = new Modelo();
	    
	    EOSOntResourceAnnotation eosora;
	    
	    qs = rs.nextSolution();
		while(rs.hasNext()){
			
			//eosora = new EOSOntResourceAnnotation();
			//eosora.setLabel(qs.getLiteral("label").getString());
			//eosora.setComment(qs.getLiteral("comment").getString());
			
			modelo.setLocalName(qs.getResource("modelo").getLocalName());
			modelo.setTamanho(qs.getResource("tamanho").getLocalName());
			modelo.setQuantidade(qs.getLiteral("quantidade").getInt());
			modelo.setImagem(qs.getLiteral("imagem").getString());
			
			ArrayList<String> cores = new ArrayList<String>();
			
			try{
				while(qs.getResource("modelo").getLocalName().compareTo(modelo.getLocalName())==0){
					cores.add(qs.getLiteral("corHexa").getString());
					qs = rs.nextSolution();
					
				}
			}catch(NoSuchElementException e){
			
			}
						
			modelo.setCores(cores);
			modelos.add(modelo);
			modelo = new Modelo();
		}
		
		return modelos;
	
	}

	
}
