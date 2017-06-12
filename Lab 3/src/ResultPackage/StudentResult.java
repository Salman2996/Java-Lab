package ResultPackage;
import StudentPackage.*;
import java.util.*;

public class StudentResult {
	double cgpa,sgpa[];
	char grade[];
	Scanner s=new Scanner(System.in);
	StudentResult(RegisterStudent r){
		grade=new char[5];
		sgpa=new double[r.sem];
	}
	void compute1(double x)throws InvalidCGPA{
		if(x>10.0)
			throw new InvalidCGPA();
	}
	public void get(RegisterStudent r)throws Exception{
		try{
			System.out.println("Enter SGPA in each semester:");
			for(int i=0;i<r.sem;i++)
				sgpa[i]=s.nextDouble();
			System.out.println("Enter CGPA:");
			cgpa=s.nextDouble();
			compute1(cgpa);
		}catch(NumberFormatException e){
			System.out.println(e);
			System.exit(0);
		}catch(InvalidCGPA i){
			System.out.println(i);
			System.exit(0);
		}
	}
	public void getGrades(RegisterStudent r){
		System.out.println("Enter grades for subjects:");
		for(int i=0;i<5;i++){
			System.out.println(r.subject[i]+":");
			grade[i]=s.next().trim().charAt(0);
		}
	}
	public void display(RegisterStudent r){
		System.out.println("Name: "+r.name);
		System.out.println("Branch: "+r.branch);
		System.out.println("Grades are:");
		for(int i=0;i<5;i++)
			System.out.println(r.subject[i]+": "+grade[i]);
		System.out.println("SGPA:");
		for(int i=0;i<r.sem;i++)
			System.out.println((i+1)+"Sem: "+sgpa[i]);
		System.out.println("CGPA: "+cgpa);
		System.out.println("Credits obtained: "+r.credits);
	}

}
