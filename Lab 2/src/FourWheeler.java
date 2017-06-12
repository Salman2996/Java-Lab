import java.util.*;
public final class FourWheeler extends Vehicle {
	String brand,colour;
	int cost;
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
		System.out.println("Four wheeler");
		System.out.println("Brand: "+brand);
		System.out.println("Cost: "+cost);
		System.out.println("Colour: "+colour);
		System.out.println("Year of Manufacture: "+year_of_manufacture);
	}
}
