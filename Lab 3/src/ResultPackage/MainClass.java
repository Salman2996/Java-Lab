package ResultPackage;
import StudentPackage.*;
public class MainClass {
	public static void main(String []args) throws Exception{
		RegisterStudent r=new RegisterStudent();
		r.getName();
		r.getBranch();
		r.getCredits();
		StudentResult s=new StudentResult(r);
		s.get(r);
		s.getGrades(r);
		s.display(r);
	}

}
