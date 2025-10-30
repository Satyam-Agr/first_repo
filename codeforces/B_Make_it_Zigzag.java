import java.util.*;
import java.io.*;
public class B_Make_it_Zigzag {

    static int solve(int arr[],int n)
    {
        int max=Integer.MIN_VALUE;
        int count=0;
        for (int i = 0; i < n; i++) 
        {
            max=Math.max(max, arr[i]);
            if(i%2==1 && max>arr[i])
            {
                if(i!=n-1)
                {
                    if(arr[i]<=arr[i-1] || arr[i]<=arr[i+1])
                    {
                        arr[i]=max;
                    }
                }
                else
                {
                    if(arr[i]<=arr[i-1])
                    {
                        arr[i]=max;
                    }
                }
            }
        }
        if(arr[0]-arr[1]>=0)
            count=arr[0]-arr[1]+1;
        for (int i = 2; i < n; i++) 
        {
            if(i%2==0)
            {
                if(i!=n-1)
                {
                    if(arr[i]>=Math.min(arr[i-1],arr[i+1]))
                    {
                        count+=arr[i]-Math.min(arr[i-1],arr[i+1])+1;
                    }
                }
                else
                {
                    if(arr[i]>=arr[i-1])
                    {
                        count+=arr[i]-arr[i-1]+1;
                    }
                }
            }
        }
        return count;
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