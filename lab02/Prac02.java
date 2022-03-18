package lab02;

import java.util.Scanner;

public class Prac02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		String[] arr = input.split(" ");
		
		String name_input_1 = arr[0].toUpperCase();
		char a = name_input_1.charAt(0);
		
		String name_input_2 = arr[1].toUpperCase();
		char b = name_input_2.charAt(0);
		
		String name_input_3 = arr[2];
		String tmp = name_input_3.substring(0, 1);
		String name_head = tmp.toUpperCase();
		String name_tail = name_input_3.substring(1);
		String last_name = name_head + name_tail;
		String final_last_name = last_name.replace(",", "");
		
		String f_name = arr[3];
		String ftmp1 = f_name.substring(0, 1);
		String file_head = ftmp1.toUpperCase();
		String file_body = f_name.substring(1, f_name.length() - 4);
		String ftmp2 = f_name.substring(f_name.length() - 4);
		String file_tail = ftmp2.replace(ftmp2, ".pdf");
		String file_name = file_head + file_body + file_tail;
		
		System.out.printf("Name Length(Korean) : %d\n", arr.length - 1);
		System.out.println(a + "." + b + "." + final_last_name + " submitted " + file_name);
	}

}