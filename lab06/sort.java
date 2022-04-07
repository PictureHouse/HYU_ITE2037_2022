package lab06;

public class Sort {
	public static void main(String[] args) {
		int[] arr1 = {7, 4, 5, 1, 3};		//배열 선언 및 초기화 
		int[] arr2 = {9, 2, 2, 5, 4, 3, 1, 6, 7, 3, 8, 0, 3};
		
		printArr(arr1);						//정렬하기 전 배열 출력 
		bubbleSort(arr1, arr1.length);		//bubble sort
		printArr(arr1);						//정렬을 마친 배열 출력 
		
		System.out.printf("\n");
		
		printArr(arr2);						//정렬하기 전 배열 출력 
		bubbleSort(arr2, arr2.length);		//bubble sort
		System.out.println("simple bubble sort");
		printArr(arr2);						//정렬을 마친 배열 출력 
	}
	
	public static void bubbleSort(int arr[], int n) {	//배열의 요소들을 bubble sort하는 method
		int tmp;
		for (int i = 0; i < n; i++) {				//배열의 요소들을 순차적으로 순환 
			for (int j = 0; j < n - 1; j++) {
				if (arr[j] > arr[j + 1]) {			//i번째 요소가 i+1번째 요소보다 크다면 두 요소를 교환 
					tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	
	public static void printArr(int arr[]) {		//배열 프린트 method
		for (int i = 0; i < arr.length; i++) {		//for 루프를 돌면서 배열의 요소들을 순차적으로 출력 
			System.out.printf(arr[i] + " ");
		}
		System.out.printf("\n");
	}	
}