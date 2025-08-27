import java.util.*;
public class recTower 
{
	static void tower(int n,String scr,String help,String dis)
	{
		if(n==1)
		{
			System.out.println("transfer disk "+n+" from "+scr+" to "+dis);
			return;
		}
		tower(n-1,scr,dis,help);
		System.out.println("transfer disk "+n+" from "+scr+" to "+dis);
		tower(n-1,help,scr,dis);
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();			
		tower(n, "Scorce","Helper","Destenation");
	}
}
