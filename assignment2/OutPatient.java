package assignment2;

import java.time.LocalDate;

//외래환자 클래스이며 환자 클래스의 자식 클래스임 
public class OutPatient extends Patient{
	LocalDate appointment;
	
	//환자의 ID, 이름, 나이, 진료 예약 일시를 받는 생성자 
	public OutPatient(int pid, String name, int age, LocalDate aptment) {
		super(pid, name, age);
		this.setAppointment(aptment);
	}
	
	//환자 클래스의 toString method를 override하여 진료 예약 일시를 포함하여 리턴 
	public String toString() {
		return super.toString() + ", Appointment: " + this.appointment;
	}
	
	//환자의 진료 예약일을 설정하는 method 
	public void setAppointment(LocalDate date) {
		this.appointment = date;
	}
}
