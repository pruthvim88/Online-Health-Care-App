package HealthCareApp;

public class Prescription {

    protected int prescriptionId;
	protected String prescriptionDescrition;
    public Prescription(String string, int i) {
    	this.prescriptionDescrition = string ;
    	this.prescriptionId = i;
    }

    public Prescription(String pres) {
    	this.prescriptionDescrition = pres;
    }
    
    protected String getPrescriptionDescription(){
    	return this.prescriptionDescrition;
    }    
}