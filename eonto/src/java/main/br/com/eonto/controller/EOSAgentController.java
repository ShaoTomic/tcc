package br.com.eonto.controller;

import java.util.List;

import br.com.eonto.agent.EOSAgent;
import br.com.eonto.agent.EOSOntPropertyJSON;
import br.com.eonto.agent.EOSOntResourceAnnotation;
import br.com.eonto.agent.EOSOntResourceAnnotationFactory;
import br.com.eonto.artigo.Artigo;


public class EOSAgentController {
	
	EOSAgent eosAgent;
	
	public EOSAgentController(String ont, String nameSpace){
		 eosAgent = new EOSAgent(ont, nameSpace);
	}
	
	
	public  List<EOSOntPropertyJSON> getAllOntProperties(){
		return eosAgent.getAllOntProperties();
	}



	public List<EOSOntResourceAnnotation> getAllIndividualsOfRange(	String range) {
		return eosAgent.getAllIndividualsOfRange(range);
	}
	
}
