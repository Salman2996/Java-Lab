import java.util.Date;

public class Calls {
	String name,phno;
	Date date;
	static int no_of_calls=0;
	
	Calls(String p,String s){
		name=s;
		phno=p;
		date=new Date();
	}
	Calls(String p){
		name="Private";
		phno=p;
		date=new Date();
	}
	void displayDetails(){
		System.out.println("Name: "+name);
		System.out.println("Phone number: "+phno);
		System.out.println("Date: "+date);
	}
}
