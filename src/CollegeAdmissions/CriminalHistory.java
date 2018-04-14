package CollegeAdmissions;
// Class for finding criminal history. Measures the time since the last felony. 
// If applicant is clean, it defaults to Jan 1, 1900. 

import java.util.Date;

public class CriminalHistory {
private Date lastFelony;  


public  CriminalHistory(Date lastFelony){
   this.lastFelony = lastFelony;
}


public Date getLastFelony() {
	return lastFelony;
}


public void setLastFelony(Date lastFelony) {
	this.lastFelony = lastFelony;
}

}
