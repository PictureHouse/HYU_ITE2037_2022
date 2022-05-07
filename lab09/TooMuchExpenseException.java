package lab09;

public class TooMuchExpenseException extends Exception {
	private int inputNum;
	
	public TooMuchExpenseException() {		//기본 생성자 
		super("Not enough balance.");
	}
	
	public TooMuchExpenseException(int input) {		//int 인자를 받는 생성자 
		super("Over the limit!");
		inputNum = input;
	}
	
	public int getInputNum() {		//inputNum을 반환하는 getter 
		return this.inputNum;
	}
}
