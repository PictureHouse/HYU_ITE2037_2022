package assignment2;

import java.time.LocalDate;

//입원환자 클래스이며 환자 클래스의 자식 클래스임 
public class InPatient extends Patient {
	private LocalDate inDate;
	private LocalDate outDate;
	
	/*
	 * 환자의 ID, 이름, 나이, 입원일, 퇴원(예정)일을 받는 생성자 
	 * super 키워드를 사용하여 ID, 이름, 나이를 설정하고 setInOutDate method를 사용하여 입원일과 퇴원(예정)일을 설정 
	 */
	public InPatient(int pid, String name, int age, LocalDate in, LocalDate out) {
		super(pid, name, age);
		this.setInOutDate(in, out);
	}
	
	//환자의 입원일과 퇴원(예정)일을 설정하는 method
	public void setInOutDate(LocalDate in, LocalDate out) {
		this.inDate = in;
		this.outDate = out;
	}
	
	//환자 클래스의 toString method를 override하여 입퇴원 정보를 포함한 정보를 리턴 
	public String toString() {
		return super.toString() + ", In date: " + this.inDate + ", Out date: " + this.outDate;
	}
}
