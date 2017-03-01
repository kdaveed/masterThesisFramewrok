package rdfbones.form;

public class SubformAdder extends FormContainer{

	public int min;
	public int max;
	private static final String TYPE = "SUBFORMADDER";
	
	public SubformAdder(String uri){
		
		super(uri);
		
	}
	
	@Override
	public String getType(){
		return SubformAdder.TYPE;
	}
	
}

