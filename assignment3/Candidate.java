package assignment3;

//Candidate class는 Comparable interface를 implement함 
public class Candidate implements Comparable {
	//Candidate class는 3개의 instance variable을 가짐 
	private String name;
	private int numVotes;
	private Vote[] votes;
	
	/*
	 * 이름과 최대 투표수를 인자로 받는 생성자 
	 * 후보 이름은 전달받은 이름으로 설정하고 득표수는 0으로 초기화한 후, 전달받은 최대 투표수 크기만큼 votes array 생성 
	 */
	public Candidate(String name, int maxVotes) {
		this.name = name;
		this.numVotes = 0;
		this.votes = new Vote[maxVotes];
	}
	
	//후보 정보를 문자열로 리턴하는 toString method
	public String toString() {
		return "----------Candidate----------\nName: " + this.name + "\nVotes: " + this.numVotes;
	}
	
	//Vote inner class
	private class Vote {
		//Vote class는 1개의 instance variable을 가짐 
		private int regionNum;
		
		//지역 번호를 인자로 받는 생성자 
		public Vote(int regionNum) {
			this.regionNum = regionNum;
		}
	}
	
	/*
	 * 지역번호를 인자로 받아서 해당 지역에 vote 객체를 생성하고 votes array에 추가하는 method
	 * vote 객체를 추가한다는 것은 후보가 한표를 득표했다는 것을 의미
	 * 과정을 모두 마친 후에는 notifyAll method를 실행 
	 */
	public synchronized void addVote(int regionNum) {
		Vote vote = new Vote(regionNum);
		votes[numVotes++] = vote;
		notifyAll();
	}

	//득표수를 리턴하는 getter
	public int getNumVotes() {
		return this.numVotes;
	}
	
	/*
	 * Comparable interface의 compareTo method를 override 
	 * 후보의 득표수에 따라 크기를 비교해서 1, -1, 0을 리턴 
	 */
	public int compareTo(Object o) {
		if (this.numVotes > ((Candidate) o).getNumVotes())
			return 1;
		else if (this.numVotes < ((Candidate)o).getNumVotes())
			return -1;
		else
			return 0;
	}
}
