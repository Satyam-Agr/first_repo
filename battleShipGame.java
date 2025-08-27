//High Score-10 VineetA
package first_repo;
import java.util.*;

class setship
{
	generate gen=new generate();
	String names1[]= {"Navi","Vikrant","Jalvir"};
	String names2[]= {"Alpha","Prime","Ranger"};
	String name;
	ArrayList<String> loc=new ArrayList<>();
	static ArrayList<String> heap=new ArrayList<>();
	void setname(String n)
	{
		name=n;
	}
	void setloc()
	{
		
		ArrayList<String> temp=new ArrayList<>();
		boolean clone=false;
		do
		{
			temp=gen.potition();			
			clone=false;
			for (String s:heap)
			{
				for (String st:temp)
				{
					if (s.equals(st))
						clone=true;
				}
			}
		}
		while(clone);
		loc=temp;
		heap.addAll(temp);
	}
}
class game
{	
	setship[]p1=new setship[3];
	setship[]p2=new setship[3];
	long noofguess=0;
	static byte kills1=0;
	static byte kills2=0;
	
	void run1()
	{
		for(int i=0;i<3;i++)
		{
			p1[i]=new setship();
			p1[i].setname(p1[i].names1[i]);
			p1[i].setloc();
		}
		System.out.println("your goal is to sink all the ship by guessing there location");
		System.out.println("");
		System.out.println("this has 7X7 tiles named from A1 to G7");
		dynamic1();
	}
	
	void run2()
	{
		for(int i=0;i<3;i++)
		{
			p1[i]=new setship();
			p1[i].setname(p1[i].names1[i]);
			p1[i].setloc();
		}
		for(int i=0;i<3;i++)
		{
			p2[i]=new setship();
			p2[i].setname(p2[i].names2[i]);
			p2[i].setloc();
		}
		System.out.println("your goal is to sink all the ship by guessing there location before your own ships are distroyed by the other player");
		System.out.println("");
		System.out.println("this has 7X7 tiles named from A1 to G7");
		dynamic2();
	}
	void dynamic1()
	{
		boolean continu=true;
		while (continu)
		{
			System.out.print("Enter your guess:- ");
			String guess=input();
			System.out.println("");
			check1(guess);
			if (kills1==3||guess.equals("mastercontrole_end"))
			{
				continu=false;
			}	
		
			noofguess++;
	    }
		System.out.println("You won the game in "+noofguess+" moves");
	}
	void dynamic2()
	{
		boolean player1=true;
		boolean continu=true;
		noofguess++;
		while (continu)
		{
			noofguess++;
			if (player1)
			{
				System.out.print("Player 1 enter your guess:- ");
				String guess=input();
				System.out.println("");
				check1(guess);
				if (kills1==3||guess.equals("mastercontrole_end"))
				{
					continu=false;
					System.out.println("Player 1 won the game in "+noofguess/2+" moves");
				}
				player1=false;
			}
			else
			{
				System.out.print("player 2 enter your guess:- ");
				String guess=input();
				System.out.println("");
				check2(guess);
				if (kills2==3||guess.equals("mastercontrole_end"))
				{
					continu=false;
					System.out.println("Player 2 won the game in "+noofguess/2+" moves");
				}
				player1=true;
			}
			;			
	    }
	}
	String input()
	{
		Scanner sc=new Scanner(System.in);
		String st=null;
		char ch='\u0000';
		String block=null;
		boolean retry=true;
		do
		{
			st=sc.nextLine();
			for(int i=65;i<72;i++)
			{
				for (int j=1;j<8;j++)
				{
					ch=(char)i;
					block=ch+String.valueOf(j);
					if (st.equals(block)||st.equals("mastercontrole_end"))
					{
						retry=false;
						break;						
					}					
				}
				if (!retry)
					break;
			}
			if (!retry)
				break;
			System.out.println("Wrong input. Enter a valid coordinate");
			
		}
		while(retry);
		return st;
	}
	
	void check1(String g)
	{
		String result="miss";
		for (int i=0;i<3;i++)
		{			
				int index=p1[i].loc.indexOf(g);
				if (index>=0)
				{
					System.out.print(p1[i].name+" is ");
					result="hit";
					p1[i].loc.remove(index);
					if(p1[i].loc.isEmpty())
					{
						result="killed";
						kills1++;						
					}
				}
			
		}
		System.out.println(result);
	}
	void check2(String g)
	{
		String result="miss";
		for (int i=0;i<3;i++)
		{			
				int index=p2[i].loc.indexOf(g);
				if (index>=0)
				{
					System.out.print(p2[i].name+" is ");
					result="hit";
					p2[i].loc.remove(index);
					if(p2[i].loc.isEmpty())
					{
						result="killed";
						kills2++;						
					}
				}
			
		}
		System.out.println(result);
	}
}

class generate
{
	ArrayList<String> potition()
	{
		ArrayList<String> ranLoc = new ArrayList<>();
		double ran1=Math.random()*2;
		byte orientation=(byte) ran1;
		
		ran1=Math.random()*7;
		byte full=(byte)ran1;
		ran1=Math.random()*5;
		byte partial=(byte)ran1;
		char row='\u0000';
		String loc=null;
		if (orientation==0)
		{
			full+=65;
			row=(char)full;
			for (int i=0;i<3;i++)
			{				
				partial++;
				loc=row+String.valueOf(partial);
				ranLoc.add(loc);
			}
		}
		else
		{
			partial+=65;
			full++;
			for (int i=0;i<3;i++)
			{
				row=(char)partial;
				partial++;
				loc=row+String.valueOf(full);
				ranLoc.add(loc);
			}
		}
		return ranLoc;
	}
}
public class battleShipGame
{

	public static void main(String[] args) 
	{
		game ghjkl=new game();
		System.out.println("Choose the play type:Enter 'A1' for multiplayer or any thing else for singleplayer");
		String sg=ghjkl.input();
		if (sg.equals("A1"))
        ghjkl.run2();
		else
			ghjkl.run1();
	}

}
