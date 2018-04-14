package CollegeAdmissions;

// The grade an scale. Will be converted to percentage in Decision Engine
public class Grades {
	
	private double scale;
	private double gpa; 

	public Grades (double d, double e)
	{
		this.scale = d;
		this.gpa = e; 
		
	}
	
	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(int gpa) {
		this.gpa = gpa;
	}

}
