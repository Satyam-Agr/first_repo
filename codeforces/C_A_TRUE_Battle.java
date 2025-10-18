import java.util.Scanner;

public class C_A_TRUE_Battle {

    static String solve(String bool, int n)
    {
        if(bool.charAt(0)=='1' || bool.charAt(n-1)=='1')
            return "YES";
        for (int i = 1; i < n-2; i++) 
        {
            if(bool.charAt(i)=='1' && bool.charAt(i+1)=='1')
            return "YES";
        }
        return "NO";
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            String bool=sc.next();
            System.out.println(solve(bool, n));
        }
        sc.close();
    }
}