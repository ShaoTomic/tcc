package br.com.eonto.agent;

public class EOSAgentConfig {
	private static String ontClassPath = "file:/home/jacksparow/Desenvolvimento/TCC_Data/data/modeloFinal.ttl";
	private static String nameSpace = "http://www.semanticweb.org/jacksparow/ontologies/2015/2/modelo#";
		
	public  static String getOntClassPath() {
		return ontClassPath;
	}
	public void setOntClassPath(String ontClassPath) {
		this.ontClassPath = ontClassPath;
	}
	public static String getNameSpace() {
		return nameSpace;
	}
	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}
		
	
	
}
