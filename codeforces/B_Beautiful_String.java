import java.util.*;
import java.io.*;
public class B_Beautiful_String {

    static String solve(String binary, int n)
    {
        StringBuilder sb = new StringBuilder(); 
        int count=0;
        for (int i = 0; i < n; i++) 
        {
            if(binary.charAt(i)=='0')
            {
                count++;
                sb.append(i+1).append(" ");
            }
        }
        sb.insert(0, count + "\n");
        return sb.toString();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String binary=br.readLine();
            sb.append(solve(binary, n)).append('\n');
        }
        System.out.print(sb.toString());
    }
}