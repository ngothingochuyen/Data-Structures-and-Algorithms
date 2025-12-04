package lab5;

import java.util.*;
import java.io.*;

public class EiTaskDis {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = rd.nextInt();
		int m = rd.nextInt();
		int[] task = new int[m];
		for (int i = 0; i < m; i++) {
			task[i] = rd.nextInt();
		}
		Arrays.sort(task);

		Queue<Worker> worker = new PriorityQueue<Worker>((p1, p2) -> {
			int compare = Long.compare(p1.workLoad, p2.workLoad);
			if (compare == 0) {
				compare = Long.compare(p1.index, p2.index);
			}
			return compare;
		});
		Worker[] workers = new Worker[n];
		for (int i = 0; i < n; i++) {
			workers[i] = new Worker(i + 1, 0);
			worker.add(workers[i]);
		}

		for (int i = task.length - 1; i >= 0; i--) {
			Worker min = worker.poll();
			min.workLoad += task[i];
			worker.add(min);
		}
		for (int i = 0; i < n; i++) {
			sb.append(workers[i] + " ");
		}
		System.out.println(sb);

	}

	static class Worker {
		int index;
		int workLoad;

		public Worker(int i, int workLoad) {
			index = i;
			this.workLoad = workLoad;
		}

		@Override
		public String toString() {
			return workLoad + "";
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
