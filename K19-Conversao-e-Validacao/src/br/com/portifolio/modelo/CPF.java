package br.com.portifolio.modelo;


public class CPF {

	private int numeroDeIdentificacao;
	private int primeiroDigitoVerificador;
	private int segundoDigitoVerificador;

	public int getNumeroDeIdentificacao() {
		return numeroDeIdentificacao;
	}
	public void setNumeroDeIdentificacao(int numeroDeIdentificacao) {
		this.numeroDeIdentificacao = numeroDeIdentificacao;
	}
	public int getPrimeiroDigitoVerificador() {
		return primeiroDigitoVerificador;
	}
	public void setPrimeiroDigitoVerificador(int primeiroDigitoVerificador) {
		this.primeiroDigitoVerificador = primeiroDigitoVerificador;
	}
	public int getSegundoDigitoVerificador() {
		return segundoDigitoVerificador;
	}
	public void setSegundoDigitoVerificador(int segundoDigitoVerificador) {
		this.segundoDigitoVerificador = segundoDigitoVerificador;
	}
	
	
}
