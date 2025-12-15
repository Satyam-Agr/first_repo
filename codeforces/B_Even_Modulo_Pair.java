package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class B_Even_Modulo_Pair {

    static String solve(int[]arr, int n)
    {
        int pos1=-1;
        for (int i = 0; i < n-1; i++) 
        {
            if(arr[i]%2==0)
            {
                if(pos1==-1) 
                    pos1=arr[i];
                else 
                {
                    return pos1+" "+arr[i];
                }
            }
            if((arr[i+1]%arr[i])%2==0)
            {
                return arr[i]+" "+arr[i+1];
            }
        }
        for (int i = 0; i <n ; i++) 
        {
            for (int j = i+1; j < n; j++) {
                if((arr[j]%arr[i])%2==0)
                    return arr[i]+" "+arr[j];
            }
        }
        return "-1";
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