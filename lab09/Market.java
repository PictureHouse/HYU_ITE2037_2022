package lab09;

import java.util.Scanner;

public class Market {

	public static void main(String[] args) {
		Wallet wallet = new Wallet("my wallet");
		Scanner keyboard = new Scanner(System.in);
		
		while (true) {		//무한 반복문 
			try {
				int input;
				wallet.empty();
				System.out.println("Enter price : ");
				input = keyboard.nextInt();
				if (input < 0)
					throw new NegativeException();
				else if (input > 100)
					throw new TooMuchExpenseException(input);
				else if (input > wallet.getBalance())
					throw new TooMuchExpenseException();
				else {
					wallet.increaseIndex();
					wallet.decreaseBalance(input);
				}
			}
			catch (NegativeException ne){		//입력값이 0보다 작은 경우에 대한 예외처리 
				System.out.println(ne);
				System.out.println("\tat "+ne.getStackTrace()[0]);
			}
			catch (TooMuchExpenseException tmee) {		//입력값이 100보다 크거나, 잔고보다 클 경우에 대한 예외처리 
				System.out.println(tmee);
				System.out.println("\tat "+tmee.getStackTrace()[0]);

			}
			catch (Exception e) {		//지갑이 비었을 경우에 대한 예외처리 
				System.out.println(e);
				System.out.println("\tat "+e.getStackTrace()[0]);
				keyboard.close();
				return;
			}
			finally {
				System.out.println(wallet.toString());
				System.out.printf("---transaction complete--- \n\n");
			}
		}

	}

}
