
/*function getOntAllProperties:
 *faz uma requisição para o frontController "/getAllProperties" requerindo todas as propriedades 
*da ontologia, a interface do array "data" retornado pela function success é a mesma da class
* excluindo os prefixos get/set , exemplo: para acessar o atributo domain
* data[0].domain.localName ou data[0].domain.label, já que domain, property e range são objetos
* da classe EOSOntResourceAnnotation que por sua vez possui os atributos (localName e label)
* a function getOntAllProperties(isAsync).sucess(data) possui o método listProperties(data) comentado
* para verificar o que foi recebido apenas retire os comentários e acesse o console do navegador
* clicando com o botão direito na página cbox2 e selecionando a opção inspecionar elemento e cliando na aba console 
*/

function getAllArticleModels(articleLocalName){
	
	var aux;
	
	$.ajax({
		type:"GET",
		async:false,
		url : "http://localhost:8080/eonto/getAllArticleModels",
		data : { articleLocalName : articleLocalName },
		success : function(data){
			aux = data;
		},
		error : function(){
			console.log("ERRO: ajax cbox2Ajax.js function getAllSubClassesOf() fails!!!");
		}
	})
	
	console.log("aux:"+aux);
	
	return aux;
}

function getAllSubClassesOf(ontClass,isAsync){
	
	var ontClasses;
	
	$.ajax({
		type:"GET",
		async:isAsync,
		url : "http://localhost:8080/eonto/getAllSubClassesOf",
		data : {ontClass : ontClass},
		success : function(data){
			ontClasses = data;
		},
		error : function(){
			console.log("ERRO: ajax cbox2Ajax.js function getAllSubClassesOf() fails!!!");
		}
	})
	
	return ontClasses;
	
}

function sendQueryToServer(query){
	
	$.ajax({
		type :"GET",
		async: true,
		url : "http://localhost:8080/eonto/articleQueryExecute",
		data : {query : query},
		success : function(data){
			recarregarListaArtigos(data);
		},
		error : function(){
			console.log("ERRO: ajax cbox2Ajax.js function sendQueryToServer() fails!!!");
			alert("servidor fora do ar");
		}
	})	

}



function getOntAllProperties(isAsync){
		 
	  var dataAux;
	  $.ajax({
			type :"GET",
			async: isAsync,
			url : "http://localhost:8080/eonto/getOntAllProperties",
			success : function(data){
				dataAux = data;
				//listProperties(data)
			},
			error : function(){
				console.log("ERRO: ajax cbox2Ajax.js function getOntAllProperties() fails!!!");
				alert("servidor fora do ar");
			}
		})	
	
		
		
		return dataAux;
}

function getAllIndividualsOfRange(range){
		
	var dataAux;
	  $.ajax({
			type :"GET",
			async: false,
			url : "http://localhost:8080/eonto/getAllIndividualsOfRange",
			data : {range : range},
			success : function(data){
				dataAux = data;
			},
			error : function(){
				console.log("ERRO: ajax cbox2Ajax.js function getAllIndividualsOfRange() fails!!!");
				alert("servidor fora do ar");
			}
		})	
	
		return dataAux;
}
	



//função teste
function listandoArtigos(data){
	console.log("listando artigos");
	$.each(data,function(index, item){
		console.log(item);
	})
}

//função de teste
function listProperties(data){
	  console.log("data length:"+data.length);
  for(i = 0; i < data.length ; i++){
	  console.log("property:"+data[i].property.localName+" label:"+data[i].property.label);
	  //console.log("domain"+data[i].domain.localName+" label:"+data[i].domain.label);
	  //console.log("range"+data[i].range.localName+" label:"+data[i].range.label);
  }
	  
}
