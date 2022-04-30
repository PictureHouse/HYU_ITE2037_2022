package assignment1;

import java.util.Scanner;

public class PatientManager {
	private static Patient[] patientList = new Patient[20];
	
	//메인 메뉴를 출력하고 사용자의 선택을 입력 받는 method
	public static int managePatients() {
		Scanner keyboard = new Scanner(System.in);
		int choice;
		
		System.out.println("==========Welcome to patient management system==========");
		System.out.println("1 - Add patient");
		System.out.println("2 - Delete patient");
		System.out.println("3 - Update patient");
		System.out.println("4 - Find patient");
		System.out.println("5 - Exit");
		System.out.println("Please enter your choice");
		choice = Integer.valueOf(keyboard.nextLine());
		return choice;
	}
	
	/*
	 환자를 환자 목록에 추가하는 method
	 사용자에게 환자ID를 입력 받은 후 입력 받은 정보가 환자 목록에 존재하는지 확인한 후 존재할 경우에는 메시지 출력후 메인 메뉴로 복귀
	 입력 받은 정보가 환자 목록에 존재하지 않을 경우에는 환자의 이름, 나이, 상태를 추가로 입력 받음
	 입력 받은 환자 정보를 환자 목록에 존재하는 환자 정보들 중 가장 마지막에 새롭게 추가 
	 추가가 완료되면 추가가 완료되었다는 메시지 출력 
	 */
	public static void addPatient() {
		String pid, name, status;
		int age;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter patient ID:");
		pid = keyboard.nextLine();
		if (doesExist(pid) != -1) {
			System.out.println("This ID already exists, please try again!");
			return;
		}		
		System.out.println("Please enter patient name:");
		name = keyboard.nextLine();
		System.out.println("Please enter patient age:");
		age = Integer.valueOf(keyboard.nextLine());
		System.out.println("Please enter patient status:");
		status = keyboard.nextLine();
		
		int i = 0;
		while (!patientList[i].getPid().equals("unknown")) {
			i++;
		}
		patientList[i] = new Patient(pid, name, age, status);
		System.out.println("Add patient completed, input 1 to continue.");
	}
	
	/*
	 입력 받은 환자ID가 환자 목록에 존재하는지 확인하는 method
	 목록을 순회하면서 환자ID 값이 목록에 존재한다면 해당 환자 정보의 index값을 리턴 
	 끝까지 순회하였으나 정보가 존재하지 않는다면 -1 값을 리턴 
	 */
	public static int doesExist(String pid) {
		int i = 0;
		while (!patientList[i].getPid().equals("unknown")) {
			if (pid.equals(patientList[i].getPid())) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	/*
	 환자 목록의 모든 환자 정보를 출력하는 method
	 목록에 환자가 없다면 정보가 없다는 메시지를 출력 
	 목록에 환자가 있다면 Patient 클래스의 toString() method를 사용하여 모든 환자들의 정보를 출력 
	 환자 목록에 unknown으로 되어있는 곳은 환자가 없는 것이므로 출력하지 않음 
	 */
	public static void outputAllPatients() {
		int i = 0;
		String patientInfo;
		if (patientList[0].getPid().equals("unknown")) {
			System.out.println("No such information, please add new information");
		}
		else {
			System.out.println("Patient information - ID / Name / Age / Status");
			while (!patientList[i].getPid().equals("unknown") && i < 20) {
				patientInfo = patientList[i++].toString();
				System.out.println("Patient{" + patientInfo + "}");
			}
		}
	}
		
	/*
	 환자 정보를 삭제하는 method
	 삭제하려는 환자의 ID를 입력 받아 doesExist() method를 사용하여 환자 목록에서 정보를 찾은 후 delete() method를 사용하여 환자 정보 삭제 
	 삭제 완료 후에는 환자 정보 삭제 완료 메시지 출력 
	 환자 정보가 환자 목록에 존재하지 않을 경우에는 정보가 존재하지 않는다는 메시지 출력 
	 */
	public static void deletePatient() {
		String pid;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Pleas enter the ID of the patient you want to delete:");
		pid = keyboard.nextLine();
		if (doesExist(pid) != -1) {
			delete(pid, doesExist(pid));
			System.out.println("Delete patient information completed, input 1 to continue.");
			}
		else {
			System.out.println("This ID does not exist!");
		}
	}
	
	/*
	 환자 정보 삭제 method
	 환자 목록에서 가장 마지막에 존재하는 환자 정보일 경우에는 해당 정보를 삭제 
	 삭제하려는 환자 정보의 뒤에 다른 환자 정보들이 이어질 경우에는 해당 정보를 삭제 후 뒤에 존재하는 환자 정보들을 한칸씩 앞으로 이동 
	 */
	public static void delete(String pid, int index) {
		if (patientList[index+1].getPid().equals("unknown"))
			patientList[index] = new Patient();
		else {
			int i = 0;
			for (i = index; i < 19 && !patientList[i+1].getPid().equals("unknown"); i++) {
				patientList[i] = patientList[i+1];
				patientList[i+1] = new Patient();
			}
		}
	}
	
	/*
	 환자 정보 수정 method
	 수정하려는 환자의 ID를 입력받아서 해당 환자가 환자 목록에 존재할 경우에 환자 정보들을 사용자로부터 새롭게 입력 받아 해당 환자의 정보를 새로운 정보로 교체 
	 환자 정보가 환자 목록에 존재하지 않을 경우에는 환자가 목록에 존재하지 않는다는 메시지 출력 
	 */
	public static void updatePatient() {
		String pid, newName, newStatus;
		int newAge;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the ID of the patient you want to change:");
		pid = keyboard.nextLine();
		if (doesExist(pid) != -1) {
			int i = doesExist(pid);
			System.out.println("Please enter new name of the patient:");
			newName = keyboard.nextLine();
			System.out.println("Please enter new age of the patient:");
			newAge = Integer.valueOf(keyboard.nextLine());
			System.out.println("Please enter new status of the patient:");
			newStatus = keyboard.nextLine();
			patientList[i] = new Patient(pid, newName, newAge, newStatus);
		}
		else {
			System.out.println("Can't find the patient.");
		}
	}
	
	/*
	 main method
	 환자 목록 초기화를 먼저 진행한 후 UserManager를 이용하여 로그인 과정을 진행 
	 로그인에 성공하였을 경우 환자 관리 프로그램으로 이동 
	 사용자의 선택에 따라 해당하는 method를 사용하여 원하는 과정을 수행 
	 선택지를 잘못 입력하였을 경우에는 에러메시지 출력 후 다시 메인 메뉴 출력 
	 */
	public static void main(String[] args) {
		boolean login;
		int input;
		for (int i = 0; i < 20; i++) {
			patientList[i] = new Patient();
		}
		UserManager userManager = new UserManager();
		login = userManager.login();
		while (!login)
			login = userManager.login();
		while (login) {
			input = managePatients();
			switch (input) {
				case 1:
					addPatient();
					break;
				case 2:
					deletePatient();
					break;
				case 3:
					updatePatient();
					break;
				case 4:
					outputAllPatients();
					break;
				case 5:
					System.out.println("Exit patient manager program");
					return;
				default:
					System.out.println("You input the wrong choice!");
			}
		}
	}
}
