package first_repo.practice_codes;
import java.util.*;
import java.io.*;

public class rottingOrange {
    static class Pair
    {
        int i;
        int j;
        int t;
        Pair(int i, int j, int t)
        {
            this.t=t;
            this.i=i;
            this.j=j;
        }
    }   
     static int solve(int grid[][])
    {
        int offSet[][]={{-1,0},{1,0},{0,-1},{0,1}};
        int m=grid.length;
        int n=grid[0].length;
        int rottenOranges=0;
        int oranges=0;
        int steps=0;
        Queue<Pair> rotten=new LinkedList<>();
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++)
            {
                if(grid[i][j]==2)
                {
                    rotten.add(new Pair(i, j, 0));
                }
                else if(grid[i][j]==1)
                {
                    oranges++;
                }
            }
        }
        if(oranges==0)
            return 0;
        while (!rotten.isEmpty()) {
            Pair current=rotten.poll();
            for (int k = 0; k < offSet.length; k++) {
                int i=current.i+offSet[k][0];
                int j=current.j+offSet[k][1];
                if(i <m && j <n && i>-1 && j>-1)
                {
                    if(grid[i][j]==1)
                    {
                        grid[i][j]=2;
                        rotten.add(new Pair(i, j, current.t+1));
                        rottenOranges++;
                    }
                }
            }
            steps=current.t;
        }
        return rottenOranges==oranges?steps:-1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int grid[][]=new int[m][n];
        for (int i = 0; i < m; i++) 
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.print(solve(grid));
    }    
}
