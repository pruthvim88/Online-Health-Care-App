package HealthCareApp;
import java.util.HashMap;

public class Location {

    public Location(String name) {
		
    	this.location= name;
	}
    
    protected String location;
	HashMap<Integer, Hospital>  hospitalList = new HashMap<Integer, Hospital>();
	HashMap<Integer, DiagnosticLab>  DiagLabList = new HashMap<Integer, DiagnosticLab>();
	
	//@Requires({"id >= null && Name != null && !Name.isEmpty()"})
  	//@Ensures({"this.hospitalList.size() == old(this.hospitalList.size()) + 1 "})
	protected void addHospital(int id, Hospital Name){
		this.hospitalList.put(id, Name);
	}
	protected String getLocation(){
		return this.location;
	}
	protected void removeHospital(int id, Hospital Name){
		this.hospitalList.remove(id, Name);
	}
	
	protected void addLab(int id, DiagnosticLab Name){
		this.DiagLabList.put(id, Name);
	}
	
	protected void removeLab(int id, DiagnosticLab Name){
		this.DiagLabList.remove(id, Name);
	}

	protected HashMap<Integer , Hospital> getHospitals() {
		return hospitalList;        
    }

	protected HashMap<Integer , DiagnosticLab> getDiagnosticLabs() {
        return DiagLabList;
    }

}