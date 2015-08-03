
var countTableLine = 0;
var propertiesInUse = new Array();
var ontClasses;

function init(){
  
	//sequência de funções  obrigatória 
	
	ontClasses = getAllSubClassesOf("Artigo",false);
	select_classes = document.getElementById("select_classes");
	fillSelectBoxProperty(select_classes,ontClasses);
	
	
	//1º criar tabela
	table = createTable();
		
	//2º -false:primeira chamada deve ser síncrona 
	ontology = getOntAllProperties(false);
	
	ontologyList = checkForInvalidProperty(ontology);
	
	//º3 criar linha da tabela com os itens da lista
	createTableLine(null);
	
}


function checkForPropertyRangeLikeADomain(individualClass){
	
	var isDomain = false
	$.each(ontologyList, function(index, item){
		if(item.domain.localName.localeCompare(individualClass)==0){
			isDomain = true;
		}
	})
	
	return isDomain;
}

function checkForPropertiesInUse(listOfProperties){
	
	var isPropInUse = false;
	var propertiesAbleToUse = new Array();
	
	 $.each(listOfProperties, function(index1 , value1){
		$.each(propertiesInUse,function(index2,value2){
			if(value1.property.localName.localeCompare(value2)==0 ){
				isPropInUse = true;
			}
		});
		
		if(!isPropInUse){
			var propAux = new Object();
			propAux.localName = value1.property.localName;
			propAux.label  = value1.property.label;
			propertiesAbleToUse.push(propAux);
		}else{
			isPropInUse=false;
		}
		
	});
	 
	return propertiesAbleToUse;
}

function fillSelectBoxProperty(selectBox,properties){
	
	var voidOption   =  document.createElement("option");
	selectBox.add(voidOption);
	
	var option;
	
	$.each(properties, function(index, prop){
		
		
		
		option = document.createElement("option");
		option.setAttribute("value",prop.localName);
		option.text = prop.label;
		selectBox.appendChild(option);
	});
	return selectBox;
}

function setPosition(selectBox,topPos,leftPos){
	selectBox.setAttribute("style","position:absolute; left:"+leftPos+"px; top:"+topPos+"px;");
	return selectBox;
}

function removeTableLine(btn){
	
	 var td = btn.parentNode;
	 var tr = td.parentNode;
	 var tds = tr.childNodes;
	 var tdsChildNodes = tds[1].childNodes;
	
	 var removePropList = new Array();
	 $.each(tdsChildNodes, function(index,selectBox){
		if(selectBox.name.localeCompare("property")==0){
			removePropList.push(selectBox.value);
		}
	 });
	 
	 $.each(propertiesInUse, function(index1, propInUse){
		 $.each(removePropList, function(index2, prop){
			 if(propInUse!=null && propInUse.localeCompare(prop)==0){
				    delete  propertiesInUse[index1];
			 } 
		 })
	  })
	
 
	 table.removeChild(tr);
}


var contTemCorProp=0;
function pushPropertyInPropertiesInUseList(selectBoxProperty){
	var property = selectBoxProperty.value;
	
	if(property.localeCompare("temCor")==0){
		
		contTemCorProp++;
		
		if(contTemCorProp==3){
			propertiesInUse.push(selectBoxProperty.value);
			contTemCorProp=0;
		}
	}else{
		propertiesInUse.push(selectBoxProperty.value);
	}
	
	
}


function createTableLine(button){

	//checando por propriedades já utilizadas
	var propertiesChecked  = checkForPropertiesInUse(ontologyList);
	
	//mudar botão para menos 
	if(button!=null){
		if(propertiesChecked.length != 0){
			var btnTextMinus = document.createTextNode("-");
			$(button).empty();
			button.setAttribute("onclick","removeTableLine(this)");
			button.appendChild(btnTextMinus);
		}
   }
		
	var tr  = document.createElement("tr");
	var td0 = document.createElement("td");
	var td1 = document.createElement("td");
	var td2 = document.createElement("td");
		
	selectBox = createSelectBox("property", "checkPropertySelectBox(this)");
		
	if(propertiesChecked.length != 0){
	
		selectBox = fillSelectBoxProperty(selectBox, propertiesChecked);
		
		//creating checkbox NOT
		var checkBox = document.createElement("input");
		checkBox.type = "checkbox";
			
		var textNodeNot = document.createTextNode("\u00A0 NÃO \u00A0");
		
		td0.appendChild(checkBox);
		td0.appendChild(textNodeNot);
		
		td1.appendChild(selectBox); 
		td1.style = "width:80%";
		
		//adicionando btn "+" a coluna 3
		var newBtn=createButton("+");
		newBtn.setAttribute("onClick","createTableLine(this)");
		newBtn.style = "visibility : hidden";
		newBtn.id = countTableLine;
	
		td2.appendChild(newBtn);
		
		tr.appendChild(td0);
		tr.appendChild(td1);
		tr.appendChild(td2);
		table.appendChild(tr);
		countTableLine++;
		
		
		
	}
}

//checagem para ranges do tipo numeral para tratamento diferenciado
function checkDataRangeType(range){
var numeralType = ["double","integer","float","int","decimal","real"];

	var isNumeral=false;
	for(i=0;i < numeralType.length;i++){
		if(range.localeCompare(numeralType[i])==0){
			isNumeral=true;
		}		
	}
	
	return isNumeral;
}


function listAllPropertiesOfDomain(classDomain){
	
	var propertiesOfDomain = new Array();
	$.each(ontologyList, function(index, item){
		if(item.domain.localName.localeCompare(classDomain)==0){
			var prop = new Object();
			propertiesOfDomain.push(item);
		}
	})
	
	return propertiesOfDomain;
}

function checkIndividualValue(individualSelectBox){
	
	if(individualSelectBox.value.localeCompare("?")==0){
		
		var classDomain = individualSelectBox.name;
		var allPropertiesOfDomainList = listAllPropertiesOfDomain(classDomain);
		var propertiesChecked  = checkForPropertiesInUse(allPropertiesOfDomainList);
		var propertyDomainSelectBox  = createSelectBox("property", "checkPropertySelectBox(this)");
		propertyDomainSelectBox = fillSelectBoxProperty(propertyDomainSelectBox, propertiesChecked);
		var td1 = individualSelectBox.parentNode;
		td1.appendChild(propertyDomainSelectBox);
		
	}else{
			
		
		var td = individualSelectBox.parentNode;
		var tr = td.parentNode;
		var tds = tr.childNodes;
		
		var td2 = tds[2].childNodes;
		if(td2[0].firstChild.nodeValue.localeCompare("-")!=0){
			enablePlusButton(countTableLine);
		}
				
	}
		
	
}


function removeChildrenAfterHTMLElement(HTMLElement){

  var indexAux = $(HTMLElement).index();	
  var HTMLParentNode = HTMLElement.parentNode;
  var HTMLChildNodes = HTMLParentNode.childNodes;
 
  if(indexAux == 0){
	  
	  $(HTMLParentNode).empty();
	  HTMLParentNode.appendChild(HTMLElement);
	  
  }else{

	  $.each(HTMLChildNodes, function(index, HTMLElement){
		 if(index > indexAux){
			 HTMLParentNode.removeChild(HTMLElement);
		 }
	  })
  }
}

function checkPropertySelectBox(propertySelectBox){
	
	if(propertySelectBox.value.trim()==""){
		removeChildrenAfterHTMLElement(propertySelectBox)
		
	}else{
		removeChildrenAfterHTMLElement(propertySelectBox)
		pushPropertyInPropertiesInUseList(propertySelectBox);
		createIndividual(propertySelectBox);
	}
		
}

function createIndividual(selectBox){
	
   var td1 = selectBox.parentNode;
   var tr = td1.parentNode;
   var tds = tr.childNodes; 
      
   var selectBoxValue = selectBox.value;
   var propertyRange = getPropertyRange(selectBoxValue);
   var isNumeral = checkDataRangeType(propertyRange);
	  
   individualSelectBox = document.createElement("select");
   individualSelectBox.setAttribute("name", selectBoxValue);
	
   //opção vazia
   var voidOption   =  document.createElement("option");
   individualSelectBox.add(voidOption); 
	   
   if(checkForPropertyRangeLikeADomain(propertyRange)){
	  var option = document.createElement("option");
	  option.value="?";
	  option.text="?";
	  individualSelectBox.appendChild(option);
	  individualSelectBox.setAttribute("name", propertyRange);
	  	     
   }
	
   individualSelectBox.setAttribute("onChange","checkIndividualValue(this)");
   
  var individualFilled;
  if(!isNumeral){
	var individuals = getAllIndividualsOfRange(propertyRange);
    individualFilled = fillSelectBoxEOSResourceAnnotation(individualSelectBox, individuals);
    td1.appendChild(individualFilled); 
    tds[0].style="visibility: visible" //habilitando campo NOT
  }else{
	individualFilled = createIndividualForNumeralRangeTypes(propertyRange);
	tds[0].style="visibility: hidden"; // desabilitando campo NOT
	
	td1.appendChild(individualFilled[0]); 
	td1.appendChild(individualFilled[1]); 
	td1.appendChild(individualFilled[2]);
  }
	
	
}


function enablePlusButton(idButton){
	var button = document.getElementById(idButton-1);
	button.style.visibility = "visible";
	
}

function createIndividualForNumeralRangeTypes(range){
	var restrictions = [" maior que "," menor que "," igual a "," maior ou igual a "," menor ou igual a "];
	var restrictionsSimbols=[">","<","=",">=","<="];
	
	var restrictionSelectBox = createSelectBox("numberRestriction", "");
  
	var option;
	for(i=0; i<restrictions.length;i++){
		option = document.createElement("option");
		option.text=restrictions[i];
		option.value = restrictionsSimbols[i];
		restrictionSelectBox.appendChild(option);
	}

	//divInputText.setAttribute("class","input-group-addon");// <div class="input-group-addon">$</div>
	
	
	var inputText = document.createElement("input");
	inputText.type = "text";
	inputText.style="width:20%";
	inputText.setAttribute("onblur","enablePlusButton("+countTableLine+")");
	inputText.name = "number";
	
	cifrao = document.createTextNode("R$");
		
	var numeralCamps = new Array();
	numeralCamps[0] = restrictionSelectBox;
	numeralCamps[1] = cifrao;
	numeralCamps[2] = inputText;
	
	return numeralCamps;
}


function fillSelectBoxEOSResourceAnnotation(selectBox, items){
   
	 var option = document.createElement("option");
	 for(i = 0; i < items.length ; i++){
		option.value = items[i].localName;
		option.text = items[i].label;
		selectBox.appendChild(option);
		option = document.createElement("option");
		
	 }
	 
	
	 return selectBox;
}



