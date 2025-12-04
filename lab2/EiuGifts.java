package lab2;

import java.util.*;
import java.io.*;

public class EiuGifts {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = rd.nextInt();
		long money = rd.nextLong();
		int[] price = new int[n];
		for (int i = 0; i < price.length; i++) {
			price[i] = rd.nextInt();
		}

		Arrays.sort(price);

		int i = 0;
		int j = price.length - 1;
		long minDiff = Long.MAX_VALUE;
		long maxSum = 0;
		long sum = 0;
		while (i < j) {
			sum = price[i] + price[j];
			if (sum <= money) {
				if (sum > maxSum) {
					maxSum = sum;
					minDiff = price[j] - price[i];
				} else if (sum == maxSum) {
					if (price[j] - price[i] < minDiff) {
						minDiff = price[j] - price[i];
					}
				}
				i++;
			} else {
				j--;
			}
		}
		if (maxSum == 0) {
			maxSum = -1;
			minDiff = -1;
		}
		System.out.println(maxSum + " " + minDiff);

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
