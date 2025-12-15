package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class B_Split {

    static long solve(Map <Integer, Integer> freq ,int n)
    {
        int badEven=0;
        int goodEven=0;
        int oddCount=0;
        for (int curr : freq.keySet()) {
            int count=freq.get(curr);
            if(count%2==0)
            {
                if(count%4==0)
                    badEven++;
                else
                {
                    goodEven++;
                }
                    
            }
            else{
                oddCount++;
            }
        }
        long out = oddCount+2*(goodEven+badEven);
        if(badEven%2==1 && oddCount<2)
        {
            out-=2;
        }
        return out;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Map <Integer, Integer> freq = new HashMap<>();
            for (int i = 0; i < 2*n; i++)
            {
                int curr = Integer.parseInt(st.nextToken());
                freq.put(curr, freq.getOrDefault(curr, 0)+1);
            }
            sb.append(solve(freq, n)).append('\n');
        }
        System.out.print(sb.toString());
    }
}