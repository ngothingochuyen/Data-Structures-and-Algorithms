package lab5;

import java.util.*;
import java.io.*;

public class EiHProfit {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = rd.nextInt();
		int top = rd.nextInt();
		List<Product> products = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int identity = rd.nextInt();
			String name = rd.next();
			int price = rd.nextInt();
			int cost = rd.nextInt();
			int quantity = rd.nextInt();
			Product product = new Product(identity, name, price, cost, quantity);
			products.add(product);
		}
		products.sort((s1, s2) -> {
			int compare = Long.compare(s2.profit, s1.profit);
			if (compare == 0) {
				compare = Integer.compare(s1.identity, s2.identity);
			}
			return compare;
		});
		long topProfit = products.get(top - 1).profit;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).profit >= topProfit) {
				sb.append(products.get(i) + "\n");
			} else
				break;
		}
		System.out.println(sb);
	}

	static class Product {
		int identity;
		String name;
		long profit = 0;

		public Product(int identity, String name, int price, int cost, int quantity) {
			this.identity = identity;
			this.name = name;
			this.profit = (price - cost) * (long) quantity;
		}

		@Override
		public String toString() {
			return (identity + " " + name + " " + profit);
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
