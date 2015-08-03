
function createQuery(){
	
	var trs = table.childNodes;
	var domain = "eos:";
	
	var tdsAux;
	var selects;
	
	var rdf  = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n";
	var owl  = "PREFIX owl: <http://www.w3.org/2002/07/owl#> \n";
	var rdfs = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n";
	var xsd  = "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> \n";
	var eos  = "PREFIX eos: <http://www.semanticweb.org/jacksparow/ontologies/2015/2/modelo#> \n\n";	
	
	var prefixies = rdf+owl+rdfs+xsd+eos;
	
	var header = "SELECT  DISTINCT ?artigo ?label ?comment ?valor ?imagem  WHERE{ \n";
	
	var ontClass = $("#select_classes").val();
	
	header+=" ?artigo rdf:type "+domain+ontClass+". \n\n";
	
	
	var query='';
	var ontResource;
	var partQuery='';
	var finalQuery='';
	
	for(y = 0; y < trs.length; y++){
		
		tdsAux = trs[y].childNodes;
		selects = tdsAux[1].childNodes;
		tdsChildNodes = tdsAux[0].childNodes;
		
		for(ii = 0; ii < selects.length; ii++){
					
			if(getPropertyDomain(selects[ii].value).localeCompare("Artigo")!=0 && 
			   getPropertyDomain(selects[ii].value).localeCompare("Vestuario")!=0){
				
				// traçando rota de propriedade até artigo
				partQuery = traceRoute(selects[ii].value);
				query+=partQuery+" "+domain + selects[ii+1].value+".\n";
				partQuery='';
				
			}else if(selects[ii].name.trim().localeCompare("property")==0 && selects[ii+1].name.trim().localeCompare("numberRestriction")==0){
				
				query+="  ?artigo " + domain + selects[ii].value +" ?valor .\n";
				query+="   FILTER(?valor " + selects[ii+1].value + " " +selects[ii+3].value+") \n";
			
			}else if(selects[ii].name.trim().localeCompare("property")==0 && selects[ii+1].value.trim().localeCompare("?")==0){
				
				query+="  ?artigo " + domain + selects[ii].value + " ?"+ selects[ii+1].name+" .";
				query+="  ?"+selects[ii+1].name +" "+ domain + selects[ii+2].value+" "+domain+selects[ii+3].value+" .\n";
				
			}else{
				query+="  ?artigo " + domain + selects[ii].value + " " + domain + selects[ii+1].value+" .\n";
			}
			
			if(tdsChildNodes[0].checked && selects[ii+1].name.trim().localeCompare("numberRestriction")!=0){
				var queryMinus = "FILTER NOT EXISTS{"+query+"}";
				query = queryMinus;
			}
			
			ii = selects.length;
		}
		finalQuery+=query;
		query='';
			
	}
	
	var botton = "\n  ?artigo rdfs:label ?label. \n" +
				
				 "  ?artigo "+domain+"temPreco ?valor. \n" +
				 "  ?artigo "+domain+"temImagem ?imagem. \n" +
			      "}\n";
				 
	
	finalQuery = prefixies + header + finalQuery + botton;
		
		
	sendQueryToServer(finalQuery);
		
}

function getPropertyRange(property){

	var range;
	for(i=0; i < ontology.length; i++){
		if(property.localeCompare(ontology[i].property.localName)==0){
			range = ontology[i].range.localName;
		}
	}
	
	return range;
}



function getPropertyDomain(property){
	
	var domain;
	for(i=0; i < ontology.length; i++){
		if(property.localeCompare(ontology[i].property.localName)==0){
			domain = ontology[i].domain.localName;
		}
	}
	
	return domain;
}


function getPropertyOfRange(range){
	
	var property;
	var rangeAux;
	
	for(i=0; i < ontology.length; i++){
		
		rangeAux = ontology[i].range.localName;
		
		if(rangeAux.localeCompare(range)==0){
			property = ontology[i].property.localName;
			return property;
		}
	}
	
	return 0; 
	
}


function traceRoute(propertyAux){

	var domainAux ='';
	var ontResource = new Array();
	
	ontResource.push(propertyAux);
	while(domainAux.localeCompare("Artigo")!=0){
	
		domainAux = getPropertyDomain(propertyAux);
		ontResource.push(domainAux);
		propertyAux = getPropertyOfRange(domainAux);
	
		if(propertyAux!=0){
			ontResource.push(propertyAux);
		}
	}	
	
	var partQuery='';
	
	var auxVar;
	
	while(ontResource.length!=0){
		
		auxVar=ontResource.pop();
		
		if(auxVar.localeCompare("Artigo")!=0){
			partQuery+="?"+auxVar.toLowerCase()+". \n";
			partQuery+="?"+auxVar.toLowerCase()+" ";
		}else{
			partQuery+="?"+auxVar.toLowerCase()+" ";
		}
		
		partQuery+="eos:"+ontResource.pop()+" ";
		
		
	}
	
	return partQuery;
}
