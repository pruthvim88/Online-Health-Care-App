package HealthCareApp;

//@Invarient("this.doctor.doctorName !=null && !this.doctor.doctorName.isEmpty() && this.answer !=null && !this.answer.isEmpty()")
public class Answer {
	
    public Answer(String question, Doctor s, String a) {
    	this.Question = question;
    	this.doctor = s;
    	this.answer = a;
    }
    
    public Answer(Doctor s, String a) {
    	this.doctor = s;
    	this.answer = a;
    }
    
    protected Doctor doctor;
    protected String answer;
	protected String Question;
}