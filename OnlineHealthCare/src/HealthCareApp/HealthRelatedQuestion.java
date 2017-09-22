package HealthCareApp;
import java.util.*;

public class HealthRelatedQuestion {

	List<Answer> answers = new ArrayList<Answer>();

	protected String HealthRelatedQuestion; 
	protected Patient p;
	
	protected HealthRelatedQuestion(String s) {
    	this.HealthRelatedQuestion = s;
    }
	protected HealthRelatedQuestion(String string, Patient p) {
		this.HealthRelatedQuestion = string;
		this.p = p;
	}
}