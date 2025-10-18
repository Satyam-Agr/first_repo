import java.util.*;
import java.io.*;
public class D_MAD_Interactive_Problem {
    static Scanner sc=new Scanner(System.in);
    static int printQuere(LinkedList<Integer> quere)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("? "+quere.size()+" ");
        for (int idx: quere) 
        {
            sb.append(idx).append(' ');
        }
        System.out.println(sb.toString());
        System.out.flush();
        return sc.nextInt();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr=new int[2*n];
            LinkedList<Integer> quere=new LinkedList<>();
            LinkedList<Integer> quere2=new LinkedList<>();
            for (int i = 1; i <= 2*n; i++) 
            {
                quere.add(i);
                int verdict=printQuere(quere);
                if(verdict!=0)
                {
                    arr[i-1]=verdict;
                    quere2.add(quere.removeLast());
                }

            }
            for (int i = 0; i < n*2; i++) 
            {
                if(arr[i]==0)
                {
                    quere2.add(i+1);
                    arr[i]=printQuere(quere2);
                    quere2.removeLast();
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("! ");
            for (int i = 0; i < 2*n; i++) 
            {
                sb.append(arr[i]).append(' ');
            }
            System.out.println(sb.toString());
            System.out.flush();
        }
    }
}