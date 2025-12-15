package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class C_Rabbits {

    static String solve(String s, int n)
    {
        boolean first=s.charAt(0)=='0';
        boolean valid=true;
        int count=0;
        for (int i = 0; i < n-1; i++) 
        {
            if(s.charAt(i)=='0')
                count++;
            if(s.charAt(i)==s.charAt(i+1))
            {
                if(s.charAt(i)=='0')
                    valid=false;
                else
                {
                    if(valid)
                    {
                        if(!first && count%2==1)
                            return "NO";
                    }
                    count=0;
                    valid=true;
                }
                first=false;
            }
        }  
        if(valid && s.charAt(n-1)=='1' && count%2==1 && !first)
            return "NO";
        return "YES";

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s=br.readLine();
            sb.append(solve(s, n)).append('\n');
        }
        System.out.print(sb.toString());
    }
}