package lab1;

import java.util.*;
import java.io.*;

public class EiuPh014 {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		while (true) {
			int n = rd.nextInt();
			if (n == 0)
				break;
			boolean flag = true;
			int[] arr = input(n);
			int count = 0;
			while (true) {
				flag = isEquals(arr);
				int x = arr[0];
				for (int i = 0; i < arr.length - 1; i++) {
					arr[i] = Math.abs(arr[i] - arr[i + 1]);
				}
				arr[n - 1] = Math.abs(arr[n - 1] - x);
				if (flag) {
					System.out.println(count);
					break;
				}
				count++;
				if (count > 1000) {
					System.out.println(-1);
					break;
				}
			}
		}
	}

	public static boolean isEquals(int[] arr) {
		boolean flag = true;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i + 1])
				flag = false;
		}
		return flag;
	}

	public static int[] input(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt();
		}
		return arr;
	}

	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
