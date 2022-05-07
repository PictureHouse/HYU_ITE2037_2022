package lab09;

public class Wallet {
	private String name;
	private int balance;
	private int txIndex;
	
	public Wallet(String name) {		//name을 인자로 받고 instance variable의 값을 초기화하는 생성자 
		this.name = name;
		this.txIndex = 0;
		this.balance = 100;
	}
	
	public int getBalance() {		//balance에 대한 getter
		return this.balance;
	}
	
	public void increaseIndex() {		//txIndex를 1만큼 증가시키는 method
		this.txIndex++;
	}
	
	public void decreaseBalance(int expense) {		//balance를 expense만큼 감소시키는 method 
		this.balance = this.balance - expense;
	}
	
	public String toString() {
		return "name: "+this.name+", #"+this.txIndex+", balance: "+this.balance;
	}
	
	public void empty() throws Exception {		//지갑에 돈이 없으면 집에 가야하는 method 
		if (this.balance <= 0) {
			throw new Exception("Go Home");
		}
	}
}
