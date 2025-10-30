import java.util.*;
import java.io.*;
public class E_Beautiful_Palindromes {

    static String solve(int arr[], int n, int k)
    {
        HashSet<Integer> absent=new HashSet<>();
        for (int i = 1; i <= n; i++) 
        {
            absent.add(i);
        }
        for (int i = 0; i < n; i++) 
        {
            if(absent.contains(arr[i]))
                absent.remove(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        if(absent.isEmpty())
        {
            for (int i = 0; i < k; i++) 
            {
                sb.append(arr[n - 3 + (i % 3)]+" ");
            }
        }
        else
        {
            int []loop=new int[3];
            for (Integer integer : absent) {
                loop[0]=integer;
                break;
            }
            for (int i = 1; i <= n; i++) 
            {
                if(i!=loop[0] && i!=arr[n-1])
                {
                    loop[1]=i;
                    break;
                }
            }
            loop[2]=arr[n-1];
            for (int i = 0; i < k; i++) 
            {
                sb.append(loop[i%3]+" ");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int arr[] =new int[n];
            for (int i = 0; i < n; i++)
                arr [i] = Integer.parseInt(st.nextToken());
            sb.append(solve(arr, n, k)).append('\n');
        }
        System.out.print(sb.toString());
    }
}