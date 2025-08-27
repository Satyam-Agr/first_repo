package first_repo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
//All the coins
class Coin
{
	private int homeIndex;
	private int extra;//the starting pos of the coin in the track
	private int pos;
	private String name;
	//constructor
	Coin(String name,int homeIndex,int extra)
	{
		this.name=name;
		this.homeIndex=homeIndex;
		this.extra=(extra==0)?52:extra;
		this.pos=0;
	}
	String getLabel()
	{
		return this.name;
	}
	int getExtra()
	{
		return this.extra;
	}
	int getHomeIndex()
	{
		return this.homeIndex;
	}
	int getPos()
	{
		return this.pos;
	}
	void setPos(int newPos)
	{
		this.pos=newPos;
	}
}
//the game also have the main method
public class LUDO {
	//size of the board
    private static final int SIZE = 15;
    //the random class's object
    private static final Random random = new Random();
    //the dice button and its value
    private static JButton diceButton;
    private static int diceRoll = 0;
    //the List of all the JList(s)
    private static java.util.List<JList<String>> pathCells = new ArrayList<>();
    //the index value of pathCells where different thing are
    static final int []homePos= {3,4,16,17,8,9,21,22,78,79,91,92,73,74,86,87};
    static final int[]track= {-1,27,28,29,30,31,
    						23,18,13,10,5,0,
				    		1,2,7,12,15,20,25,
				    		35,36,37,38,39,40,
				    		54,69,68,67,66,65,64,
				    		72,77,82,85,90,95,
				    		94,93,88,83,80,75,70,
				    		60,59,58,57,56,55,
				    		41,26};
    static final int[]offTrack= {-1,42,43,44,45,46,47,6,11,14,19,24,33,53,52,51,50,49,48,89,84,81,76,71,62};
    static final int[]display= {32,34,63,61};
    static final Color[] colors= {Color.RED,Color.GREEN,Color.YELLOW,Color.BLUE};
    //all the safe blocks
    static final boolean isSafe[] = {
							    false,true,false,false,false,false,
							    false,false,false,true,false,false,
							    false,false,true,false,false,false,false,
							    false,false,false,true,false,false,
							    false,false,true,false,false,false,false,
							    false,false,false,true,false,false,
							    false,false,true,false,false,false,false,
							    false,false,false,true,false,false,
							    false,false};
    //names of all the coins
    static final List<String> coinLabels= List.of("R1","R2","R3","R4","G1","G2","G3","G4","Y1","Y2","Y3","Y4","B1","B2","B3","B4");
    //tracks the coins at different locations
    static int [] atHome= {4,4,4,4};
    static int[] atFinish= {0,0,0,0};
    // give the object of the coin with the given name
    private static Map<String, Coin> coinObjectOf = new HashMap<>();
    //tells which coins are possible to move in the current turn and if it captures any coin or not
    static List<String> possibleCoins;
    static Map <String, Boolean> coinCaptured;
    //a global object of this class
    static LUDO game = new LUDO();
    //tells which player is currently playing
    static int player=1;
    static int winner=0;
    //the main method
    public static void main(String[] args) 
    {
    	System.out.println("Player 1 start the game by rolling the dice");
        SwingUtilities.invokeLater(() -> {
            game.GUISetup();
            ((DefaultListModel<String>)pathCells.get(display[player-1]).getModel()).addElement("P"+player);
            game.SetupCoin();
        });
    }
    //the dice is rolled and the turn starts
    public void rollTheDice()
    {
		if(diceRoll==0)
		{
            diceRoll = random.nextInt(6) + 1;
            diceButton.setText(Integer.toString(diceRoll));
            System.out.printf("Player %d rolled the number: %d\n",player,diceRoll);
            //JOptionPane.showMessageDialog(null, "Dice rolled: " + diceRoll);
            if(noMoveExist())
            {
            	System.out.printf("Player %d has no posible move\n",player);
            	((DefaultListModel<String>)pathCells.get(display[player-1]).getModel()).clear();;
            	player=nextPlayer();            	
            	((DefaultListModel<String>)pathCells.get(display[player-1]).getModel()).addElement("P"+player);
            	System.out.printf("Player %d roll the dice\n",player);
            	diceRoll=0;
            	return;
            }
            else
            {
            	System.out.println("Player "+player+" select a coin to move");
            }
        }
    }
    // the selected coin is moved if possible
    public void moveCoin(JList<String> list) 
    {
    if (diceRoll == 0) 
    {
    	list.clearSelection();
    	return; // only works after a dice roll
    }                   
    String coin = list.getSelectedValue();
    boolean next=false;
    if (coin != null) {
    	if(possibleCoins.contains(coin))//check if the selected coin can move or not
    	{
        	((DefaultListModel<String>) list.getModel()).removeElement(coin);
        	Coin movingCoin=coinObjectOf.get(coin);
        	int currentPos=movingCoin.getPos();
        	int newPos=nextPos(movingCoin);
        	if(currentPos==0)//from home to track
        	{
        		atHome[player-1]--;
        	}
        	if(newPos==(0-player*6))//to the finish
        	{
        		atFinish[player-1]++;
        		if(atFinish[player-1]==4)
        		{
        			winner=player;
        			 JOptionPane.showMessageDialog(null, "🏆 Player " + winner + " wins the game!");
        			 // Disable dice and prevent further moves
        			 diceButton.setEnabled(false);
        			 for(JList<String> cell : pathCells) {
        				 cell.setEnabled(false);
        	    	}
        		}
        	}
        	movingCoin.setPos(newPos);
        	//decide where the coin should go next
        	DefaultListModel<String> model;
        	if(newPos>0)
        	{
        		model=((DefaultListModel<String>)pathCells.get(track[newPos]).getModel());
        	}
        	else
        	{
        		model=((DefaultListModel<String>)pathCells.get(offTrack[0-newPos]).getModel());
        	}
        	//if there is a coin in the new position capture that coin
        	if(coinCaptured.get(coin))
        	{
        		Coin captured=coinObjectOf.get(model.get(0));
        		atHome[(coinLabels.indexOf(captured.getLabel()))/4]++;
        		captured.setPos(0);
        		
        		((DefaultListModel<String>)pathCells.get(captured.getHomeIndex()).getModel()).addElement(captured.getLabel());
        		model.clear();	                    	
        	}
        	model.addElement(coin);
            System.out.println("Selected coin: " + coin); 
            next=true;//to prevent next dice roll before a coin is moved
        }
    	else
    		list.clearSelection();
    }
    if(next)
    {
    	//give another chance or move to next player
    	if (diceRoll != 6) {
    	    diceRoll = 0;
    	    ((DefaultListModel<String>)pathCells.get(display[player-1]).getModel()).clear();
    	    player=nextPlayer();
    	    ((DefaultListModel<String>)pathCells.get(display[player-1]).getModel()).addElement("P"+player);
        	System.out.printf("Player %d roll the dice\n",player);
    	} 
    	else {
    	    
    	    diceRoll = 0;  
    	    System.out.printf("Player %d gets another chance!\n",player);
    	}
        return;
    }
}
    // sets up GUI
    public void GUISetup() 
    {
        JFrame frame = new JFrame("Ludo Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(new GridLayout(SIZE, SIZE));

        // Center dice button
        diceButton = new JButton("D");

        // Fill board
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                // Top-left house (Red)
            	if (i < 6 && j < 6) {
                	 if ((i == 1 && j == 1) || (i == 1 && j == 4) || (i == 4 && j == 1) || (i == 4 && j == 4)) {                		 
                         frame.add(new JScrollPane(makeList(Color.RED)));
                     } 
                	 else {
                         frame.add(coloredPanel(Color.RED));
                     }
                }
                // Top-right house (Green)
                else if (i < 6 && j > 8) {
                	if ((i == 1 && j == 10) || (i == 1 && j == 13) || (i == 4 && j == 10) || (i == 4 && j == 13)) {
                        frame.add(new JScrollPane(makeList(Color.GREEN)));
                    } else {
                        frame.add(coloredPanel(Color.GREEN));
                    }
                }
                // Bottom-left house (Blue)
                else if (i > 8 && j < 6) {
                	 if ((i == 10 && j == 1) || (i == 10 && j == 4) || (i == 13 && j == 1) || (i == 13 && j == 4)) {
                         frame.add(new JScrollPane(makeList(Color.BLUE)));
                     } else {
                         frame.add(coloredPanel(Color.BLUE));
                     }
                }
                // Bottom-right house (Yellow)
                else if (i > 8 && j > 8) {
                	if ((i == 10 && j == 10) || (i == 10 && j == 13) || (i == 13 && j == 10) || (i == 13 && j == 13)) {
                        frame.add(new JScrollPane(makeList(Color.YELLOW)));
                    } else {
                        frame.add(coloredPanel(Color.YELLOW));
                    }
                }
                // Center dice block
                else if (i == 7 && j == 7) {
                    frame.add(diceButton);
                    }

                else {
                    frame.add(new JScrollPane(makeList(null)));
                }
            }
        }
        for(int i=1;i<=24;i++)
        {
        	pathCells.get(offTrack[i]).setBackground(colors[(i-1)/6]);
        }
        for(int i=0;i<4;i++)
        {
        	pathCells.get(track[(i*13)+1]).setBackground(colors[i]);
        	pathCells.get(track[(i*13)+9]).setBackground(Color.LIGHT_GRAY);
        	//pathCells.get(display[i]).setBackground(Color.GRAY);
        	
        }
        //listener for the dice and coin selection 
        diceButton.addActionListener(e -> rollTheDice());
        for (JList<String> list : pathCells) {
            list.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JList<String> clickedList = (JList<String>) e.getSource();
                    moveCoin(clickedList);
                }
            });
        }
        frame.setVisible(true);
    }
    //coins setup
    //set up coins
    public void SetupCoin()
    {
		for (int i=0;i<16;i++)
		{
			String label=coinLabels.get(i);
			coinObjectOf.put(label,(new Coin(label,homePos[i],(i/4)*13)));//makes the map of all the coin by there label
			((DefaultListModel<String>)pathCells.get(homePos[i]).getModel()).addElement(label);//add the label to it's home position 
		}
    }
    //helper method to tell if any move is possible or not
    // all the helper methods
    public boolean noMoveExist()
    {
    	boolean noExist=true;
    	possibleCoins=new ArrayList<>();
    	coinCaptured=new HashMap<>();
    	if(diceRoll!=6&&atHome[player-1]+atFinish[player-1]==4)
    		return true;
    	for(int i=0;i<4;i++)
    	{
    		if(movePossible(coinLabels.get(((player-1)*4)+i)))
    			noExist=false;
    	}
    	return noExist;
    }
    //helper method to tell if this move is possible or not and it a coin is captured
    public boolean movePossible(String lable)
    {
    	Coin movingCoin=coinObjectOf.get(lable);
    	int newPos=nextPos(movingCoin);
    	if(newPos==movingCoin.getPos())//if it is has gone beyond the offTrack index of the given player
    		return false;
    	if(newPos>=0) {
	    	if(isSafe[newPos])
	    	{
	    		possibleCoins.add(lable);
	    		coinCaptured.put(lable, false);
	    		return true;
	    	}
    	}
    	else {
    		possibleCoins.add(lable);
    		coinCaptured.put(lable, false);
    		return true;
    	}
    	DefaultListModel<String> model;
    	if(newPos>0)
    	{
    		model=((DefaultListModel<String>)pathCells.get(track[newPos]).getModel());
    	}
    	else
    	{
    		model=((DefaultListModel<String>)pathCells.get(offTrack[0-newPos]).getModel());
    	}
    	if(model.getSize()==0)//next block is empty
    	{
    		possibleCoins.add(lable);
    		coinCaptured.put(lable, false);
    		return true;
    	}
    	else if(model.get(0).charAt(0)==lable.charAt(0))//the coin present is of the same player
    	{
    		possibleCoins.add(lable);
    		coinCaptured.put(lable, false);
    		return true;
    	}
    	else if(model.getSize()==1)//the only capture condition
    	{
    		possibleCoins.add(lable);
    		coinCaptured.put(lable, true);
    		return true;
    	}
    	else if(model.getSize()>1)//more than 1 coin of another player
    	{
    		return false;
    	}
    	else
    	{
    		for(int i=0;i<5;i++)
    			System.out.println("check the movePossible method");
    	}
    	return false;
    }
    //helper method to find the next position of the moving coin
    int nextPos(Coin movingCoin) 
    {
        int currentPos = movingCoin.getPos();
        // at home
        if (currentPos == 0) {
            return (diceRoll == 6) ? ((movingCoin.getExtra() % 52) + 1) : 0;
        }
        // On the track
        if (currentPos > 0) 
        {
            int offTrackPos = 51 - ((currentPos + 52 - movingCoin.getExtra()) % 52) - diceRoll;
            if (offTrackPos < 0) 
            {
                // Entering this player's finish lane
                return offTrackPos - ((player - 1) * 6);
            }
            int newPos = currentPos + diceRoll;
            return (newPos > 52) ? newPos - 52 : newPos;
        }
        //at off track
        int newPos = currentPos - diceRoll;
        return (newPos >= (0 - player * 6)) ? newPos : currentPos; // exact finish required
    }
    //helper methods to tell the next and last player according to the number of players
    public int nextPlayer()
    {
    	return (player==4) ? 1:player+1;
    }
    //helper method for background
    private static JPanel coloredPanel(Color c) 
    {
        JPanel panel = new JPanel();
        panel.setBackground(c);
        return panel;
    }
    private static JList<String> makeList(Color c)
    {
    	DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> list = new JList<>(model);
        list.setBackground(c);
        list.setVisibleRowCount(1);
        pathCells.add(list);
        return list;
    }
}

