package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class C_Monopati {
    static class Pair 
    {
        int min;
        int max;
        Pair(int m, int x)
        {
            min=m;
            max=x;
        }
    }
    static long solve(int a[], int b[], int n)
    {
        Pair adiff[]=new Pair[n];
        Pair bdiff[]=new Pair[n];
        int ans[]=new int[2*n];
        for (int i = 0; i < 2*n; i++) ans[i]=Integer.MAX_VALUE;
        adiff[0]=new Pair(a[0], a[0]);
        bdiff[n-1]=new Pair(b[n-1], b[n-1]);
        for (int i = 1; i < n; i++) 
        {
            int min=a[i] < adiff[i-1].min ? a[i] : adiff[i-1].min;
            int max=a[i] > adiff[i-1].max ? a[i] : adiff[i-1].max;
            adiff[i]=new Pair(min, max);
        }
        for (int i = n-2; i >=0 ; i--) 
        {
            int min=b[i] < bdiff[i+1].min ? b[i] : bdiff[i+1].min;
            int max=b[i] > bdiff[i+1].max ? b[i] : bdiff[i+1].max;
            bdiff[i]=new Pair(min, max);
        }
        for (int i = 0; i < n; i++) 
        {
            int min= Math.min(adiff[i].min, bdiff[i].min);
            int max= Math.max(adiff[i].max, bdiff[i].max);
            ans[min-1]=Math.min(ans[min-1], max);
        }
        for (int i = 2*n-2; i >= 0; i--) 
        {
            ans[i]=Math.min(ans[i], ans[i+1]);
        }
        long out=0;
        for (int i = 0; i < 2*n; i++) 
        {
            if(ans[i]!=Integer.MAX_VALUE)
                out+=((2*n)-ans[i]+1);
        }
        return out;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a[]=new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int b[]=new int[n];
            for (int i = 0; i < n; i++)
                b[i] = Integer.parseInt(st.nextToken());
            sb.append(solve(a, b, n)).append('\n');
        }
        System.out.print(sb.toString());
    }
}