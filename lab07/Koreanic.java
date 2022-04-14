package lab07;

public class Koreanic extends Language {		//Koreanic클래스는 Language클래스의 자식 클래스 
	public Koreanic(String name, int numSpeakers) {		//2개의 인자를 받는 생성자 
		super(name, numSpeakers);
		this.name = name;
		this.numSpeakers = numSpeakers;
		this.regionsSpoken = "Korean peninsula(South Korea, North Korea, Jeju) and several prefectures of China";
		this.wordOrder = "subject-object-verb";
		if (name.contains("Jeju")) {		//name에 Jeju가 들어있다면 
			this.regionsSpoken = "Jeju island";		//regionsSpoken을 Jeju island로 바꿈 
		}
	}
}
