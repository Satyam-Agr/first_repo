package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class C_Dungeon {
    static class Pair{
        long mo;
        long dr;
        Pair(long mo, long dr)
        {
            this.mo=mo;
            this.dr=dr;
        }
    }
    static int solve(long sowd[], long mons[], long drop[], int n ,int m )
    {
        TreeMap <Long, Integer> freq=new TreeMap<>();
        for (int i = 0; i < n; i++) 
        {
            freq.put(sowd[i], freq.getOrDefault(sowd[i], 0)+1);
        }

        List<Pair> dungeon=new ArrayList<>();
        for (int i = 0; i < m; i++) 
        {
            dungeon.add(new Pair(mons[i], drop[i]));
        }
        Collections.sort(dungeon, (a, b) -> {
            // Move all pairs with dr == 0 to the end
            if (a.dr == 0 && b.dr != 0) return 1;
            if (a.dr != 0 && b.dr == 0) return -1;

            // For dr == 0 pairs → sort by mo in descending order
            if (a.dr == 0 && b.dr == 0)
                return Long.compare(b.mo, a.mo);

            // For others → sort by mo in ascending order
            return Long.compare(a.mo, b.mo);
        });
        int ans=0;
        int i = 0;
        for (; i < m; i++) 
        {
            Pair curr=dungeon.get(i);
            if(curr.dr==0)
                break;
            Long val = freq.ceilingKey(curr.mo);
            if (val == null) {
                break;
            } 
            else 
            {
                if(val<curr.dr)
                {
                    int count = freq.get(val) - 1;
                    if (count == 0) freq.remove(val);
                    else freq.put(val, count);
                    freq.put(curr.dr, freq.getOrDefault(curr.dr, 0)+1);
                }

            }
            ans++;
        }
        if(i!=m)
        {
            while (dungeon.get(i).dr!=0) {
                i++;
                if(i==m)
                    return ans;
            }
        }
        for (; i < m; i++) 
        {
            Pair curr=dungeon.get(i);
            Long val = freq.ceilingKey(curr.mo);
            if (val != null) {
                int count = freq.get(val) - 1;
                if (count == 0) freq.remove(val);
                else freq.put(val, count);
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            long sowd[]=new long[n]; 
            long mons[]=new long[m];
            long drop[]=new long[m];

            for (int i = 0; i < n; i++)
                sowd[i] = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) 
            {
                mons[i] = Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) 
            {
                drop[i] = Long.parseLong(st.nextToken());
            }
            sb.append(solve(sowd, mons, drop, n, m)).append('\n');
        }
        System.out.print(sb.toString());
    }
}