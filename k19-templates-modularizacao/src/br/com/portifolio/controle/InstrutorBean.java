package br.com.portifolio.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.portifolio.modelo.Instrutor;

@ManagedBean(name="instrutorBean")
public class InstrutorBean {
	private List<Instrutor> instrutores = new ArrayList<Instrutor>();
	
	public InstrutorBean(){
		Instrutor ins1 = new Instrutor("Rafael Consentino","30/10/1084");
		Instrutor ins2 = new Instrutor("Marcelo Martins","02/04/1985");
		
		this.instrutores.add(ins1);
		this.instrutores.add(ins2);
	}

	public List<Instrutor> getInstrutores() {
		return instrutores;
	}

	public void setInstrutores(List<Instrutor> instrutores) {
		this.instrutores = instrutores;
	}
	
	
}
