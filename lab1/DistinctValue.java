package lab1;

import java.util.*;
import java.io.*;

public class DistinctValue {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int a = rd.nextInt();
		for (int j = 1; j <= a; j++) {
			int n = rd.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = rd.nextInt();
			Arrays.sort(arr);
			for (int i = 0; i < n; i++) {
				if (i == 0) {
					if (arr[i] != arr[i + 1])
						sb.append(arr[i] + " ");
				} else if (i == n - 1) {
					if (arr[i] != arr[i - 1])
						sb.append(arr[i]);
				} else if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1])
					sb.append(arr[i] + " ");
			}
			sb.append("\n");

		}
		System.out.println(sb);
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
