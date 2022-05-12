package lab10;

public class Tiger extends Animal implements Barkable {
	public Tiger() {		//name을 Tiger로 초기화하는 default 생성자 
		super("Tiger");
	}
	
	public String bark() {		//호랑이소리를 리턴하는 bark method 
		return "Growl";
	}
}
