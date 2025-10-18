/*
Recall that a permutation of length nis a sequence of length n such that each integer from 1 to n appears in it exactly once.

Let's define the cost of a permutation as the minimum length of its contiguous subsegment (possibly empty) that needs to be sorted so that the entire permutation becomes sorted in ascending order.

You are given an integer array p consisting of integers from 0 to n
, where no positive (strictly greater than zero) integer appears more than once. You should replace zeros with integers so that the array p becomes a permutation.

Your task is to calculate the maximum possible cost of the resulting permutation.

Input
The first line contains a single integer t (1≤t≤10^4) — the number of test cases.

The first line of each test case contains a single integer n(1≤n≤2*10^5).

The second line contains n integers p1,p2,…,pn (0≤pi≤n). No positive integer appears more than once in this sequence.

Additional constraint on the input: the sum of n
over all test cases doesn't exceed 2⋅105
.

Output
For each test case, print a single integer — the maximum possible cost of the resulting permutation. * 
*/
package first_repo.codeforces;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MaximumCostPermutation {
    static void maxCost(int [][] cases,int [] result)
    {
        for (int i = 0; i < cases.length; i++)   
        {
            Deque <Integer> zidx=new ArrayDeque<>();
            Set <Integer> numPresent = new HashSet<>();
            int start=-1,end=-1;
            for(int j=0; j < cases[i].length ; j++)
            {
                numPresent.add(cases[i][j]);
                if(cases[i][j] == 0)
                {
                    zidx.offerLast(j);
                }
            }
            for(int j=cases[i].length; j > 0 && (!zidx.isEmpty()) ; j--)
            {
                if(!numPresent.contains(j))
                {
                    cases[i][zidx.pollFirst()]=j;
                }
            }
            for(int j=0; j < cases[i].length ; j++)
            {
                if(cases[i][j]!=j+1)
                {
                    if(start==-1)
                    {
                        start=j;
                        end=j;
                    }
                    else
                    {
                        end=j;
                    }
                }
            }
            if(start==-1)
                result[i]=0;
            else
                result[i]=end-start+1;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        int cases[][]=new int[t][]; 
        int result[]=new int[t];       
        for (int i = 0; i < t; i++) {
            int n=sc.nextInt();
            cases[i]=new int[n];
            for (int j = 0; j < n; j++) 
            {
                cases[i][j]=sc.nextInt();
            }
        }
        sc.close();
        maxCost(cases,result);
        for (int i = 0; i < t; i++) 
        {
            System.out.println(result[i]);
        }
    }
}
