package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class A_Souvlaki_VS_Kalamaki {

    static String solve(int arr[], int n)
    {
        Arrays.sort(arr);
        for (int i = 0; i < n-1; i++) 
        {
            if(i%2==1)
            {
                if(arr[i]!=arr[i+1])
                    return "NO";
            }
        }
        return "YES";
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arr[]=new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            sb.append(solve(arr, n)).append('\n');
        }
        System.out.print(sb.toString());
    }
}