package lab08;

import java.time.LocalDate;

public class BEV extends Car {		//BEV class는 Car class의 child class
	private static int carNum;
	private static int CO2emission;
	private static int GHGPERCAR = 25;
	
	public BEV() {		//기본 생성자 
		super();
	}
	
	public BEV(String name, LocalDate date, int carNum) {		//3개의 인자를 받는 생성자 
		this.name = name;
		this.date = date;
		BEV.carNum = BEV.carNum + carNum;
		BEV.CO2emission = BEV.CO2emission + carNum * BEV.GHGPERCAR;
	}
	
	public boolean equals(Object obj) {		//equals method override
		if (obj == null)
			return false;
		BEV bev = (BEV)obj;		//타입캐스팅 
		if (this.name.equals(bev.name) && this.date.equals(bev.date))
			return true;
		else
			return false;
	}
	
	public String toString() {
		return "name: " + name + ", date: " + date + ", carNum: " + carNum;
	}
	
	public int totalCO2() {
		System.out.println("BEV emit CO2 most when generating electric energy");
		return BEV.CO2emission;
	}
}
