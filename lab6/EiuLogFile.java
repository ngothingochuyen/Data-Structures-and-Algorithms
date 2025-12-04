package lab6;

import java.util.*;
import java.io.*;

public class EiuLogFile {
	public static void main(String[] args) {
		int n = reader.nextInt();
		double[] arr = new double[n];
		long count = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = reader.nextLong();
		}
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			long k = ~Arrays.binarySearch(arr, arr[i] + 600000.5);
			count += k - i - 1;
		}
		System.out.println(count);
	}

	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

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
