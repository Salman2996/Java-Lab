
public class MainClass {

	public static void main(String[] args)  throws InterruptedException {
		// TODO Auto-generated method stub
		FirstThread firstThread=new FirstThread();
		SecondThread secondThread=new SecondThread();
		firstThread.start();
		Thread.sleep(100);
		secondThread.start();
	}

}
