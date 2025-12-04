package lab2;

import java.util.*;
import java.io.*;

public class Ei20213Q2 {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
//		int n = rd.nextInt();
//		int[] arr = new int[n];
//		int[] count = new int[100000];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = rd.nextInt();
//			count[arr[i]]++;
//		}
//		for (int i = 0; i < count.length; i++) {
//			if (count[i] != 0)
//				System.out.println(i + " " + count[i]);
//		}
		int n = rd.nextInt();
		HashMap<Integer, Integer> count = new HashMap<>();

		for (long i = 0; i < n; i++) {
			int value = rd.nextInt();
			count.put(value, count.getOrDefault(value, 0) + 1);
		}
		List<Integer> value = new ArrayList<>(count.keySet());
		Collections.sort(value);
		for (int i = 0; i < value.size(); i++) {
			System.out.println(value.get(i) + " " + count.get(value.get(i)));
		}

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
