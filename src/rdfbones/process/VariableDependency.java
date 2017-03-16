package rdfbones.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import rdfbones.statement.Statement;
import rdfbones.variable.Variable;

public class VariableDependency {

	public Variable outputNode;
	public List<Variable> inputNodes = null;
	public Variable inputNode;
	
	public List<Statement> path;
	
	public VariableDependency(){
		
	}

	public VariableDependency(Variable node){
		this.inputNode = node;
	}
	
	public List<Map<String, String>> setSomeValuesFrom(List<Map<String, String>> result){
		
		for(Map<String, String> map : result){
			map.put("min", Integer.toString(1));
		}
		return result;
	}
	
	public void addInputNode(Variable var){
		
		if(this.inputNodes == null){
			this.inputNodes = new ArrayList<Variable>();
		}
		this.inputNodes.add(var);
	}
	
	public void addToPath(Statement statement){
		this.path.add(statement);
	}
}
