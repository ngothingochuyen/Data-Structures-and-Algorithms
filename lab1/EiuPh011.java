package lab1;

import java.util.Scanner;

public class EiuPh011 {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = sc.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[j] == array[i] && i!=j)
					array[j] = 0;
			}
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0)
				sb.append(array[i]).append(" ");
		}
		System.out.println(sb);
	}

}
