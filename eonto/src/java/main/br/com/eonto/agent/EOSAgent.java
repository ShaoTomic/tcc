package br.com.eonto.agent;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.mindswap.pellet.jena.PelletReasonerFactory;

import br.com.eonto.artigo.Artigo;

import com.clarkparsia.pellet.sparqldl.jena.SparqlDLExecutionFactory;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

public class EOSAgent {
	
   // ontology that will be used
   private String ont ;
   private String nameSpace;
   private OntModel model;
   
   //PREFIXES
   private String owl = "<http://www.w3.org/2002/07/owl#>";
   private String rdfs= "<http://www.w3.org/2000/01/rdf-schema#>";
   private String rdf = "<http://www.w3.org/1999/02/22-rdf-syntax-ns#>";
   private String xsd = "<http://www.w3.org/2001/XMLSchema#>";
   private String eos = "<http://www.semanticweb.org/jacksparow/ontologies/2015/2/modelo#>";
   
   private String eosPrefixes=owl+"\n"+rdfs+"\n"+rdf+"\n"+xsd+"\n"+eos+"\n";


   public EOSAgent(String ont, String nameSpace) {
		
	   this.ont = ont;
		this.nameSpace = nameSpace;
		
		//model = ModelFactory.createOntologyModel( PelletReasonerFactory.THE_SPEC );
		model = ModelFactory.createOntologyModel();
		model.read( ont );
		// load the model to the reasoner
		model.prepare();
		
	}
	
  
  
	
	private String getAllPartQuerys(ArrayList<EOSProperty> eosProperties, OntClass target, String query){
		
		String partQuery="";
	    for (EOSProperty eosProperty : eosProperties) {
			partQuery = getPartQuery(eosProperty, target, partQuery);
            query+=partQuery+"\n";
            partQuery="";
		}
		
		
		return query;
	}
	
	
    private  String getPartQuery(EOSProperty eosp,OntClass target,String queryAux){
		
		if(eosp!=null){
			queryAux+=eosp.getPartQuery(target);
			return getPartQuery(eosp.getRange(),target,queryAux);
		}
		  
		return queryAux;
	}

	private String getFullQuery(String query,String eosprefixes) {
	
		String select = "\n SELECT DISTINCT  ?artigo ?label ?preco  WHERE{ \n\n";
		
		String artigo = " ?artigo eos:temPreco ?preco.  \n"
					  + " ?artigo rdfs:label ?label .\n}";
		
		return eosprefixes+select+query+"\n"+artigo;
	}
	
	public List<EOSOntPropertyJSON> getAllOntProperties(){
		List<EOSOntPropertyJSON> listProperties = new ArrayList<EOSOntPropertyJSON>();
		
		Property onClass = model.getProperty("http://www.w3.org/2002/07/owl#onClass");
		
		ExtendedIterator<OntProperty> listAllOntProperties = model.listAllOntProperties();
						
			while(listAllOntProperties.hasNext()){
				
				OntProperty nextOntProperty = listAllOntProperties.next();
				EOSOntPropertyJSON eospJson;
				EOSOntResourceAnnotation eosRA;
				
				if(nextOntProperty.getNameSpace().equals(nameSpace)){
					
					eospJson = new EOSOntPropertyJSON();
					eosRA = new EOSOntResourceAnnotation();
					
					//pegando primeiro o domain: checando null por causa da probabilidade de existirem cardinalidades onde o 
					//tratamento para a recuperação do domínio é diferente
					EOSOntResourceAnnotation domain;
					if(nextOntProperty.getDomain().getLocalName()==null){
						 OntResource domainOntResource = nextOntProperty.getDomain().getPropertyValue(onClass).as(OntResource.class);
						 domain = EOSOntResourceAnnotationFactory.getInstance(domainOntResource);
					}else{
						 domain = EOSOntResourceAnnotationFactory.getInstance(nextOntProperty.getDomain());
					}
					eospJson.setDomain(domain);
					
					EOSOntResourceAnnotation range;
					if(nextOntProperty.getRange().getLocalName()==null){
						 OntResource domainOntResource = nextOntProperty.getRange().getPropertyValue(onClass).as(OntResource.class);
						 range = EOSOntResourceAnnotationFactory.getInstance(domainOntResource);
					}else{
						 range = EOSOntResourceAnnotationFactory.getInstance(nextOntProperty.getRange());
					}
					eospJson.setRange(range);
					
					EOSOntResourceAnnotation property = EOSOntResourceAnnotationFactory.getInstance(nextOntProperty);
					eospJson.setProperty(property);
										
					listProperties.add(eospJson);
				}
			}
				
		return listProperties;
	}
			
	public List<EOSOntResourceAnnotation> getAllIndividualsOfRange(String range) {
		 
			OntClass ontClass = model.getOntClass(nameSpace+range);
			ExtendedIterator<? extends OntResource> listInstances = ontClass.listInstances();
			List<EOSOntResourceAnnotation> instances = new ArrayList<EOSOntResourceAnnotation>();
			while(listInstances.hasNext()){
				EOSOntResourceAnnotation instance = EOSOntResourceAnnotationFactory.getInstance(listInstances.next());
				instances.add(instance);
			}
			
			return instances;
	}
	
	
	
	public String getOnt() {
		return ont;
	}

	public void setOnt(String ont) {
		this.ont = ont;
	}

	public String getNameSpace() {
		return nameSpace;
	}

	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	public String getEosPrefixes() {
		return eosPrefixes;
    }

	public void setEosPrefixes(String eosPrefixes) {
		this.eosPrefixes +="\n"+eosPrefixes;
	}


	public OntModel getModel() {
		return model;
	}


	public void setModel(OntModel model) {
		this.model = model;
	}
	
	
	
}
