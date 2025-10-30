import java.util.*;
import java.io.*;
public class A_Notelock {

    static int solve(String binary, int n, int k)
    {
        int dp=0;
        boolean first=true;
        int count=0;
        for (int i = 0; i < n; i++) 
        {
            if(binary.charAt(i)=='0')
                dp++;
            else
            {
                if(first)
                {
                    count++;
                    first=false;
                }
                else if(k<=dp)
                {
                    count++;
                }
                dp=0;
            }
        }
        return count;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String binary= br.readLine(); 
            sb.append(solve(binary, n, k-1)).append('\n');
        }
        System.out.print(sb.toString());
    }
}