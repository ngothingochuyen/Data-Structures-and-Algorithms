package lab1;

import java.util.Scanner;

public class EiuPh010 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] N = new int[n];
		int[] S = new int[100001];
		int times = 0;
		int num = 0;
		for (int i = 0; i < N.length; i++) {
			N[i] = sc.nextInt();
			S[N[i]]++;// đếm vị trí thứ N[i] lên
		}
		for (int i = 0; i < S.length; i++) {
			if (times < S[i]) {
				times = S[i];
				num = i;
			}

		}
		System.out.println(num + " " + times);
	}
}