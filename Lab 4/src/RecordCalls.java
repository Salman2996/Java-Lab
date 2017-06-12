import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RecordCalls {
	HashMap<String, String> contacts;
	ArrayList<Calls> missedCalls;
	int max=5;
	Scanner s;
	
	public RecordCalls() {
		// TODO Auto-generated constructor stub
		contacts=new HashMap<>();
		missedCalls=new ArrayList<>();
		s=new Scanner(System.in);
		
		contacts.put("111", "San");
		contacts.put("222", "Gran");
		contacts.put("333", "Tan");
		contacts.put("444", "Dan");
	}
	
	void addCall(){
		System.out.println("Enter number of missed call:");
		String input=s.next();
		if(Calls.no_of_calls>max)
			missedCalls.remove(0);
		if(contacts.containsKey(input))
			missedCalls.add(new Calls(input,contacts.get(input)));
		else 
			missedCalls.add(new Calls(input));
		Calls.no_of_calls++;
	}
	
	void details(){
		outerloop:
		for(int i=0;i<missedCalls.size();i++){
			System.out.println("NEXT CALL:\t"+missedCalls.get(i).phno);
			innerloop:
				while(true){
					System.out.println("1:View details\n2.Delete\n3.Next\n4.Back");
					int choice=Integer.parseInt(s.next());
					switch (choice) {
					case 1:
						missedCalls.get(i).displayDetails();
						break;
					case 2:
						missedCalls.remove(i);
						Calls.no_of_calls--;
						break innerloop;
					case 3:
						continue outerloop;
					case 4:
						return;

					default:
						break;
					}
				}
		}
	}
	
	void deleteContact(){
		System.out.println("Enter contact number to be deleted:");
		String delNumber=s.next();
		if(contacts.containsKey(delNumber))
			contacts.remove(delNumber);
		else
			System.out.println("Doesn't Exist!");
	}
}
