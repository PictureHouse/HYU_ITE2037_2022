package lab09;

public class NegativeException extends Exception {
	public NegativeException() {	//기본 생성자 
		super("price must be positive");
	}
	
	public NegativeException(String message) {		//String 인자를 받는 생성자 
		super(message);
	}
}
