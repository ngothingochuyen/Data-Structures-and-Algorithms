package lab4;

import java.util.*;
import java.io.*;
import java.text.*;
public class EiGradu {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	static DecimalFormat df = new DecimalFormat();
	public static void main(String[] args) {
		int n = rd.nextInt();
		int credit = rd.nextInt();
		HashMap<Integer, Student> map = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			int id = rd.nextInt();
			String name = rd.next();
			int numberOfCourse = rd.nextInt();
			Student student = map.getOrDefault(name, new Student(id, name));
			for (int j = 1; j <= numberOfCourse; j++) {
				int grade = rd.nextInt();
				if (grade >= 50) {
					map.put(id, student);
					student.addGrade(grade);
				}
			}
		}
		List<Student> list = new ArrayList<>((map.values()));
		list.sort((s1, s2) -> {
			int compare = Double.compare(s2.average, s1.average);
			if (compare == 0) {
				compare = Integer.compare(s1.id, s2.id);
			}
			return compare;
		});
		for (Student student : list) {
			if (student.credit >= credit)
				sb.append(student).append("\n");
		}
		System.out.println(sb);

	}

	static class Student {
		int id;
		String name;
		int totalCourse;
		int totalGrade;
		int average;
		int credit;

		public Student(int id, String name) {
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
			average =totalGrade / totalCourse;
			credit += 4;
		}

		@Override
		public String toString() {
			return String.format(id + " " + name + " " + average);
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
