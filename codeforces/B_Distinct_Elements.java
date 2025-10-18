import java.util.*;
import java.io.*;
public class B_Distinct_Elements {

    static String solve(long[] b, int n)
    {
        long[] a=new long[n];
        int num=0;
        a[0]=++num;
        for (int i = 1; i < n; i++) 
        {
            long diff=b[i]-b[i-1];
            if(diff==i+1)
            {
                a[i]=++num;
            }
            else
            {
                a[i]=a[-((int)diff-i)];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) 
        {
            sb.append(a[i]).append(' ');
        }
        return sb.toString();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] b=new long[n];
            for (int i = 0; i < n; i++)
                b[i] = Long.parseLong(st.nextToken());
            sb.append(solve(b, n)).append('\n');
        }
        System.out.print(sb.toString());
    }
}