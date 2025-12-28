package first_repo.leetcode;
import java.util.*;
class Solution {
    public int maxSubArray(int[] nums) {
        long max = Long.MIN_VALUE;
        long current = 0;
        int strat=-1, end=-1, s=0;
        for (int i = 0; i < nums.length; i++) {
            current+= nums[i];
            if(max<current)
            {
                strat=s;
                end=i;
                max=current;
            }
            if (current < 0) {
                current = 0;
                s=i+1;
            }
        }
        System.out.println("Start Index: " + strat + ", End Index: " + end);
        return (int)max;
    }
}
public class MaximumSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution run = new Solution();
        StringTokenizer in = new StringTokenizer(sc.nextLine());
        int[] a = new int[in.countTokens()];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(in.nextToken());
        }
        run.maxSubArray(a);
        sc.close();
    }
}
