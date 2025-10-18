import java.util.*;
import java.io.*;
public class C_I_Will_Definitely_Make_It {

    static String solve(int [] towers,int n, int k)
    {
        int currHeight=towers[k-1];
        towers[k-1]=0;
        int waterLevel=0;
        Arrays.sort(towers);
        int i=0;
        while (currHeight>= towers[i])
        {
            i++;
            if(i==n-1)
                break;
        }
        for (; i < n; i++) 
        {
            int diff=towers[i]-currHeight;
            int hight=currHeight-waterLevel;
            if(hight<diff)
            {
                return "NO";
            }
            else
            {
                waterLevel+=diff;
                currHeight=towers[i];
                if(i!=n-1){
                    while (towers[i]==towers[i+1]) {
                        i++;
                        if(i==n-1)
                            break;
                    } 
                }
            }            
        }
        return "YES";
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
            int[] towers=new int[n];
            for (int i = 0; i < n; i++)
                towers[i] = Integer.parseInt(st.nextToken());
            sb.append(solve(towers, n, k)).append('\n');
        }
        System.out.print(sb.toString());
    }
}