package dataInputProcess;

import java.util.HashMap;
import java.util.Map;

import rdfbones.form.FormElement;
import rdfbones.process.VariableDependency;
import rdfbones.statement.Statement;
import rdfbones.variable.Variable;

public class DataInputProcess {

	public Map<String, Variable> variables;
	public Map<String, Statement> statements;
	public Map<String, FormElement> formElements;

	public Map<String, VariableDependency> variableDependencies = new HashMap<String, VariableDependency>();
	
}


