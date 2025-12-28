package first_repo.leetcode;
import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution run = new Solution();
        StringTokenizer in = new StringTokenizer(sc.nextLine());
        int[] a = new int[in.countTokens()];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(in.nextToken());
        }
        run.maxProfit(a);
        sc.close();
    }
}
