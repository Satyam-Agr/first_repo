package first_repo.codeforces;
import java.util.*;
import java.io.*;
public class B_Make_Connected {
    static class Pair {
    
        int row;
        int col;
        int sum;
        int diff;
        Pair(int r, int c)
        {
            this.row=r;
            this.col=c;
            this.diff=r-c;
            this.sum=r+c;
        }
    }
    static String solve(List<Pair> blacks, int n)
    {
        if(blacks.isEmpty())
            return "YES";
        if(blacks.size()==4)
        {
            if(blacks.get(0).row==blacks.get(1).row && blacks.get(2).row==blacks.get(3).row && blacks.get(0).col==blacks.get(2).col && blacks.get(1).col==blacks.get(3).col)
            {
                if(blacks.get(1).col-blacks.get(0).col==1 && blacks.get(2).row-blacks.get(0).row==1)
                    return "YES";
            }
        }
        Pair first=blacks.get(0);
        Pair last=blacks.get(blacks.size()-1);
        int diagnol1=0;
        int diagnol2=Integer.MAX_VALUE;
        boolean checkRight=true;;
        if(first.sum==last.sum || first.sum==last.sum-1 || first.sum==last.sum+1)
        {
            diagnol1=first.sum;
            if(first.sum!=last.sum)
                diagnol2=last.sum;
        }
        else if(first.diff==last.diff ||first.diff==last.diff+1 ||first.diff==last.diff-1)
        {
            diagnol1=first.diff;
            if (first.diff!=last.diff) {
                diagnol2=last.diff;
            }
            checkRight=false;
        }
        else 
            return "NO";
        for (int i = 1; i < blacks.size(); i++) {
            int val = checkRight ? blacks.get(i).sum : blacks.get(i).diff; 

            if (val == diagnol1 || val == diagnol2) {
                continue;
            } 
            else if (diagnol2 == Integer.MAX_VALUE) {
                if (val == diagnol1 + 1 || val == diagnol1 - 1)
                    diagnol2 = val;
                else
                    return "NO";
            } 
            else
                return "NO";
        }
        return "YES";
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Pair> blacks=new ArrayList<>();
            for (int i = 0; i < n; i++)
            {
                String currRow=br.readLine();
                for (int j = 0; j < n; j++) {
                    if(currRow.charAt(j)=='#')
                    {
                        blacks.add(new Pair(i+1, j+1));
                    }
                }
            }
            sb.append(solve(blacks, n)).append('\n');
        }
        System.out.print(sb.toString());
    }
}