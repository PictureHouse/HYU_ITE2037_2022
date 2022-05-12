package lab10;

public class Animal {
	private String name;
	
	public Animal(String name) {		//name을 입력 받아서 초기화하는 생성자 
		this.name = name;
	}
	
	public String getName() {		//name의 getter
		return this.name;
	}
}
