package lab11;

public class Gyeonggi extends Hub {			//Gyeonggi 클래스는 Hub 클래스의 자식 클래스 
	public static int init_num =  1000;
	public static String init_area = "Gyeonggi";
	public static int init_per_box = 3000;
	
	public Gyeonggi(String description) {			//description 값만 받는 생성자 
		this.setDescription(description);
		this.setArea(init_area);
		this.setPricePerBox(init_per_box);
		this.setNumber(++init_num);
	}
}
