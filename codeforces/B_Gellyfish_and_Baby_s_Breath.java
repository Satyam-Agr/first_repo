import java.util.*;
import java.io.*;

public class B_Gellyfish_and_Baby_s_Breath {
    static String solve(int p[], int q[], int n)
    {
        int pow[]=new int[n+1];
        pow[0]=1;
        for (int i = 1; i <= n; i++) 
        {
            pow[i]=(pow[i-1]*2)%998244353;
        } 
        int r[]=new int[n];

        int maxP=0;
        int maxQ=0;
        for (int i = 0; i < n; i++) 
        {
            if(p[maxP]<p[i])
                maxP=i;
            if(q[maxQ]<q[i])
                maxQ=i;
            long value=0;
            if(p[maxP]>q[maxQ])
                value=pow[p[maxP]]+pow[q[i-maxP]];
            else if(p[maxP]<q[maxQ])
                value=pow[p[i-maxQ]]+pow[q[maxQ]];
            else
                value=pow[p[maxP]]+pow[Math.max(p[i-maxQ], q[i-maxP])];
            r[i]=(int)(value%998244353);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) 
        {
            sb.append(r[i]+" ");
        }
        return sb.toString();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int p[]=new int[n];
            int q[]=new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                p[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                q[i] = Integer.parseInt(st.nextToken());
            sb.append(solve(p, q, n)).append('\n');
        }
        System.out.print(sb.toString());
    }
}