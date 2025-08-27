//This takes too much time the next one is good(the one in comments)
package first_repo;
import java.io.*;
import java.util.*;

public class maxProfit
{

    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[][] value=new int[n][2];
        for(int i=0;i<n;i++)
        {
            value[i][0]=sc.nextInt();
            value[i][1]=sc.nextInt();
        }
        int profit=result(x,value);
        if(profit==-1)
            System.out.print("Got caught!");
        else 
            System.out.print(profit);    
    }
    static int result (int x,int[][]value)
    {
        int profit=-1;
        int n=value.length;
        Arrays.sort(value,(one,two)->one[1]-two[1]);
        for(int i=0;i<value.length;i++)
            if(value[i][1]>x)
            {
                n=i;
                break;
            }
        Gene.generate (value,n,x,0,0,0);
        if(Gene.possible!=null)
            for(int i=0;i<Gene.possible.size();i++)
            {
                int pos=Gene.possible.get(i);
                int sum=0;
                while(pos!=0)
                {
                    sum+=value[(pos%10)-1][0];
                    pos/=10;
                }
                profit = Math.max(profit, sum);            
            }
        return profit; 
    }
}
class Gene
{
    static List<Integer> possible=new ArrayList<>();
    public static void generate(int[][]value,int n,int x,int sum,int pos,int index)
    {
        if(index==n)
        {
            if(sum==x)
                possible.add(pos);
            return;
        }
        for(int i=0;i<2;i++)
        {
            if (i==0)
            {
                generate(value,n,x,sum,pos,index+1);
                
            }
            else
            {
                generate(value,n,x,sum+value[index][1],(pos*10)+index+1,index+1);
            }
            
        }
    }
}

/*
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[][] value = new int[n][2];
        for (int i = 0; i < n; i++) {
            value[i][0] = sc.nextInt(); // profit
            value[i][1] = sc.nextInt(); // cost
        }

        int profit = result(x, value);
        if (profit == -1)
            System.out.print("Got caught!");
        else
            System.out.print(profit);
    }

    static int result(int x, int[][] value) {
        int[] dp = new int[x + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0; // base case

        for (int[] item : value) {
            int profit = item[0];
            int cost = item[1];
            // traverse backwards to avoid overwriting states
            for (int sum = x; sum >= cost; sum--) {
                if (dp[sum - cost] != -1) {
                    dp[sum] = Math.max(dp[sum], dp[sum - cost] + profit);
                }
            }
        }

        return dp[x]; // max profit with total cost = x, or -1 if impossible
    }
}
*/