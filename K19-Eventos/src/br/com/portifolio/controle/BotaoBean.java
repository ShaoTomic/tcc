package br.com.portifolio.controle;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;


@ManagedBean(name="botaoBean")
public class BotaoBean {
	public void sorteiaBotao(ActionEvent event){
		UIComponent formulario = event.getComponent().getParent();
		
		UIComponent botaoJonas = formulario.findComponent("botao-jonas");
		UIComponent botaoMarcelo = formulario.findComponent("botao-marcelo");
		UIComponent botaoRafael = formulario.findComponent("botao-rafael");
		
		botaoJonas.getAttributes().put("disabled", true);
		botaoMarcelo.getAttributes().put("disabled", true);
		botaoRafael.getAttributes().put("disabled", true);
		
		double numero = Math.random();
		
		if(numero < 1.0/3.0){
			botaoJonas.getAttributes().put("disabled", false);
		}else if(numero < 2.0/3.0){
			botaoMarcelo.getAttributes().put("disabled", false);
		}else{
			botaoRafael.getAttributes().put("disabled", false);
		}
	}
}
