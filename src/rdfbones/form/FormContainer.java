package rdfbones.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rdfbones.utils.FormElementUtil;

public class FormContainer extends FormElement {

		public Map<String,FormElement> formElements = new HashMap<String, FormElement>();	
		private static final String TYPE = "FORMCONTAINER";
		
		public FormContainer(String uri){
			
			super(uri);
			this.setElements();
		}
		
		public void setElements(){
			
			String SPARQL = ""
					+ "SELECT ?element ?type"
					+ "WHERE {"
					+ "	 	?uri	 wa:container ?element . "
					+ "   ?uri	 vitro:mostSpecificType ?type . "
 					+ "   FILTER ( ?uri = <" + this.uri + "> )"
					+ "}";
			
			//EXECUTION

			List<Map<String, String>> elements = new ArrayList<Map<String, String>>(); 
			for(Map<String, String> element : elements){
				String uri = element.get("element");
				String type = element.get("type");
				this.formElements.put(uri, FormElementUtil.getElement(uri, type));
			}
		}
		
		@Override
		public String getType(){
			return FormContainer.TYPE;
		}
			
}
