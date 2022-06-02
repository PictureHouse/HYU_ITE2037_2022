package lab13;

public class DigitObserver implements Observer {
	private NumberGenerator num;

	public DigitObserver(NumberGenerator num) {		//생성자 
		this.num = num;
		num.addObserver(this);
	}

	public void update(NumberGenerator generator) {		//Observer interface에서 정의되지 않았던 method를 정의 
		System.out.println("DigitObserver: " + generator.getNumber());

		try {
			Thread.sleep(100);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
