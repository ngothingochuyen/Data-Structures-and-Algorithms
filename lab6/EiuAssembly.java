package lab6;

import java.io.*;
import java.util.*;

public class EiuAssembly {

    static FastScanner fs = new FastScanner(System.in);

    public static void main(String[] args) {
        int T = fs.nextInt();
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = fs.nextInt();
            long budget = fs.nextLong();

            long[] P = new long[n];
            long[] M = new long[n];

            long maxP = 0;
            long minM = Long.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                P[i] = fs.nextLong();
                M[i] = fs.nextLong();
                maxP = Math.max(maxP, P[i]);
                minM = Math.min(minM, M[i]);
            }

            // Binary search for maximum K
            long lo = 0, hi = maxP + budget / minM + 5;
            long ans = 0;

            while (lo <= hi) {
                long mid = (lo + hi) >> 1;
                if (can(mid, P, M, budget)) {
                    ans = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }

    static boolean can(long K, long[] P, long[] M, long budget) {
        long cost = 0;
        int n = P.length;

        for (int i = 0; i < n; i++) {
            if (P[i] < K) {
                long need = K - P[i];

                // avoid overflow: if need * M[i] > budget -> immediate fail
                if (need > budget / M[i]) return false;

                cost += need * M[i];
                if (cost > budget) return false;
            }
        }
        return cost <= budget;
    }


    // FastScanner to avoid TLE
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
    }
}
