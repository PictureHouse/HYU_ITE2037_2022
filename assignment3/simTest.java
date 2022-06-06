package assignment3;

public class simTest {
	/*
	 * simTest class는 input file과 output file의 경로를 instance variable로 가짐 
	 * 현재 작성되어 있는 경로는 코드를 작성할 때 기준 input file과 output file의 경로 
	 * input file과 output file의 경로가 바뀌면 수정이 필요함 
	 */
	private static final String INPUTFILE = "/Users/choyune/eclipse-workspace/practices/src/assignment3/file/inputfile.txt";
	private static final String OUTPUTFILE = "/Users/choyune/eclipse-workspace/practices/src/assignment3/file/outputfile.txt";
	
	/*
	 * main method
	 * input file과 output file의 경로를 인자로 넣어 ElectionSim 객체를 생성한 후 시뮬레이션을 진행  
	 */
	public static void main(String[] args) {
		ElectionSim eSim = new ElectionSim(INPUTFILE, OUTPUTFILE);
		eSim.runSimulation();
	}
}
