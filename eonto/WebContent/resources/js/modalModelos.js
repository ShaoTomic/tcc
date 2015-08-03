var modelos;

function ativarModal(articleLabel){
		
	
	modelos = getAllArticleModels(articleLabel);
	
	createArticleColorLine(modelos);
	
	$('#myModal').modal('show');
}



function createArticleColorLine(modelos){

		
  	 var tr = document.getElementById("articleColors");

     canvas = document.createElement("canvas");
     canvas.width = 50;
     canvas.height = 50;

     canvas.setAttribute("onclick","carregarImagemModelo('"+modelos[0].imagem+"')");
     
     drawCanvasColorOptions(canvas, modelos[0]);
     
     td = document.createElement("td");
     td.setAttribute("align","center");
     td.appendChild(canvas);
	 tr.appendChild(td);
	

}



function drawCanvasColorOptions(canvas, modelo){
	
	var numberOfColors = modelo.cores.length;	

	switch(numberOfColors){

		case 1: 
			canvas = draw(canvas, modelo.cores[0], modelo.cores[0], modelo.cores[0], modelo.cores[0]);
			break;

		case 2: 
			canvas = draw(canvas, modelo.cores[0], modelo.cores[0], modelo.cores[1], modelo.cores[1]);
			break;

		case 3: 
			canvas = draw(canvas, modelo.cores[0], modelo.cores[1], modelo.cores[2], modelo.cores[2]);
			break;

		case 4: 
			canvas = draw(canvas, modelo.cores[0], modelo.cores[1], modelo.cores[2], modelo.cores[3]);
			break;
	}

	return canvas;
}


function draw(canvas, color1, color2, color3, color4) {

	console.log("color1:"+color1+" color2:"+color2+" color3:"+color3+" color4:"+color4);

  	var context = canvas.getContext('2d');
	
  	var iniPos=5;
	var x = 20;
	var center = (((x*2)-iniPos)/2)+iniPos;
	
	context.lineWidth = 0;
	context.beginPath();
	
	context.moveTo(iniPos,iniPos); //define o ponto de início
	context.lineTo(2*x, iniPos);
	context.lineTo(center ,center );
	context.lineTo(iniPos,iniPos);
	
	context.fillStyle = color1;
    context.fill();
   
   
	context.beginPath();
		
	context.moveTo(iniPos, iniPos); //define o ponto de início
	context.lineTo(iniPos, 2*x);
	context.lineTo(center, center);
	context.lineTo(iniPos, iniPos);
		
	context.fillStyle = color2;
    context.fill();
    

	context.beginPath();
	context.moveTo(iniPos, x*2)
	context.lineTo(x*2, x*2);
	context.lineTo(center,center);
	context.lineTo(iniPos, x*2);

	context.fillStyle = color3;
    context.fill();
    
	context.beginPath();

	context.moveTo(x*2, x*2);
    context.lineTo(x*2, iniPos);
    context.lineTo(center, center);
    context.lineTo(x*2, x*2);
	
	context.fillStyle = color4;
    context.fill();
  
    
    //desenhando as bordas 
    context.beginPath();
	context.moveTo(iniPos, iniPos);
    context.lineTo(iniPos, x*2);
    context.lineTo(x*2, x*2);
    context.lineTo(x*2,iniPos);
    context.lineTo(iniPos, iniPos);
    
    context.lineWidth = 2;
	context.strokeStyle = "black";
	context.stroke();
       
	context.closePath();

	return canvas;
	
}


function carregarImagemModelo(imagem){
  
    
    var tamanhoTexto;
    var tdRadioTamanho = document.getElementById("radioTamanho");
    
    $.each(modelos, function(index, modelo){
    	
    	if(modelo.imagem.localeCompare(imagem)==0 && (modelo.quantidade > 0) ){
    		
	        tamanhoTexto = document.createTextNode(modelo.tamanho+" ");  
	        
	        tdRadioTamanho.appendChild(tamanhoTexto);
	        
    	}
    })
       
	
	var imgElem = document.getElementById("imgModelo");
    imgElem.src = "resources/img/"+imagem;

   

}
