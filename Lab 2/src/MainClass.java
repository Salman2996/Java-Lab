import java.util.*;
public class MainClass {
	public static void main(String []args) {
		TwoWheeler tw=new TwoWheeler();
		tw.getData();
		tw.putData();
		FourWheeler fw=new FourWheeler();
		fw.getData();
		fw.putData();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter brand:");
		String brand=s.next();
		System.out.println("Enter cost:");
		int cost=Integer.parseInt(s.next());
		System.out.println("Enter colour:");
		String colour=s.next();
		System.out.println("Enter name:");
		String name=s.next();
		System.out.println("Enter year of manufacture:");
		int y=Integer.parseInt(s.next());
		MyTwoWheeler obj=new MyTwoWheeler(brand,cost,colour,name,y);
		obj.print();
		s.close();
	}
}
