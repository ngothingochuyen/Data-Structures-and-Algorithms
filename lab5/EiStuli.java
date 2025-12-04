package lab5;

import java.util.*;
import java.io.*;

public class EiStuli {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = rd.nextInt();
		int k = rd.nextInt();
		List<Student> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			long id = rd.nextLong();
			String name = rd.next();
			int numberOfCourse = rd.nextInt();
			Student student = new Student(id, name);
			for (int j = 1; j <= numberOfCourse; j++) {
				int grade = rd.nextInt();
				if (grade >= 50) {
					student.addGrade(grade);
				}
			}
			list.add(student);
		}
		list.sort((s1, s2) -> Double.compare(s2.average, s1.average));
		if (k >= n) {
			for (Student student : list) {
				sb.append(student).append("\n");
			}
		} else {
			double standard = list.get(k).average;
			for (Student student : list) {
				if (student.average > standard) {
					sb.append(student).append("\n");
				}
			}
		}
		System.out.println(sb);

	}

	static class Student {
		long id;
		String name;
		double totalCourse;
		double totalGrade;
		double average;
		int credit;

		public Student(long id, String name) {
			this.id = id;
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
			credit += 4;
		}

		@Override
		public String toString() {
			return String.format(id + " " + name + " " + Math.round(average) + " " + credit);
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
