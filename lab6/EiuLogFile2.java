package lab6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EiuLogFile2 {
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        var sb = new StringBuilder();
        int n = rd.nextInt();
        long[] files = new long[n];
        int m = rd.nextInt();
        long[] events = new long[m];
        for (int i = 0; i < n; i++) {
            files[i] = rd.nextLong();
        }
        Arrays.sort(files);
        for (int i = 0; i < m; i++) {
            events[i] = rd.nextLong();
        }
        for (int i = 0; i < m; i++) {
            var target = events[i];
            var k = Arrays.binarySearch(files, target);
            if (k < 0) {
                k = k * (-1);
                k = k - 1;
            }
            if (k < n) {
                if (files[k] >= target) {
                    sb.append(files[k] + " ");
                }
            } else {
                sb.append("-1 ");
            }
        }
        System.out.println(sb);
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