package lab10;

public class Dog extends Animal implements Barkable {
	public Dog() {		//name을 Dog로 초기화하는 default 생성자 
		super("Dog");
	}
	
	public String bark() {		//개소리를 리턴하는 bark method 
		return "Bowwow";
	}
}
