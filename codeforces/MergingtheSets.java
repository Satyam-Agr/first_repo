/*You are given n
 sets S1,S2,…,Sn
, where each element in the sets is an integer between 1
 and m
.

You want to choose some of the sets (possibly none or all), such that every integer between 1
 and m
 is included in at least one of the chosen sets.

You have to determine whether there exist at least three ways to choose the sets.

Input
Each test contains multiple test cases. The first line contains the number of test cases t
 (1≤t≤104
). The description of the test cases follows.

The first line of each test case contains two integers n
 and m
 (2≤n≤5⋅104
, 1≤m≤105
) — the number of sets and the upper bound of the integers in the sets.

Then n
 lines follow, the i
-th line first containing an integer li
 (1≤li≤m
) — the size of set Si
.

Then li
 integers Si,1,Si,2,…,Si,li
 follow in the same line (1≤Si,1<Si,2<⋯<Si,li≤m
) — the elements of set Si
.

Let L=∑i=1nli
. It is guaranteed that:

The sum of n
 over all test cases does not exceed 5⋅104
;
The sum of m
 over all test cases does not exceed 105
;
The sum of L
 over all test cases does not exceed 2⋅105
.
Output
For each test case, print "YES" if there exist at least three ways to choose the sets. Otherwise, print "NO".

You can output the answer in any case (upper or lower). For example, the strings "yEs", "yes", "Yes", and "YES" will be recognized as positive responses.*/
package first_repo.codeforces;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


public class MergingtheSets {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();      
        for (int i = 0; i < t; i++) {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int [] count = new int[m+1];
            List <HashSet<Integer>> input =new ArrayList<>();
            for (int j = 0; j < n; j++) 
            {
                int size=sc.nextInt();
                HashSet <Integer>currSet=new HashSet<>(); 
                for (int k = 0; k < size; k++) 
                {
                    int current=sc.nextInt();
                    if(currSet.add(current))
                        count[current]++;
                }
                input.add(currSet);
            }
            boolean possible = true;
            for (int x = 1; x <= m; x++) {
                if (count[x] == 0) {
                    possible = false;
                    break;
                }
            }
            if (!possible) {
                System.out.println("NO");
                continue;
            }
            int remSets=0;
            for(HashSet<Integer> currSet: input)
            {
                boolean removable=true;
                for(int current: currSet)
                {
                    if(count[current]<=1)
                    {
                        removable=false;
                        break;
                    }
                }
                if(removable)
                    remSets++;
                if(remSets>=2)
                    break;
            }
            if(remSets>=2)
                System.out.println("YES");
            else
                System.out.println("NO");
                
           
                

        }
        sc.close();
    }
}
