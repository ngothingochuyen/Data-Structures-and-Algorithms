package lab6;

import java.util.*;
import java.io.*;

public class EiCardsys {
    public static void main(String[] args) {
        int n = rd.nextInt();
        HashMap<String, Customer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String id = rd.next();
            long money = rd.nextLong();
            Customer customer = map.getOrDefault(id, new Customer(id));
            customer.calculateDiscount(money);
            map.put(id, customer);
        }
        
        double totalDiscount = 0;
        for (Customer customer : map.values()) {
            totalDiscount += customer.discount;
        }

        if (totalDiscount == (long) totalDiscount) {
            System.out.printf("%d%n", (long) totalDiscount);
        } else if ((totalDiscount * 10) == Math.floor(totalDiscount * 10)) {
            System.out.printf("%.1f%n", totalDiscount);
        } else {
            System.out.printf("%.2f%n", totalDiscount);
        }
    }

    public static class Customer {
        public String id;
        public long total = 0;
        public double discount = 0;

        public Customer(String id) {
            this.id = id;
        }

        public void calculateDiscount(long money) {
            double discountAmount = 0;
            if (total >= 200000000) {
                discountAmount = money * 7.0 / 100.0;
            } else if (total >= 50000000) {
                discountAmount = money * 5.0 / 100.0;
            } else if (total >= 20000000) {
                discountAmount = money * 3.0 / 100.0;
            } else if (total >= 1000000) {
                discountAmount = money * 2.0 / 100.0;
            }
            discount += discountAmount;
            total += money;
        }
    }

    static InputReader rd = new InputReader(System.in);

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
