package br.com.eonto.agent;

import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.query.QuerySolution;

public class EOSOntResourceAnnotationFactory {
	
	public static EOSOntResourceAnnotation getInstance(OntResource or){
		EOSOntResourceAnnotation eosora = new EOSOntResourceAnnotation();
	
		eosora.setLocalName(or.getLocalName());
		eosora.setLabel(or.getLabel(null));
		eosora.setComment(or.getComment(null));
		
		return eosora;
	}
	
	
}
