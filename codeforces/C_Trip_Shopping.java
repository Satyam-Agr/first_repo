import java.util.*;
import java.io.*;

public class C_Trip_Shopping {
    static void solve(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); // not used

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] b = new int[n];
        st = new StringTokenizer(br.readLine());
        long ans = 0;
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            if (b[i] < a[i]) {
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            }
            ans += (long)(b[i] - a[i]);
            pairs[i] = new Pair(a[i], b[i]);
        }

        Arrays.sort(pairs, (p1, p2) -> Integer.compare(p1.first, p2.first));

        // Check for overlap
        boolean overlap = false;
        for (int i = 1; i < n; i++) {
            if (pairs[i].first <= pairs[i-1].second) {
                overlap = true;
                break;
            }
        }

        if (overlap) {
            System.out.println(ans);
            return;
        }

        // Compute minimum gap
        int minGap = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minGap = Math.min(minGap, pairs[i].first - pairs[i-1].second);
        }

        System.out.println(ans + 2L * minGap);
    }

    static class Pair {
        int first, second;
        Pair(int f, int s) { first = f; second = s; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) solve(br);
    }
}
