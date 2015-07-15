package br.com.portifolio.controle;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="caraOuCoroaBean")
public class CaraOuCoroaBean {
	public String proxima(){
		if(Math.random() < 0.5 ){
			return "cara";
		}else{
			return "coroa";
		}
	}

}
