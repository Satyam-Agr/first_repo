package first_repo.codeforces;
import java.util.Scanner;

public class B_Deck_of_Cards {

    static void solve(String action,int n, int k)
    {
        if(k>=n)
        {
            for (int i = 0; i < n; i++) {
                System.out.print('-');
            }
            System.out.println();
            return;
        }
        int top=0;
        int bottom=n-1;
        int both=0;
        for (int i = 0; i < k; i++) {
            if(action.charAt(i)=='0')
                top++;
            else if(action.charAt(i)=='1')
                bottom--;
            else
                both++;
        }
        int maxTop=top+both;
        int maxBottom=bottom-both;
        StringBuilder deck=new StringBuilder();
        for (int i = 0; i < n; i++) 
        {
            if(i<top||i>bottom)
                deck.append('-');
            else if(i<maxTop||i>maxBottom)
                deck.append('?');
            else
                deck.append('+');
        }
        System.out.println(deck);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int k=sc.nextInt();
            String actions=sc.next();
            if(n==1&&k>0)
                System.out.println('-');
            else
                solve(actions, n, k);
        }
        sc.close();
    }
}