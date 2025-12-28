package first_repo.leetcode;
import java.util.*;
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
public class majorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution run = new Solution();
        StringTokenizer in = new StringTokenizer(sc.nextLine());
        int[] a = new int[in.countTokens()];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(in.nextToken());
        }
        run.majorityElement(a);
        sc.close();
    }
}
