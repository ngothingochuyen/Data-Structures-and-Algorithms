package lab2;

import java.util.*;
import java.io.*;

public class EiuPrEiu {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = rd.nextInt();
		for (int i = 0; i < n + 1; i++) {
			if (i == 0) {
				sb.append(printFirstRow(n)).append("\n");
			} else if (i == (n / 2)) {
				sb.append(printMiddleRow(n)).append("\n");
			} else if (i == n) {
				sb.append(printLastRow(n));
			} else {
				sb.append(printNormalRow(n)).append("\n");
			}
		}
		System.out.println(sb);
	}

	public static String printNormalRow(int n) {
		String print = "";
		int temp = n / 2 + 2;
		for (int i = 0; i < n + 6; i++) {
			if (i == 0 || i == temp || i == temp + 2 || i == n + 5) {
				print += "|";
			} else
				print += " ";
		}
		return print;
	}

	public static String printFirstRow(int n) {
		String print = "";
		int temp = n / 2;
		for (int i = 0; i < n + 6; i++) {
			if (1 <= i && i <= temp) {
				print += "_";
			} else
				print += " ";
		}
		return print;

	}

	public static String printMiddleRow(int n) {
		char[] chars = printNormalRow(n).toCharArray();
		int temp = n / 2;
		String print = "";
		for (int i = 0; i < n + 6; i++) {
			if (1 <= i && i <= temp) {
				chars[i] = '_';
			}
			print += chars[i];
		}
		return print;
	}

	public static String printLastRow(int n) {
		char[] chars = printNormalRow(n).toCharArray();
		int temp = (int) n / 2;
		String print = "";
		for (int i = 0; i < chars.length; i++) {
			if (1 <= i && i <= temp || temp + 4 < i && i <= chars.length - 2) {
				chars[i] = '_';
			}
			print += chars[i];
		}
		return print;
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
