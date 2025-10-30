import java.util.*;
import java.io.*;
public class B_Your_Name {

    static String solve(String s,String b,int n)
    {
        char[] arr1 = s.toCharArray();
        Arrays.sort(arr1);
        char[] arr2 = b.toCharArray();
        Arrays.sort(arr2);
        boolean same=true;
        for (int i = 0; i < n; i++) 
        {
            if(arr1[i]!=arr2[i])
            {
                same=false;
                break;
            }
        }
        if(same)
            return "YES";
        else
            return "NO";
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s=st.nextToken();
            String b=st.nextToken();
            sb.append(solve(s, b, n)).append('\n');
        }
        System.out.print(sb.toString());
    }
}