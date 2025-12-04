package lab4;

import java.util.*;
import java.io.*;

public class EiuSls {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = rd.nextInt();
		HashMap<Integer, Student> studentMap = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			String name = rd.next();
			int numberOfCourse = rd.nextInt();
			for (int j = 1; j <= numberOfCourse; j++) {
				double grade = rd.nextDouble();
				Student student = studentMap.getOrDefault(i, new Student(name, i));
				studentMap.put(i, student);
				student.addGrade(numberOfCourse, grade);
			}
		}
		List<Student> students = new ArrayList<>(studentMap.values());
		students.sort((s1, s2) -> {
			int compare = Double.compare(s2.average, s1.average);
			if (compare == 0) {
				compare = Integer.compare(s1.stt, s2.stt);
			}
			return compare;
		});
		int count = 2;
		for (Student student : students) {
			while (count-- > 0) {
				sb.append(student).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());

	}

	static class Student {
		String name;
		int stt;
		int totalCourse;
		double totalGrade;
		double average;

		public Student(String name, int stt) {
			this.name = name;
			this.stt = stt;
		}

		public void addGrade(int courseId, double grade) {
			totalGrade += grade;
			totalCourse++;
			average = totalGrade / totalCourse;
		}

		@Override
		public String toString() {
			return name;
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
