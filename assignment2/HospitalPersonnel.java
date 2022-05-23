package assignment2;

//의료기관 종사자 클래스이며 간호사 클래스와 의사 클래스를 자식 클래스로 가짐 
public abstract class HospitalPersonnel {
	private int uid;
	private String password;
	private String name;
	protected HospitalManagementSystem hospitalsystem;
	
	//의료기관 종사자의 ID, 이름, 비밀번호, 병원관리시스템을 받는 생성자 
	public HospitalPersonnel(int id, String name, String password, HospitalManagementSystem hospitalsystem) {
		this.uid = id;
		this.name = name;
		this.password = password;
		this.hospitalsystem = hospitalsystem;
	}
	
	//의료기관 종사자의 ID를 리턴하는 getter 
	public int getUid() {
		return this.uid;
	}
	
	//의료기관 종사자의 이름을 리턴하는 getter 
	public String getName() {
		return this.name;
	}
	
	//의료기관 종사자의 비밀번호를 리턴하는 getter 
	public String getPassword() {
		return this.password;
	}
	
	//환자관리 추상method이며 자식 클래스인 간호사 클래스와 의사 클래스에서 정의됨 
	public abstract void managePatient();
}
