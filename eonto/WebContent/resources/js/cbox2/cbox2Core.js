
var propInUse;
var ontologyList;
var ontology;
var table;




function createSelectBox(type,onClickNameFunction){
		
	 var newSelectBox = document.createElement("select");
	 newSelectBox.setAttribute("onChange",onClickNameFunction);
	 newSelectBox.setAttribute("name",type);
	 
   return newSelectBox; 
}

function createTable(){

	var table = document.getElementById("selectTable"); 
	
	/*
	var table = document.createElement("table");
	table.setAttribute("style","position:absolute; left: 100px; top:50px;");
	table.setAttribute("id","table");
	//table.setAttribute("border","1");
	document.body.appendChild(table);
	*/
	return table;
}

function createButton(textNode){
	var btn = document.createElement("button");
	var btnText = document.createTextNode(textNode);
	btn.appendChild(btnText);
	return btn;
}

function checkForInvalidProperty(list){
	   
	var invalidProperties = ["temModelo","temImagem"];
	
	var isProperyRestricted = false;
	var propertiesAux = new Array();
	
	$.each(list, function(index, item){
		$.each(invalidProperties, function(index, value){
			if(item.property.localName.localeCompare(value)==0){
				isProperyRestricted = true;
			}
		})
		
		if(!isProperyRestricted){
			propertiesAux.push(item);
		}else{
			isProperyRestricted = false
		}
	
	})
	
	
	return propertiesAux;
}

