package rdfbones.form;

public class InstanceSelectorSubformAdder extends SelectorSubformAdder {

	public InstanceSelectorSubformAdder(String uri) {
		super(uri);
		// TODO Auto-generated constructor stub
	}

	private static final String TYPE = "INSTANCESELECTORSUBFORMADDER";
	
	@Override
	public String getType(){
		return InstanceSelectorSubformAdder.TYPE;
	}
}
