package rdfbones.form;

public class ClassSelectorSubformAdder extends SubformAdder {

	public ClassSelectorSubformAdder(String uri) {
		super(uri);
		// TODO Auto-generated constructor stub
	}
	
	private static final String TYPE = "CLASSSELECTORSUBFORMADDER";
	
	@Override
	public String getType(){
		return ClassSelectorSubformAdder.TYPE;
	}
}