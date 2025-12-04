package lab6;

import java.util.*;
import java.io.*;

public class EiuMergeSort {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	static long[] tempArray;

	public static void main(String[] args) {
		int n = rd.nextInt();
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = rd.nextInt();
		}
		mergeSort(arr);
		for (long x : arr) {
			sb.append(x).append("\n");
		}
		System.out.print(sb);

	}

	public static void mergeSort(long[] a) {
		tempArray = new long[a.length];
		mergeSort(a, 0, a.length);
	}

	private static void mergeSort(long[] a, int from, int to) {
		if (to - from <= 1)
			return;
		int middle = (from + to) / 2;
		mergeSort(a, from, middle);
		mergeSort(a, middle, to);
		merge(a, from, middle, to);
	}

	private static void merge(long[] a, int from, int middle, int to) {
		int i = from, j = middle, k = from;
		while (i < middle || j < to) {
			if ((i < middle && j < to && a[i] <= a[j]) || j == to) {
				tempArray[k++] = a[i++];

			} else {
				tempArray[k++] = a[j++];
			}
		}
		for (int t = from; t < to; t++) {
			a[t] = tempArray[t];
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
