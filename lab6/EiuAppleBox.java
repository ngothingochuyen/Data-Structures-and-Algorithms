package lab6;

import java.util.*;
import java.io.*;

public class EiuAppleBox {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	static long[] temp;
	static long inversion;

	public static void main(String[] args) {
		int T = rd.nextInt();

		while (T-- > 0) {

			int N = rd.nextInt();
			long A = rd.nextLong();
			long P = rd.nextLong();

			long[] arr = new long[N];

			arr[0] = (A * 1L * A) % P;
			for (int i = 1; i < N; i++) {
				arr[i] = (arr[i - 1] * A) % P;
			}

			inversion = 0;
			temp = new long[N];
			mergeSort(arr, 0, N);

			sb.append(inversion).append('\n');
		}

		System.out.print(sb);
	}

	public static void mergeSort(long[] a) {
		temp = new long[a.length];
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
				temp[k++] = a[i++];

			} else {
				temp[k++] = a[j++];

				inversion += middle - i;
			}
		}
		for (int t = from; t < to; t++) {
			a[t] = temp[t];
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
