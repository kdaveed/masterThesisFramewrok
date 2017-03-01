package rdfbones.utils;

import rdfbones.form.FormContainer;
import rdfbones.form.FormElement;
import rdfbones.form.SubformAdder;

public class FormElementUtil {

	
	public static FormElement getElement(String uri, String type){
		
		switch(type){
			
			case "wa:FormContainer" :
					return new FormContainer(uri);
			case "wa:SubFormAdder" : 
					return new SubformAdder(uri);
			default :
					return null;
		}
	}
}
