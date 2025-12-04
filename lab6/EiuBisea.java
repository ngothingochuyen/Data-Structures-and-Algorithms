package lab6;

import java.util.*;
import java.io.*;

public class EiuBisea {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	static long[] tempArray;

	public static void main(String[] args) {
		int n = rd.nextInt();
		int m = rd.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = rd.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 0; i < m; i++) {
			int a = rd.nextInt();
			int ans = binarySearch(arr, a);
			sb.append(ans);
			if (i < m - 1) {
				sb.append(" ");
			}
		}
		System.out.println(sb);
	}

	public static int binarySearch(int[] arr, int n) {
		int left = 0;
		int right = arr.length;
		int ans = -1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == n) {
				ans = mid;
				right = mid - 1;
			} else if (arr[mid] < n) {
				left = mid + 1;
			} else
				right = mid - 1;
		}
		return ans;
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
