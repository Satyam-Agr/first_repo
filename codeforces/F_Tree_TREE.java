package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class F_Tree_TREE {
    static void subTree(ArrayList<Integer> graph[], int subTreeDp[], int current, int parent)
    {
        subTreeDp[current]=1;
        if(graph[current].size()==1 && parent!=-1)
            return;
        for (int i = 0; i < graph[current].size(); i++) 
        {
            int next=graph[current].get(i);
            if(next!=parent)
            {
                subTree(graph, subTreeDp, next, current);
                subTreeDp[current]+=subTreeDp[next];
            }
        }
        
    }
    static long solve(ArrayList<Integer> graph[], int n, int k)
    {
        int subTreeDp[]=new int[n+1];
        int dp[]=new int[n+1];
        subTree(graph, subTreeDp, 1, -1);
        for (int i = 1; i < n+1; i++) 
        {
            if(subTreeDp[i]>=k)
                dp[1]++;
        }
        Queue<Integer> q=new LinkedList<>();
        boolean visited[]=new boolean[n+1];
        q.add(1);
        visited[1]=true;
        while (!q.isEmpty()) {
            int src=q.poll();
            for (int i = 0; i < graph[src].size(); i++) 
            {
                int dis=graph[src].get(i);
                if(!visited[dis])
                {
                    visited[dis]=true;
                    dp[dis]=dp[src];
                    if(subTreeDp[dis]<k) dp[dis]++;
                    if(n-subTreeDp[dis]<k) dp[dis]--;
                    q.add(dis);
                }
            }
        }
        long out=0L;
        for (int i = 0; i < n+1; i++) 
        {
            out+=dp[i];
        }
        return out;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            ArrayList<Integer> graph[]=new ArrayList[n+1];
            for (int i = 0; i < n+1; i++) 
            {
                graph[i]= new ArrayList<>();
            }
            for (int i = 0; i < n-1; i++)
            {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }
            sb.append(solve(graph, n, k)).append('\n');
        }
        System.out.print(sb.toString());
    }
}