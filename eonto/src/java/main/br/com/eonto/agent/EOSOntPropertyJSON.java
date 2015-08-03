package br.com.eonto.agent;



public class EOSOntPropertyJSON {
	
	private EOSOntResourceAnnotation domain;
	private EOSOntResourceAnnotation property;
	private EOSOntResourceAnnotation range;
		
	public EOSOntPropertyJSON() {
	
	}
		
	@Override
	public String toString() {
		return "EOSOntPropertyJSON \n domain=" + domain + 
				                 ",\n property="+ property + 
				                 ",\n range=" + range+"\n";
	}

	public EOSOntResourceAnnotation getDomain() {
		return domain;
	}
	public void setDomain(EOSOntResourceAnnotation domain) {
		this.domain = domain;
	}
	public EOSOntResourceAnnotation getProperty() {
		return property;
	}
	public void setProperty(EOSOntResourceAnnotation property) {
		this.property = property;
	}
	public EOSOntResourceAnnotation getRange() {
		return range;
	}
	public void setRange(EOSOntResourceAnnotation range) {
		this.range = range;
	}
	
	
	
	
}
