package lab05.manager;

import lab05.account.Account;
import java.time.LocalDate;
import java.util.Random;

public class AccountManager {

	public static void main(String[] args) {
		LocalDate created = LocalDate.of(2021, 12, 1);		//LocalDate.of를 사용해서 가입일 생성
		Account account = new Account("Cho", 5, created);	//사용자 계좌 생성 
		System.out.println(account.toString());				//생성한 계좌의 모든 정보 출력 
		
		int month = 0;			//가입한지 몇달 지났는지 카운트하기 위한 변수 
		int flag = 0;			//이자율을 한번만 증가시키기 위한 flag 변수 
		LocalDate date = account.getCreated();		//날짜 변수 
		
		while (account.getBalance() < 10000) {			
			date = date.plusMonths(1);		//날짜 한달 증가 
			month++;						//가입 달수를 카운트하는 변수 1증가 
			
			account.receiveIncome(100);		//소득 수령 
			account.receiveInterest();		//이자 수령 
			
			if (month >= 12 && month % 12 == 1) {	//가입한지 1년 이상 지났을 경우 + 1월인 경우 
				Random random = new Random();
				int event = 7;						//미리 설정해 놓은 당첨번호 
				int winner = random.nextInt(9);		//0~9까지의 난수를 생성 
				if (event == winner) {				//난수와 미리 설정해놓은 당첨번호가 같은 경우(당첨인 경우) 
					account.receiveIncome(100);		//계좌로 100만원 상당의 현금성 상품권 지급 
					System.out.println("이벤트 당첨! " + date);		//당첨 정보 출력 
				}
			}
			
			if (month == 36 && flag == 0) { 		//가입한지 3년이 지났을 경우 + 이자율을 한번도 증가시키지 않았을 경우 
				account.increaseYearlyInterest(2);	//이자율을 2% 인상 
				flag++;								//이자율을 한번 증가했음을 표시하기 위해 flag 변수를 1증가 
				System.out.println("가입 후 3년이 지나서 이자율이 2% 인상되었습니다.");	//이자율 증가 메세지 출력 
			}
		}
		System.out.println(account.toString() + ", 1억 모으기 끝: " + date);		//잔고가 10000 이상일 때 while loop를 빠져나와 계좌의 모든 정보 출력 
	}

}
