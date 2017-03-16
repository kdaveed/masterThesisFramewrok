package rdfbones.process;

import rdfbones.variable.ClassVariable;
import rdfbones.variable.Variable;

public class SubClassVariableDependency extends VariableDependency {

	public SubClassVariableDependency(Variable node) {
		super(node);
	}
	
	public SubClassVariableDependency(ClassVariable node) {
		this.outputNode = node;
	}
}

