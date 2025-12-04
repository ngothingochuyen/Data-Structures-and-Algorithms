package lab4;

import java.util.*;
import java.io.*;

public class EiuGrade {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = rd.nextInt();
		HashMap<Integer, Student> studentMap = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			int studentId = rd.nextInt();
			int courseId = rd.nextInt();
			double grade = rd.nextDouble();
			Student student = studentMap.getOrDefault(studentId, new Student(studentId));
			studentMap.put(studentId, student);
			student.addGrade(courseId, grade);
		}
		List<Student> students = new ArrayList<>(studentMap.values());
		students.sort((s1, s2) -> { // sắp xếp s1 và s2 trước khi so sánh
			int compare = Double.compare(s2.average, s1.average); // nếu s2>s1 thì lấy s2, nếu 2 cái bằng nhau thì
																	// compare = 0
			if (compare == 0) { // nếu 2 cái avg bằng nhau thì xét tiếp id
				compare = Integer.compare(s1.studentId, s2.studentId);
			}
			return compare;
		});
		for (Student student : students) {
			sb.append(student).append("\n");
		}
		System.out.println(sb.toString());
	}

	static class Student {
		int studentId;
		int totalCourse;
		double totalGrade;
		double average;

		public Student(int studentId) {
			this.studentId = studentId;
		}

		public void addGrade(int courseId, double grade) {
			totalGrade += grade;
			totalCourse++;
			average = totalGrade / totalCourse;
		}

		@Override
		public String toString() {
			return studentId + " " + average;
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
