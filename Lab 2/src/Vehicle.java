
public abstract class Vehicle {
	int year_of_manufacture;
	public Vehicle(){}
	public Vehicle(int y) {
		// TODO Auto-generated constructor stub
		year_of_manufacture=y;
	}
	public abstract void getData();
	public abstract void putData();
}
