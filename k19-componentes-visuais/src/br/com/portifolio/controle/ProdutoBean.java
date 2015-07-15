package br.com.portifolio.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.portifolio.modelo.Produto;

@ManagedBean(name="produtoBean")
@SessionScoped
public class ProdutoBean {
	
	private Produto produto = new Produto();
	private List<Produto> produtos = new ArrayList<Produto>();
		
	public void adicionarProduto(){
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
