import java.util.*;
public class FirstThread extends Thread {
	public void run(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a string:");
		String str=s.nextLine();
		int count[]={0,0,0,0,0}, sum=0;
		for(int i=0;i<str.length();i++){
			char c=str.charAt(i);
			if(c=='a' || c=='A')
				count[0]++;
			else if(c=='e' || c=='E')
				count[1]++;
			else if(c=='i' || c=='I')
				count[2]++;
			else if(c=='o' || c=='O')
				count[3]++;
			else if(c=='u' || c=='U')
				count[4]++;
		}
		for(int i=0;i<5;i++)
			sum+=count[i];
		System.out.println("Vowel - A, Count - "+count[0]);
		System.out.println("Vowel - E, Count - "+count[1]);
		System.out.println("Vowel - I, Count - "+count[2]);
		System.out.println("Vowel - O, Count - "+count[3]);
		System.out.println("Vowel - U, Count - "+count[4]);
		System.out.println("Total number of vowels: "+sum);
		s.close();
	}
}
