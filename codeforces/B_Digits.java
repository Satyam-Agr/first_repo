/*Artem wrote the digit d on the board exactly n! times in a row. So, he got the number dddddd…ddd
(exactly n! digits).
Now he is curious about which odd digits from 1 to 9 divide the number written on the board.
Input
The first line contains a single integer t (1≤t≤100 the number of test cases. The next t
 test cases follow.
Each test case consists of a single line containing two integers n and d (2≤n≤109, 1≤d≤9).
Output
For each test case, output the odd digits in ascending order that divide the number written on the board*/
import java.util.Scanner;

public class B_Digits {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int d=sc.nextInt();
            System.out.print("1 ");
            if(n>=3||d%3==0)
                System.out.print("3 ");
            if(d%5==0)
                System.out.print("5 ");
            if(n>=3||d%7==0)
                System.out.print("7 ");
            if(d%9==0 || n>=6 || (n>=3 && d%3==0))
                System.out.print("9 ");
            System.out.println();
        }
        sc.close();
    }
}