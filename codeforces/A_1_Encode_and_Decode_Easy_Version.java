package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class A_1_Encode_and_Decode_Easy_Version {
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
                char in=(char)('a'+Integer.parseInt(st.nextToken())-1);
                sb.append(in);
            }
            System.out.print(sb.toString());
        }
        else
        {
            String arr=br.readLine();
            System.out.println(arr.length());
            for (int i = 0; i < arr.length(); i++) 
            {
                int out=arr.charAt(i)-'a'+1;
                System.out.print(out+ " ");
            }
        }
    }
}