package rdfbones.process;

import java.util.List;

import rdfbones.lib.LabelDataGetter;
import rdfbones.variable.LiteralVariable;
import rdfbones.variable.ResourceVariable;
import rdfbones.variable.Variable;

public class Graph {

	
	public Graph mainGraph;
	public LabelDataGetter labelGetter;
	public List<Variable> variables;

	public List<ResourceVariable> newInstances;
	public List<ResourceVariable> existingInstances;
	
	public List<LiteralVariable> literalVariables;
	
	
	public Graph(){
	
			//Initiator
		
	}
	
	
	
	public String getLabel(String uri){
		return this.mainGraph.labelGetter.getLabel(uri);
	}
}
