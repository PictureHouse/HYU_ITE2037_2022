package assignment2;

import java.time.LocalDate;
import java.util.Scanner;

//병원 관리 시스템 클래스이며 메인 method를 포함하고 있음 
public class HospitalManagementSystem {
	protected HospitalPersonnel[] hospitalPersonnelList;
	protected Patient[] patientList;
	protected static int hospitalPersonnelNum;
	protected static int patientNum;
	
	//의료기관 종사자 배열과 환자 배열을 받는 병원 관리 시스템 생성자 
	public HospitalManagementSystem(HospitalPersonnel[] hp, Patient[] pa) {
		hospitalPersonnelList = hp;
		patientList = pa;
	}
	
	//의료기관 종사자 배열을 리턴하는 getter 
	public HospitalPersonnel[] getHPL() {
		return this.hospitalPersonnelList;
	}
	
	//환자 배열을 리턴하는 getter 
	public Patient[] getPL() {
		return this.patientList;
	}
	
	//인덱스와 환자를 받아서 인덱스에 해당하는 환자 배열의 정보를 환자로 설정하는 method 
	public void setPL(int index, Patient patient) {
		this.patientList[index] = patient;
	}
	
	//의사를 받아서 의료기관 종사자 배열에 추가하는 method 
	public void addDoctor(Doctor doctor) {
		int i;
		for (i = 0; i < hospitalPersonnelNum; i++) {
			if (this.hospitalPersonnelList[i] == null)
				break;
		}
		this.hospitalPersonnelList[i] = doctor;
		hospitalPersonnelNum++;
	}
	
	//간호사를 받아서 의료기관 종사자 배열에 추가하는 method 
	public void addNurse(Nurse nurse) {
		int i;
		for (i = 0; i < hospitalPersonnelNum; i++) {
			if (this.hospitalPersonnelList[i] == null)
				break;
		}
		this.hospitalPersonnelList[i] = nurse;
		hospitalPersonnelNum++;
	}
	
	//환자를 받아서 환자 배열에 추가하는 method 
	public void addPatient(Patient patient) {
		int i;
		for (i = 0; i < patientNum; i++) {
			if (this.patientList[i] == null)
				break;
		}
		this.patientList[i] = patient;
		patientNum++;
	}
	
	//입력 받은 환자 ID에 해당하는 환자를 환자 배열에서 찾아서 해당 환자의 정보를 출력하는 method 
	public void outputPatient(int pid) {
		for (int i = 0; i < patientNum; i++) {
			if (pid == this.patientList[i].getPid())
				this.patientList[i].outputPatientInfo();
		}
	}
	
	//환자 배열에 있는 모든 환자의 정보를 출력하는 method 
	public void outputPatient() {
		for (int i = 0; i < patientNum; i++) {
			this.patientList[i].outputPatientInfo();
		}
	}
	
	/*
	 * 의료기관 종사자의 ID와 비밀번호를 받아서 로그인을 수행하는 method 
	 * 의료기관 종사자 배열에 일치하는 정보가 있으면 로그인 성공 메시지와 함께 해당 정보의 인덱스를 리턴하고, 일치하는 정보가 없으면 로그인 실패 메시지와 함께 -1을 리턴 
	 */
	public int login(String name, String password) {
		int i;
		for (i = 0; i < hospitalPersonnelNum; i++) {
			if (name.equals(this.hospitalPersonnelList[i].getName())) {
				if (password.equals(this.hospitalPersonnelList[i].getPassword())) {
					System.out.println("Login success");
					return i;
				}
			}
		}
		System.out.println("Login failed");
		return -1;
	}
	
	/*
	 * 메인 method
	 * 처음 실행할 때 의사2명, 간호사2명, 환자3명의 정보를 추가하는 초기화를 수행함
	 * 이후에는 로그인 화면을 띄운 후 이름과 비밀번호를 입력받고 로그인 method 및 환자관리 method를 수행함 
	 */
	public static void main(String[] args) {
		int login_result = -1;
		String name, password;
		Scanner keyboard = new Scanner(System.in);
		HospitalPersonnel[] hp = new HospitalPersonnel[50];
		Patient[] pa = new Patient[50];
		HospitalManagementSystem hospitalsystem = new HospitalManagementSystem(hp, pa);
		
		Doctor doctor1 = new Doctor(1, "Emma", "123456", hospitalsystem);
		hospitalsystem.addDoctor(doctor1);
		Doctor doctor2 = new Doctor(2, "Olivia", "123456", hospitalsystem);
		hospitalsystem.addDoctor(doctor2);
		Nurse nurse1 = new Nurse(1, "Ava", "123456", hospitalsystem);
		hospitalsystem.addNurse(nurse1);
		Nurse nurse2 = new Nurse(2, "Mia", "123456", hospitalsystem);
		hospitalsystem.addNurse(nurse2);
		
		Patient patient1 = new Patient(1, "Bob", 25);
		hospitalsystem.addPatient(patient1);
		LocalDate inDate = LocalDate.of(2022, 05, 24);
		LocalDate outDate = LocalDate.of(2022, 06, 04);
		InPatient patient2 = new InPatient(2, "Tom", 23, inDate, outDate);
		patient2.setDoctor(doctor1);
		hospitalsystem.addPatient(patient2);
		LocalDate aptment = LocalDate.of(2022, 06, 01);
		OutPatient patient3 = new OutPatient(3, "Alice", 18, aptment);
		patient3.setDoctor(doctor2);
		hospitalsystem.addPatient(patient3);
		
		while (login_result == -1) {
		System.out.println("========== Hospital Management System Login Page ==========");
		System.out.println(">>Please login");
		System.out.printf("Name: ");
		name = keyboard.nextLine();
		System.out.printf("Password: ");
		password = keyboard.nextLine();
		login_result = hospitalsystem.login(name, password);
		}
		hospitalsystem.hospitalPersonnelList[login_result].managePatient();
		
		keyboard.close();
	}

}
