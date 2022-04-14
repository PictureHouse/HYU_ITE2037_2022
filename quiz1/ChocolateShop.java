package quiz1;

import java.util.Scanner;
import java.util.Arrays;

public class ChocolateShop {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double totalSales = 0.0;
		
		Chocolate[] choco = new Chocolate[3];
		for (int i = 0; i < choco.length; i++) {
			choco[i] = new Chocolate(scanner.next(), scanner.nextDouble(), scanner.nextInt());
			System.out.println("Chocolate{" + choco[i].toString() + "}");
		}
		totalSales = Chocolate.calculateTotalSales(choco);
		System.out.println("Total Sales: " + totalSales);
		
		double[] income = new double[choco.length];
		for (int i = 0; i < choco.length; i++) {
			income[i] = choco[i].getPrice() * choco[i].getBox();
		}
		Arrays.sort(income);
		System.out.printf("sorted array: ");
		for (int i = 0; i < income.length; i++) {
			System.out.print(income[i]);
			if (i != income.length - 1) {
				System.out.print(", ");
			}
		}
	}

}
