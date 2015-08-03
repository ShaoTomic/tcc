package br.com.eonto.agent;

public class EOSOntResourceAnnotation {
	private String localName;
	private String label;
	private String comment;
	
	public EOSOntResourceAnnotation() {

	}

	public EOSOntResourceAnnotation(String localName, String label,String comment) {
		this.localName = localName;
		this.label = label;
		this.comment = comment;
	}



	public String getLocalName() {
		return localName;
	}



	public void setLocalName(String localName) {
		this.localName = localName;
	}



	public String getLabel() {
		return label;
	}



	public void setLabel(String label) {
		this.label = label;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}

	
	
}
