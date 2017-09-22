package HealthCareApp;

public class DoctorAppointment extends Appointment {

    public DoctorAppointment(Patient p) {
    	this.p = p;
    }

    protected Doctor doctor;
    protected Patient patient;

    protected void cancelAppointment() {
    }

}