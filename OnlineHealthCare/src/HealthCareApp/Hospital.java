package HealthCareApp;
import java.util.*;

//@Invariant({“this.deptList.size() >= 0 && this.hospitalName != null && !this.hospitalName.isEmpty()"})
public class Hospital {

	public Hospital(String name){
		this.hospitalName = name;
	}
    public Hospital(String name, Location location) {
    	this.hospitalName = name;
		this.location = location;
    }

    private HashMap<Integer, Department> deptList = new HashMap<Integer, Department>();
    protected String hospitalName;
    protected Location location;
    
    protected void addDoctors(Department dept, Doctor name, int id){
    	dept.addDoctors(id, name);
    	deptList.put(id, dept);
	}
    
    protected void addDepartments(int id, Department Name){
    	deptList.put(id, Name);
	}

    protected HashMap<Integer, Department> getDepartments() {
		return deptList;
    }

    protected Department getDepartment(int id) {
		return deptList.get(id);
    }
}