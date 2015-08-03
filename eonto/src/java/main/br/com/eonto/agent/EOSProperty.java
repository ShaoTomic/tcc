package br.com.eonto.agent;

import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.rdf.model.Property;

public class EOSProperty {

	private OntResource domain;
	private Property property;
	private EOSProperty range;
	private EOSQueryRestriction eosQueryRestriction = null;

	
	
    @Override
	public String toString() {
    	String info = "";
    	
    
    	try {
			info+= "EOSResource [domain=" + domain.getLocalName() + 
    				", property=" + property.getLocalName() + 
    				", range=" + range.getDomain().getLocalName() ; 
		} catch (NullPointerException e) {
			info+= "EOSResource [domain=" + domain.getLocalName() + 
					", property=" + property.getLocalName() + 
					", range=" + "null"; 
		}
    	
    	try {
    		info+= ", eosQueryRestriction=" + eosQueryRestriction.toString() + "]";
    	} catch (Exception e) {
			info+= ", eosResourceRestriction=null]";
		}
    	
    
    	return info;
	}

	public EOSProperty(){
    	
    }
    
	public EOSProperty(Property property, EOSProperty range,EOSQueryRestriction eosResourceRestriction){
		findDomain(property);
		this.range = range;
	    this.eosQueryRestriction = eosResourceRestriction;
	}

	public OntResource getDomain() {
		return domain;
	}

	public void setDomain(OntResource domain) {
		this.domain = domain;
	}

	public Property getProperty() {
		return property;
	}

	public OntResource findDomain(Property property){
		setProperty(property);
		return getDomain();
	}
	
	public void setProperty(Property property) {
		
		if(property.canAs(DatatypeProperty.class)){
			DatatypeProperty dp = property.as((DatatypeProperty.class));
			setDomain(dp.getDomain());
		}else{
			ObjectProperty op = property.as((ObjectProperty.class));
			setDomain(op.getDomain());
		}
		
		this.property = property;
	}

	public EOSProperty getRange() {
		return range;
	}

	public void setRange(EOSProperty range) {
		this.range = range;
	}
	
	public EOSQueryRestriction getEOSQueryRestriction() {
		return eosQueryRestriction;
	}

	public void setEOSQueryRestriction(EOSQueryRestriction eosQueryRestriction) {
		this.eosQueryRestriction = eosQueryRestriction;
	}

    public static void printRoute(EOSProperty eos){
    	recursiveFunction(recursiveFunction(eos));
    }
    
    private static  EOSProperty recursiveFunction(EOSProperty eos){
    
    	try {
	      		System.out.println(eos.getDomain());
	           	System.out.println(eos.getProperty());
	      		
	  	  	} catch (NullPointerException e) {
	  			return null;
	  		}
	      	
	      	try {
	      		System.out.println(eos.getEOSQueryRestriction().toString());
			} catch (NullPointerException e) {
				
			}
	      
    	
    	return eos.getRange();
    }
    
   
    public String getPartQuery(OntResource target){
         	
    	String partQuery = "";
    	String individual = "";
        String domain = getDomain().getLocalName().toLowerCase();
        
        if(getDomain().as(OntClass.class).hasSuperClass(target)){
        	domain="artigo";
        }
        
    	try {
            individual = getEOSQueryRestriction().getIndividual();
	   	
	    	if(property.canAs(DatatypeProperty.class)){
	    		if(getEOSQueryRestriction().getRestriction()!=null){
	    			partQuery+=" ?"+domain+" eos:"+getProperty().getLocalName()+" ?"+getProperty().getLocalName().toLowerCase();
		   		    String filter=" FILTER(?"+getProperty().getLocalName().toLowerCase()+" "+getEOSQueryRestriction().getRestriction()+" '"+
		   		    		      individual+"'^^<"+getProperty().as(DatatypeProperty.class).getRange()+"> ) .";
		   		    partQuery+=filter;
		   		}
	    	}else{
	    		// ObjectProperty
	    		  if(getEOSQueryRestriction().isPropertyExclusive()){
	    			  partQuery+=" MINUS{?"+domain+" eos:"+getProperty().getLocalName()+" eos:"+individual+" .}";
	    		  }else{
	    			  partQuery+=" ?"+domain+" eos:"+getProperty().getLocalName()+" eos:"+individual+" .";  
	    		  }
	    	}
    	
    	} catch (NullPointerException e) {
    			partQuery+=" ?"+domain+" eos:"+getProperty().getLocalName()+" ?"+getRange().getDomain().getLocalName().toLowerCase()+" .";
			
		}
    		
    	return partQuery;
    }
    

    
    
}
