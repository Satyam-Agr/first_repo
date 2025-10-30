import java.util.*;
import java.io.*;
public class E_khba_Loves_to_Sleep {

    static class Pair {
        long dist;
        long pos;
        char dir;
        Pair(long d, long p, char dir) 
        { 
            dist = d; 
            pos = p; 
            this.dir = dir;
        }
    }

    static String solve(long[] a, int n, int k, long x) {
        Arrays.sort(a);
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Long.compare(p2.dist, p1.dist));
        HashSet<Long> used = new HashSet<>(); // to ensure distinct positions

        // Left edge
        if (a[0] > 0) {
            pq.add(new Pair(a[0], 0L, 'R'));
            used.add(0L);
        }

        // Middle gaps
        for (int i = 0; i < n - 1; i++) {
            long L = a[i], R = a[i + 1];
            if (R - L > 1) {
                if((L + R)%2==0 )
                {
                    long mid = (L + R) / 2;
                    long d = Math.min(mid - L, R - mid);
                    pq.add(new Pair(d, mid,'B'));
                    used.add(mid);
                }
                else 
                {
                    long mid = (L + R) / 2;

                    long d = Math.min(mid - L, R - mid);
                    pq.add(new Pair(d, mid,'L'));
                    pq.add(new Pair(d, mid+1,'R'));
                    used.add(mid);
                    used.add(mid+1);
                }
            }
        }

        // Right edge
        if (a[n - 1] < x) {
            pq.add(new Pair(x - a[n - 1], x, 'L'));
            used.add(x);
        }
        if(pq.isEmpty())
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) 
            {
                sb.append(i+" ");
            }
            return sb.toString();
        }
        // Pick from PQ first
        List<Long> ans = new ArrayList<>();
        while (k-- > 0 && !pq.isEmpty()) {
            Pair p=pq.poll();
            ans.add(p.pos);
            if(p.dir=='L')
            {
                if(!used.contains(p.pos-1) && p.pos != 0)
                    {
                        pq.add(new Pair(p.dist>0 ? p.dist-1 : 0, p.pos-1, 'L'));
                        used.add(p.pos-1);
                    }
            }  
            else if(p.dir=='R')
            {
                if(!used.contains(p.pos+1) && p.pos != x)
                    {
                        pq.add(new Pair(p.dist>0 ? p.dist-1 : 0, p.pos+1, 'R'));
                        used.add(p.pos+1);
                    }
            } 
            else
            {
                if(!used.contains(p.pos-1) && p.pos != 0)
                    {
                        pq.add(new Pair(p.dist>0 ? p.dist-1 : 0, p.pos-1, 'L'));
                        used.add(p.pos-1);
                    }
                if(!used.contains(p.pos+1) && p.pos != x)
                    {
                        pq.add(new Pair(p.dist>0 ? p.dist-1 : 0, p.pos+1, 'R'));
                        used.add(p.pos+1);
                    }
            }        
        }
        StringBuilder sb = new StringBuilder();
        for (long p : ans) sb.append(p).append(" ");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            long arr[]=new long[n];
            for (int i = 0; i < n; i++)
                arr[i] = Long.parseLong(st.nextToken());
            sb.append(solve(arr, n, k, x)).append('\n');
        }
        System.out.print(sb.toString());
    }
}