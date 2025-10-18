/*There are n
 different types of magical materials, numbered from 1
 to n
. Initially, you have ai
 units of material i
 for each i
 from 1
 to n
. You are allowed to perform the following operation:

Select a material i
 (where 1≤i≤n
). Then, spend 1
 unit of every other material j
 (in other words, j≠i
) to gain 1
 unit of material i
. More formally, after selecting material i
, update array a
 as follows: ai:=ai+1
, and aj:=aj−1
 for all j
 where j≠i
 and 1≤j≤n
. Note that all aj
 must remain non-negative, i.e. you cannot spend resources you do not have.
You are trying to craft an artifact using these materials. To successfully craft the artifact, you must have at least bi
 units of material i
 for each i
 from 1
 to n
. Determine if it is possible to craft the artifact by performing the operation any number of times (including zero).

Input
Each test contains multiple test cases. The first line contains the number of test cases t
 (1≤t≤104
). The description of the test cases follows.

The first line of each test case contains a single integer n
 (2≤n≤2⋅105
) — the number of types of materials.

The second line of each test case contains n
 integers a1,a2,…,an
 (0≤ai≤109
) — the amount of each material i
 that you currently hold.

The third line of each test case contains n
 integers b1,b2,…,bn
 (0≤bi≤109
) — the amount of each material i
 needed to produce the artifact.

It is guaranteed that the sum of n
 over all test cases does not exceed 2⋅105
.

Output
For each test case, print a single line containing either "YES" or "NO", representing whether or not the artifact can be crafted.

You can output the answer in any case (upper or lower). For example, the strings "yEs", "yes", "Yes", and "YES" will be recognized as positive responses.*/
import java.util.Scanner;

public class B_Crafting {

    static void solve(int a[],int b[], int n)
    {
        int min = a[0] - b[0];
        int sMin = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            int diff = a[i] - b[i];
            if (diff <= min) {
            sMin = min;
            min = diff;
            } else if (diff < sMin) {
                sMin = diff;
            }
            if(min+sMin<0)
            {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");   
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int [] a=new int[n];
            int [] b=new int[n];
            for (int i = 0; i < n; i++) {
                a[i]=sc.nextInt();
            }
            for (int i = 0; i < n; i++)
            {
                b[i]=sc.nextInt();
            }
            solve(a, b, n);
        }
        sc.close();
    }
}