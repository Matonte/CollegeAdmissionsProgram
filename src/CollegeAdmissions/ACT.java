package CollegeAdmissions;
// The ACT will go into a student's collection of scores and thus be 
// an inheritance implementor of TestScores. 
public class ACT implements TestScore {

	private int score; 
	
	
	public  ACT (int score) {	
		this.score = score; 
	}
	
	public  int getScore(){
    	return score;
	}

	@Override
	public void setScore(int score) {
		// TODO Auto-generated method stub
		this.score = score;
	}

	

	
}