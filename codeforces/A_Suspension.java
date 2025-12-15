package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class A_Suspension {

    static void solve(int n)
    {}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(Math.min(n, (y/2)+r)).append('\n');
        }
        System.out.print(sb.toString());
    }
}