package rdfbones.process;

import java.util.List;
import java.util.Map;

import dataInputProcess.DataInputProcess;
import rdfbones.statement.ClassRestrictionStatement;
import rdfbones.variable.ClassVariable;
//import rdfbones.lib.LabelDataGetter;
import rdfbones.variable.LiteralVariable;
import rdfbones.variable.ResourceVariable;
import rdfbones.variable.Variable;

public class Graph {

	public DataInputProcess dataInputProcess;
	public Graph mainGraph;
	private Graph parentGraph;
	// public LabelDataGetter labelGetter;
	public List<Variable> variables;
	public List<Variable> formVariables;

	public List<ResourceVariable> newInstances;
	public List<ResourceVariable> existingInstances;

	public List<LiteralVariable> literalVariables;

	public ClassRestrictionStatement parentRestriction;

	private ResourceVariable inputNode;

	// Values
	public Map<String, String> retrivedTypes;
	public Map<String, String> retrivedTypLabels;

	public VariableDependency typeRetriever;

	public Graph() {

		// Initiator
	}

	public String getLabel(String uri) {
		return null;
		// this.mainGraph.labelGetter.getLabel(uri);
	}

	public VariableDependency getVariableDependecy(ClassVariable variable) {

		if (variable.toEvaluate) {
			// I return the dependency that evaluates it
			return this.typeRetriever;
		} else {
			return new VariableDependency(variable);
		}
	}

	// The task of the graph is to set the type retriever dependency and the
	// global dependencies
	private void getClassDependencies() {

		// In each graph there is at most one class input
		if (this.inputNode.type.formElement != null) {
			VariableDependency inputClassDependency = null;
			if (this.parentRestriction != null) { // ** I **
				// The input class is dependent of a class of a parent form
				// We need to set the global dependency for the input
				ClassVariable inputClass = (ClassVariable) this.parentRestriction
						.getObject(this.inputNode.type);
				inputClassDependency = this.parentGraph
						.getVariableDependecy(inputClass);
				inputClassDependency.addToPath(parentRestriction);
			} else if (this.inputNode.type.superClass != null) { // ** II. **
				inputClassDependency = new SubClassVariableDependency(
						this.inputNode.type);
			} else if (this.inputNode.type.constantValue != null) { // ** III. **
				inputClassDependency = new IndependentVariable(this.inputNode.type);
			} else {
				// ERROR
				// The input class variable is form variable but not initialized
			}
			this.addToGlobalDependencies(inputClassDependency);
		} else { 
			if (this.inputNode.formElement != null) {	// ** IV. **
					this.processInstanceDependencies();
			} else { 
				//ERROR
				//Neither the input node, nor the input class of the subgraph appears on the form
			}
		}
	}
	
	private void processInstanceDependencies(){
		
		
		
	}

	
	private void addToGlobalDependencies(VariableDependency dependency) {

		if (dependency != null) {
			this.mainGraph.dataInputProcess.variableDependencies.put(
					dependency.outputNode.variableName, dependency);
		}
	}
}
