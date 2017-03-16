package rdfbones.variable;

import java.util.List;

import rdfbones.form.FormElement;
import rdfbones.process.Graph;
import rdfbones.statement.Statement;

public class Variable {

	
	public Graph graph = null;
	public String uri;
	public String variableName;
	public String constantValue;
	public String mainInput;
	public FormElement formElement = null;
	public List<Statement> statements = new ArrayList<Statement>(); 

	
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

