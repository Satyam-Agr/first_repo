package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class B_Yuu_Koito_and_Minimum_Absolute_Sum {

    static String solve(long a[], int n)
    {
        long sum=0;
        boolean addable=false;
        boolean subtractable=false;
        if(a[0]==-1)
            subtractable=true;
        if(a[n-1]==-1)
            addable=true;
        for (int i = 0; i < n-1; i++) {
            if(a[i]==-1)
                a[i]=0;
            if(a[i+1]==-1)
                a[i+1]=0;
            sum+=a[i+1]-a[i];
        }
        if(sum>0 && subtractable)
        {
            a[0]=sum;
            sum=0;
            
        }
        else if(sum<0 && addable)
        {
            a[n-1]=0-sum;
            sum=0;
            
        }
        StringBuilder sb=new StringBuilder();
        sb.append(Math.abs(sum)+"\n");
        for (int i = 0; i < n; i++) 
        {
            sb.append(a[i]+" ");
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
            long a[] = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(st.nextToken());
            sb.append(solve(a, n)).append('\n');
        }
        System.out.print(sb.toString());
    }
}