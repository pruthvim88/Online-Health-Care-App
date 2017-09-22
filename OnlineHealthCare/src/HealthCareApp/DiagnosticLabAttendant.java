package HealthCareApp;

public class DiagnosticLabAttendant {

    public DiagnosticLabAttendant(String name) {
    	this.attendantName = name;
    }

    protected DiagnosticLab diagnosticLab;
    protected String attendantName;

    protected void performTest(Patient p) {
    	System.out.println(this.attendantName+" is performing the lab diagnostic test on "+p.patientName);
    }

    //@Requires({"testResult.testName != null && !testResult.testName.isEmpty() && testResult.testResult != null && !testResult.testResult.isEmpty()"})
  	//@Ensures({"p.dhr.listOfTestResultss.size() == old(p.dhr.listOfTestResultss.size()) + 1"})
    protected void postTestResult(Patient p, DiagnosticTestResult testResult) {
    	p.dhr.addTestResult(testResult);
    	
    }

}