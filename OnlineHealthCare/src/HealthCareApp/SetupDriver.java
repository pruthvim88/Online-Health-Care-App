package HealthCareApp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SetupDriver {

	protected static HashMap<Integer, Location> listLocations = new HashMap<Integer, Location>();
	protected void addLocation(int i, Location name){
		listLocations.put(i,name);
	}

	public static void main(String[] args) {

	SetupDriver s  = new SetupDriver();
	//data setup 
	Location Buffalo = new Location("Buffalo");
	Location Rochester = new Location("Rochester");
	s.addLocation(1, Buffalo);
	s.addLocation(2, Rochester);
	Hospital AmherstHealthCenter = new Hospital("Amherst Health Center");
	Hospital BuffaloMedicalGroup = new Hospital("Buffalo Medical Group");
	Hospital HighlandHospital = new Hospital("Highland Hospital");
	Hospital StrongMemorialHospital = new Hospital("Strong Memorial Hospital");
	DiagnosticLab ACMLabs = new DiagnosticLab("ACM Blood Test Labs");
	DiagnosticLab URMedicineLabs = new DiagnosticLab("UR Medicine Labs");
	DiagnosticLab QuestDiagnostics = new DiagnosticLab("Quest Diagnostics");
	DiagnosticLab GeneticDiagnosticLab = new DiagnosticLab("Genetic Diagnostic Laboratories");
	Buffalo.addHospital(11, AmherstHealthCenter);
	Buffalo.addHospital(12, BuffaloMedicalGroup);
	Buffalo.addLab(1, ACMLabs);
	Buffalo.addLab(2, GeneticDiagnosticLab);
	Rochester.addHospital(1, StrongMemorialHospital);
	Rochester.addHospital(2, HighlandHospital);
	Rochester.addLab(1, QuestDiagnostics);
	Rochester.addLab(2, URMedicineLabs);
	Department Dentist = new Department("Dentist");
	Department Dermatologist = new Department("Dermatologist");
	Department Gynecologist = new Department("Gynecologist");
	Doctor Harry = new Doctor("Harry");
	Doctor Elizabeth  = new Doctor("Elizabeth ");
	Doctor Michael = new Doctor("Michael");
	Doctor Christopher = new Doctor("Christopher"); 
	DiagnosticLabAttendant Eli = new DiagnosticLabAttendant("Eli"); 
	DiagnosticLabAttendant Randy = new DiagnosticLabAttendant("Randy"); 
	DiagnosticLabAttendant Matt = new DiagnosticLabAttendant("Matt");
	DiagnosticLabAttendant Robert = new DiagnosticLabAttendant("Robert");
	AmherstHealthCenter.addDoctors(Dentist, Harry, 1); AmherstHealthCenter.addDoctors(Dermatologist, Michael, 2);
	BuffaloMedicalGroup.addDoctors(Dentist, Christopher, 1); BuffaloMedicalGroup.addDoctors(Gynecologist, Elizabeth, 2);
	ACMLabs.addLabAttendant(Eli);
	URMedicineLabs.addLabAttendant(Randy);
	QuestDiagnostics.addLabAttendant(Matt);
	GeneticDiagnosticLab.addLabAttendant(Robert);
	//data setup ends
	
	//Patient 1
	Scanner scanner1 = new Scanner(System.in);
	System.out.println("Hi please enter your name ");
	String patientName = scanner1.nextLine();
	Patient patient = new Patient(patientName);
	
	//Patient 2
//	System.out.println("Hi please enter your name ");
//	String patientName2 = scanner1.nextLine();
//	Patient patient2 = new Patient(patientName2);

	s.useCase1(scanner1, patient);
	
	//s.useCase2(scanner1, patient);
	
//	s.useCase3(patient, Christopher, scanner1);
//	s.useCase3(patient2, Christopher, scanner1);
//	s.useCase5(patient, Christopher);
//	s.useCase6(patient, Christopher);
//	s.useCase8(patient, Eli);
	
//	Forum forum = new Forum();
//	s.useCase4(scanner1, patient, forum);
//	s.useCase7(scanner1, Christopher , forum);
	}
	
	protected void useCase1(Scanner scanner1, Patient patient){
		System.out.println("Select the Location ID for your Location");
	    Set set = listLocations.entrySet();
	    Iterator iterator = set.iterator();
	    while(iterator.hasNext()) {
	       Map.Entry mentry = (Map.Entry)iterator.next();
	       Location l = (Location)mentry.getValue();
	       System.out.print(mentry.getKey() + " "+l.getLocation()+"\n");
	    }	
		String inLoc = scanner1.nextLine();
		
		Location  l = listLocations.get(Integer.parseInt(inLoc));
		HashMap<Integer, Hospital>  listOfHospitals = l.getHospitals();
		System.out.println("select the Hospital ID of your Hospital Choice ");
		set = listOfHospitals.entrySet();
	    iterator = set.iterator();
	    while(iterator.hasNext()) {
	       Map.Entry mentry = (Map.Entry)iterator.next();
	       Hospital h = (Hospital)mentry.getValue();
	       System.out.print(mentry.getKey() + " "+h.hospitalName+"\n");
	    }
		HashMap<Integer , Department> listOfDepts = listOfHospitals.get(Integer.parseInt(scanner1.nextLine())).getDepartments();
		System.out.println("select the Department ID of your Department choice");
		set = listOfDepts.entrySet();
	    iterator = set.iterator();
	    while(iterator.hasNext()) {
	       Map.Entry mentry = (Map.Entry)iterator.next();
	       Department dept = (Department)mentry.getValue();
	       System.out.print(mentry.getKey() + " "+dept.deptname+"\n");
	    }

		HashMap<Integer, Doctor> listOfDoctors = listOfDepts.get(Integer.parseInt(scanner1.nextLine())).getDoctors();
		System.out.println("select the Doctor ID of your Doctor Choice ");
		set = listOfDoctors.entrySet();
	    iterator = set.iterator();
	    while(iterator.hasNext()) {
	       Map.Entry mentry = (Map.Entry)iterator.next();
	       Doctor doc = (Doctor)mentry.getValue();
	       System.out.print(mentry.getKey() + " "+doc.doctorName+"\n");
	    }

		Doctor doctor = listOfDoctors.get(Integer.parseInt(scanner1.nextLine()));
		System.out.println(doctor.getFreeHoursInSchedule()+"select your Appointment slotID \n");
		doctor.bookDoctorAppointment(patient, scanner1.nextInt());
		System.out.println("Congratulations!!! Your appointment has been confirmed");
		return;
	}
	
	protected void useCase2(Scanner scanner1, Patient patient){
		System.out.println("Select the Location ID for your Location");
	    Set set = listLocations.entrySet();
	    Iterator iterator = set.iterator();
	    while(iterator.hasNext()) {
	       Map.Entry mentry = (Map.Entry)iterator.next();
	       Location l = (Location)mentry.getValue();
	       System.out.print(mentry.getKey() + " "+l.getLocation()+"\n");
	    }	
		String inLoc = scanner1.nextLine();
		Location  l = listLocations.get(Integer.parseInt(inLoc));
		HashMap<Integer, DiagnosticLab>  listOfLabs = l.getDiagnosticLabs();
		System.out.println("select the Diagnostic Lab ID of your Lab Choice ");
		set = listOfLabs.entrySet();
	    iterator = set.iterator();
	    while(iterator.hasNext()) {
	       Map.Entry mentry = (Map.Entry)iterator.next();
	       DiagnosticLab dl = (DiagnosticLab)mentry.getValue();
	       System.out.print(mentry.getKey() + " "+dl.labName+"\n");
	    }
	    DiagnosticLab dLab = listOfLabs.get(Integer.parseInt(scanner1.nextLine()));
		System.out.println(dLab.getFreeHoursInSchedule()+"\nselect your Appointment slotID \n");
		dLab.bookLabAppointment(patient, scanner1.nextInt());
		System.out.println("Congratulations!!! Your appointment has been confirmed.\nLab Attendant "+dLab.getLabAttendant().attendantName+" will be attending your test.");
	}
	
	protected void useCase3(Patient patient, Doctor christopher, Scanner scanner) {
		System.out.println(patient.patientName+" - Enter your review for Dr. Christopher in the scale of 1 to 5");
		int rating = scanner.nextInt();
		christopher.giveReview(patient, rating);
		System.out.println("Current rating of Dr. Christopher is "+christopher.getReview());
	}
	
	protected void useCase4(Scanner scanner1, Patient patient, Forum forum) {
		System.out.println("Welcome to the Health Forum Mr."+patient.patientName+". What is your question?");
		forum.addQuestion(scanner1.nextLine() , patient);
		System.out.println("Thank You!! Your question has been successfully posted. Our doctors will get back with an answer to your question as soon as possible");
	}
	
	protected void useCase5(Patient patient, Doctor doctor){
		System.out.println("Dr." + doctor.doctorName + " is looking at the health record of "+patient.patientName);
		Prescription prescription = new Prescription("Paracetamoml 500mg daily once in the morning", 1);
		doctor.writePrescription(patient,prescription);
		System.out.println("Prescription given by Doctor:\n"+ "Paracetamoml 500mg daily once in the morning"+"\n");
	}
	
	protected void useCase6(Patient patient, Doctor doctor) {
		System.out.println("Dr." + doctor.doctorName + " is looking at the health record of "+patient.patientName);
		doctor.prescribeTest(patient, "Blood Test");
		System.out.println("Diagnostic test prescribed by the Doctor is Blood Test");
	}

	protected void useCase7(Scanner scanner1, Doctor doctor, Forum forum) {
		String s = "";
		System.out.println("Welcome Dr."+doctor.doctorName+". Given below are the list of questions from the patients");
		
		for (int i =0;i<forum.quesList.size();i++) {
		
			s = forum.quesList.get(i).HealthRelatedQuestion;
		    System.out.println("index: "+i + " Question: " + s);
		    System.out.println("Asked by: " + forum.quesList.get(i).p.patientName);
		}
		
		System.out.println("Which Question would you like to answer for this question Doctor?");
		int index = Integer.parseInt(scanner1.nextLine());
		System.out.println("Please type your answer:");
		String ans = scanner1.nextLine();
		forum.addAnswer(index, ans, doctor);
		System.out.println("Your Answer is :"+ forum.quesList.get(index).answers.get(0).answer);
	}


	protected void useCase8(Patient patient, DiagnosticLabAttendant labAttendant){
		labAttendant.performTest(patient);
		DiagnosticTestResult testResult = new DiagnosticTestResult("BloodTest", "Plateletts count - Low \nHaemoglobin count - Normal \nWhite Blood cells - Normal");
		labAttendant.postTestResult(patient,testResult);
		System.out.println("Test Results: \n"+ testResult.testName+"\n"+testResult.getDiagnosticTestResult());
		System.out.println( "Mr."+patient.patientName+"'s Digital Health record has been updated with the lab test result");
	}
}