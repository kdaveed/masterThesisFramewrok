package rdfbones.process;

import org.json.JSONArray;
import org.json.JSONObject;

import rdfbones.lib.JSON;
import rdfbones.variable.ClassVariable;

public class IndependentVariable extends VariableDependency{

	public IndependentVariable(ClassVariable variable){
		this.outputNode = variable;
	}
	
	public JSONArray getData(){
		
		JSONArray arr = JSON.arr();
		JSONObject obj = JSON.obj();
		JSON.put(obj, this.outputNode.variableName, this.outputNode.constantValue);
		arr.put(obj);
		return arr;
	}
}
