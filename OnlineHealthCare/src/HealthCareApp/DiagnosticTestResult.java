package HealthCareApp;

public class DiagnosticTestResult {

    public DiagnosticTestResult(String testName, String testResult) {
    	this.testName = testName;
    	this.testResult = testResult;
    }

    public String getDiagnosticTestResult(){
    	return this.testResult;
    }
    
    protected String testName;
    protected String testResult;
}