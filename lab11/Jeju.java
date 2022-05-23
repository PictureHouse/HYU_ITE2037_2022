package lab11;

public class Jeju extends Hub {			//Jeju 클래스는 Hub 클래스의 자식 클래스 
	public static int init_num =  9000;
	public static String init_area = "Jeju";
	public static int init_per_box = 6000;
	
	public Jeju(String description) {			//description 값만 받는 생성자 
		this.setDescription(description);
		this.setArea(init_area);
		this.setPricePerBox(init_per_box);
		this.setNumber(++init_num);
	}
}
