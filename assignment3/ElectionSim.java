package assignment3;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class ElectionSim {
	//ElectionSim class는 4개의 instance variable을 가짐 
	private String outputFile;
	private int population;
	private Candidate[] candidates;
	private Region[] regions;
	
	/*
	 * input file의 경로와 output file의 경로를 인자로 받는 생성자 
	 * input file을 가져올 때 FileNotFoundException이 발생하면 파일을 찾지 못했다는 메시지를 출력 후 프로그램 종료 
	 * input file을 성공적으로 가져오면 파일 속 내용들을 순서대로 읽어들여 instance variable들을 설정해줌 
	 * 인구의 경우, 인구수를 입력받아 population 값으로 설정 
	 * 후보의 경우, 입력 받은 후보 정보로 객체를 생성 후 candidates array에 추가 
	 * 지역의 경우, 입력 받은 지역 정보로 객체를 생성 후 regions array에 추가 
	 */
	public ElectionSim(String InputFile, String OutputFile) {
		Scanner scanner = null;
		String scan;
		
		this.outputFile = OutputFile;
		try {
			File input = new File(InputFile);
			scanner = new Scanner(new FileInputStream(input));
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(0);
		}

		scanner.next();
		this.population = scanner.nextInt();
		scanner.nextLine();

		scanner.next();
		int candidateNum = scanner.nextInt();
		this.candidates = new Candidate[candidateNum];
		scanner.nextLine();
		for (int i = 0; i < candidateNum; i++) {
			this.candidates[i] = new Candidate(scanner.next(), this.population);
			scanner.nextLine();
		}

		scanner.next();
		int regionNum = scanner.nextInt();
		this.regions = new Region[regionNum];
		scanner.nextLine();
		for (int i = 0; i < regionNum; i++) {
			String region_Name = scanner.next();
			int region_Num = scanner.nextInt();
			int region_Population = scanner.nextInt();
			this.regions[i] = new Region(region_Name, region_Num, region_Population, this.candidates);
			if (i != regionNum - 1)
				scanner.nextLine();
		}
	}
	
	/*
	 * candidates array를 득표수에 따라 내림차순으로 정렬 후 선거가 완료된 candidates array의 정보를 output file에 출력 
	 * output file을 가져올 때 FileNotFoundException이 발생하면 파일을 찾지 못했다는 메시지를 출력 후 프로그램 종료 
	 */
	public void saveData() {
		Arrays.sort(candidates, Collections.reverseOrder());
		
		File output = new File(this.outputFile);
		PrintWriter writer;
		try {
			writer = new PrintWriter(new FileOutputStream(output));
			for (int i = 0; i < candidates.length; i++) {
				writer.println(candidates[i].toString());
				writer.println();
				writer.println("=============================");
			}
			writer.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(0);
		}
		
	}
	
	/*
	 * 선거 시뮬레이션을 실행시키는 method
	 * 모든 지역의 start method를 call해서 선거를 시작하도록 하고 모든 thread가 끝날 때까지 기다림 
	 * 선거가 종료된 후에는 saveData method를 call해서 정보를 output file에 출력 
	 */
	public void runSimulation() {
		for (int i = 0; i < regions.length; i++) {
			this.regions[i].start();
			try {
				this.regions[i].join();
			} 
			catch (InterruptedException e) {
			}
		}
		this.saveData();
	}
}
