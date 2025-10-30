package first_repo.codeforces;
//1650/problem/C
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class C_Weight_of_the_System_of_Nested_Segments {
    static class data
{
    int idx;
    int weight;
    int pos;
    data(int idx, int weight, int pos)
    {
        this.idx=idx;
        this.pos=pos;
        this.weight=weight;
    }
}
    static void solve(List<data> testcase, int n, int m)
    {
        Collections.sort(testcase,(o1,o2)->o1.weight-o2.weight);
        testcase=testcase.subList(0, 2*n);
        Collections.sort(testcase,(o1,o2)->o1.pos-o2.pos);
        long totalWeight=0;
        for (int i = 0; i < testcase.size(); i++) 
        {
            totalWeight+=testcase.get(i).weight;
        }
        System.out.println(totalWeight);
        for (int i = 0; i < n; i++) 
        {
            System.out.println(testcase.get(i).idx+" "+testcase.get(testcase.size()-1-i).idx);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            List<data> testcase=new ArrayList<>();
            for (int i = 0; i < m; i++) 
            {
                int pos=sc.nextInt();
                int weight=sc.nextInt();
                testcase.add(new data(i+1, weight, pos));
            }
            solve(testcase, n, m);
            System.out.println();
        }
        sc.close();
    }
}