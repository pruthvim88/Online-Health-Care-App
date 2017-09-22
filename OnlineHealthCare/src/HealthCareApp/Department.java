package HealthCareApp;
import java.util.*;

//@Invarient("this.listDoctors.size() !=0 && this.deptname !=null")
public class Department {

    public Department(String name) {
    	this.deptname = name;
    }
    
    protected String deptname;
    protected Hospital hospital;
    protected HashMap<Integer, Doctor> listDoctors = new HashMap<Integer, Doctor>();
	
    //@Requires({"id >= 0 && !doc.doctorName.isEmpty()"})
  	//@Ensures({"this.listDoctors.size() == old(this.listDoctors.size()) + 1 "})
    protected void addDoctors(int id, Doctor doc){
		this.listDoctors.put(id, doc);
	}

    protected HashMap<Integer, Doctor> getDoctors() {
    	return this.listDoctors;
    }

}