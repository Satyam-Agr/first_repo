package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class D_Yet_Another_Array_Problem {

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long g = Long.parseLong(st.nextToken());
            for (int i = 1; i < n; i++) {
                g = gcd(g, Long.parseLong(st.nextToken()));
            }
            
            if (g == 1) {
                sb.append(2).append("\n");
                continue;
            }

            long ans = -1;
            for (long x = 2; x <= 100; x++) {
                if (gcd(g, x) == 1) {
                    ans = x;
                    break;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb.toString());
    }
}