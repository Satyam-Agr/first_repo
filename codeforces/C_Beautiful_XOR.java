//2162/problem/C
import java.util.*;
import java.io.*;
public class C_Beautiful_XOR {

    static String solve(int a, int b)
    {
        String binaryA=Integer.toBinaryString(a);
        String binaryB=Integer.toBinaryString(b);
        if(a==b)
            return "0";
        if(binaryA.length()<binaryB.length())
            return "-1";

        int out1=0;
        StringBuilder sb = new StringBuilder();
        if(binaryA.length()==binaryB.length())
        {
            sb.append("1\n").append(a^b);
            return sb.toString();
        }
        int x=Integer.parseInt(binaryA.substring(0, binaryA.length()-binaryB.length()),2);
        int y=Integer.parseInt(binaryA.substring(binaryA.length()-binaryB.length(), binaryA.length()),2);
        sb.append("2\n").append(b^y).append(" ").append(x<<binaryB.length());
        return sb.toString();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(solve(a, b)).append('\n');
        }
        System.out.print(sb.toString());
    }
}