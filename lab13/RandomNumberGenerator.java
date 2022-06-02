package lab13;

import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator {	//RandomNumberGenerator class는 NumberGenerator class의 자식클래스 
	private Random random = new Random();
	private int number;

	public int getNumber() {		//NumberGenerator에서 정의되지 않았던 abstract method 정의 
		return this.number;
	}

	public void execute() {			//NumberGenerator에서 정의되지 않았던 abstract method 정의 
		for(int i = 0;  i < 10; i++) {
			this.number = random.nextInt(50);
			notifyObservers();
		}
	}
}
