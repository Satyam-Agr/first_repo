package first_repo.codeforces;
/*You are given an array of n
 positive integers a1,a2,…,an
 and a positive integer k
.

In one operation, you may add either 0
 or k
 to each ai
, i.e., choose another array of n
 integers b1,b2,…,bn
 where each bi
 is either 0
 or k
, and update ai
 to ai+bi
 for 1≤i≤n
. Note that you can choose different values for each element of the array b
.

Your task is to perform at most k
 such operations to make gcd(a1,a2,…,an)>1
 ∗
. It can be proved that this is always possible.

Output the final array after the operations. You do not have to output the operations themselves.

∗
gcd(a1,a2,…,an)
 denotes the greatest common divisor (GCD) of a1,a2,…,an
.

Input
Each test contains multiple test cases. The first line contains the number of test cases t
 (1≤t≤1000
). The description of the test cases follows.

The first line of each test case contains two integers n
 and k
 (1≤n≤105
, 1≤k≤109
) — the length of the array a
 and the given constant.

The second line of each test case contains n
 integers a1,a2,…,an
 (1≤ai≤109
) — the elements of the array a
.

It is guaranteed that the sum of n
 over all test cases does not exceed 105
.

Output
For each test case, output an array of n
 integers in a new line — the final array after the operations. The integers in the output should be within the range from 1
 to 109+k2
.

If there are multiple valid outputs, you can output any of them.

Note that you do not have to minimize the number of operations.*/
import java.util.Scanner;

public class B_Add_0_or_K {

    static void solve(long[] testcase,int n, int k)
    {
        int g=0;
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        for (int p : primes)
            if (k % p != 0)
            {
                g=p;
                break;
            }
        for (int i = 0; i < n; i++) 
        {
            if(testcase[i]==0)
                testcase[i]+=k;
            while (testcase[i]%g!=0) {
                testcase[i]+=k;
            }
        }
        
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int k=sc.nextInt();
            long[] testcase=new long[n];
            for (int i = 0; i < n; i++) 
            {
                testcase[i] = sc.nextInt();
            }
            solve(testcase, n, k);
            for (long i : testcase) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}