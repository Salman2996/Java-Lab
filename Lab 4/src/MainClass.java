import java.util.Scanner;

public class MainClass {
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		RecordCalls recorder=new RecordCalls();
		int choice;
		while(true){
			System.out.println("Enter choice:\n1.Add missed call\n2.Display missed calls\n3.Delete Contact\n4.Exit");
			choice=s.nextInt();
			switch (choice) {
			case 1:
				recorder.addCall();
				break;
			case 2:
				recorder.details();
				break;
			case 3:
				recorder.deleteContact();
				break;
			case 4:
				System.exit(0);
			default:
				break;
			}
		}
	}
}
