import java.util.*;
import java.io.*;
public class B_Strange_Machine {

    static int solve(String afl, int quere, int n, boolean allA)
    {
        int steps=0;
        if(allA)
        {
            return quere;
        }
        int i=0;
        while (quere>0) {
            steps++;
            if(afl.charAt(i)=='A')
                quere--;
            else
                quere/=2;
            if(i>=n-1)
                i=0;
            else
                i++;
        }
        return steps;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            String afl = br.readLine();
            boolean allA=true;
            for (int i = 0; i < n; i++) 
            {
                if(afl.charAt(i)=='B')
                {
                    allA=false;
                    break;
                }
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < q; i++)
            {
                int quere = Integer.parseInt(st.nextToken());
                sb.append(solve(afl, quere, n, allA)).append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}