package lab2;

import java.util.*;
import java.io.*;
//Ei20213Q2
public class Gift1 {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = rd.nextInt();
		int m = rd.nextInt();
		int[] gift = new int[n];
		int[] wrap = new int[m];
		for (int i = 0; i < gift.length; i++) {
			gift[i] = rd.nextInt();
		}
		for (int i = 0; i < wrap.length; i++) {
			wrap[i] = rd.nextInt();
		}
		Arrays.sort(gift);
		Arrays.sort(wrap);

		int count = 0;
		int j = 0;
		int i = 0;
		while (i < gift.length && j < wrap.length) {
			if (wrap[j] < gift[i] * 2) { //nếu giấy quá nhỏ thì đổi giấy
				j++;
			} else if (wrap[j] > gift[i] * 3) { // nếu giấy quá lớn thì đổi quà
				i++;
			}else {
				count++;
				j++;
				i++;
			}
		}
		System.out.println(count);

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
