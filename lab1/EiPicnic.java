package lab1;

import java.util.*;
import java.io.*;

public class EiPicnic {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = rd.nextInt();
		int[] arr = new int[n];
		int[] group = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt();
			group[arr[i]]++;
		}
		int numOfCar = 0;
		if (group[4] > 0) {
			numOfCar += group[4];
			group[4] = 0;
		}

		if (group[3] > 0) {
			numOfCar += group[3];
			if(group[1]<group[3])
				group[1]=0;
			else
				group[1]-=group[3];
			group[3] = 0;
		}
		if (group[2] > 0) {
			numOfCar += group[2] / 2;
			group[2] -= (group[2] / 2) * 2;
			if (group[2] > 0) {
				numOfCar += group[2];
				group[1] -= group[2] * 2;
				group[2] = 0;
			}
		}
		if (group[1] > 4) {
			numOfCar += group[1] / 4;
			group[1] %= 4;
		}
		if (group[1] > 0) {
			numOfCar++;
		}

		System.out.println(numOfCar);
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
