package rdfbones.form;

public class SubformAdder extends FormContainer{

	public int min;
	public int max;
	private static final String TYPE = "SUBFORMADDER";
	
	public SubformAdder(String uri){
		
		super(uri);
		this.setCardinality();
	}
	
	public void  setCardinality(){
	
		String SPARQL = ""
				+ "SELECT ?min ?max "
				+ "WHERE {"
				+ "	 	OPTIONAL { ?uri		wa:minCardinality				?min . }	"
				+ "	 	OPTIONAL { ?uri		wa:maxCardinality				?max . }	"
				+ "   FILTER ( ?uri = <" + this.uri + "> )"  
				+ "	}";
	}
	
	@Override
	public String getType(){
		return SubformAdder.TYPE;
	}
}