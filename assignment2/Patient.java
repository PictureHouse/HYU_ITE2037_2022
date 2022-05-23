package assignment2;

//환자 클래스이며 입원환자 클래스와 외래환자 클래스를 자식 클래스로 가짐 
public class Patient {
	private int pid;
	private String name;
	private int age;
	private Doctor doctor;
	private String prescription;
	
	/*
	 * 환자의 ID, 이름, 나이를 받는 생성자
	 * 지정 의사는 지정되지 않아서 null로 처리하고 처방은 없는 것으로 지정함 
	 */
	public Patient(int pid, String name, int age) {
		this.pid = pid;
		this.name = name;
		this.age = age;
		this.doctor = null;
		this.prescription = "none";
	}
	
	/*
	 * 환자의 ID, 이름, 나이, 지정 의사를 받는 생성자 
	 * 처방은 없는 것으로 지정함 
	 */
	public Patient(int pid, String name, int age, Doctor doctor) {
		this.pid = pid;
		this.name = name;
		this.age = age;
		this.doctor = doctor;
		this.prescription = "none";
	}
	
	//환자의 ID를 리턴하는 getter
	public int getPid() {
		return this.pid;
	}
	
	//환자의 이름을 리턴하는 getter
	public String getName() {
		return this.name;
	}
	
	//환자의 나이를 리턴하는 getter 
	public int getAge() {
		return this.age;
	}
	
	//환자의 지정 의사를 설정하는 setter 
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	//환자의 처방을 설정하는 setter
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	
	/*
	 * 환자의 정보를 String 형식으로 리턴하는 toString method
	 * try-catch문을 사용하여 지정 의사가 없을 경우에는 None으로 출력 
	 */
	public String toString() {
		try {
			return "Name: " + this.name + ", Age: " + this.age + ", Doctor: " + this.doctor.getName() + ", Prescription: " + this.prescription;
		}
		catch (NullPointerException npe){
			return "Name: " + this.name + ", Age: " + this.age + ", Doctor: None" + ", Prescription: " + this.prescription;

		}
	}
	
	//toString method를 call하여 환자의 정보를 출력하는 method
	public void outputPatientInfo() {
		System.out.println(this.toString());
	}
}
