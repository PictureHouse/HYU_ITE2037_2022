package lab07;

public class Language {
	protected String name;		//4개의 protected field
	protected int numSpeakers;
	protected String regionsSpoken;
	protected String wordOrder;
	
	public Language(String name, int numSpeakers, String regionsSpoken, String wordOrder) {		//4개의 인자를 받는 생성자 
		this.name = name;
		this.numSpeakers = numSpeakers;
		this.regionsSpoken = regionsSpoken;
		this.wordOrder = wordOrder;
	}
	
	public Language(String name, int numSpeakers) {		//2개의 인자를 받는 생성자(자식 클래스에서 super를 사용하기 위해 작성)
		this.name = name;
		this.numSpeakers = numSpeakers;
	}
	
	public void getInfo() {		//정보를 출력하는 method
		System.out.printf("%s is spoken by %d people mainly in %s.\n", name, numSpeakers, regionsSpoken);
		System.out.printf("The language follows the word order: %s.\n", wordOrder);
	}
	
	public static void main(String[] args) {		//main method
		System.out.println("---------- Language ----------");
		Language spanish = new Language(
		"Spanish", 
		555000000, 
		"Spain, Latin America, and Equatorial Guinea", 
		"subject-verb-object");
		spanish.getInfo();

		System.out.println("----------Koreanic----------");
		Language korean = new Koreanic("Korean", 80400000);
		korean.getInfo();

		Language jeju_uh = new Koreanic("Jeju Language", 695500);
		jeju_uh.getInfo();

		System.out.println("----------Mayan----------");
		Mayan kiche = new Mayan("Ki'che'", 2330000);
		kiche.getInfo(); 
	}
}