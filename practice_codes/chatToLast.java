package first_repo.practice_codes;
import java.util.*;
public class chatToLast {
// make all the 'x' move to the last of the string
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String input=sc.next()+'|';
		sc.close();
		String[]result = input.split("x");
		for(int i=1;i<result.length;i++)
		{
			result[0]+=result[i];
		}
		result[0]=result[0].substring(0,result[0].length()-1);
		for(int i=1;i<result.length;i++)
		{
			result[0]+='x';
		}
		System.out.println(result[0]);
	}

}
