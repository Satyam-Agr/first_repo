import java.util.*;
import java.io.*;
public class A_Beautiful_Average {

    static void solve(int n)
    {}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int out=-1;
            for (int i = 0; i < n; i++)
                out = Math.max(out,Integer.parseInt(st.nextToken()));
            sb.append(out).append('\n');
        }
        System.out.print(sb.toString());
    }
}