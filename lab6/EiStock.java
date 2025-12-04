package lab6;

import java.util.*;
import java.io.*;

public class EiStock {
	public static void main(String[] args) {
		int n = reader.nextInt();
		HashMap<Integer, Product> map_product = new HashMap<>();
		for (int i = 0; i < n; i++) {

			String flag = reader.next();
			int code = reader.nextInt();
			long quanity = reader.nextInt();
			long price = reader.nextInt();
			Product product;
			if (map_product.get(code) == null) {
				product = new Product(code);
			} else {
				product = map_product.get(code);
			}

			if (flag.equals("+")) {
				product.totalImport(quanity, price);
			} else {
				product.totalExport(quanity, price);
			}
			map_product.put(code, product);

		}
		List<Product> list_code = new ArrayList<>(map_product.values());
		list_code.sort((p1, p2) -> Integer.compare(p1.code, p2.code));

		for (Product ele : list_code) {

			if (ele.amount_import_goods == 0) {
				continue;
			}
			str.append(ele.code).append(" ").append(ele.value_import_goods).append(" ").append(ele.value_export_goods)
					.append("\n");
		}
		System.out.println(str);
	}

	static class Product {

		public int code;
		public long quanity;
		public long amount_import_goods;
		public long amount_product;
		public long amount_export_goods;
		public long price_import_goods;
		public long price_export_goods;
		public long value_import_goods;
		public long value_export_goods;

		public Product(int code) {
			this.code = code;
			this.amount_import_goods = 0;
			this.amount_export_goods = 0;
			this.value_import_goods = 0;
			this.value_export_goods = 0;

		}

		public long totalImport(long quanity, long price) {
			amount_import_goods += quanity;
			amount_product += quanity;
			value_import_goods += quanity * price;
			return value_import_goods;
		}

		public long totalExport(long quanity, long price) {
			amount_export_goods += quanity;
			price_export_goods = price;
			if (amount_export_goods > amount_product) {
				amount_export_goods = 0;
			} else {
				value_export_goods += amount_export_goods * price_export_goods;
				amount_product -= amount_export_goods;
				amount_export_goods = 0;

			}

			return value_export_goods;
		}

	}

	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

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
