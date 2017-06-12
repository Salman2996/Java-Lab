import java.util.*;
public class TwoWheeler extends Vehicle{
	String brand,colour;
	int cost;
	public TwoWheeler(){}
	public TwoWheeler(String b, int cos, String c,int y) {
		// TODO Auto-generated constructor stub
		super(y);
		brand=b;
		cost=cos;
		colour=c;
	}
	@Override
	public void getData() {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the brand:");
		brand=s.next();
		System.out.println("Enter cost:");
		cost=Integer.parseInt(s.next());
		System.out.println("Enter colour:");
		colour=s.next();
		System.out.println("Enter year of manufacture:");
		year_of_manufacture=Integer.parseInt(s.next());
	}
	@Override
	public void putData() {
		// TODO Auto-generated method stub
		System.out.println("Two wheeler");
		System.out.println("Brand: "+brand);
		System.out.println("Cost: "+cost);
		System.out.println("Colour: "+colour);
		System.out.println("Year of Manufacture: "+year_of_manufacture);
	}
}
