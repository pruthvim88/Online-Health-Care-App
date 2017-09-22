package HealthCareApp;
import java.util.*;

//@Invarient("this.appointmentList.size() == 8 && this.labName !=null")
public class DiagnosticLab {
	DiagnosticLabAppointment[] appointmentList = new DiagnosticLabAppointment[8];

    public DiagnosticLab(String name){
		this.labName = name;
    }

    protected String labName;
    protected Location location;
    List<DiagnosticLabAttendant>  dla = new ArrayList<DiagnosticLabAttendant>();
    
    protected DiagnosticLabAttendant getLabAttendant() {
        return dla.get(0);
    }
    
    protected void addLabAttendant(DiagnosticLabAttendant labAttendant) {
    	dla.add(labAttendant);
    }
    
    protected List<String> getFreeHoursInSchedule(){
		System.out.println("slotID  From - To");
		List<String> freeHoursInSchedule = new ArrayList<String>();
		int k = 9;
		for(int i=0;i<appointmentList.length;i++){
			k+=1;
			if(appointmentList[i]==null){
				freeHoursInSchedule.add(i+1 + " " + k +":00 hrs - "+ (k+1)+":00 hrs\n");
			}
		}
		return freeHoursInSchedule;
	}

    //@Requires({"p.patientName != null && i >= 0 && appointmentList[i-1] == null"})
    //@Ensures({"appointmentList[i-1] != null"})
    protected void bookLabAppointment(Patient p, int i) {
    	DiagnosticLabAppointment app = new DiagnosticLabAppointment(p);
    	appointmentList[i-1] = app;
    }

}