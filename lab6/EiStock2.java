package lab6;

import java.util.*;
import java.io.*;

public class EiStock2 {

	public static void main(String[] args) {
		int n = reader.nextInt();
		HashMap<Integer, Product> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String type = reader.next();
			int code = reader.nextInt();
			long qty = reader.nextLong();
			long price = reader.nextLong();
			int time = reader.nextInt();

			Product p = map.getOrDefault(code, new Product(code));
			if (type.equals("+")) {
				p.importProduct(qty, price, time);
			} else {
				p.exportProduct(qty);
			}
			map.put(code, p);
		}

		List<Product> list = new ArrayList<>(map.values());
		list.sort(Comparator.comparingInt(p -> p.code));

		for (Product p : list) {
			p.computeResult();
		}

		for (Product p : list) {
			if (p.totalQty > 0)
				sb.append(p).append("\n");
		}

		System.out.print(sb);
	}

	static class Batch {
		long qty;
		long price;
		int time;

		Batch(long q, long p, int t) {
			qty = q;
			price = p;
			time = t;
		}
	}

	static class Product {
		int code;
		long totalQty = 0;

		ArrayDeque<Batch> q = new ArrayDeque<>();

		long avgPrice = 0;
		int oldestTime = 0;

		Product(int code) {
			this.code = code;
		}

		void importProduct(long qty, long price, int time) {
			q.addLast(new Batch(qty, price, time));
			totalQty += qty;
		}

		void exportProduct(long qty) {
			if (totalQty < qty)
				return; // không đủ hàng → bỏ qua

			long remain = qty;

			while (remain > 0 && !q.isEmpty()) {
				Batch b = q.peekFirst();

				if (b.qty <= remain) {
					remain -= b.qty;
					q.pollFirst();
				} else {
					b.qty -= remain;
					remain = 0;
				}
			}

			totalQty -= qty;
		}

		void computeResult() {
			if (totalQty == 0) {
				avgPrice = 0;
				oldestTime = 0;
				return;
			}

			long totalValue = 0;

			for (Batch b : q) {
				if (b.qty > 0) {
					totalValue += b.qty * b.price;
				}
			}

			avgPrice = totalValue / totalQty; // floor
			oldestTime = q.peekFirst().time; // batch đầu tiên còn hàng
		}

		public String toString() {
			return code + " " + totalQty + " " + avgPrice + " " + oldestTime;
		}
	}

	static InputReader reader = new InputReader();
	static StringBuilder sb = new StringBuilder();

	static class InputReader {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}
}
