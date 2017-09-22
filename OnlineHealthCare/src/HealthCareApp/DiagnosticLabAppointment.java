package HealthCareApp;

public class DiagnosticLabAppointment extends Appointment {

    public DiagnosticLabAppointment(Patient p) {
    	this.patient = p;
    }

    protected Patient patient;
    
    protected void cancelApointment() {
    	
    }

}