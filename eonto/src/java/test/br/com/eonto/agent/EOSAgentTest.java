package br.com.eonto.agent;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class EOSAgentTest {
	EOSAgent eosAgent;
	
	 public EOSAgentTest(){
		 eosAgent = new EOSAgent(EOSAgentConfig.getOntClassPath(),EOSAgentConfig.getNameSpace());
	 }

	
	@Test
	public void getAllOntProperties() {
	        eosAgent.getAllOntProperties();
	}

	@Test
	public void getAllIndividualsOfRange(){
		  
		   List<EOSOntResourceAnnotation> allIndividualsOfRange = eosAgent.getAllIndividualsOfRange("Cor");
		   Assert.assertEquals(allIndividualsOfRange.get(0).getLocalName(), "Verde");
		
	}
	
}
