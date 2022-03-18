package lab03;

public class StaffManager {

	public static void main(String[] args) {
		Staff james = new Staff("James Wright", 29, "Accounting", 365, 15);		//Staff	추가 
		Staff peter = new Staff("Peter Coolidge", 32, "R&D", 1095, 7);
		Staff amy = new Staff("Amy Smith", 27);
		
		String jamesInfo = james.toString();		//직원들에 대한 정보를 모두 출력 
		String peterInfo = peter.toString();
		String amyInfo = amy.toString();
		System.out.println(jamesInfo);
		System.out.println(peterInfo);
		System.out.println(amyInfo);
		
		System.out.println("---");		//구분선 출력 
		
		System.out.println("Same Career?");
		Boolean careerCompare1 = peter.sameCareer(amy);		//peter와 amy의 커리어를 비교 
		if (careerCompare1 == true) { 		//비교한 결과 값에 따라 결과값을 출력 
			System.out.printf("%s and %s, Same.\n", peter.getName(), amy.getName());
		}
		else {
			System.out.printf("%s and %s, Not exactly same.\n", peter.getName(), amy.getName());
		}
		
		System.out.println("...A Few years later...");
		amy.setCareer("R&D", 1095);
		Boolean careerCompare2 = peter.sameCareer(amy);		//peter와 amy의 커리어를 비교
		if (careerCompare2 == true) { 		//비교한 결과 값에 따라 결과값을 출력 
			System.out.printf("%s and %s, Same.\n", peter.getName(), amy.getName());
		}
		else {
			System.out.printf("%s and %s, Not exactly same.\n", peter.getName(), amy.getName());
		}
		
		System.out.println("---");		//구분선 출력 
		
		james.vacation(10);		//james와 amy가 휴가를 사용, amy는 두번째로 휴가를 사용했을 때 휴가 초과 
		amy.vacation(20);
		amy.vacation(1);
	}

}
