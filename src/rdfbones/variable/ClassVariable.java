package rdfbones.variable;

import java.util.List;

import rdfbones.form.FormElement;
import rdfbones.process.VariableDependency;
import rdfbones.statement.RestrictionStatement;
import rdfbones.statement.Statement;

public class ClassVariable extends Variable {

	// This field plays a role in the queries of the variabledependencies
	public ClassVariable superClass = null;
	public List<Error> errors;
	
	public boolean toEvaluate = true;
	public boolean valid = false;
	
	public ClassVariable(String uri) {
		super(uri);
		// TODO Auto-generated constructor stub
	}

	public String getLabel() {
		return this.graph.getLabel(this.uri);
	}
	
	public VariableDependency getVariableDependency(VariableDependency vd, RestrictionStatement rt){
		vd.addToPath(rt);
		if(this.formElement != null){
			vd.addInputNode(this);
		} else {
			RestrictionStatement nextEdge = getNextEdge(rt);
			if(nextEdge != null){
				return ((ClassVariable) nextEdge.getObject(this)).getVariableDependency(vd, nextEdge);
			}
		}
		return vd;
	}
	
	public RestrictionStatement getNextEdge(RestrictionStatement rt){
		
		for(Statement st : this.statements){
			if(st instanceof RestrictionStatement && st.uri != rt.uri){
				return (RestrictionStatement) st;
			}
		}
		return null;
	}	
}
