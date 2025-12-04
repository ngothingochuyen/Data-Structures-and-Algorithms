package lab1;

import java.util.*;
import java.io.*;

public class EiPages {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = rd.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt();
		}
		Arrays.sort(arr);
		int count = 0;
		int first = arr[0];
		int last = arr[0];
		if(arr.length==1) {
			sb.append(first);
		}
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - last == 1) {
				last = arr[i];
				count++;
				if (i == arr.length - 1) {
					if (count == 1) {
						sb.append(first + " " + last + " ");
					} else if (count > 1) {
						sb.append(first + "-" + last + " ");
					}
					break;
				}
			}
			if (arr[i] - last > 1 || i == arr.length - 1) {
				if (count == 0) {
					sb.append(last + " ");
				} else if (count == 1) {
					sb.append(first + " " + last + " ");
				} else if (count > 1) {
					sb.append(first + "-" + last + " ");
				}
				first = arr[i];
				last = arr[i];
				count = 0;
				if (i == arr.length - 1) {
					sb.append(last + " ");
				}
			}
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
