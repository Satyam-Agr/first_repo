package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class A_Round_Trip {

    static int solve(String level, int R, int X, int D, int n)
    {
        if(R<X)
            return n;
        int i = 0;
        int count=0;
        for (i = 0; i < n; i++) 
        {
            if(level.charAt(i)=='1')
            {
                R-=D;
                if(R<X)
                    break;
                count++;
            }
        }
        return n-i+count;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            String level=br.readLine();
            sb.append(solve(level, R, X, D, n)).append('\n');
        }
        System.out.print(sb.toString());
    }
}