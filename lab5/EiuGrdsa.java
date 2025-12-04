package lab5;

import java.io.*;
import java.util.*;

public class EiuGrdsa {
	static InputReader rd = new InputReader();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = rd.nextInt();
		int p = rd.nextInt();
		int m = rd.nextInt();
		int[] students = new int[n];
		for (int i = 0; i < n; i++)
			students[i] = rd.nextInt();
		HashMap<Integer, Integer> idxS = new HashMap<>();
		for (int i = 0; i < n; i++)
			idxS.put(students[i], i);
		int[] problems = new int[p];
		for (int i = 0; i < p; i++)
			problems[i] = rd.nextInt();
		HashMap<Integer, Integer> idxP = new HashMap<>();
		for (int i = 0; i < p; i++)
			idxP.put(problems[i], i);
		int[][] best = new int[n][p];
		for (int i = 0; i < m; i++) {
			int sid = rd.nextInt();
			int pid = rd.nextInt();
			int score = rd.nextInt();
			Integer si = idxS.get(sid);
			Integer pi = idxP.get(pid);
			if (si == null || pi == null)
				continue;
			if (score > best[si][pi])
				best[si][pi] = score;
		}
		Arrays.sort(students);
		for (int sid : students) {
			int si = idxS.get(sid);
			int sum = 0;
			for (int j = 0; j < p; j++)
				sum += best[si][j];
			int avg = sum / p;
			sb.append(sid).append(" ").append(avg).append("\n");
		}
		System.out.print(sb.toString());
	}
	static class InputReader {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					String line = br.readLine();
					if (line == null)
						return "";
					st = new StringTokenizer(line);
				} catch (IOException e) {
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
