package HealthCareApp;

//@Invariant({“this.doctorName !=null && this.dhr !=null "})
public class Patient {
	
	DigitalHealthRecord dhr = new DigitalHealthRecord();
	protected String patientName;
	
    public Patient(String name) {
    	this.patientName = name;
    }
    
    protected DigitalHealthRecord getHealthRecord() {
    return this.dhr;	
    }
}