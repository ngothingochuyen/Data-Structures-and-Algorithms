package lab5;
import java.util.*;
import java.io.*;

public class EiSchsh {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		//95 điểmmmmmmmmmmmmmmmmmmmmmmmmm
		int n = rd.nextInt();
		int k = rd.nextInt();
		List<Student> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			int id = rd.nextInt();
			String name = rd.next();
			int numberOfCourse = rd.nextInt();
			Student student = new Student(id, name);
			for (int j = 1; j <= numberOfCourse; j++) {
				double grade = rd.nextDouble();
				if (grade >= 50) {
					student.addGrade(grade);
				}
			}
			list.add(student);
		}
		list.sort((s1, s2) -> {
			int compare = Double.compare(s2.average, s1.average);
			if (compare == 0) {
				compare = Integer.compare(s1.id, s2.id);
			}
			return compare;
		});
		int currentRank = 1;
		int limit = Math.min(k, list.size());
		for (int i = 0; i < list.size(); i++) {
			if (i > 0 && list.get(i).average < list.get(i - 1).average) {
				currentRank = i + 1;
			}
			list.get(i).rank = currentRank;
			if(currentRank<=limit) {
				sb.append(list.get(i) + "\n");
			}
		}

		System.out.println(sb);

	}

	static class Student {
		int rank;
		int id;
		String name;
		double totalCourse;
		double totalGrade;
		double average;

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
			average = totalGrade / totalCourse;
		}

		@Override
		public String toString() {
			return String.format(rank + " " + id + " " + name + " " + Math.round(average));
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
