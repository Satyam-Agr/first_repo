import java.io.*;
import java.util.*;

public class A_MEX_Partition {
    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            st = new StringTokenizer(br.readLine());
            int MAX = 101;
            int[] freq = new int[MAX + 1];
            for (int i = 0; i < n; i++) {
                int v = Integer.parseInt(st.nextToken());
                freq[v]++;
            }

            int g = 0;
            for (int v = 0; v <= MAX; v++) {
                if (freq[v] > 0) g = gcd(g, freq[v]);
            }

            int ans = Integer.MAX_VALUE;
            for (int k = 1; k <= g; k++) {
                if (g % k != 0) continue;
                int mex = 0;
                while (mex <= MAX && freq[mex] >= k) mex++;
                ans = Math.min(ans, mex);
            }
            out.append(ans).append('\n');
        }
        System.out.print(out.toString());
    }
}
