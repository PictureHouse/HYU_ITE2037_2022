package account;

import java.time.LocalDate;

public class Account {
	private String name;		//Account 클래스의 instance 변수 
	private double yearlyInterest;
	private double balance;
	private LocalDate created;
	
	public Account(String name, double yearlyInterest, LocalDate created) {		//Account 생성자 
		this.name = name;
		this.yearlyInterest = yearlyInterest;
		this.balance = 0;
		this.created = created;
	}
	
	public double getBalance() {		//잔고를 반환하는 getter
		return balance;
	}
	
	public LocalDate getCreated() {		//가입일을 반환하는 getter
		return created;
	}
	
	public void increaseYearlyInterest(int byPercent) {		//연이자를 증가시켜주는 method
		this.yearlyInterest = this.yearlyInterest + byPercent;
	}
	
	public void receiveIncome(double income) {		//계좌에 수익을 받는 method
		this.balance = this.balance + income;
	}
	
	public void receiveInterest() {		//복리 이자를 받는 method
		this.balance = this.balance + this.balance * (this.yearlyInterest / 100) / 12;
	}
	
	public String toString() {		//toString method
		return "이름: " + this.name + ", 연이자: " + this.yearlyInterest + ", 잔고: " + this.balance + ", 가입일: " + this.created;
	}
}
