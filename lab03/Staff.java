package lab03;

public class Staff {
	private String name; // Staff 클래스의 Instance variable
	private int age;
	private String department;
	private int workDays;
	private int vacationDays;

	public Staff(String name, int age) { // name과 age만을 set하는 생성자
		this.name = name;
		this.age = age;
		this.department = "None";
		this.workDays = 0;
		this.vacationDays = 20;
	}

	public Staff(String name, int age, String department, int workDays, int vacationDays) { // 모든 변수를 set하는 생성자
		this.name = name;
		this.age = age;
		this.department = department;
		this.workDays = workDays;
		this.vacationDays = vacationDays;
	}

	public String getName() { // 이름을 반환하는 getter method
		return name;
	}

	public void setCareer(String department, int workDays) { // Department, workDays를 변경하는 setter method
		this.department = department;
		this.workDays = workDays;
	}

	public boolean sameCareer(Staff staff) { // 동일한 커리어 여부를 반환하는 method
		if (this.department.equals(staff.department) && this.workDays == staff.workDays)
			return true;
		else
			return false;
	}

	public String toString() { // 직원의 정보를 반환하는 method
		return "Name: " + this.name + ", Age:" + this.age + ", Department: " + this.department + ", workDays: "
				+ this.workDays + ", vacationDays: " + this.vacationDays;
	}

	public void vacation(int vacation) { // Staff가 휴가를 내고 싶을 때 사용하는 method
		if (vacation > this.vacationDays)
			System.out.printf("%s, 남은 휴가 일 수 부족.\n", this.name);
		else {
			this.vacationDays = this.vacationDays - vacation;
			System.out.printf("%s, 휴가 %d 사용. 남은 휴가 일 수: %d\n", this.name, vacation, this.vacationDays);
		}
	}
}
