package lab08;

import java.time.LocalDate;

public class ICE extends Car {		//ICE class는 Car class의 child class
	private static int carNum;
	private static int CO2emission;
	private static int GHGPERCAR = 35;
	
	public ICE() {		//기본 생성자 
		super();
	}
	
	public ICE(String name, LocalDate date, int carNum) {		//3개의 인자를 받는 생성자 
		this.name = name;
		this.date = date;
		ICE.carNum = ICE.carNum + carNum;
		ICE.CO2emission = ICE.CO2emission + carNum * ICE.GHGPERCAR;
	}
	
	public boolean equals(Object obj) {		//equals method override 
		if (obj == null)
			return false;
		ICE ice = (ICE)obj;		//타입캐스팅 
		if (this.name.equals(ice.name) && this.date.equals(ice.date))
			return true;
		else
			return false;
	}
	
	public String toString() {
		return "name: " + name + ", date: " + date + ", carNum: " + carNum;
	}
	
	public int totalCO2() {
		System.out.println("ICE emit CO2 most when driving");
		return ICE.CO2emission;
	}
}
