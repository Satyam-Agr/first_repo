package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class B_Siga_ta_Kymata {
    static class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return a == p.a && b == p.b;
        }

        @Override
        public int hashCode() {
            return 31 * a + b;
        }
    }

    static String solve(int arr[], String b, int n)
    {
        int maxpos=0;
        int minpos=0;
        boolean allzero=true;
        for (int i = 0; i < n; i++) 
        {
            if(b.charAt(i)=='1')
            {
                if (i==0 || i==n-1 || arr[i]==1 || arr[i]==n)
                    return "-1\n";
                allzero=false;
            }
            if(arr[i] == 1)
                minpos=i;
            if(arr[i] == n)
                maxpos=i;
        }
        if(allzero)
            return "0\n";
        StringBuilder sb=new StringBuilder();
        HashSet <Pair> pairs=new HashSet<>();
        if(minpos>1 && arr[0]!=2)
        {
            pairs.add(new Pair(1,minpos+1));
        }
        if(maxpos>1 && arr[0]!=n-1)
        {
            pairs.add(new Pair(1, maxpos+1));
        }
        if(Math.abs(maxpos-minpos)>1)
        {
            pairs.add(new Pair((Math.min(maxpos, minpos)+1), (Math.max(maxpos, minpos)+1)));
        }
        if(minpos<n-2 && arr[n-1]!=2)
        {
            pairs.add(new Pair((minpos+1), n));
        }
        if(maxpos<n-2 && arr[n-1]!=n-1)
        {
            pairs.add(new Pair((maxpos+1), n));
        }
        sb.append(pairs.size()+"\n");
        for (Pair pair : pairs) {
            sb.append(String.format("%d %d\n",pair.a,pair.b));
        }
        return sb.toString();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arr[]=new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            String b=br.readLine();
            sb.append(solve(arr, b, n));
        }
        System.out.print(sb.toString());
    }
}