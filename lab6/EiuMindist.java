package lab6;

import java.io.*;
import java.util.*;

public class EiuMindist {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int N = rd.nextInt();
		int K = rd.nextInt();
		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = rd.nextInt();
		}

		Arrays.sort(arr);

		long low = 0;
		long high = arr[N - 1] - arr[0];
		long ans = 0;

		while (low <= high) {
			long mid = (low + high) / 2;
			if (canSelect(arr, K, mid)) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println(ans);
	}

	static boolean canSelect(long[] arr, int K, long dist) {
		int count = 1;
		long last = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - last >= dist) {
				count++;
				last = arr[i];
				if (count >= K)
					return true;
			}
		}
		return false;
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
