/*You are given an array a
 consisting of n
 integers.

For every integer k
 from 1
 to n
, you have to do the following:

choose an arbitrary element of a
 and move it to the right end of the array (you can choose the last element, then the array won't change);
print the sum of k
 last elements of a
;
move the element you've chosen on the first step to its original position (restore the original array a
).
For every k
, you choose the element which you move so that the value you print is the maximum possible.

Calculate the value you print for every k
.

Input
The first line contains one integer t
 (1≤t≤104
) — the number of test cases.

Each test case consists of two lines:

the first line contains one integer n
 (1≤n≤2⋅105
);
the second line contains n
 integers a1,a2,…,an
 (1≤ai≤109
).
Additional constraint on the input: the sum of n
 over all test cases does not exceed 2⋅105
.

Output
For each test case, print n
 integers. The i
-th of these integers should be equal to the maximum value you can print if k=i
.*/
import java.util.Scanner;

public class B_Move_to_the_End {

    static void solve(int[] testCase,int n)
    {
        int[] max=new int[n];
        long sum=0;
        max[0]=testCase[0];
        for (int i = 1; i < n; i++) {
            max[i]=Math.max(max[i-1], testCase[i]);
        }
        for (int i = n-1; i >= 0; i--) {
            sum+=testCase[i];
            System.out.print(sum-testCase[i]+max[i]+ " ");
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int[] testCase=new int[n];
            for (int i = 0; i < n; i++) {
                testCase[i]=sc.nextInt();
            }
            solve(testCase, n);
        }
        sc.close();
    }
}