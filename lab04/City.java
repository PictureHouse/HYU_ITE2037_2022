package lab04;

import java.util.Random;

public class City {
	private String name;		//City 클래스의 instance 변수 
	private int locationX;
	private int locationY;
	
	public City(String name, int locationX, int locationY) {		//모든 instance 변수의 값을 set 하는 생성
		this.name = name;
		this.locationX = locationX;
		this.locationY = locationY;
	}
	
	public City(String name) {		//name 값 만을 set하는 생성
		Random random = new Random();
		this.name = name;
		this.locationX = random.nextInt(361);
		this.locationY = random.nextInt(361);
	}
	
	public String getName() {		//name 변수 값을 반환하는 getter
		return name;
	}
	
	public int getLocationX() {		//locationX 변수 값을 반환하는 getter
		return locationX;
	}
	
	public int getLocationY() {		//locationY 변수 값을 반환하는 getter
		return locationY;
	}
	
	public boolean equals(City anotherCity) {		//City 객체가 다른 City 객체와 같은지 비교하는 Method
		if (this.name.equals(anotherCity) && this.locationX == anotherCity.locationX && this.locationY == anotherCity.locationY) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {		//City 객체의 name, locationX, locationY를 반환하는 Method
		return this.name + ", " + this.locationX + ", " + this.locationY;
	}
	
	public static double distance(City city1, City city2) {		//두 City 객체 간의 거리를 반환하는 Method
		double result = Math.sqrt(Math.pow(city1.locationX - city2.locationX, 2) + Math.pow(city1.locationY - city2.locationY, 2));
		return result;
	}
}
