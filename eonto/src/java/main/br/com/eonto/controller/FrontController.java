package br.com.eonto.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.eonto.agent.EOSAgent;
import br.com.eonto.agent.EOSOntPropertyJSON;
import br.com.eonto.agent.EOSOntResourceAnnotation;
import br.com.eonto.artigo.Artigo;
import br.com.eonto.artigo.ArtigoDAO;
import br.com.eonto.artigo.Modelo;
import br.com.eonto.artigo.ModeloDAO;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

@Controller
public class FrontController {
	
	 private String ont = "file:/home/jacksparow/Desenvolvimento/TCC_Data/data/modeloFinal.ttl";
	 private String nameSpace = "http://www.semanticweb.org/jacksparow/ontologies/2015/2/modelo#";
	
	//redireciona para a página main.jsp 
	@RequestMapping("/main")
	public String main(){
		return "main2";
	}
	
	//redireciona para a página cbox2.jsp
	@RequestMapping("/cbox2")
	public String cbox2(){
		return "cbox2";
	}

	@RequestMapping("/getOntAllProperties")
	public @ResponseBody List<EOSOntPropertyJSON>  getAllOntProperties(){
				
		EOSAgentController eosAgentController = new EOSAgentController(ont,nameSpace);
		return  eosAgentController.getAllOntProperties();
	}
	
	@RequestMapping("/getAllSubClassesOf")
	public @ResponseBody List<EOSOntResourceAnnotation> getAllSubClassesOf(@RequestParam("ontClass") String ontClass){
			
			EOSAgent eosAgent = new EOSAgent(ont,nameSpace);
			OntClass ontClass2 = eosAgent.getModel().getOntClass(nameSpace+ontClass);
		
			ExtendedIterator<OntClass> listSubClasses = ontClass2.listSubClasses();
			
			EOSOntResourceAnnotation eosRA = null;
			List<EOSOntResourceAnnotation> arrayList = new ArrayList<EOSOntResourceAnnotation>();
			
			while(listSubClasses.hasNext()){
				
			    eosRA = new EOSOntResourceAnnotation();
				
				OntClass next = listSubClasses.next();
				eosRA.setLocalName(next.getLocalName());
				eosRA.setLabel(next.getLabel(null));
				
				arrayList.add(eosRA);
			}
			
			for (EOSOntResourceAnnotation eosOntResourceAnnotation : arrayList) {
				//System.out.println(eosOntResourceAnnotation.getLocalName());
			}
			
			return arrayList;
			
	}
	
	@RequestMapping("/getAllIndividualsOfRange")
	public @ResponseBody List<EOSOntResourceAnnotation> getAllIndividualsOfRange(@RequestParam("range") String range){
		EOSAgentController eosAgentController = new EOSAgentController(ont,nameSpace);
		return eosAgentController.getAllIndividualsOfRange(range);
	}
	
	
	@RequestMapping("/articleQueryExecute")
	public @ResponseBody List<Artigo> articleQueryExecute(@RequestParam("query") String query){
		
		EOSAgent eosAgent = new EOSAgent(ont,nameSpace);
		ArtigoDAO artigoDAO = new ArtigoDAO();
		List<Artigo> artigos = artigoDAO.listar(query, eosAgent.getModel());
		
		return artigos;
	}
	
	
	@RequestMapping("/getAllArticleModels")
	public @ResponseBody List<Modelo> getAllArticleModels(@RequestParam("articleLocalName") String articleLocalName){
		
		OntModel model = ModelFactory.createOntologyModel();
		String ont = "file:/home/jacksparow/Desenvolvimento/TCC_Data/data/modeloFinal.ttl";
		model.read( ont );
		
		ModeloDAO modeloDAO = new ModeloDAO();
		List<Modelo> modelos = modeloDAO.listar(articleLocalName, model);
	
		for (Modelo modelo : modelos) {
			System.out.println(modelo.toString());
		}
		
		model.close();
		
		return modelos;
		
	}
	
}
