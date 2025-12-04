package lab3;

import java.util.*;
import java.io.*;

public class EiuTrans {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = rd.nextInt();
		int m = rd.nextInt();
		HashMap<String, String> message = new HashMap<>();
		for (int i = 1; i <= m; i++) {
			String a = rd.next();
			String b = rd.next();
			message.put(a, b);
		}
		for (int i = 0; i < n; i++) {
			String mess = rd.next();
			if (mess.length() > message.get(mess).length()) { // b<a=>b
				sb.append(message.get(mess)).append(" ");
			} else
				sb.append(mess).append(" ");
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
