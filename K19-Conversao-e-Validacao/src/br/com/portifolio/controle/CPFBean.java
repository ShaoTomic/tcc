package br.com.portifolio.controle;

import javax.faces.bean.ManagedBean;

import br.com.portifolio.modelo.CPF;

@ManagedBean(name="cPFBean")
public class CPFBean {
			
	private CPF cpf = new CPF();

	public CPF getCpf() {
		return cpf;
	}

	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}
	
	
}
