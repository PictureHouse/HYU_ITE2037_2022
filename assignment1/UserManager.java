package assignment1;

import java.util.Scanner;

public class UserManager {
	private User[] userList = new User[20];
	
	/*
	 유저 관리자 객체를 생성하는 기본생성자 
	 객체를 생성하면서 유저 목록을 for 루프를 이용해 순환하면서 각각 초기화 
	 */
	public UserManager() {
		for (int i = 0; i < 20; i++) {
			userList[i] = new User(); 
		}
	}
	
	/*
	 유저 계정을 유저 목록에 추가하는 method
	 사용자에게 ID와 password를 순차적으로 입력받아 유저 목록에 추가 
	 */
	public void addUser() {
		String id, pw;
		int i = 0;
		Scanner keyboard = new Scanner(System.in);
		
		while (userList[i] != null && i < 19)
			i++;
		System.out.println("Please enter user ID");
		id = keyboard.nextLine();
		System.out.println("Please enter user password");
		pw = keyboard.nextLine();
		userList[i] = new User(id, pw);
	}
	
	/*
	 로그인 과정을 진행하는 method
	 계정을 추가할지, 아니면 로그인을 진행할지 선택하는 화면이 가장 먼저 나옴 
	 계정을 추가할 경우(case 1), addUser() method를 사용하여 사용자 계정을 추가 
	 로그인을 진행할 경우(case 2), 사용자에게 ID와 password를 입력받아 입력 받은 정보가 유저 목록에 있는지 for 루프와 중첩 if문을 사용하여 확인하고
	 만약에 입력 받은 정보가 유저 목록에 있을 경우에는 loginFlag를 1 증가시켜줌, 정보가 존재하지 않을 경우에는 loginFlag 값이 최종적으로 0
	 최종적으로 loginFlag 값을 확인하여 로그인 성공여부를 판단하고 성공 또는 실패 메시지를 출력한 후 boolean 값을 리턴 
	 */
	public boolean login() {
		String idInput, pwInput;
		int menuSelect, input, loginFlag = 0;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("=======================Login Page=======================");
		System.out.println("1 - Sign up");
		System.out.println("2 - Sign in");
		System.out.println("Please enter your choice");
		menuSelect = Integer.valueOf(keyboard.nextLine());
		switch (menuSelect) {
			case 1:		
				addUser();
				return false;
			case 2:
				System.out.println("Please login");
				System.out.println("ID:");
				idInput = keyboard.nextLine();
		
				System.out.println("Password:");
				pwInput = keyboard.nextLine();
			
				for (int i = 0; i < 20; i++) {
					if (idInput.equals(userList[i].getUid())) {
						if (pwInput.equals(userList[i].getPassword()))
							loginFlag++;
					}
				}
		
				if (loginFlag == 1) {
					System.out.println("Login success, input 1 to continue.");
					input = Integer.valueOf(keyboard.nextLine());
					return true;
				}
				else {
					System.out.println("Login failed, input 1 to continue.");
					input = Integer.valueOf(keyboard.nextLine());
					return false;
				}
			default:
				return false;
		}
	}
}
