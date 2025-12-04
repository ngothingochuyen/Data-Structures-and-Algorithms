package lab3;

import java.util.*;	
import java.io.*;

public class EiDupBod {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = rd.nextInt();
		HashMap<String, Birthday> map = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			int day = rd.nextInt();
			int month = rd.nextInt();
			int year = rd.nextInt();
			String date = (((day < 10) ? "0" + day : day) + "/" + ((month < 10) ? "0" + month : month) + "/" + year);
			Birthday birthday = map.get(date);
			if (birthday == null) {
				birthday = new Birthday(day, month, year, date);
				map.put(date, birthday);
			}
			birthday.count++;
		}
		List<Birthday> list = new ArrayList<>(map.values());
		list.sort((a, b) -> {
			int temp = Integer.compare(a.year, b.year);
			if (temp == 0) {
				temp = Integer.compare(a.month, b.month);
			}
			if (temp == 0) {
				temp = Integer.compare(a.day, b.day);
			}
			return temp;
		});
		for (Birthday birthday : list) {
			System.out.println(birthday.toString());
		}

	}

	static class Birthday {
		int year;
		int month;
		int day;
		String date;
		int count;

		public Birthday(int day, int month, int year, String date) {
			this.date = date;
			this.day = day;
			this.month = month;
			this.year = year;
		}

		@Override
		public String toString() {
			return date + " " + count;
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
