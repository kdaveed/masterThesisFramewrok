package rdfbones.form;

public class FormElement {

		public String uri;
		public String variableUri;
		public boolean inline;
		public String title;
		public int number;
	
		private static final String TYPE = "FORMELEMENT";
		
		public String getType(){
			return FormElement.TYPE;
		}
		
		
		public FormElement(String uri){
			
			this.uri = uri;
			this.uri = uri;
			this.setLiterals();
		}
		
		public void setLiterals(){
			
			String SPARQL = ""
					+ "SELECT ?title ?inline ?number ?variableUri "
					+ "WHERE {"
					+ "	 	OPTIONAL { ?uri		wa:title				?title . }	"
					+ "	 	OPTIONAL { ?uri		wa:title				?string . }	"
					+ "	 	OPTIONAL { ?uri		wa:number				?number . }	"
					+ "   OPTIONAL { ?uri   wa:represents 	?variableUri . }"
					+ "   FILTER ( ?uri = <" + this.uri + "> )"  
					+ "	} ";

			//set the fields title, inline, number variableUri
		}
}
