package HealthCareApp;
import java.util.*;

//@Invariant({“AggregateReview <= 5 && this.doctorName !=null && !this.doctorName.isEmpty()"})
public class Doctor {

	DoctorAppointment[] appointmentList = new DoctorAppointment[8];
    protected Department department;
    protected String doctorName;	
    private boolean started= false;
	private float AggregateReview ;
	List<Review> rl = new ArrayList<Review>();
	
    public Doctor(String name) {
    	this.doctorName = name;
    }

    //@Requires({"test != null && !test.isEmpty()"})
  	//@Ensures({"p.dhr.listOfTests.size() == old(p.dhr.listOfTests.size()) + 1 "})
    protected void prescribeTest(Patient p, String test) {
    	p.dhr.addTest(test);
    }

    //@Requires({"prescription != null && !prescription.isEmpty()"})
    //@Ensures({"p.dhr.listOfPrescriptions.size() == old(p.dhr.listOfPrescriptions.size()) + 1 "})
    protected void writePrescription(Patient p, Prescription prescription) {
		p.dhr.addPrescription(prescription);
	}

    protected void bookDoctorAppointment(Patient p, int i) {
    	DoctorAppointment app = new DoctorAppointment(p);
    	appointmentList[i-1] = app;
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

	
	//@Requires({"i <= 5"})
	//@Ensures({"AggregateReview <= 5"})
	protected void giveReview(Patient p, int i) {
		Review r1 = new Review(p,i);		
		if(!started) {started= true;
		AggregateReview = i;
		}
		else{
			AggregateReview = (AggregateReview*rl.size()+i)/(rl.size()+1);
		}
		rl.add(r1);
	}
	
	public float getReview() {
		return AggregateReview;
	}

}