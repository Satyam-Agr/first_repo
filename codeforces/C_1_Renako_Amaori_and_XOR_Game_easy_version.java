package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class C_1_Renako_Amaori_and_XOR_Game_easy_version {

    static String solve(int a[], int b[], int n)
    {
        int ajisai = 0;
        int mai = 0;
        for (int i = 0; i < n; i++) {
            if(a[i]==b[i])
            {
                ajisai^=a[i];
                mai^=a[i];
            }
        }
        for (int i = 0; i < n; i++) 
        {
            if(a[i]!=b[i])
            {
                if(i%2==0)
                {
                    if(ajisai ==1 && mai ==1)
                        mai^=1;
                    else
                        ajisai^=1;
                }
                else
                {
                    if(ajisai %2==1 && mai%2==1)
                        ajisai^=1;
                    else
                        mai^=1;
                }
            }
        }
        if(ajisai==mai)
            return "Tie";
        else if(ajisai>mai)
            return "Ajisai";
        else
            return "Mai";

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int b[] = new int[n];
            for (int i = 0; i < n; i++)
                b[i] = Integer.parseInt(st.nextToken());
            sb.append(solve(a, b, n)).append('\n');
        }
        System.out.print(sb.toString());
    }
}