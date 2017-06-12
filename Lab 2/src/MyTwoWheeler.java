public class MyTwoWheeler extends TwoWheeler {
	String ownerName;
	public MyTwoWheeler(String brand, int cost, String colour, String name, int y) {
		// TODO Auto-generated constructor stub
		super(brand,cost,colour,y);
		ownerName=name;
	}
	
	public void print(){
		System.out.println("Name: "+ownerName);
		super.putData();
	}
}
