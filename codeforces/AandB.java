/*Given a string s
 of length n
, consisting only of the characters 'a' and 'b'.

In one operation, you can choose a position i
 (1≤i≤n−1
) and swap the neighboring characters si
 and si+1
.

You need to perform the minimum number of operations to ensure that all characters of one type (either a
 or b
) are located strictly together, forming exactly one continuous block.

Characters of the other type can be positioned either before or after this block, forming two (possibly empty) blocks.

Examples of valid final forms:

'aaabbbaaa' — all 'b's are located together (one block), 'a's can be both before and after this block;
'bbbaaaaaabbb' — all 'a's together, 'b's are at the edges of the string;
'aaaaabbbb' or 'bbbbaaaaa' — both types of characters form one continuous block each.
You need to find the minimum number of described operations required to achieve the specified state.

Input
Each test consists of several test cases.

The first line contains one integer t
 (1≤t≤104
) — the number of test cases. The description of test cases follows.

The first line of each test case contains one integer n
 (1≤n≤2⋅105
) — the length of the string s
.

The second line contains the string s
 of length n
, consisting only of the characters 'a' and 'b'.

It is guaranteed that the sum of the values of n
 over all test cases does not exceed 2⋅105
.

Output
For each test case, output one integer — the minimum number of operations required for all characters of one of the two types to form a single continuous block.*/
package first_repo.codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AandB {
    static long minMoves(int[] pos, int n)
    {
        int median=pos[n/2];
        long moves=0;
        for(int i=0;i<n;i++)
            moves+=(long)Math.abs(pos[i]-median);
        return moves;
    }
    static void solve(List<String> cases) {
        // you will complete this method
        for(String testCase : cases)
        {
            int n=testCase.length();
            int an=0;
            int bn=0;
            int[] aPos=new int[n];
            int[] bPos=new int[n];
            for(int i=0 ;i<n;i++)
            {
                if(testCase.charAt(i)=='a')
                    aPos[an++]=i-an;
                else
                    bPos[bn++]=i-bn;
            }
            System.out.println(Math.min(minMoves(bPos, bn), minMoves(aPos, an)));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<String> cases = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            sc.nextInt();
            String s = sc.next();
            cases.add(s);
        }
        sc.close();
        solve(cases);
    }   
}
