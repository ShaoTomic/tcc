package br.com.portifolio.controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.portifolio.modelo.Funcionario;


@ManagedBean(name="funcionarioBean")
@RequestScoped
public class FuncionarioBean {
	private Funcionario funcionario;
	
	public FuncionarioBean(){
		this.funcionario = new Funcionario();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}
