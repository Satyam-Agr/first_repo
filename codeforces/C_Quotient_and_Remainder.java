package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class C_Quotient_and_Remainder {

    static int solve(long q[], long r[], long k, int n)
    {
        Arrays.sort(q);
        Arrays.sort(r);
        int i=0,j=n-1;
        int out=0;
        while (i<n && j>=0) {
            long y=r[j]+1;
            long x=(y*q[i])+r[j--];
            while(x>k && j>=0)
            {
                y=r[j]+1;
                x=(y*q[i])+r[j--];
            }
            if(x<=k)
            {
                i++;
                out++;
            }
        }
        return out;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            long q[]=new long[n];
            for (int i = 0; i < n; i++)
                q[i] = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            long r[]=new long[n];
            for (int i = 0; i < n; i++)
                r[i] = Long.parseLong(st.nextToken());

            sb.append(solve(q, r, k, n)).append('\n');
        }
        System.out.print(sb.toString());
    }
}