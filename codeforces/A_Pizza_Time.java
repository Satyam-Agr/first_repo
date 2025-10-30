package first_repo.codeforces;
import java.io.*;
public class A_Pizza_Time {

    static int solve(int n)
    {
        int total=0;
        while (n>2) {
            int split=n/3;
            total+=split;
            n=split+n%3;
        }
        return total;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(solve(n)).append('\n');
        }
        System.out.print(sb.toString());
    }
}