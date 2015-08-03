
function recarregarListaArtigos(artigos) {
	
	  var p = document.getElementById("lista");
	  
	  var filhos = p.childNodes;
	  for( i = filhos.length - 1; i >= 0; i-- ) {
	     p.removeChild( filhos[i] );
	  }
	  
	  
	  i=0;
	  var artigoMontado;
	  while(i < artigos.length){
		 
	  	artigoMontado = criarArtigo(artigos[i++]);
	  	p.appendChild(artigoMontado);
	  	
	  }
 	  
}


function criarArtigo(artigo){
	
	  var div1 = document.createElement("div");
	  div1.setAttribute("class","col-md-3 col-sm-6 hero-feature");
	  
	  div1.setAttribute("onclick","ativarModal('"+artigo.localName+"')");
	  
	  var div2 = document.createElement("div"); 
	  div2.setAttribute("class","thumbnail");	 
	 
      var img = document.createElement("img");
	  img.setAttribute("src","resources/img/"+artigo.imagem);
	  
	  var div3 = document.createElement("div");
	  div3.setAttribute("class","caption");
	 	 
	  var h4 = document.createElement("h4");
	  var a = document.createElement("a");
	  
	  a.text = artigo.anotacao.label;
	 
	  h4.appendChild(a);
	  div3.appendChild(h4);
	  
	  //<h4 class="pull-right" id="artigoPreco"></h4><br>
	   var h4Preco = document.createElement("h4");
	   h4Preco.setAttribute("class","pull-right");
	   h4Preco.textContent = "R$"+artigo.preco;
	   
	   div3.appendChild(h4Preco);
	   
	  /// <p id="artigoComentario" ></p>
	  var pComentario = document.createElement("p"); 
	  pComentario.textContent = artigo.comentario;
	  div3.appendChild(pComentario);
	   
	  div2.appendChild(img);
	  div2.appendChild(div3);
	  div1.appendChild(div2);
	  
	  return div1;
	
}

