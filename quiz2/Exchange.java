package quiz2;

import java.util.Scanner;

public class Exchange {

	public static void main(String[] args) {
		Collector<PocketMonster> col1 = new Collector<PocketMonster>("Red", 100);
		Collector<PocketMonster> col2 = new Collector<PocketMonster>("Green", 200);
		PocketMonster mon1 = new PocketMonster("Pikachu", "1 Million Volt Electric Shock");
		PocketMonster mon2 = new PocketMonster("GGobugi", "Surfing");
		col1.add(mon1);
		col2.add(mon2);
		col1.printAllTokens();
		col2.printAllTokens();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("----- Enter tokenId -----");
		int tokenId = keyboard.nextInt();
		col1.transfer(tokenId, col2);
		col1.printAllTokens();
		col2.printAllTokens();
	}
}
