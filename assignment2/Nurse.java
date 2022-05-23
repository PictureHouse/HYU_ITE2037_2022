package assignment2;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//간호사 클래스이며 의료기관 종사자 클래스의 자식 클래스임 
public class Nurse extends HospitalPersonnel {
	//간호사 ID, 이름, 비밀번호, 병원관리시스템을 받는 생성자 
	public Nurse(int id, String name, String password, HospitalManagementSystem hospitalsystem) {
		super(id, name, password, hospitalsystem);
	}
	
	/*
	 * 의료기관 종사자 클래스에서 추상method로 정의되었던 환자관리 method를 override한 method 
	 * 간호사로 로그인하면 간호사 버전의 메인화면이 출력되고 그에 맞는 작업들을 수행할 수 있음 
	 */
	public void managePatient() {
		int input, pid, age;
		String pInput, name, in, out;
		LocalDate start, end, aptment;
		Scanner keyboard = new Scanner(System.in);
		
		while (true) {
			System.out.println("====== Welcome to Hospital Management System(Nurse) ======");
			System.out.println("1 - Register patient");
			System.out.println("2 - Update patient information");
			System.out.println("3 - Output patient information");
			System.out.println("0 - Exit");
			System.out.printf(">>Select menu: ");
			input = keyboard.nextInt();
			switch (input) {
			case (1):
				System.out.printf("Input patient ID: ");
				pid = keyboard.nextInt();
				keyboard.nextLine();
				System.out.printf("Input name: ");
				name = keyboard.nextLine();
				System.out.printf("Input age: ");
				age = keyboard.nextInt();
				keyboard.nextLine();
				Patient patient = new Patient(pid, name, age);
			
				System.out.printf("Input doctor name: ");
				name = keyboard.nextLine();
				int i;
				for (i = 0; i < super.hospitalsystem.getHPL().length; i++) {
					if (name.equals(super.hospitalsystem.getHPL()[i].getName()))
						break;
				}
				Doctor doctor = (Doctor) super.hospitalsystem.getHPL()[i];
			
				registerPatient(patient, doctor);
				break;
			case (2):
				System.out.printf("Input patient ID: ");
				pid = keyboard.nextInt();
				keyboard.nextLine();
				System.out.println("Input 'i' if the patient is inpatient, or input 'o' if the patient is outpatient");
				pInput = keyboard.nextLine();
				switch (pInput) {
				case ("i"):
					System.out.printf("Input in date(yyyy-mm-dd): ");
					in = keyboard.nextLine();
					start = LocalDate.parse(in, DateTimeFormatter.ISO_DATE);
					System.out.printf("input out date(yyyy-mm-dd): ");
					out = keyboard.nextLine();
					end = LocalDate.parse(out, DateTimeFormatter.ISO_DATE);
					updatePatient(pid, start, end);
					break;
				case ("o"):
					System.out.printf("Input appointment date(yyyy-mm-dd): ");
					in = keyboard.nextLine();
					aptment = LocalDate.parse(in, DateTimeFormatter.ISO_DATE);
					updatePatient(pid, aptment);
					break;
				}
				break;
			case (3):
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
	
	//환자와 의사를 받아서 의사를 환자의 지정 의사로 설정하고 환자를 환자 관리시스템에 추가하는 method 
	public void registerPatient(Patient patient, Doctor doctor) {
		patient.setDoctor(doctor);
		super.hospitalsystem.addPatient(patient);
	}
	
	/*
	 * 입원환자의 정보를 업데이트하는 method 
	 * 두가지 버전으로 overloading 되어있음 
	 * 환자의 ID, 입원일, 퇴원(예정)일을 받아서 환자 ID에 해당하는 환자를 환자 목록에서 찾은 후 정보를 업데이트함 
	 */
	public void updatePatient(int pid, LocalDate start, LocalDate end) {
		int i;
		for (i = 0; i < super.hospitalsystem.getPL().length; i++) {
			if (pid == super.hospitalsystem.getPL()[i].getPid())
				break;
		}
		InPatient in_patient = new InPatient(super.hospitalsystem.getPL()[i].getPid(), super.hospitalsystem.getPL()[i].getName(), super.hospitalsystem.getPL()[i].getAge(),start, end);
		super.hospitalsystem.setPL(i, in_patient);
	}
	
	/*
	 * 외래환자의 정보를 업데이트하는 method 
	 * 두가지 버전으로 overloading 되어있음 
	 * 환자의 ID, 진료 예약일을 받아서 환자 ID에 해당하는 환자를 환자 목록에서 찾은 후 정보를 업데이트함 
	 */
	public void updatePatient(int pid, LocalDate aptment) {
		int i;
		for (i = 0; i < super.hospitalsystem.getPL().length; i++) {
			if (pid == super.hospitalsystem.getPL()[i].getPid())
				break;
		}
		OutPatient out_patient = new OutPatient(super.hospitalsystem.getPL()[i].getPid(), super.hospitalsystem.getPL()[i].getName(), super.hospitalsystem.getPL()[i].getAge(), aptment);
		super.hospitalsystem.setPL(i, out_patient);
	}
}
