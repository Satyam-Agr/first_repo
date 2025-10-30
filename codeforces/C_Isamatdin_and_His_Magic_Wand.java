import java.util.*;
import java.io.*;
public class C_Isamatdin_and_His_Magic_Wand {

    static void solve(int n)
    {}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int []arr=new int[n];
            boolean allE=true;
            boolean allO=true;
            for (int i = 0; i < n; i++)
            {
                int curr = Integer.parseInt(st.nextToken());
                arr[i]=curr;
                if(curr%2==0)
                    allO=false;
                else
                    allE=false;
            }
            if(!(allE || allO))
            {
                Arrays.sort(arr);
            }
            for (int i = 0; i < n; i++) 
            {
                sb.append(arr[i]+" ");
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}