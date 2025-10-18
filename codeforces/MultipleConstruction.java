/*You are given an integer n
. Your task is to construct an array of length 2⋅n such that:

Each integer from 1 to n appears exactly twice in the array.
For each integer x (1≤x≤n), the distance between the two occurrences of x is a multiple of x. In other words, if px and qx are the indices of the two occurrences of x, |qx−px| must be divisible by x.
It can be shown that a solution always exists.

Input
Each test contains multiple test cases. The first line contains the number of test cases t (1≤t≤104). The description of the test cases follows.
Each of the next t lines contains a single integer n (1≤n≤2⋅105).
It is guaranteed that the sum of n over all test cases does not exceed 2⋅105.
Output
For each test case, print a line containing 2⋅n integers — the array that satisfies the given conditions.

If there are multiple valid answers, print any of them.
*/
package first_repo.codeforces;

import java.util.Scanner;

public class MultipleConstruction
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();      
        for (int i = 0; i < t; i++) {
            int n=sc.nextInt();
            int [] arr=new int[n*2];
            for (int j = n; j > 0; j--)
            {
                arr[n-j]=j;
                int k=1;
                while(arr[(n-j)+(k*j)]!=0)
                    k++;
                arr[(n-j)+(k*j)]=j;

            } 
            for (int current: arr) 
            {
                System.out.print(current+" ");
            }
            System.out.println("");
        }
        sc.close();
    }
}