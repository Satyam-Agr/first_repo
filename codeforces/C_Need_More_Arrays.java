/*Given an array a
 and n
 integers. It is sorted in non-decreasing order, that is, ai≤ai+1
 for all 1≤i<n
.

You can remove any number of elements from the array (including the option of not removing any at all) without changing the order of the remaining elements. After the removals, the following will occur:

a1
 is written to a new array;
if a1+1<a2
, then a2
 is written to a new array; otherwise, a2
 is written to the same array as a1
;
if a2+1<a3
, then a3
 is written to a new array; otherwise, a3
 is written to the same array as a2
;
⋯
For example, if a=[1,2,4,6]
, then:

a1=1
 is written to the new array, resulting in arrays: [1]
;
a1+1=2
, so a2=2
 is added to the existing array, resulting in arrays: [1,2]
;
a2+1=3
, so a3=4
 is written to a new array, resulting in arrays: [1,2]
 and [4]
;
a3+1=5
, so a4=6
 is written to a new array, resulting in arrays: [1,2]
, [4]
, and [6]
.
Your task is to remove elements in such a way that the described algorithm creates as many arrays as possible. If you remove all elements from the array, no new arrays will be created.

Input
The first line of input contains one integer t
 (1≤t≤104
) — the number of test cases.

The first line of each test case contains one integer n
 (1≤n≤2⋅105
) — the length of the array.

The second line of each test case contains n
 integers a1,a2,…,an
 (1≤ai≤106
, ai≤ai+1
) — the elements of the array.

It is guaranteed that the sum of n
 across all test cases does not exceed 2⋅105
.

Output
For each test case, output one integer — the maximum number of arrays that can be obtained by removing any (possibly zero) number of elements.*/
import java.util.Scanner;

public class C_Need_More_Arrays {

    static void solve(int testCase[], int n)
    {
        int count=1;
        int dp=1;
        for (int i = 1; i < n; i++) {
            if(testCase[i] == testCase[i-1]+1)
            {
                dp++;
            }
            else if(testCase[i] > testCase[i-1]+1)
            {
                dp=1;
                count++;
            }
            if(dp == 3)
            {
                dp=1;
                count++;
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int testCase[]=new int[n];
            for (int i = 0; i < n; i++) {
                testCase[i]=sc.nextInt();
            }
            solve(testCase, n);
        }
        sc.close();
    }
}