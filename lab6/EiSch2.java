package lab6;

import java.util.*;
import java.io.*;

public class EiSch2 {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
		int n = rd.nextInt();
		for (int i = 0; i < n; i++) {
			String name = rd.next();
			int subjects = rd.nextInt();
			Student st = new Student(name, subjects);
			for (int j = 0; j < subjects; j++) {
				int grade = rd.nextInt();
				st.sum += grade;
			}
			if (subjects > 0)
				st.average = st.sum / subjects;
			else
				st.average = 0;
			list.add(st);
		}
		list.sort((a, b) -> {
			if (Double.compare(a.average, b.average) != 0)
				return Double.compare(b.average, a.average);
			else
				return a.name.compareTo(b.name);
		});
		int maxA = n / 12;
		int maxB = n / 3;
		int maxC = n / 2;
		String rankA = "A";
		String rankB = "B";
		String rankC = "C";

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).average > list.get(maxA).average)
				sb.append(list.get(i).toString()).append(rankA).append("\n");
			else if (list.get(i).average > list.get(maxB).average)
				sb.append(list.get(i).toString()).append(rankB).append("\n");
			else if (list.get(i).average > list.get(maxC).average)
				sb.append(list.get(i).toString()).append(rankC).append("\n");
			else
				break;
		}
		System.out.println(sb);
	}

	static class Student {
		double sum;
		double average;
		String name;
		int numberOfSubjects;

		public Student(String name, int numberOfSubjects) {
			this.name = name;
			this.numberOfSubjects = numberOfSubjects;
		}

		public String getAverage() {
			return String.format("%.2f", average);
		}

		@Override
		public String toString() {
			return name + " " + getAverage() + " ";
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
