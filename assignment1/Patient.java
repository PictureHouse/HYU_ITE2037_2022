package assignment1;

public class Patient {
	private String pid;
	private String name;
	private int age;
	private String status;
	
	/*
	 환자 객체를 생성하는 기본생성자 
	 String variable들은 모두 unknown으로 초기화하고, int variable들은 0으로 초기화 
	*/
	public Patient() {
		this.pid = "unknown";
		this.name = "unknown";
		this.age = 0;
		this.status = "unknown";
	}
	
	/*
	 모든 parameter들을 받는 생성자 
	 각각의 instance variable들을 입력 받은 parameter들로 초기화 
	*/
	public Patient(String pid, String name, int age, String status) {
		this.pid = pid;
		this.name = name;
		this.age = age;
		this.status = status;
	}
	
	//pid 값을 리턴하는 getter method
	public String getPid() {
		return this.pid;
	}
	
	//name 값을 리턴하는 getter method
	public String getName() {
		return this.name;
	}
	
	//age 값을 리턴하는 getter method
	public int getAge() {
		return this.age;
	}
	
	//instance variable들의 값을 string으로 리턴하는 toString method
	public String toString() {
		return "pid='" + this.pid + "', name='" + this.name + "', age=" + this.age + ", status='" + this.status + "'";
	}
}
