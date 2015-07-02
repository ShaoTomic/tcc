package br.com.portifolio.controle;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="consumidorBean")
public class ConsumidorBean {
	private String nome;
	private String email;
	private String telefone;
	private char sexo;
	private int numeroDoPedido;
	private ArrayList<String> assunto;
	private String comentario;
	
	public ConsumidorBean(){
		assunto = new ArrayList<String>();
		assunto.add("reclamações");
		assunto.add("sugestões");
		assunto.add("dúvida");
		assunto.add("elogios");
	}
	
	
	public String enviar(){
		return "consumidor";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public int getNumeroDoPedido() {
		return numeroDoPedido;
	}
	public void setNumeroDoPedido(int numeroDoPedido) {
		this.numeroDoPedido = numeroDoPedido;
	}
	public ArrayList<String> getAssunto() {
		return assunto;
	}
	public void setAssunto(ArrayList<String> assunto) {
		this.assunto = assunto;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	
}
