package CollegeAdmissions;

import java.util.ArrayList;
import java.util.Date;

public class Driver {


public Driver() {}	
	

     // Driver File (My "model")
	public static void main (String args[])
	{
		// Create the "DataBase"
		
	   Grades joesGrades = new Grades(5.0,4.3);
	   TestScore joesACT = new ACT(23);
	   TestScore joesSAT= new SAT(1843);
	   ArrayList<TestScore> joesTests = new ArrayList();
       joesTests.add(joesSAT);
       joesTests.add(joesACT);
       Date joesLastFelony = new Date (115,6,3);
       CriminalHistory joesRap = new CriminalHistory(joesLastFelony);
       
	  Applicant joeDirt = new Applicant("Joe", "Dirt", 24, joesGrades, joesTests, joesRap, Residence.INDIANA); 	
	  
	  Grades samsGrades = new Grades(5.0,4.5);
	  TestScore samsACT = new ACT(19);
	  ArrayList<TestScore> samsTests = new ArrayList();
      samsTests.add(samsACT);
      Date samsLastFelony = new Date (0);
      CriminalHistory samsRap = new CriminalHistory(samsLastFelony);
	  
	  Applicant sam = new Applicant("sam", "the grass cat", 19, samsGrades, samsTests, samsRap, Residence.ALABAMA); 	
	  
	  Grades abbyGrades = new Grades(5.0,4.5);
	  TestScore abbySAT = new SAT(2000);
	  ArrayList<TestScore> abbyTests = new ArrayList();
      abbyTests.add(abbySAT);
      Date abbysLastFelony = new Date (0);
      CriminalHistory abbysRap = new CriminalHistory(abbysLastFelony);
      
      Applicant abbyNormal = new Applicant("Abby", "Normal", 134, abbyGrades, abbyTests, abbysRap, Residence.CALIFORNIA); 	
    
      
     Grades briansGrades = new Grades(5.0,3.5);
	 TestScore briansACT = new ACT(33);
	 ArrayList<TestScore> briansTests = new ArrayList<TestScore>();
     briansTests.add(briansACT);
     Date briansLastFelony = new Date (0);
     CriminalHistory briansRap = new CriminalHistory(samsLastFelony);
      
      
	  Applicant brianCohen = new Applicant("Brian", "Cohen", 17, briansGrades, briansTests, briansRap,Residence.CALIFORNIA);
	  
	  Grades arthursGrades = new Grades(5.0,4.6);
	  TestScore arthurACT = new ACT(34);
	  ArrayList<TestScore> arthursTests = new ArrayList<TestScore>();
      samsTests.add(arthurACT);
      Date arthursLastFelony = new Date (100,1,1);
      CriminalHistory arthursRap = new CriminalHistory(arthursLastFelony);
	  
	  Applicant kingArthur = new Applicant("King", "Arthur", -2, arthursGrades, arthursTests, arthursRap, Residence.MASSACHEUSSTES); 	
	  
	  
	  Grades biggusGrades = new Grades(4.0,3.7);
	  TestScore biggusSAT = new SAT(1994);
	  ArrayList<TestScore> biggusTests = new ArrayList<TestScore>();
      biggusTests.add(biggusSAT);
      Date biggusLastFelony = new Date (0);
      CriminalHistory bigRap = new CriminalHistory(samsLastFelony);
	  Applicant biggusDickus = new Applicant("Biggus","Dicus", 18, biggusGrades, biggusTests, bigRap, Residence.KENTUCKY);
	  
	  
	  Grades badnameGrades = new Grades(4.0,3.7);
	  TestScore badnameSAT = new SAT(1994);
	  ArrayList<TestScore> badnameTests = new ArrayList<TestScore>();
      badnameTests.add(badnameSAT);
      Date badnameLastFelony = new Date (0);
      CriminalHistory badRap = new CriminalHistory(samsLastFelony);
	  Applicant badName = new Applicant("Bad","NaMe", 18, badnameGrades, badnameTests, badRap, Residence.CALIFORNIA);
	  
	  
	  
	  
	  Grades fattysGrades = new Grades(5.0,3.3);
	  TestScore fatACT = new ACT(24);
	  ArrayList<TestScore> fatTests = new ArrayList();
      fatTests.add(fatACT);
      Date fattyLastFelony = new Date (0);
      CriminalHistory creoRap = new CriminalHistory(fattyLastFelony);
      Applicant misterCreostole = new Applicant("The Guy" ,"Who Ate Everything and Exploded", 25, fattysGrades, fatTests, creoRap,Residence.TEXAS); 	
	  
	  // Load Applicants
	  ArrayList<Applicant> theApplicants = new ArrayList();
	  theApplicants.add(joeDirt);
	  theApplicants.add(sam);
	  theApplicants.add(abbyNormal);
	  theApplicants.add(brianCohen);
	  theApplicants.add(kingArthur);
	  theApplicants.add(biggusDickus);
	  theApplicants.add(misterCreostole);
	  theApplicants.add(badName);
	  
	  //Make decisions that print to console or to a text file
	  DecisionEngine.autoreject(theApplicants);
	  DecisionEngine.autoaccept(theApplicants);
	  DecisionEngine.sendWLnotice(theApplicants);
	  
	}
	
}
