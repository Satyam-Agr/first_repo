package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class A_2_Encode_and_Decode_Hard_Version {

    static String solve(long n)
    {
        if(n==1000000000)
            return "zo";
        StringBuilder sb = new StringBuilder();
        while (n>0) {
            char in=(char)(n%10+'a');
            sb.append(in);
            n/=10;
        }
        sb.append('o');
        return sb.toString();
    }
    static long solve(String n)
    {
        if(n.equals("z"))
            return 1000000000;
        long out=0;
        for (int i = n.length()-1; i >= 0; i--) {
            out=(out*10)+(int)(n.charAt(i)-'a');
        }
        return out;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String root=br.readLine();
        if(root.equals("first"))
        {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
            {
                sb.append(solve(Long.parseLong(st.nextToken())));
            }
            System.out.print(sb.toString());
        }
        else
        {
            String arr=br.readLine();
            String parts[]=arr.split("o");
            System.out.println(parts.length);
            for (int i = 0; i < parts.length; i++) 
            {
                System.out.print(solve(parts[i])+ " ");
            }
        }
    }
}