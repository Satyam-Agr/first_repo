//2155 C
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C_The_Ancient_Wizards_Capes {
    static int solve(int[] visible, int n)
    {
        byte[] capes=new byte[n];// L==1, R==2
        boolean allSame=true;
        for (int i = 0; i < n-1; i++) 
        {
            int diff=visible[i]-visible[i+1];
            if(diff==0)
            {
                if(capes[i]==1)
                {
                    if(capes[i+1]==1)
                        return 0;
                    capes[i+1]=2;
                }
                else if(capes[i]==2)
                {
                    if(capes[i+1]==2)
                        return 0;
                    capes[i+1]=1;
                }
            }
            else if(diff==1)
            {
                allSame=false;
                if(capes[i]==1||capes[i+1]==1)
                    return 0;

                capes[i]=2;
                capes[i+1]=2;
            }
            else if(diff==-1)
            {
                allSame=false;
                if(capes[i]==2 || capes[i+1]==2)
                    return 0;

                capes[i]=1;
                capes[i+1]=1;
            }
            else
                return 0;
        }
        if(allSame)
        {
            if(n%2==0 && (visible[0]==n/2 || visible[0]==n/2+1))
                return 1;
            else if(n%2==1 && visible[0]==n/2+1)
                return 2;
            else
                return 0;
        }
        int lastVisible=0;
        for (int i = n-2; i >= 0; i--) 
        {
            if(capes[i]==1)
                lastVisible++;
            else if(capes[i]==0)
            {
                if(i%2==1)
                    lastVisible+=(i+1)/2;
                else
                {
                    if(capes[i+1]==1)
                        lastVisible+=i/2;
                    else
                        lastVisible+=(i/2)+1;
                }
                break;
            }
        }
        if(visible[n-1]==++lastVisible)
            return 1;
        else
            return 0;
    }
    public static void main(String[] args) throws Exception
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0)
    {
        int n = Integer.parseInt(br.readLine());
        int[] visible = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            visible[i] = Integer.parseInt(st.nextToken());
        sb.append(solve(visible, n)).append('\n');
    }
    System.out.print(sb.toString());
}

}