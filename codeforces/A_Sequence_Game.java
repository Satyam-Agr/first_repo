package first_repo.codeforces;
import java.util.*;
import java.io.*;

public class A_Sequence_Game {
    static String solve(int arr[], int x, int n)
    {
        boolean allsmall=true;
        boolean alllarge=true;
        for (int i = 0; i < n; i++) 
        {
            if(arr[i]>x)
                allsmall=false;
            else if(arr[i]<x)
                alllarge=false;
            else
                return "YES";
        }
        if(alllarge || allsmall)
            return "NO";
        else
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
            int x = Integer.parseInt(br.readLine());
                sb.append(solve(arr, x, n)).append('\n');
        }
        System.out.print(sb.toString());
    }    
}
