import java.util.*;
import java.io.*;
public class D_Not_Alone {

    static void solve(int[] arr, int n)
    {
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr=new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            sb.append(solve(arr, n)).append('\n');
        }
        System.out.print(sb.toString());
    }
}