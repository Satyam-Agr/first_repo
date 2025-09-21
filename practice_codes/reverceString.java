package first_repo.practice_codes;
import java.util.*;
public class reverceString 
{
	static void rev(String line,int pos)
	{
		if(pos==-1)
			return;
		System.out.print(line.charAt(pos));
		rev(line,pos-1);
	}
	static String getRev(String line,String revString,int pos)
	{
		if(pos==-1)
			return revString ;
		revString+=getRev(line,""+line.charAt(pos),pos-1);
		return revString;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String line=sc.nextLine();
		sc.close();
		rev(line,line.length()-1);
		
		System.out.print("\n"+getRev(line,"",line.length()-1));
	}
}
