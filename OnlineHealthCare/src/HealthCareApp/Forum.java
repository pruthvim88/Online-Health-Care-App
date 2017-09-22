package HealthCareApp;
import java.util.*;

public class Forum {

	List<HealthRelatedQuestion> quesList = new ArrayList<HealthRelatedQuestion>();
    protected HealthRelatedQuestion question;
    protected Answer answer;
    protected Patient patient;
    protected Doctor doctor;
    
    public Forum() {
    }    

    protected void addQuestion(String string, Patient p) {
    	this.quesList.add(new HealthRelatedQuestion(string, p));
	}

    //@Requires({"i >= 0 && !string.isEmpty()"})
  	//@Ensures({"this.quesList.get(i).answers.size() == old(this.quesList.get(i).answers.size()) + 1 "})
    protected void addAnswer(int i,String string, Doctor d) {
    	this.quesList.get(i).answers.add(new Answer(d, string));
	}


}