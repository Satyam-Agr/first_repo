import java.util.Scanner;

public class C_Even_Larger {

    static void solve(int [] testCase, int n)
    {
        long moveCount=0;
        for (int i = 1; i < n-1; i+=2) {
            if(testCase[i-1]>testCase[i])
            {
                moveCount+=testCase[i-1]-testCase[i];
                testCase[i-1]=testCase[i];
            }
            if(testCase[i+1]>testCase[i]-testCase[i-1])
            {
                moveCount+=testCase[i+1]+testCase[i-1]-testCase[i];
                testCase[i+1]=testCase[i]-testCase[i-1];
            }
        }
        if(n%2==0&&testCase[n-2]>testCase[n-1])
            moveCount+=testCase[n-2]-testCase[n-1];
        System.out.println(moveCount);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n=sc.nextInt();
            int[] testCase=new int[n];
            for (int j = 0; j < n; j++) {
                testCase[j]=sc.nextInt();
            }
            solve(testCase, n);
        }
        sc.close();
    }  
}