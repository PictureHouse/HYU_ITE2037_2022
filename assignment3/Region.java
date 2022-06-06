package assignment3;

import java.util.Random;

//Region class는 Thread class를 상속받음 
public class Region extends Thread {
	//Region class는 4개의 instance variable을 가짐 
	private String name;
	private int regionNum;
	private int population;
	private Candidate[] candidates;
	
	//모든 인자를 받아서 각각의 instance variable들을 설정하고 객체를 생성하는 생성자 
	public Region(String name, int regionNum, int population, Candidate[] candidates) {
		this.name = name;
		this.regionNum = regionNum;
		this.population = population;
		this.candidates = new Candidate[candidates.length];
		for (int i = 0; i < candidates.length; i ++)
			this.candidates[i] = candidates[i];
	}
	
	/*
	 * 0과 후보 수 사이의 랜덤 숫자를 생성해서 그 숫자의 인덱스에 해당하는 후보의 득표를 증가시키는 method 
	 * 해당 후보의 addVote method를 call해서 득표를 증가시킴 
	 */
	public void generateVotes() {
		Random random = new Random();
		int randomNum = random.nextInt(this.candidates.length);
		this.candidates[randomNum].addVote(this.regionNum);
	}

	//generateVotes method를 전체 population만큼 실행되게 해주는 run method 
	public void run() {
		for (int i = 0; i < this.population; i++)
			this.generateVotes();
	}
}
