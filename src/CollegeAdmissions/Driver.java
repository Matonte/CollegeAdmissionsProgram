package CollegeAdmissions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Driver {


public Driver() {}	
	

     // Driver File (My "model")
	public static void main (String args[]) throws IOException 
	{
		// The fileWriter utility 
		
		
		// Create the "DataBase" want to eventually add these into an xml bean format. 
		FileWriter fw = new FileWriter("Decisions.csv");
		 PrintWriter out = new PrintWriter(fw);
		 
		 
		 //header for CSV
		 out.print( "APPLICANT" );
		  out.print(',');
		  out.print("DECISION");
		  out.print(',');
		  out.print("REASON FOR REJECTION");
		  out.println();
		 
		//Loading Applicants 
	   Grades joesGrades = new Grades(5.0,4.3);
	   TestScore joesACT = new ACT(23);
	   TestScore joesSAT= new SAT(1843);
	   ArrayList<TestScore> joesTests = new ArrayList();
       joesTests.add(joesSAT);
       joesTests.add(joesACT);
       Date joesLastFelony = new Date (115,6,3);
       CriminalHistory joesRap = new CriminalHistory(joesLastFelony);
       
	  Applicant joeDirt = new Applicant("Joe", "Dirt", 24, joesGrades, joesTests, joesRap, Residence.INDIANA,""); 	
	  
	  Grades samsGrades = new Grades(5.0,4.5);
	  TestScore samsACT = new ACT(19);
	  ArrayList<TestScore> samsTests = new ArrayList();
      samsTests.add(samsACT);
      Date samsLastFelony = new Date (0);
      CriminalHistory samsRap = new CriminalHistory(samsLastFelony);
	  
	  Applicant sam = new Applicant("sam", "the grass cat", 19, samsGrades, samsTests, samsRap, Residence.ALABAMA,""); 	
	  
	  Grades abbyGrades = new Grades(5.0,4.5);
	  TestScore abbySAT = new SAT(2000);
	  ArrayList<TestScore> abbyTests = new ArrayList();
      abbyTests.add(abbySAT);
      Date abbysLastFelony = new Date (0);
      CriminalHistory abbysRap = new CriminalHistory(abbysLastFelony);
      
      Applicant abbyNormal = new Applicant("Abby", "Normal", 134, abbyGrades, abbyTests, abbysRap, Residence.CALIFORNIA,""); 	
    
      
     Grades briansGrades = new Grades(5.0,3.5);
	 TestScore briansACT = new ACT(33);
	 ArrayList<TestScore> briansTests = new ArrayList<TestScore>();
     briansTests.add(briansACT);
     Date briansLastFelony = new Date (0);
     CriminalHistory briansRap = new CriminalHistory(samsLastFelony);
      
      
	  Applicant brianCohen = new Applicant("Brian", "Cohen", 33, briansGrades, briansTests, briansRap,Residence.CALIFORNIA,"");
	  
	  Grades arthursGrades = new Grades(5.0,4.6);
	  TestScore arthurACT = new ACT(34);
	  ArrayList<TestScore> arthursTests = new ArrayList<TestScore>();
      samsTests.add(arthurACT);
      Date arthursLastFelony = new Date (100,1,1);
      CriminalHistory arthursRap = new CriminalHistory(arthursLastFelony);
	  
	  Applicant kingArthur = new Applicant("King", "Arthur", -2, arthursGrades, arthursTests, arthursRap, Residence.MASSACHEUSSTES,""); 	
	  
	  
	  Grades biggusGrades = new Grades(4.0,3.7);
	  TestScore biggusSAT = new SAT(1994);
	  ArrayList<TestScore> biggusTests = new ArrayList<TestScore>();
      biggusTests.add(biggusSAT);
      Date biggusLastFelony = new Date (0);
      CriminalHistory bigRap = new CriminalHistory(biggusLastFelony);
	  Applicant biggusDickus = new Applicant("Biggus","Dicus", 18, biggusGrades, biggusTests, bigRap, Residence.CALIFORNIA,"");
	  
	  
	  Grades badnameGrades = new Grades(4.0,3.7);
	  TestScore badnameSAT = new SAT(1994);
	  ArrayList<TestScore> badnameTests = new ArrayList<TestScore>();
      badnameTests.add(badnameSAT);
      Date badnameLastFelony = new Date (0);
      CriminalHistory badRap = new CriminalHistory(badnameLastFelony);
	  Applicant badName = new Applicant("Bad","NaMe", 18, badnameGrades, badnameTests, badRap, Residence.CALIFORNIA,"");
	  
	  
	  
	  
	  Grades fattysGrades = new Grades(5.0,3.3);
	  TestScore fatACT = new ACT(24);
	  ArrayList<TestScore> fatTests = new ArrayList();
      fatTests.add(fatACT);
      Date fattyLastFelony = new Date (0);
      CriminalHistory creoRap = new CriminalHistory(fattyLastFelony);
      Applicant misterCreostole = new Applicant("The Guy" ,"Who Ate Everything and Exploded", 25, fattysGrades, fatTests, creoRap,Residence.TEXAS,""); 	
	  
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
	  
	  //Make decisions that print to console or to a csv file
	  DecisionEngine.autoreject(theApplicants);
	  for(Applicant i:DecisionEngine.dinged)
	      {
		  out.print( i.getFname() + " " + i.getLname()  );
		  out.print(',');
		  out.print("REJECTED.");
		  out.print(',');
		  out.print(i.getRejected());
		  out.println();
	      }
	  /*
	  Iterator it =  DecisionEngine.dingedwithReason.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        out.print(pair.getKey().toString());
	         out.print(',');
	        out.print(pair.getValue().toString());
	        out.println();
	        it.remove(); // avoids a ConcurrentModificationException
	  */
	        DecisionEngine.autoaccept(theApplicants);
	  for(Applicant i:DecisionEngine.welcome)
      	{
		  out.print( i.getFname() + " " + i.getLname()  );
		  out.print(',');
		  out.print("ACCEPTED.");
		  out.println();
      	}
	  DecisionEngine.sendWLnotice(theApplicants);
	  for(Applicant i:theApplicants)
    	{
		  out.print( i.getFname() + " " + i.getLname()  );
		  out.print(',');
		  out.print("DETERMINATION PENDING.");
		  out.println();
    	}
	  
	  // Close writing aparatus 
	  //Flush the output to the file
	   out.flush();
	       
	   //Close the Print Writer
	   out.close();
	       
	   //Close the File Writer
	   fw.close();       
	}
	
}
