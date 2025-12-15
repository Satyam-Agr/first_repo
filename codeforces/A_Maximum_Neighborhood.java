package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class A_Maximum_Neighborhood {

    static int solve(int n)
    {
        int arr[][]=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j]=(n*i)+j+1;
            }
        }
        int max=0;
        int offset[][]={{1,0},{-1,0},{0,1},{0,-1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum=arr[i][j];
                for (int k = 0; k < 4; k++) 
                {
                    int ni=i+offset[k][0];
                    int nj=j+offset[k][1];
                    if(ni>=0 && ni<n && nj>=0 && nj<n)
                    {
                        sum+=arr[ni][nj];
                    }
                }
                max=Math.max(max, sum);
            }
        }
        return max;
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