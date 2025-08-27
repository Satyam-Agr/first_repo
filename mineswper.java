import java.util.*;
public class mineswper 
{
	int []pos;
	int []mines;
	int rowSize;
	int colSize;
	int level;
	mineswper(int level)
	{
		if(level==2)
		{
			this.pos=new int[256];
			this.mines=new int[40];
			this.level=level;
			this.rowSize=16;
			this.colSize=16;
		}
		else if(level==3)
		{
			this.pos=new int[480];
			this.mines=new int[99];
			this.level=level;
			this.rowSize=30;
			this.colSize=16;
		}
		else
		{
			this.pos=new int[81];
			this.mines=new int[10];
			this.level=1;
			this.rowSize=9;
			this.colSize=9;
		}
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the level");
		int level=sc.nextInt();
		mineswper game=new mineswper(level);
		game.setUp();
		for(int i=0;i<game.rowSize;i++)
		{
			for(int j=0;j<game.colSize;j++)
			{
				System.out.print(game.pos[i*game.colSize+j]+" ");
			}
			System.out.println("");
		}
		sc.close();
	}
	//set up(s)
	void setUp()
	{
		Set<Integer> mineSet = new HashSet<>();
		Random gen=new Random();
		for(int i=0;i < this.mines.length;i++)
		{
			mineSet.add(gen.nextInt(this.pos.length));
		}
		while (mineSet.size() < this.mines.length) 
		{
			System.out.println("Repeat");
		    mineSet.add(gen.nextInt(this.pos.length));
		}
		this.mines = mineSet.stream().mapToInt(Integer::intValue).toArray();
		for(int minePos:this.mines)
		{
			int row=minePos/this.colSize;
			int col=minePos%this.colSize;
			/*
			(-1,-1) (-1,0) (-1,+1)
			( 0,-1)        ( 0,+1)
			(+1,-1) (+1,0) (+1,+1)
			*/
			final int[] dRow = {-1,-1,-1,0,0,1,1,1};
			final int[] dCol = {-1,0,1,-1,1,-1,0,1};
			for (int k = 0; k < 8; k++) 
			{
			    int nr = row + dRow[k];
			    int nc = col + dCol[k];
			    if (nr >= 0 && nr < rowSize && nc >= 0 && nc < colSize) 
			    {
			        pos[nr*colSize + nc]++;
			    }
			}
		}
		for(int minePos:mines)
		{
			pos[minePos]=9;
		}
		
	}
	//helpers
}
