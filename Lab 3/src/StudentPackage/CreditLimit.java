package StudentPackage;

public class CreditLimit extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CreditLimit(){}
	public String toString(){
		return "CreditLimitException! Exceeds limit";
	}

}
