import java.util.*;
public class Account {
	int accno, phno;
	String name;
	float balance;
	Account(int a, String n, int p, float b){
		accno=a;
		phno=p;
		name=n;
		balance=b;
	}
	
	void deposit(int d){
		if(d>0){
			balance+=d;
			System.out.println("Amount deposited. New balance is: "+balance);
		}else
			System.out.println("Deposit amount invalid");
	}
	
	void withdraw(int w){
		if(w>0 && w<=balance){
			if(balance<10000)
				System.out.println("Account balance less than 10000! Cannot withdraw!");
			else{
				balance-=w;
				System.out.println("Amount withdrawn. New balance is: "+balance);
			}
		}else
			System.out.println("Withdraw amount invalid");
	}
	
	public static void main(String []args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number of employees:");
		int n=Integer.parseInt(s.next());
		Account a[]=new Account[n];
		System.out.println("Enter the details for all accounts:");
		int accno,phno;
		String name;
		float balance;
		for(int i=0;i<n;i++){
			System.out.println("Enter the account number:");
			accno=Integer.parseInt(s.next());
			System.out.println("Enter name:");
			name=s.next();
			System.out.println("Enter the phone number:");
			phno=Integer.parseInt(s.next());
			System.out.println("Enter the account balance:");
			balance=Float.parseFloat(s.next());
			a[i]=new Account(accno,name,phno,balance);
		}
		
		while(true){
			System.out.println("Enter choice:\n1.Deposit\n2.Withdraw\n3.Exit");
			int choice=Integer.parseInt(s.next());
			switch(choice){
				case 1:
					System.out.println("Enter the account number:");
					int acc=Integer.parseInt(s.next());
					System.out.println("Enter amount to be deposited:");
					int d=Integer.parseInt(s.next());
					for(int i=0;i<n;i++){
						if(a[i].accno==acc)
							a[i].deposit(d);
					}
					break;
				case 2:
					System.out.println("Enter the account number:");
					acc=Integer.parseInt(s.next());
					System.out.println("Enter amount to be withdrawn:");
					int w=Integer.parseInt(s.next());
					for(int i=0;i<n;i++){
						if(a[i].accno==acc)
							a[i].withdraw(w);
					}
					break;
				case 3:
					s.close();
					System.exit(0);
			}
		}
	}
}
