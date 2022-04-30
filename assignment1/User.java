package assignment1;

public class User {
	private String uid;
	private String password;
	
	/*
	 사용자 객체를 생성하는 기본생성자 
	 instance variable들을 모두 unknown으로 초기화
	 */
	public User() {
		this.uid = "unknown";
		this.password = "unknown";
	}
	
	/*
	 모든 parameter들을 받는 생성자 
	 각각의 instance variable들을 입력 받은 parameter들로 초기화 
	 */
	public User(String uid, String password) {
		this.uid = uid;
		this.password = password;
	}
	
	//uid 값을 리턴하는 getter method
	public String getUid() {
		return this.uid;
	}
	
	
	//password 값을 리턴하는 getter method 
	public String getPassword() {
		return this.password;
	}
	
	/*
	 equals method를 오버라이딩 
	 두 object의 instance variable들을 비교하여 값이 같은지 확인하는 equals method
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		User user = (User)obj;
		if (this.uid.equals(user.uid) && this.password.equals(user.password))
			return true;
		else
			return false;
	}
}
