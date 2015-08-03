package br.com.eonto.agent;


public class EOSQueryRestriction {

	private boolean isPropertyExclusive = false;
	private String individual="" ;
	private String restriction="";
	
	@Override
	public String toString() {
		return " [isPropertyExclusive="
				+ isPropertyExclusive + ", individual=" + individual
				+ ", restriction=" + restriction + "]";
	}

	public EOSQueryRestriction(){
		
	}
	
	public EOSQueryRestriction(boolean isPropertyExclusive,	String individual,String restriction) {
		
		this.isPropertyExclusive = isPropertyExclusive;
		this.individual = individual;
		this.restriction = restriction;
	}

	public boolean isPropertyExclusive() {
		return isPropertyExclusive;
	}

	public void setPropertyExclusive(boolean isPropertyExclusive) {
		this.isPropertyExclusive = isPropertyExclusive;
	}

	public String getIndividual() {
		return individual;
	}

	public void setIndividual(String individual) {
		this.individual = individual;
	}


	public String getRestriction() {
		return restriction;
	}

	public void setRestriction(String restriction) {
		
		if(restriction !=null && !restriction.isEmpty()){
			
			if(!restriction.trim().equals(">")&& 
			   !restriction.trim().equals("<")&&
			   !restriction.trim().equals("=")&&
			   !restriction.trim().equals("<=")&&
			   !restriction.trim().equals(">=")){
				
				throw new IllegalArgumentException("invalid restriction "+restriction);
			}
			
	    }
		
		this.restriction = restriction;
	}


	
}
