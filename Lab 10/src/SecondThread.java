import java.util.*;
public class SecondThread extends Thread{
	public void run(){
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a number with 4 or more digits:");
		String n=s.next();
		String words[]={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
		for(char c:n.toCharArray()){
			if(c<48 || c>57){
				System.out.println("Invalid input");
				break;
			}
			System.out.println(c+" - "+words[(int)(c-48)]);
		}
		s.close();
	}
}
