import java.util.*;
import java.io.*;
public class A_Square {

    static void solve(int n)
    {}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean square=true;
            int v=Integer.parseInt(st.nextToken());
            for (int i = 1; i < 4; i++)
                if(v!=Integer.parseInt(st.nextToken()))
                    square=false;
            if(square)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.print(sb.toString());
    }
}