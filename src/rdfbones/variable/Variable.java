package rdfbones.variable;

import rdfbones.process.Graph;

public class Variable {

	
	public Graph graph;
	public String uri;
	public String variableName;
	public String constantValue;
	public String mainInput;
	
	
	public Variable(String uri){
	
		this.uri = uri;
		this.setLiterals();
	}
	
	public void setLiterals(){
		
		String SPARQL = ""
				+ "SELECT ?variableName ?constantValue ?mainInput "
				+ "WHERE {"
				+ "	 	OPTIONAL { ?uri		wa:variableName				?variableName . }	"
				+ "	 	OPTIONAL { ?uri		wa:constantValue		  ?contantValue . }	"
				+ "	 	OPTIONAL { ?uri		wa:mainInput					?mainInput . }	"
				+ "   FILTER ( ?uri = <" + this.uri + "> )"  
				+ "	} ";
		
		//set the fields variables variableName, constantValue, mainInput
		
	}
	
}

