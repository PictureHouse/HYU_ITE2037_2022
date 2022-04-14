package quiz1;

public class Chocolate {
	private String name;
	private double price;
	private int box;
	private double sales;
	
	public Chocolate(String name, double price, int box) {
		this.name = name;
		this.price = price;
		this.box = box;
		this.sales = price * box;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public int getBox() {
		return this.box;
	}
	
	public double getSales() {
		return this.sales;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setBox(int box) {
		this.box = box;
	}
	public static double calculateTotalSales(Chocolate[] chocolateList) {
		double totalSales = 0.0;
		for (int i = 0; i < chocolateList.length; i++) {
			totalSales = totalSales + chocolateList[i].price * chocolateList[i].box;
		}
		return totalSales;
	}
	
	public String toString() {
		return "Name='"+this.name+"', price="+this.price+", box="+this.box+", sales="+this.sales;
	}
}
