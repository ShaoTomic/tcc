package br.com.eonto.agent;

public class EOSPropertyCardinality {

	private int qualifiedCardinality;
	private int minQualifiedCardinality;
	private int maxQualifiedCardinality;
	
	public EOSPropertyCardinality(){
		
	}
	
	

	@Override
	public String toString() {
		return "EOSPropertyCardinality [qualifiedCardinality="
				+ qualifiedCardinality + ", minQualifiedCardinality="
				+ minQualifiedCardinality + ", maxQualifiedCardinality="
				+ maxQualifiedCardinality + "]";
	}



	public int getQualifiedCardinality() {
		return qualifiedCardinality;
	}

	public void setQualifiedCardinality(int qualifiedCardinality) {
		this.qualifiedCardinality = qualifiedCardinality;
	}

	public int getMinQualifiedCardinality() {
		return minQualifiedCardinality;
	}

	public void setMinQualifiedCardinality(int minQualifiedCardinality) {
		this.minQualifiedCardinality = minQualifiedCardinality;
	}

	public int getMaxQualifiedCardinality() {
		return maxQualifiedCardinality;
	}

	public void setMaxQualifiedCardinality(int maxQualifiedCardinality) {
		this.maxQualifiedCardinality = maxQualifiedCardinality;
	}
	
	
	
	
	
}
