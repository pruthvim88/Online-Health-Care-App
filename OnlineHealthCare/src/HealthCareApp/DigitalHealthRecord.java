package HealthCareApp;
import java.util.*;

//@Invariant({“this.listOfPrescriptions.size() >= 0 && this.listOfTests.size() >= 0 && this.listOfTestResultss.size() >= 0"})
public class DigitalHealthRecord {
	
	List<Prescription>  listOfPrescriptions = new ArrayList<Prescription>();
	List<String>  listOfTests = new ArrayList<String>();
	List<DiagnosticTestResult>  listOfTestResultss = new ArrayList<DiagnosticTestResult>();
    
	public DigitalHealthRecord() {
    }

	protected Patient patient;
    Prescription prescription ;
    DiagnosticTestResult dtr; 

    protected void addPrescription(Prescription p) {
    	this.listOfPrescriptions.add(p);
    }

    protected void addTest(String t) {
    	this.listOfTests.add(t);
    }
    
    protected void addTestResult(DiagnosticTestResult t) {
    	this.listOfTestResultss.add(t);
    }

}