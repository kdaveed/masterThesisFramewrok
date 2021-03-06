package rdfbones.statement;

import rdfbones.variable.Variable;

public class Statement {

	public String uri;
	public Variable subject;
	public String predicate;
	public Variable object;
	
	public Statement(String uri){
		this.uri = uri;
	}
	
	public Variable getObject(Variable subject){
		
		if(this.subject.uri.equals(subject.uri)){
			return this.object;
		} else {
			return this.subject;
		}
	}
}

