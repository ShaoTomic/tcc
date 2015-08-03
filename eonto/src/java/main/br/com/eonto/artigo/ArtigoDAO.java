package br.com.eonto.artigo;

import java.util.ArrayList;
import java.util.List;

import br.com.eonto.agent.EOSOntResourceAnnotation;
import br.com.eonto.agent.EOSOntResourceAnnotationFactory;

import com.clarkparsia.pellet.sparqldl.jena.SparqlDLExecutionFactory;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;

public class ArtigoDAO {
	
	public List<Artigo> listar(String query, OntModel model){
		
		Query finalQuery = QueryFactory.create(query);
		
		QueryExecution qe = SparqlDLExecutionFactory.create( finalQuery, model );

		ResultSet rs = qe.execSelect();
		
		List<Artigo> artigos = popularListaArtigos(rs);
		
		model.close();
		
		return artigos;

		
	}
	
	
	private List<Artigo> popularListaArtigos(ResultSet rs){
		
		QuerySolution qs;
	    List<Artigo> artigos = new ArrayList<Artigo>();
	    Artigo artigo = new Artigo();
	    
	    EOSOntResourceAnnotation eosora;
		while(rs.hasNext()){
			
			qs = rs.nextSolution();
			
			eosora = new EOSOntResourceAnnotation();
						
			eosora.setLabel(qs.getLiteral("label").getString());
			//eosora.setComment(qs.getLiteral("comment").getString());
			
			artigo.setLocalName(qs.getResource("artigo").getLocalName());
			artigo.setAnotacao(eosora);
			artigo.setPreco(qs.getLiteral("valor").getDouble());
			artigo.setImagem(qs.getLiteral("imagem").getString());
						
			artigos.add(artigo);
			artigo = new Artigo();
		}
		
		return artigos;
	
	}
	
	
}
