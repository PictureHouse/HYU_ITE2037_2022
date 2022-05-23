package assignment2;

import java.util.Scanner;

//의사 클래스이며 의료 기관 종사자 클래스의 자식 클래스임 
public class Doctor extends HospitalPersonnel {
	//의사 ID, 이름, 비밀번호, 병원관리시스템을 받는 생성자 
	public Doctor(int id, String name, String password, HospitalManagementSystem hospitalsystem) {
		super(id, name, password, hospitalsystem);
	}
	
	/*
	 * 의료기관 종사자 클래스에서 추상method로 정의되었던 환자관리 method를 override한 method 
	 * 의사로 로그인하면 의사 버전의 메인화면이 출력되고 그에 맞는 작업들을 수행할 수 있음 
	 */
	public void managePatient() {
		int input;
		Scanner keyboard = new Scanner(System.in);
		
		while (true) {
			System.out.println("====== Welcome to Hospital Management System(Doctor) ======");
			System.out.println("1 - Update patient information");
			System.out.println("2 - Output patient information");
			System.out.println("0 - Exit");
			System.out.printf(">>Select menu: ");
			input = keyboard.nextInt();
			switch (input) {
			case (1):
				int pid;
				String prescription;
				System.out.printf("Input patient ID: ");
				pid = keyboard.nextInt();
				keyboard.nextLine();
				System.out.printf("Input prescription: ");
				prescription = keyboard.nextLine();
				updatePatient(pid, prescription);
				break;
			case (2):
				super.hospitalsystem.outputPatient();
				break;
			case (0):
				System.out.println("Exit program");
				return;
			default:
				System.out.println("Wrong input!");
				break;
			}
		}
	}
	
	/*
	 * 환자의 정보를 업데이트하는 method 
	 * 환자의 ID, 처방 정보를 받아서 환자 ID에 해당하는 환자를 환자 목록에서 찾은 후 정보를 업데이트함 
	 */
	public void updatePatient(int pid, String prescription) {
		int i;
		for (i = 0; i < super.hospitalsystem.getPL().length; i++) {
			if (pid == super.hospitalsystem.getPL()[i].getPid())
				break;
		}
		Patient patient = super.hospitalsystem.getPL()[i];
		patient.setPrescription(prescription);
		super.hospitalsystem.setPL(i, patient);
	}
}
