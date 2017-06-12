package StudentPackage;
import java.io.*;
public class RegisterStudent implements Student {
	
	public String name,branch,subject[];
	public int credits,sem;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public RegisterStudent(){
		subject=new String[5];
	}
	void compute(int x) throws CreditLimit{
		if(x>30)
			throw new CreditLimit();
	}


	@Override
	public void getName() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter name:");
		name=br.readLine();
	}

	@Override
	public void getBranch() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter branch:");
		branch=br.readLine();

	}
	
	public void getCredits() throws Exception {
		int x[]=new int[5];
		System.out.println("Enter semester:");
		sem=Integer.parseInt(br.readLine());
		System.out.println("Enter subjects and credits:");
		for(int i=0;i<5;i++){
			System.out.println("Subject: ");
			subject[i]=br.readLine();
			System.out.println("Credits:");
			x[i]=Integer.parseInt(br.readLine());
		}
		credits=0;
		for(int i=0;i<5;i++)
			credits=credits+x[i];
		try{
			compute(credits);
		}catch(CreditLimit e){
			System.out.println(e);
			System.exit(0);
		}
	}


}
