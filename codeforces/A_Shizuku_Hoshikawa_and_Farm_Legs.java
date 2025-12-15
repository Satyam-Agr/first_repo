package first_repo.codeforces;
import java.io.*;
public class A_Shizuku_Hoshikawa_and_Farm_Legs {

    static int solve(int n)
    {
        if(n%2==1)
            return 0;
        else
            return (n/4)+1;
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