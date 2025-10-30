package first_repo.codeforces;

import java.io.*;
public class C_Reverse_XOR {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String bin = Integer.toBinaryString(n); // binary representation
            int[] bits = new int[bin.length()];
            int end=0;
            boolean palendrom=true;
            String out="";
            for (int i = 0; i < bin.length(); i++)
            {
                bits[i] = bin.charAt(i) - '0';
                if(bits[i]==1)
                    end=i;
            }
            if(end%2==0 && bits[end/2]==1)
            {
                out="NO";
            }
            else
            {
                for (int i = 0, j=end; i<j ; i++,j--) 
                {
                    if(bits[i]!=bits[j])
                    {
                        palendrom=false;
                        break;
                    }
                    
                }
                if(palendrom)
                    out="YES";
                else
                    out="NO";
            }
            sb.append(out).append('\n');
        }
        System.out.print(sb.toString());
    }
}