package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class C_Triple_Removal {

    static String solve(int[] ds, int[][] queries, int n, int q)
    {
        int[] prefix=new int[n];
        int[] alternativeDp=new int[n];
        prefix[0]=ds[0];
        for (int i = 1; i < n; i++) 
        {
            prefix[i]=prefix[i-1]+ds[i];
        }
        alternativeDp[0]=1;
        for (int i = 1; i < n; i++) 
        {
            if(ds[i]==ds[i-1])
                alternativeDp[i]=1;
            else
                alternativeDp[i]=alternativeDp[i-1]+1;
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < q; i++) 
        {
            int l=queries[i][0];
            int r=queries[i][1];
            int qSize=r-l+1;
            if((qSize)%3==0&&(prefix[r-1]-prefix[l-1]+ds[l-1])%3==0)
            {
                if(alternativeDp[r-1]>=qSize)
                    sb.append(qSize/3+1).append('\n');
                else
                    sb.append(qSize/3).append('\n');
            }
            else
                sb.append(-1).append('\n');
        }
        return sb.toString();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q= Integer.parseInt(st.nextToken());
            int[] ds=new int[n];
            int[][] queries= new int[q][2];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                ds[i] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < q; i++) 
            {
                st = new StringTokenizer(br.readLine());
                queries[i][0] = Integer.parseInt(st.nextToken());
                queries[i][1] = Integer.parseInt(st.nextToken());
            }
            sb.append(solve(ds, queries, n, q));
        }
        System.out.print(sb.toString());
    }
}