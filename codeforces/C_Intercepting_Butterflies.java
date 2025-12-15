package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class C_Intercepting_Butterflies {

    static String solveA(int n)
    {
        n--;
        int arr[]=new int[20];
        for (int i = 0; i < 15; i++) 
        {
            arr[i]=n>>i & 1; 
        }
        int safty=0;
        for (int i = 0; i < 15; i++) {
            if(arr[i]==1)
            safty^=i+1;
        }
        for (int i = 0; i < 4; i++) 
        {
            arr[15+i]=safty>>i & 1;
        }
        arr[19]=arr[15]^arr[16]^arr[17]^arr[18];
        int count=0;
        for (int i = 0; i < 20; i++) 
        {
            count+=arr[i];
        }
        StringBuilder sb=new StringBuilder();
        sb.append(count+"\n");
        for (int i = 0; i < 20; i++) 
        {
            if(arr[i]==1)
            sb.append((i+1)+" ");
        }
        return sb.toString();
    }
    static int solveB(int arr[], int n)
    {
        if(arr[19]==(arr[15]^arr[16]^arr[17]^arr[18]))
        {
            int safty=0;
            for (int i = 0; i < 4; i++) 
            {
                safty=(safty<<1) +arr[18-i];
            }
            for (int i = 0; i < 15; i++) {
                if(arr[i]==1)
                safty^=i+1;
            }
            
            if(safty!=0)
                arr[safty-1]=arr[safty-1]==1 ? 0:1;
        }
        int out=0;
        for (int i = 14; i >= 0; i--) 
        {
            out=(out<<1)+arr[i];
        }
        return out+1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String root=br.readLine();
        if(root.equals("first"))
        {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine());
                sb.append(solveA(n)+"\n");
            }
            System.out.print(sb.toString());
        }
        else
        {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine());
                StringTokenizer st = new StringTokenizer(br.readLine());
                int arr[]=new int[20];
                for (int i = 0; i < n; i++) 
                    arr[Integer.parseInt(st.nextToken())-1]=1;
                sb.append(solveB(arr, n)+"\n");
            }
            System.out.println(sb.toString());
        }
    }
}