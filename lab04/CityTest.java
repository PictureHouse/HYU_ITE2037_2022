package lab04;

public class CityTest {

	public static void main(String[] args) {
		City seoul = new City("Seoul", 23, 45);		//객체 생성 
		City paris = new City("Paris", 123, 41);
		City racoon = new City("Racoon City");
		City mega = new City("Mega City");
		
		System.out.println(seoul.toString());		//생성한 객체의 정보 출력 
		System.out.println(paris.toString());
		System.out.println(racoon.toString());
		System.out.println(mega.toString());
		
		System.out.println("Seoul-Paris : " + seoul.distance(seoul, paris));		//도시 사이의 거리 출력 
		System.out.println("Seoul-Racoon City : " + seoul.distance(seoul, racoon));
		System.out.println("Paris-Mega City : " + paris.distance(paris, mega));
	}
}
