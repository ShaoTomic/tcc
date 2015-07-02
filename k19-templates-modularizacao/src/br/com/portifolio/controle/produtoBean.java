package br.com.portifolio.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.portifolio.modelo.Produto;

@ManagedBean(name="produtoBean")
public class produtoBean {

	private List<Produto> produtos = new ArrayList<Produto>();
	
	public produtoBean(){
		
		Produto p1 = new Produto("creme dental colgate",4.99,"creme dental para dentes sensíveis","produto.png");
		Produto p2 = new Produto("sabonete dove",6.75,"sabonete hidratante para peles mistas", "produto.png");
		Produto p3 = new Produto("desodorante axe",7.00,"desodorante tipo spray metol", "produto.png");
		
		produtos.add(p1); produtos.add(p2); produtos.add(p3);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
}
