package lab10;

public class Program {

	public static void main(String[] args) {
		Dog dog = new Dog();		//Dog, Tiger, Turtle 객체 생성 
		Tiger tiger = new Tiger();
		Turtle turtle = new Turtle();
		
		Animal[] animals = new Animal[3];		//배열을 만들어서 만든 객체들을 저장 
		animals[0] = dog;
		animals[1] = tiger;
		animals[2] = turtle;
		
		Person person = new Person() {		//익명 클래스를 이용한 Person의 구현 
			private int hp = 100;
			
			public void control(Animal animal) {
				if (animal instanceof Dog)
					hp = hp - 10;
				else if (animal instanceof Tiger)
					hp = hp - 80;
				System.out.println("You have overpowered the " + animal.getName());
			}
			
			public void showInfo() {
				System.out.println("Person HP: " + this.hp);
			}
		};
		
		showResult(animals, person);

	}
	
	private static void showResult(Animal[] animals, Person p) {
		for (int i = 0; i < animals.length; i++) {		//animals의 모든 Animal을 순회 
			System.out.printf("Animal%d:" + animals[i].getName() + "\n", i + 1);		//Animal의 이름 출력 
			if (animals[i] instanceof(Barkable barkable)) {		//Animal이 Barkable이면 bark() 수행 
				if (animals[i] instanceof Dog)
					System.out.printf("Animal%d barked " + ((Dog)animals[i]).bark() + "\n", i + 1);
				else if (animals[i] instanceof Tiger)
					System.out.printf("Animal%d barked " + ((Tiger)animals[i]).bark() + "\n", i + 1);
			}
			p.control(animals[i]);
			p.showInfo();
		}
	}

}
