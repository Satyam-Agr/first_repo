package first_repo.codeforces;import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class A_Incremental_Path {
    static int nextPos(Set<Integer> blacks, int currentPos,char action)
    {
        if(action=='A')
            ++currentPos;
        else if(action=='B')
        {
            currentPos++;
            while (blacks.contains(currentPos))
                currentPos++;
        }
        return currentPos;
    }
    static String solve(String actions ,Set<Integer> blacks, int n)
    {
        int currentPos=1;
        int startPos=1;
        blacks.add(nextPos(blacks, currentPos, actions.charAt(0)));
        for (int i = 1; i < n; i++) {
            currentPos=startPos;
            currentPos=nextPos(blacks, currentPos, actions.charAt(i-1));
            startPos=currentPos;
            blacks.add(nextPos(blacks, currentPos, actions.charAt(i)));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(blacks.size()).append('\n');
        for (int num : new TreeSet<>(blacks))
            sb.append(num).append(" ");
        return sb.toString();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            String actions =br.readLine();
            st=new StringTokenizer(br.readLine());
            Set <Integer> blacks=new HashSet<>();
            for (int i = 0; i < m; i++)
                blacks.add(Integer.parseInt(st.nextToken()));
            sb.append(solve(actions, blacks, n)).append('\n');
        }
        System.out.print(sb.toString());
    }
}