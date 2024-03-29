package lab08;

import java.time.LocalDate;

public abstract class Car {		//car class는 추상클래스로 선언 
	protected String name;
	protected LocalDate date;
	
	public Car() {		//기본 생성자 
		name = "Car Frame";
		date = null;
	}
	
	public abstract int totalCO2();  //abstract method 
	
	public static void main(String[] args) {		//main method
		Car protoICE = new ICE();
		Car protoBEV = new BEV();
		System.out.println(protoICE);
		System.out.println(protoBEV);
			
		ICE protoType1 = new ICE("Test1", LocalDate.of(1886, 01, 29),1);
		ICE newICE = new ICE("ICE1", LocalDate.now(), 800000);
		ICE addICE = new ICE("ICE1", LocalDate.now(), 200000);
		System.out.println(protoType1);System.out.println(newICE); System.out.println(addICE);
			
		System.out.println(protoType1.equals(newICE));
		System.out.println(newICE.equals(addICE));
			
		BEV protoType2 = new BEV("Test2", LocalDate.of(1832, 01,01),1);
		BEV newBEV = new BEV("BEV1", LocalDate.now(), 1000000);
		BEV addBEV = new BEV("BEV1", LocalDate.now(), 300000);
		BEV BEVplusplus = new BEV("BEV1++", LocalDate.now(), 100000);
			
		System.out.println(protoType2);System.out.println(newBEV);
		System.out.println(addBEV);System.out.println(BEVplusplus);
			
		System.out.println(newBEV.equals(addBEV));
		System.out.println(addBEV.equals(BEVplusplus));
		
	    System.out.println(protoICE.totalCO2());
		System.out.println(protoBEV.totalCO2());
	}

}
