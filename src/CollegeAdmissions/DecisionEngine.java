package CollegeAdmissions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvWriter;

// The Core Business Logic will print the name of all applicants, the decisions, and 
// "constructive" feedback. 
// Will eventually store results in HashMap and print them into a csv.  

public class DecisionEngine  {

	  FileWriter fw = new FileWriter("Decisions.csv");
	   PrintWriter out = new PrintWriter(fw);
	   
	   
	public DecisionEngine() throws IOException{}
	// Here are the variables that have the various standards for autodinging 
	// and autoaccept 
	private  static double minGPA = 0.70;
	private static double minAutoGPA = 0.90;
	private static long minRehabTime =  157784630000L ;
	private static int minSATauto = 1920;
	private static int minACTauto = 27; 
	private static int isCollegeAgeMin = 17; 
	private static int isCollegeAgeMax = 25; 
	private static int senior = 80; 
	
	// The lists of automatically rejected and accepted applicants.
	static ArrayList<Applicant> dinged = new ArrayList();
	static ArrayList<Applicant>  welcome = new ArrayList();
	static HashMap<Applicant,String> dingedwithReason = new HashMap();

	// First check to see if they are unqualified to attend college. 
	public static ArrayList<Applicant> autoreject(ArrayList<Applicant> candidates)
	{
		// We collect the list of people who are criminally or academically inadmissible
		// or those who have ill-formed applications.  
		
	   // we come here to see how far their last felony is in the past given the time in ms for 5 years.
		// is a class variable so can be changed. 
		Date date = new Date();
		for (Applicant i:candidates) {
		if (  date.getTime() -  i.getHistory().getLastFelony().getTime() <  minRehabTime)
		{
			System.out.println(i.getFname() + " " + i.getLname() + " "
					+ "can't come to school because they are a crook!" );
			
			  dinged.add(i);
			  dingedwithReason.put(i,"APPLICATION IS NONREHABILITATED FELON");
			  continue;
		}
		// They have to be born. This should be a Checked Exception, but the requirements 
		// are to run with the entry. 
		else if ( i.getAge() < 0)                          
		{
			System.out.println(i.getFname() + " " + i.getLname() + " "
					+ "can't come to school because they are not born yet!" );
			  dinged.add(i);
			  dingedwithReason.put(i,"APPLICATION INVALID - AGE");
			  continue;
		}
		else if (i.getGrades().getGpa()  / i.getGrades().getScale() < minGPA)
		   {
			  System.out.println(i.getFname() + " " + i.getLname() + " "
					+ "can't come to school because they aren't qualified!" );
			  dinged.add(i);
			  dingedwithReason.put(i,"APPLICANT IS NOT QUALIFIED");
			  continue;
		   }
		// We check to see if their name is properly formed 
		else if (Character.isUpperCase(i.getFname().codePointAt(0) ) != true ||
				 Character.isUpperCase(i.getLname().codePointAt(0) ) != true ||
				i.getLname().substring(1).equals(i.getLname().substring(1).toLowerCase()) != true ||
				i.getFname().substring(1).equals(i.getFname().substring(1).toLowerCase()) != true )
		   {
		System.out.println(i.getFname() + " " + i.getLname() + " "
		+ "can't come to school because they don't have a proper name!" );  		
			 dinged.add(i);
			  dingedwithReason.put(i,"APPLICATION INVALID - NAME");

			 
			  continue;
		    }
			   
		}
		// remove the inadmissible from candidate pool. 
		candidates.removeAll(dinged);
		return candidates;
	}
	// Next is called the autoaccept method. This is for people who are eligible and meet 
	// certain additional requirements. 
	public static ArrayList<Applicant> autoaccept(ArrayList<Applicant> candidates) {
		// Take out the 
		//ArrayList<Applicant>  welcome = new ArrayList();
  
        // If the grades, age, and residency are correct, we move to see if any of their score qualify them
		for (Applicant i:candidates) {
			if( 
				i.getGrades().getScale()/ i.getGrades().getGpa() >= minAutoGPA && 
				(
				   i.getResidence().name() == "CALIFORINA" && i.getAge() <= isCollegeAgeMax && i.getAge() >= isCollegeAgeMin||
				   i.getAge() >= senior
				   )
				// Must have taken at least one test to be accepted. The iterator will 
				// go through all attempts to see if applicant satisfies requirement. 
				&& i.getTestScores().size() > 0 )
			{
				for (TestScore j : i.getTestScores())
				{
					if ((j.getScore() > minACTauto && j instanceof ACT) ||
							(j.getScore() > minSATauto && j instanceof SAT)	
							)
					{
						System.out.println(i.getFname() + " " + i.getLname() + " "
								+ "automatically gets accepted!" );  	
									 welcome.add(i);
									  continue;
								}
				          }
				}
			}
			// remove the accepted candidates.       
			candidates.removeAll(welcome);
		    return candidates; 
		}
		
	// The remainder of the candidates will be "waitlisted" if they haven't already 
	// been rejected or admitted. 
	public static void sendWLnotice (ArrayList<Applicant> waitlist){
		for(Applicant i:waitlist)
		{
		 System.out.println(i.getFname() +" "+ i.getLname()+ " "
				 + "is offered a position on our waitlist.");	
		}
		
	}
}
