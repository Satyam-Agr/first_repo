package first_repo.codeforces;
/*Alice and Bob are playing a game. They have n
 cards numbered from 1
 to n
. At the beginning of the game, some of these cards are given to Alice, and the rest are given to Bob.

Card with number i
 beats card with number j
 if and only if i>j
, with one exception: card 1
 beats card n
.

The game continues as long as each player has at least one card. During each turn, the following occurs:

Alice chooses one of her cards and places it face up on the table;
Bob, seeing Alice's card, chooses one of his cards and places it face up on the table;
if Alice's card beats Bob's card, both cards are taken by Alice. Otherwise, both cards are taken by Bob.
A player can use a card that they have taken during one of the previous turns.

The player who has no cards at the beginning of a turn loses. Determine who will win if both players play optimally.

Input
The first line contains a single integer t
 (1≤t≤5000
) — the number of test cases.

Each test case consists of two lines:

the first line contains a single integer n
 (2≤n≤50
) — the number of cards;
the second line contains n
 characters, each either A or B. If the i
-th character is A, then card number i
 is initially given to Alice; otherwise, it is given to Bob.
Additional constraint on the input: in each test case, at least one card is initially given to Alice, and at least one card is initially given to Bob.

Output
For each test case, output Alice if Alice wins with optimal play, or Bob if Bob wins. It can be shown that if both players play optimally, the game will definitely end in a finite number of turns with one of the players winning.*/
import java.util.Scanner;

public class C_Card_Game {
    static String solve(String cards,int n)
    {
        if(n==2)
        {
            if(cards.charAt(0)=='A')
                return "Alice";
            else
                return "Bob";
        }
        if(cards.charAt(n-1)=='A'&&(cards.charAt(n-2)=='A'||cards.charAt(0)=='A'))
            return "Alice";
        if(cards.charAt(n-2)=='B'&&cards.charAt(0)=='B')
            return "Bob";
        if(cards.charAt(n-1)=='B')
        {
            for(int i=0 ;i<n-1;i++)
            {
                if(cards.charAt(i)=='B')
                    return "Bob";
            }
        }
        return "Alice";
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while (t--!=0) {
            int n=sc.nextInt();
            System.out.println(solve(sc.next(), n));
        }
        sc.close();
    }
}