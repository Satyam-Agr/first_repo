import java.util.Scanner;

class checkSorted
{
    static boolean check(int []arr,int idx)
    {
        if(idx==arr.length-1)
            return true;
        if(arr[idx]>=arr[idx+1])
            return false;
        return check(arr,idx+1);
    }
    public static void main(String args[]) 
    {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
            if(check(arr, 0))
                System.out.println("sorted");
            else
                System.out.println("not sorted");
            sc.close();
    }
}