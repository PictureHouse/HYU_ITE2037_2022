package lab11;

public class Hub {
	private int number;
	private String description;
	private String area;
	private double price_per_box;
	
	public void setNumber(int number) {			//number의 setter
		this.number = number;
	}
	
	public void setDescription(String description) {			//description의 setter
		this.description = description;
	}
	
	public void setArea(String area) {			//area의 setter
		this.area = area;
	}
	
	public void setPricePerBox(double price_per_box) {			//price_per_box의 setter
		this.price_per_box = price_per_box;
	}
	
	public int getNumber() {			//number의 getter
		return this.number;
	}
	
	public String getDescription() {			//description의 getter
		return this.description;
	}
	
	public String getArea() {			//area의 getter
		return this.area;
	}
	
	public double getPricePerBox() {			//price_per_box의 getter
		return this.price_per_box;
	}
	
	public String toString() {		//toString method
		return "Box Number : " + this.number + "\nDescription : " + this.description + "\nArea : " + this.area + "\nPrice per box : " + this.price_per_box;
	}
}
