package rdfbones.variable;

import rdfbones.utils.Cardinality;

public class ResourceVariable extends Variable{

	public ClassVariable type;
	public boolean subGraphStartNode = false;
	
	public ResourceVariable(String uri) {
		super(uri);
		// TODO Auto-generated constructor stub
	}
}


