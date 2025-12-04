package lab6;

import java.util.*;
import java.io.*;

public class EiuMeDarray4 {
    static InputReader rd = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    static long[] tempArray;

    public static void main(String[] args) {
    	int T = rd.nextInt();
		while (T-- > 0) {
			int N = rd.nextInt();
			long A = rd.nextLong();
			long P = rd.nextLong();
			long k = rd.nextLong();
			long[] a = new long[N];
			a[0] = (A * A) % P;
			for (int i = 1; i < N; i++) {
				a[i] = (a[i - 1] * A) % P;
			}
			long result = quickSelect(a, 0, N - 1, (int)(k - 1));
			sb.append(result + "\n");
		}
		System.out.print(sb);
	}

	static long quickSelect(long[] a, int l, int r,int k) {
		while (true) {
			 if (l == r) return a[l];

	            int pivotIndex = l + (r - l) / 2;
	            pivotIndex = partition(a, l, r, pivotIndex);

	            if (k == pivotIndex)
	                return a[k];
	            else if (k < pivotIndex)
	                r = pivotIndex - 1;
	            else
	                l = pivotIndex + 1;
	        }
	    }

	static int partition(long[] a, int l, int r, int pivotIndex) {
		long pivotValue = a[pivotIndex];
        swap(a, pivotIndex, r);
        int store = l;

        for (int i = l; i < r; i++) {
            if (a[i] < pivotValue) {
                swap(a, store, i);
                store++;
            }
        }

        swap(a, store, r);
        return store;
    }

	static void swap(long[] a, int i, int j) {
		long tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
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
                } catch (IOException e) {}
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
