package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class C_Loyalty {

    static String solve(long arr[],long x, int n)
    {
        long total=0;
        long s=0;
        Arrays.sort(arr);
        long out[]=new long[n];
        int i=0;
        for(int front=0, rear=n-1;front<=rear; )
        {
            if(s+arr[rear]>=x)
            {
                s=(s+arr[rear])%x;
                total+=arr[rear];
                out[i++]=arr[rear];
                rear--;
            }
            else
            {
                s=s+arr[front];
                out[i++]=arr[front];
                if(s>=x)
                {
                    s%=x;
                    total+=arr[front];
                }
                front++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(total+ "\n");
        for (int j = 0; j < i; j++) {
            sb.append(out[j]+ " ");
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
            long x = Long.parseLong(st.nextToken());
            long arr[]=new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                arr[i] = Long.parseLong(st.nextToken());
            sb.append(solve(arr, x, n)).append('\n');
        }
        System.out.print(sb.toString());
    }
}