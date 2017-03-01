package rdfbones.variable;

public class ClassVariable extends Variable{

	public ClassVariable(String uri) {
		super(uri);
		// TODO Auto-generated constructor stub
	}

		
	public String getLabel(){
		return this.graph.getLabel(this.uri);
	}
}
