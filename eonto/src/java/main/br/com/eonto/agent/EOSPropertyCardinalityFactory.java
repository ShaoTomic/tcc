package br.com.eonto.agent;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.rdf.model.Property;

public class EOSPropertyCardinalityFactory {

	
	public static EOSPropertyCardinality getInstance(OntResource or, OntModel model){
		EOSPropertyCardinality eospc = new EOSPropertyCardinality();
		
		String owl = "http://www.w3.org/2002/07/owl#";
		Property onClass = model.getProperty(owl+"onClass");
		Property maxQualifiedCardinality = model.getProperty(owl+"maxQualifiedCardinality");
		Property minQualifiedCardinality = model.getProperty(owl+"minQualifiedCardinality");
		Property qualifiedCardinality  = model.getProperty(owl+"qualifiedCardinality");
		
		int maxCardinality = or.getCardinality(maxQualifiedCardinality);
		eospc.setMaxQualifiedCardinality(maxCardinality);
		
		int minCardinality = or.getCardinality(minQualifiedCardinality);
		eospc.setMinQualifiedCardinality(minCardinality);
		
		
		int qualiCardinality = or.getCardinality(qualifiedCardinality);
		eospc.setQualifiedCardinality(qualiCardinality);

		//System.out.println(eospc.toString());
		
		return eospc;
	}
}
