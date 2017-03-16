package rdfbones.statement;

public class ClassRestrictionStatement extends Statement {

	public ClassRestrictionStatement(String uri) {
		super(uri);
		// TODO Auto-generated constructor stub
	}

	public boolean someValuesFrom;
	public boolean allValuesFrom;
	public boolean qualified;
	
	String queryTriples = " "
			+ " ?inputVariable_X        	rdfs:subClassOf  	?restriction_X . "
      + " ?restriction_X        		 owl:onProperty   ?property_X . "
      + " OPTIONAL { ?restriction_X      owl:minQualifiedCardinality    	?min . } "
      + " OPTIONAL { ?restriction_X      owl:qualifiedCardinality       	?exact . } "
      + " OPTIONAL { ?restriction_X      owl:qualifiedCardinality         ?max .	} "
      + " ?restriction   ?restrictionType_X       ?outputVariable_X ." ; 
	
	public String getRestrictionFilter(){
		
		if(someValuesFrom == true && allValuesFrom == true){
			return new String("FILTER ( ?restrictionType_X = owl:someValuesFrom || ?restrictionType_X = owl:allValuesFrom )");
		} else if (this.someValuesFrom == true){
			return new String("FILTER ( ?restrictionType_X = owl:someValuesFrom)");
		} else if (this.allValuesFrom == true){
			return new String("FILTER ( ?restrictionType_X = owl:allValuesFrom)");
		} else {
			return new String("FILTER ( ?restrictionType_X = owl:onClass)");
		}
	}
	
}
