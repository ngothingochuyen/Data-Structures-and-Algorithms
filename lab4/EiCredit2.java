package lab4;

import java.util.*;
import java.io.*;

public class EiCredit2 {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = rd.nextInt();
		for (int i = 1; i <= n; i++) {
			String name = rd.next();
			Student student = new Student(name);
			sb.append(student.getName() + " ");
			int numberOfCourse = rd.nextInt();
			for (int j = 1; j <= numberOfCourse; j++) {
				int grade = rd.nextInt();
				if (grade >= 50) {
					student.addGrade(grade);
					sb.append(Math.round(grade) + " ");
				}
			}
			if (student.totalGrade >= 0)
				sb.append(Math.round(student.getAverage()) + "\n");
			else
				sb.append(0 + "\n");
		}
		System.out.println(sb);

	}

	static class Student {
		String name;
		int totalCourse;
		int totalGrade;
		double average;

		public Student(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public double getAverage() {
			return average;
		}

		public void addGrade(double grade) {
			totalGrade += grade;
			totalCourse++;
			average = totalGrade / totalCourse;
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
