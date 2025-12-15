package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class C_1_No_Cost_Too_Great_Easy_Version {
    
    static final int N = 200000 + 10;
    static ArrayList<Integer>[] pfac = new ArrayList[N + 1];

    static void sieve() {
        for (int i = 0; i <= N; i++) pfac[i] = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (!pfac[i].isEmpty()) continue;
            for (int j = i; j <= N; j += i)
                pfac[j].add(i);
        }
    }
    static int solve(HashSet<Integer> arr1, HashSet<Integer> arr2, int n)
    {
        HashSet<Integer> factors=new HashSet<>();
        for (int curr:arr1) 
        {
            ArrayList<Integer> pcurr=pfac[curr];
            for (int j = 0; j < pcurr.size(); j++) 
            {
                if(factors.contains(pcurr.get(j)))
                    return 0;
                factors.add(pcurr.get(j));
            }
        }
        HashSet<Integer> factors2=new HashSet<>();
        for (int curr:arr2) 
        {
            ArrayList<Integer> pcurr=pfac[curr];
            for (int j = 0; j < pcurr.size(); j++) 
            {
                factors2.add(pcurr.get(j));
            }
        }
        for (int integer : factors2) {
            if(factors.contains(integer))
                return 1;
        }
        return 2;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        sieve();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            HashSet<Integer> arr1=new HashSet<>();
            HashSet<Integer> arr2=new HashSet<>();
            int evens=0;
            for (int i = 0; i < n; i++)
            {
                int in = Integer.parseInt(st.nextToken());
                if(in%2==0)
                    evens++;
                if(arr1.contains(in) && in!=1)
                    evens=3;
                arr1.add(in);
                arr2.add(in+1);
            }
            br.readLine();
            if(evens>=2)
                sb.append(0+"\n");
            else
                sb.append(solve(arr1, arr2, n)+"\n");
        }
        System.out.print(sb.toString());
    }
}
