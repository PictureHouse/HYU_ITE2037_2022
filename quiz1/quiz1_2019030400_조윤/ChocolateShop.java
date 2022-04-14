package quiz1;

import java.util.Scanner;
import java.util.Arrays;
import quiz1.Chocolate;

public class ChocolateShop {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double totalSales = 0.0;
		
		Chocolate[] choco = new Chocolate[3];
		for (int i = 0; i<choco.length; i++) {
			choco[i].setName(scanner.next());
			choco[i].setPrice(scanner.nextDouble());
			choco[i].setBox(scanner.nextInt());
			System.out.println(choco[i].toString());
		}
		
		double[] income = { };
		totalSales = calculateTotalSales(choco);
	}

}
