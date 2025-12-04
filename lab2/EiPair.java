package lab2;

import java.util.*;
import java.io.*;

public class EiPair {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		long n = rd.nextLong();
		while (n-- > 0) {
			long a = rd.nextLong();
			HashMap<Long, Integer> count = new HashMap<>();

			for (long i = 0; i < a; i++) {
				long price = rd.nextLong();
				count.put(price, count.getOrDefault(price, 0) + 1);
			}
			long ans = 0;
			for (long i : count.keySet()) {
				long e = count.get(i);
				long b = count.get(i) - 1;
				ans += e * b / 2;
			}
			System.out.println(ans);

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
