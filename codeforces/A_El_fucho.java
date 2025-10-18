import java.util.Scanner;

public class A_El_fucho {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            long matches=0;
            int loses=0;
            while(n>=2){
                matches+=n/2+loses/2;
                loses-=loses/2;
                loses+=n/2;
                n-=n/2;
            }
            while (loses>=2) {
                matches+=loses/2;
                loses-=loses/2;
            }
            System.out.println(matches+1);
        }
        sc.close();
    }
}