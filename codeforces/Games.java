/*Alice and Bob are planning to play an online game together but haven't decided on which one yet. Alice has a list of n
 games she enjoys: a1,a2,…,an
. Bob, on the other hand, has a list of m
 games he likes: b1,b2,…,bm
. They share at least one game in common between their lists.

To choose a game, they take turns suggesting games from their lists. Alice begins by suggesting one of her favorite games. If Bob likes it, they play that game. If not, Bob suggests one of his favorite games. If Alice likes it, they play that game. This alternating process continues, with Alice and Bob each suggesting games from their lists in turn, ensuring that no game is suggested more than once.

Your task is to calculate the maximum possible number of suggestions they will make while choosing which game to play.

Input
The first line contains a single integer t
 (1≤t≤1000
) — the number of test cases.

The first line of each test case contains two integers n
 and m
 (1≤n,m≤100
).

The second line contains n
 integers a1<a2<⋯<an
 (1≤ai≤100
).

The third line contains m
 integers b1<b2<⋯<bm
 (1≤bi≤100
).

Arrays a
 and b
 contain at least one common integer.

Output
For each test case, print a single integer — the maximum possible number of suggestions they will make while choosing which game to play.*/
package first_repo.codeforces;
import java.util.*;

public class Games {
    static void solve(Set<Integer> alice, Set<Integer> bob, int n, int m) {
        int commonCount=0;
        if(n>m)
        {
             for(int current: bob )
            {
                if(alice.contains(current))
                    commonCount++;
            }
            System.out.println(m-commonCount+2);
        }
        else
        {
            for(int current: alice )
            {
                if(bob.contains(current))
                    commonCount++;
            }
            System.out.println(n-commonCount+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            Set <Integer>alice = new HashSet<>();
            Set <Integer>bob = new HashSet<>();

            for (int j = 0; j < n; j++)
                alice.add(sc.nextInt());

            for (int j = 0; j < m; j++)
                bob.add(sc.nextInt());

            solve(alice, bob, n, m);            
        }

        sc.close();
    }
}
